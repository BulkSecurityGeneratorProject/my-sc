package zw.co.elearning.school.reports.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.DRUG_NAME;
import zw.co.elearning.school.db.tables.DRUG_OPTION;
import zw.co.elearning.school.db.tables.DRUG_SUFFIX;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.PERSON_MEDICATION;
import zw.co.elearning.school.db.tables.ZEPI_DRUG_NAME;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;
import zw.co.elearning.school.reports.util.QueryUtil;

import static org.jooq.impl.DSL.*;

@Component

public class ImmunisationService extends ReportService<SubReportData<ImmunisationData>> {

	@Autowired
	private QueryUtil q;

	@Override
	public String getGroup() {

		return "Lists";
	}

	@Override
	public String getId() {

		return "immunised";
	}

	@Override
	public String getName() {

		return "List of immunised children below 5 years";
	}

	@Override
	protected Collection<SubReportData<ImmunisationData>> generateData(Date from, Date to, String[] deptIds) {

		List<ImmunisationData> data = new ArrayList<>();

		PERSON p = Tables.PERSON.as("p");
		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		ZEPI_DRUG_NAME zd = Tables.ZEPI_DRUG_NAME.as("zd");
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		DRUG_OPTION dp = Tables.DRUG_OPTION.as("dp");
		DRUG_SUFFIX ds = Tables.DRUG_SUFFIX.as("ds");

		// @formatter:off
		this.schema()
		.select(p.LASTNAME,p.FIRSTNAME, p.SEX, p.BIRTHDATE,p.ID,p.BIRTHDATE,pm.DATE)
				
		        .from(pm)
				.join(zd).on(zd.DRUG_NAME_ID.eq(pm.DRUG_NAME_ID))
				.join(p).on(p.ID.eq(pm.PERSON_ID))
				.where().groupBy(p.ID).fetch().forEach((row) -> {
					// @formatter:on

					if (q.getAgeMonths(row.getValue(p.BIRTHDATE).toLocalDate(),
							q.fromDate(row.getValue(pm.DATE))) <= 60) {

						ImmunisationData vaccination = new ImmunisationData();

						vaccination.setAddress(q.getCurrentAddress(row.getValue(p.ID)));
						vaccination.setAge((int) q.getAgeMonths(row.getValue(p.BIRTHDATE).toLocalDate(),
								q.fromDate(row.getValue(pm.DATE))));
						vaccination.setSex(row.getValue(p.SEX));
						vaccination.setFirstname(row.getValue(p.FIRSTNAME));
						vaccination.setLastname(row.getValue(p.LASTNAME));
						vaccination.setMedications(vaccinationGiven(row.getValue(p.ID), to));

						data.add(vaccination);
					}

				});
		List<SubReportData<ImmunisationData>> result = new ArrayList<>();

		result.add(new SubReportData<ImmunisationData>(data));

		return result;

	}

	private List<Immunisation> vaccinationGiven(Long personId, Date date) {
		List<Immunisation> result = new ArrayList<>();

		PERSON p = Tables.PERSON.as("p");
		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		ZEPI_DRUG_NAME zd = Tables.ZEPI_DRUG_NAME.as("zd");
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		DRUG_OPTION dp = Tables.DRUG_OPTION.as("dp");
		DRUG_SUFFIX ds = Tables.DRUG_SUFFIX.as("ds");
		// @formatter:off
		//groupConcat()
		this.schema().select(groupConcat(concat(dn.ALIAS, val(" "),DSL.decode().when(ds.NAME.isNull(), "").otherwise(ds.NAME))).as("drugname"),pm.DATE)
				.from(pm)
				.join(zd).on(zd.DRUG_NAME_ID.eq(pm.DRUG_NAME_ID))
				.join(dn).on(dn.ID.eq(zd.DRUG_NAME_ID))
				.leftJoin(dp).on(dp.ID.eq(pm.DRUG_OPTION_ID))
				.leftJoin(ds).on(ds.ID.eq(dp.SUFFIX_ID))
				.where(pm.DATE.lessOrEqual(new java.sql.Timestamp(date.getTime())))
				.and(pm.PERSON_ID.eq(personId))
				.groupBy(pm.DATE)
				.fetch().forEach((row) -> {
					// @formatter:on
					Immunisation vaccination = new Immunisation();

					vaccination.setDate(row.getValue(pm.DATE));
					vaccination.setDrug_name(row.getValue("drugname").toString());

					result.add(vaccination);
				});
		return result;
	}

	@Override
	public String getTemplateUrl() {
		return "reports/registers/vaccinationreg.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a4_landscape.jasper";
	}

}
