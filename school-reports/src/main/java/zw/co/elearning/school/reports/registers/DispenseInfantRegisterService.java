package zw.co.elearning.school.reports.registers;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.dateDiff;
import static org.jooq.impl.DSL.val;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.DISPENSE;
import zw.co.elearning.school.db.tables.DRUG;
import zw.co.elearning.school.db.tables.DRUG_BATCH;
import zw.co.elearning.school.db.tables.DRUG_NAME;
import zw.co.elearning.school.db.tables.DRUG_OPTION;
import zw.co.elearning.school.db.tables.DRUG_SUFFIX;
import zw.co.elearning.school.db.tables.FORMULATION;
import zw.co.elearning.school.db.tables.FREQUENCY;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.PERSON_MEDICATION;
import zw.co.elearning.school.db.tables.UNIT;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;
import zw.co.elearning.school.reports.util.QueryUtil;

@Component
public class DispenseInfantRegisterService extends ReportService<SubReportData<DispenseInfantRegisterData>> {
	@Autowired
	private QueryUtil q;

	@Override
	public String getGroup() {
		return "Registers";
	}

	@Override
	public String getId() {
		return "infant-dispense-register";
	}

	@Override
	public String getName() {
		return "Ifant Dispensing Register";
	}

	@Override
	protected Collection<SubReportData<DispenseInfantRegisterData>> generateData(Date from, Date to, String[] deptIds) {
		List<DispenseInfantRegisterData> data = new ArrayList<>();
		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());
		
		List<Long> depts = new ArrayList<>();
		if (deptIds!=null && deptIds.length > 0) {
			for (String d : deptIds) {
				depts.add(Long.parseLong(d));
			}
		}

		PERSON p = Tables.PERSON.as("p");
		DISPENSE d = Tables.DISPENSE.as("d");
		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		DRUG_OPTION dp = Tables.DRUG_OPTION.as("dp");
		DRUG_SUFFIX ds = Tables.DRUG_SUFFIX.as("ds");
		DRUG_BATCH db = Tables.DRUG_BATCH.as("db");
		FREQUENCY f = Tables.FREQUENCY.as("f");
		DRUG dr = Tables.DRUG.as("dr");
		FORMULATION fo = Tables.FORMULATION.as("fo");
		UNIT u = Tables.UNIT.as("u");

		// @formatter:off	
		this.schema()
				.select(d.DATE, concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("patient"), p.SEX, p.BIRTHDATE, dn.NAME,
						dn.ALIAS, pm.DRUG_OPTION_ID, ds.NAME.as("suffix"), concat(fo.NAME, val(" "),dr.STRENGTH, u.NAME).as("formulation"),
					 d.QUANTITY, db.BATCH_NUMBER, db.EXPIRY_DATE, f.DESCRIPTION)
				.from(d)
				.leftJoin(pm).on(pm.ID.eq(d.PERSON_MEDICATION_ID))
				.leftJoin(dn).on(dn.ID.eq(pm.DRUG_NAME_ID))
				.leftJoin(dp).on(dp.ID.eq(pm.DRUG_OPTION_ID))
				.leftJoin(ds).on(ds.ID.eq(dp.SUFFIX_ID))
				.leftJoin(db).on(db.ID.eq(d.BATCH_ID))
				.leftJoin(f).on(f.ID.eq(d.FREQUENCY_ID))
				.leftJoin(dr).on(dr.ID.eq(d.DRUG_ID))
				.leftJoin(fo).on(fo.ID.eq(dr.FORMULATION_ID))
				.leftJoin(u).on(u.ID.eq(dr.UNIT_ID))
				.leftJoin(p).on(p.ID.eq(pm.PERSON_ID))
				.where(d.DATE.between(new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime())))
				.and(dateDiff(toDate, p.BIRTHDATE).lessOrEqual(1825))
				.orderBy(d.DATE.desc())
				.fetch().forEach((row) -> {
					// @formatter:on
					DispenseInfantRegisterData detail = new DispenseInfantRegisterData();
					detail.setAge(q.getAgeYears(row.getValue(p.BIRTHDATE).toLocalDate(), q.fromDate(row.getValue(d.DATE))));
					detail.setBatch_number(row.getValue(db.BATCH_NUMBER));
					detail.setDate(row.getValue(d.DATE));
					detail.setExpiry_date(row.getValue(db.EXPIRY_DATE));
					detail.setFormulation(row.getValue("formulation").toString());
					if (row.getValue(pm.DRUG_OPTION_ID) != null && row.getValue(dn.ALIAS) != null) {
						detail.setName(row.getValue(dn.ALIAS).concat(" ".concat(row.getValue("suffix").toString())));
					} else if (row.getValue(pm.DRUG_OPTION_ID) != null) {
						detail.setName(row.getValue(dn.NAME).concat(" ".concat(row.getValue("suffix").toString())));
					} else {
						detail.setName(row.getValue(dn.ALIAS) != null && row.getValue(dn.ALIAS).length() > 0
								? row.getValue(dn.ALIAS) : row.getValue(dn.NAME));
					}
					detail.setNotes(row.getValue(f.DESCRIPTION));
					detail.setPatient(row.getValue("patient").toString());
					detail.setQuantity(row.getValue(d.QUANTITY));
					detail.setSex(row.getValue(p.SEX));

					data.add(detail);
				});

		List<SubReportData<DispenseInfantRegisterData>> result = new ArrayList<>();

		result.add(new SubReportData<DispenseInfantRegisterData>(data));

		return result;
	}

	@Override
	public String getTemplateUrl() {
		return "reports/registers/dispenseinfantregister.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a2_landscape.jasper";
	}
}
