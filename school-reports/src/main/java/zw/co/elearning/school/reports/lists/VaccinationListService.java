package zw.co.elearning.school.reports.lists;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

@Component
public class VaccinationListService extends ReportService<SubReportData<VaccinationListData>> {

	@Autowired
	private QueryUtil q;

	@Override
	public String getGroup() {

		return "Lists";
	}

	@Override
	public String getId() {

		return "vaccination-list";
	}

	@Override
	public String getName() {

		return "List of children under five vaccinated this month";
	}

	@Override
	protected Collection<SubReportData<VaccinationListData>> generateData(Date from, Date to, String[] deptIds) {

		List<VaccinationListData> data = new ArrayList<>();
		java.sql.Timestamp fromDate = new Timestamp(from.getTime());
		java.sql.Timestamp toDate = new Timestamp(to.getTime());

		PERSON p = Tables.PERSON.as("p");

		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		ZEPI_DRUG_NAME zd = Tables.ZEPI_DRUG_NAME.as("zd");
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		DRUG_OPTION dp = Tables.DRUG_OPTION.as("dp");
		DRUG_SUFFIX ds = Tables.DRUG_SUFFIX.as("ds");
		// @formatter:off
		this.schema()
		.select(pm.DATE, concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("fullname"), p.SEX, p.BIRTHDATE, dn.NAME,
				dn.ALIAS, pm.DRUG_OPTION_ID,ds.NAME.as("suffix"),p.ID,p.BIRTHDATE)
				.from(pm)
				.join(zd).on(zd.DRUG_NAME_ID.eq(pm.DRUG_NAME_ID))
				.join(dn).on(dn.ID.eq(zd.DRUG_NAME_ID))
				.leftJoin(dp).on(dp.ID.eq(pm.DRUG_OPTION_ID))
				.leftJoin(ds).on(ds.ID.eq(dp.SUFFIX_ID))
				.join(p).on(p.ID.eq(pm.PERSON_ID))
				.where(pm.DATE.between(fromDate, toDate))
				.groupBy(p.ID)
				.orderBy(pm.DATE.desc())
				.fetch().forEach((row) -> {
					// @formatter:on
					if (q.getAgeMonths(row.getValue(p.BIRTHDATE).toLocalDate(), q.fromDate(row.getValue(pm.DATE))) <= 60) {

						VaccinationListData vaccination = new VaccinationListData();

						vaccination.setFullname(row.getValue("fullname").toString());
						vaccination.setAge((int) q.getAgeMonths(row.getValue(p.BIRTHDATE).toLocalDate(), q.fromDate(row.getValue(pm.DATE))));
						vaccination.setAddress(q.getCurrentAddress(row.getValue(p.ID)));
						vaccination.setSex(row.getValue(p.SEX));
						vaccination.setDrug_name(q.getBirthVaccination(row.getValue(p.ID), row.getValue(pm.DATE), row.getValue(pm.DATE)));

						vaccination.setDate(row.getValue(pm.DATE));

						data.add(vaccination);
					}

				});
		List<SubReportData<VaccinationListData>> result = new ArrayList<>();

		result.add(new SubReportData<VaccinationListData>(data));

		return result;
	}

	@Override
	public String getTemplateUrl() {

		return "reports/registers/vaccination-list.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {

		return "reports/a4_landscape.jasper";
	}

}
