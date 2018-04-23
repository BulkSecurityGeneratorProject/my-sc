package zw.co.elearning.school.reports.util;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.dateDiff;
import static org.jooq.impl.DSL.groupConcatDistinct;
import static org.jooq.impl.DSL.val;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.ADDRESS;
import zw.co.elearning.school.db.tables.ADMISSION_ENCOUNTER;
import zw.co.elearning.school.db.tables.ANC;
import zw.co.elearning.school.db.tables.COMPLAINT;
import zw.co.elearning.school.db.tables.DELIVERY;
import zw.co.elearning.school.db.tables.DEPARTMENT;
import zw.co.elearning.school.db.tables.DIAGNOSIS;
import zw.co.elearning.school.db.tables.DRUG_NAME;
import zw.co.elearning.school.db.tables.DRUG_OPTION;
import zw.co.elearning.school.db.tables.DRUG_SUFFIX;
import zw.co.elearning.school.db.tables.ENCOUNTER;
import zw.co.elearning.school.db.tables.ENCOUNTER_COMPLAINT;
import zw.co.elearning.school.db.tables.ENCOUNTER_DIAGNOSIS;
import zw.co.elearning.school.db.tables.ENCOUNTER_EXAMINATION;
import zw.co.elearning.school.db.tables.ENCOUNTER_INVESTIGATION;
import zw.co.elearning.school.db.tables.ENCOUNTER_NOTE;
import zw.co.elearning.school.db.tables.ENCOUNTER_PROCEDURE;
import zw.co.elearning.school.db.tables.ENCOUNTER_VITAL;
import zw.co.elearning.school.db.tables.EXAMINATION;
import zw.co.elearning.school.db.tables.IMMUNIZATION_SCHEDULE;
import zw.co.elearning.school.db.tables.INFANT;
import zw.co.elearning.school.db.tables.INVESTIGATION;
import zw.co.elearning.school.db.tables.INVESTIGATION_RESULT;
import zw.co.elearning.school.db.tables.LAB_RESULT;
import zw.co.elearning.school.db.tables.LAB_TEST;
import zw.co.elearning.school.db.tables.MEDICAL_PROCEDURE;
import zw.co.elearning.school.db.tables.OPD;
import zw.co.elearning.school.db.tables.OPD_ENCOUNTER;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.PERSON_ART_STATUS;
import zw.co.elearning.school.db.tables.PERSON_COMPLAINT;
import zw.co.elearning.school.db.tables.PERSON_DIAGNOSIS;
import zw.co.elearning.school.db.tables.PERSON_EXAMINATION;
import zw.co.elearning.school.db.tables.PERSON_INVESTIGATION;
import zw.co.elearning.school.db.tables.PERSON_INVESTIGATION_TEST;
import zw.co.elearning.school.db.tables.PERSON_MEDICATION;
import zw.co.elearning.school.db.tables.PERSON_PROCEDURE;
import zw.co.elearning.school.db.tables.PERSON_VITAL;
import zw.co.elearning.school.db.tables.PHONE;
import zw.co.elearning.school.db.tables.REFERRAL;
import zw.co.elearning.school.db.tables.SAMPLE;
import zw.co.elearning.school.db.tables.SITE_SETTING;
import zw.co.elearning.school.db.tables.TEST_KIT;
import zw.co.elearning.school.db.tables.TEST_KIT_BATCH;
import zw.co.elearning.school.db.tables.TOWN;
import zw.co.elearning.school.db.tables.ZEPI_DRUG_NAME;
import zw.co.elearning.school.repository.SiteSettingRepository;

@Component
public class QueryUtil {
	private final Logger log = LoggerFactory.getLogger(QueryUtil.class);
	@Inject
	DSLContext schema;



	@Inject
	SiteSettingRepository siteSettingRepository;



	public long getAgeMonths(LocalDate date) {
		LocalDate today = LocalDate.now();
		return getAgeMonths(date, today);
	}

	public long getAgeMonths(LocalDate date, LocalDate reference) {
		return ChronoUnit.MONTHS.between(date, reference);
	}

	public long getAgeMonths(Date date, Date reference) {

		LocalDate b = fromDate(date);
		LocalDate r = fromDate(reference);

		return getAgeMonths(b, r);

	}

	public String getAgeMonthsAndDays(Date date, Date reference) {

		LocalDate b = fromDate(date);
		LocalDate r = fromDate(reference);
		long intervalMonths = ChronoUnit.MONTHS.between(b, r);
		Period intervalPeriod = Period.between(b, r);

		if (intervalPeriod.getDays() > 0) {
			return intervalMonths + " month(s)" + intervalPeriod.getDays() + " day(s)";
		}
		return intervalMonths + " month(s)";
	}

	public int getAgeYears(LocalDate birthdate) {
		return getAgeYears(birthdate, LocalDate.now());
	}

	public int getAgeYears(LocalDate birthdate, LocalDate reference) {
		Period p = Period.between(birthdate, reference);
		return p.getYears();
	}

	public int getAgeYears(Date birthdate, Date reference) {
		LocalDate b = fromDate(birthdate);
		LocalDate r = fromDate(reference);
		return getAgeYears(b, r);
	}

	public LocalDate fromDate(Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

	public LocalDate fromDate(Timestamp date) {
		Date d = new Date(date.getTime());
		return d.toLocalDate();
	}

	public String getCurrentAddress(Long personId) {
		ADDRESS a = Tables.ADDRESS.as("a");
		TOWN t = Tables.TOWN.as("t");

		Record row = schema
				.select(concat(DSL.decode().when(a.STREET.isNull(), "").otherwise(a.STREET), val(" "),
						DSL.decode().when(a.CITY.isNull(), "").otherwise(a.CITY), val(" "), t.NAME).as("address"))
				.from(a).leftJoin(t).on(t.ID.eq(a.TOWN_ID)).where(a.PERSON_ID.eq(personId))
				.orderBy(a.CREATED_DATE.desc()).limit(1).fetchOne();
		if (row != null && row.getValue("address") != null) {
			return row.getValue("address").toString();
		}

		return "";

	}

	public String getMedication(Long personId, Date date) {

		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");

		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");

		Record row = schema.select(groupConcatDistinct(dn.NAME).as("drugnames")).from(pm).join(dn)
				.on(dn.ID.eq(pm.DRUG_NAME_ID))
				.where(pm.PERSON_ID.eq(personId).and(pm.DATE.eq(new java.sql.Timestamp(date.getTime()))))
				.groupBy(pm.PERSON_ID).fetchOne();

		if (row != null) {
			return row.getValue("drugnames").toString();
		}

		return null;

	}

	public String getOpdMedication(Long opdId) {

		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		OPD o = Tables.OPD.as("o");
		// @formatter:off
		Record drugRow = schema.select(groupConcatDistinct(dn.NAME).as("drugnames")).from(pm).join(dn)
				.on(dn.ID.eq(pm.DRUG_NAME_ID)).join(o).on(pm.PERSON_ID.eq(o.PERSON_ID))
				.where(o.ID.eq(opdId))
				.groupBy(pm.PERSON_ID).fetchOne();
		// @formatter:on
		if (drugRow != null) {
			return drugRow.getValue("drugnames").toString();
		}

		return null;

	}

	public String medicationGiven(Long personId, Date from, Date to, List<Long> drugList) {
		String result = "-";
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		DRUG_OPTION dp = Tables.DRUG_OPTION.as("dp");
		DRUG_SUFFIX ds = Tables.DRUG_SUFFIX.as("ds");
		// @formatter:off
		Record record = schema.select(dn.NAME, dn.ALIAS, pm.DRUG_OPTION_ID, ds.NAME).from(pm)
				.join(dn).on(dn.ID.eq(pm.DRUG_NAME_ID))
				.leftJoin(dp).on(dp.ID.eq(pm.DRUG_OPTION_ID))
				.leftJoin(ds).on(ds.ID.eq(dp.SUFFIX_ID))
				.where(pm.DRUG_NAME_ID.in(drugList))
				.and(pm.PERSON_ID.eq(personId))
				.and(pm.DATE.between(new java.sql.Timestamp(from.getTime()),new java.sql.Timestamp(to.getTime())))
				.orderBy(pm.DATE.desc()).limit(1).fetchOne();
		// @formatter:on
		if (record != null) {
			if (record.getValue(pm.DRUG_OPTION_ID) != null) {
				result = record.getValue(dn.ALIAS) != null && record.getValue(dn.ALIAS).length() > 0
						? record.getValue(dn.ALIAS) + " " + record.getValue(ds.NAME)
						: record.getValue(dn.NAME) + " " + record.getValue(ds.NAME);
			} else {
				result = record.getValue(dn.ALIAS) != null && record.getValue(dn.ALIAS).length() > 0
						? record.getValue(dn.ALIAS) : record.getValue(dn.NAME);
			}

		}
		return result;
	}

	public String getVital(Long opdId, Long vitalId) {
		PERSON_VITAL pv = Tables.PERSON_VITAL.as("pv");
		ENCOUNTER_VITAL ev = Tables.ENCOUNTER_VITAL.as("ev");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");

		Record row = schema.select(pv.VALUE.as("value")).from(pv).join(ev).on(pv.ID.eq(ev.PERSON_VITAL_ID)).join(oe)
				.on(oe.ENCOUNTER_ID.eq(ev.ENCOUNTER_ID)).where(pv.VITAL_ID.eq(vitalId)).and(oe.OPD_ID.eq(opdId))
				.orderBy(pv.CREATED_DATE.desc()).limit(1).fetchOne();
		if (row != null) {
			return row.getValue("value").toString();
		}

		return "";
	}

	public String getVitalByDate(Date date, Long vitalId, Long personId) {
		PERSON_VITAL pv = Tables.PERSON_VITAL.as("pv");
		// @formatter:off
		Record row = schema.select(pv.VALUE).from(pv)
				.where(pv.VITAL_ID.eq(vitalId))
				.and(pv.DATE.eq(new Timestamp(date.getTime())))
				.and(pv.PERSON_ID.eq(personId))
				.orderBy(pv.CREATED_DATE.desc()).limit(1)
				.fetchOne();
		// @formatter:on
		if (row != null) {
			return row.getValue(pv.VALUE).toString();
		}

		return "";
	}

	public String getComplaint(Long opdId) {

		COMPLAINT c = Tables.COMPLAINT.as("c");
		PERSON_COMPLAINT pc = Tables.PERSON_COMPLAINT.as("pc");
		ENCOUNTER_COMPLAINT ec = Tables.ENCOUNTER_COMPLAINT.as("ec");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");

		Record row = schema.select(groupConcatDistinct(c.NAME).as("complaint")).from(pc).join(c)
				.on(c.ID.eq(pc.COMPLAINT_ID)).join(ec).on(ec.PERSON_COMPLAINT_ID.eq(pc.ID)).join(oe)
				.on(oe.ENCOUNTER_ID.eq(ec.ENCOUNTER_ID)).where(oe.OPD_ID.eq(opdId)).groupBy(oe.OPD_ID).limit(1)
				.fetchOne();
		if (row != null) {
			return row.getValue("complaint").toString();
		}

		return "";
	}

	public String getExamination(Long opdId) {
		EXAMINATION e = Tables.EXAMINATION.as("e");
		PERSON_EXAMINATION pe = Tables.PERSON_EXAMINATION.as("pe");
		ENCOUNTER_EXAMINATION ee = Tables.ENCOUNTER_EXAMINATION.as("ee");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");

		Record row = schema.select(groupConcatDistinct(e.NAME).as("examination")).from(pe).join(e)
				.on(e.ID.eq(pe.EXAMINATION_ID)).join(ee).on(ee.PERSON_EXAMINATION_ID.eq(pe.ID)).join(oe)
				.on(oe.ENCOUNTER_ID.eq(ee.ENCOUNTER_ID)).where(oe.OPD_ID.eq(opdId)).groupBy(oe.OPD_ID).limit(1)
				.fetchOne();
		if (row != null) {
			return row.getValue("examination").toString();
		}

		return "";
	}

	public String getDiagnosis(Long opdId) {
		DIAGNOSIS d = Tables.DIAGNOSIS.as("d");
		PERSON_DIAGNOSIS pd = Tables.PERSON_DIAGNOSIS.as("pd");
		ENCOUNTER_DIAGNOSIS ed = Tables.ENCOUNTER_DIAGNOSIS.as("ed");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		// @formatter:off
		Record row = schema.select(groupConcatDistinct(d.NAME).as("diagnosis"))
				.from(pd)
				.join(d).on(d.ID.eq(pd.DIAGNOSIS_ID)).
				join(ed).on(ed.PERSON_DIAGNOSIS_ID.eq(pd.ID))
				.join(oe).on(oe.ENCOUNTER_ID.eq(ed.ENCOUNTER_ID))
				.where(oe.OPD_ID.eq(opdId))
				.groupBy(oe.OPD_ID)
				.limit(1)
				.fetchOne();
		// @formatter:on
		if (row != null) {
			return row.getValue("diagnosis").toString();
		}

		return "";
	}

	public String getProcedures(Long opdId) {
		MEDICAL_PROCEDURE mp = Tables.MEDICAL_PROCEDURE.as("mp");
		PERSON_PROCEDURE pp = Tables.PERSON_PROCEDURE.as("pp");
		ENCOUNTER_PROCEDURE ep = Tables.ENCOUNTER_PROCEDURE.as("ep");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");

		Record row = schema.select(groupConcatDistinct(mp.NAME).as("procedure")).from(pp).join(mp)
				.on(mp.ID.eq(pp.PROCEDURE_ID)).join(ep).on(ep.PERSON_PROCEDURE_ID.eq(pp.ID)).join(oe)
				.on(oe.ENCOUNTER_ID.eq(ep.ENCOUNTER_ID)).where(oe.OPD_ID.eq(opdId)).groupBy(oe.OPD_ID).limit(1)
				.fetchOne();
		if (row != null) {
			return row.getValue("procedure").toString();
		}

		return "";
	}

	public String getInvestigation(Long opdId) {
		INVESTIGATION i = Tables.INVESTIGATION.as("i");
		PERSON_INVESTIGATION pi = Tables.PERSON_INVESTIGATION.as("pi");
		ENCOUNTER_INVESTIGATION ei = Tables.ENCOUNTER_INVESTIGATION.as("ei");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		SAMPLE s = Tables.SAMPLE.as("s");
		LAB_TEST lt = Tables.LAB_TEST.as("lt");
		INVESTIGATION_RESULT ir = Tables.INVESTIGATION_RESULT.as("ir");

		StringBuffer sb = new StringBuffer();
		// @formatter:off
		this.schema.select(pi.INVESTIGATION_ID,i.ID, concat(s.NAME, val(" "), lt.NAME).as("name"), pi.RESULT)
				.from(pi).join(i)
				.on(pi.INVESTIGATION_ID.eq(i.ID))
				.join(s).on(s.ID.eq(i.SAMPLE_ID))
				.join(lt).on(lt.ID.eq(i.TEST_ID))
				.join(ei).on(ei.PERSON_INVESTIGATION_ID.eq(pi.ID))
				.join(oe).on(oe.ENCOUNTER_ID.eq(ei.ENCOUNTER_ID))
				.where(oe.OPD_ID.eq(opdId))
				.fetch()
				.forEach((row) -> {
		// @formatter:on
					sb.append(row.get("name") + ": ");
		// @formatter:off
			Record rowInvestigation = schema.select(ir.RESULT_ID)
					.from(ir)
					.where(ir.INVESTIGATION_ID
					.eq(row.getValue(pi.INVESTIGATION_ID)))
					.limit(1)
					.fetchOne();
		// @formatter:on
					if (rowInvestigation != null) {

						//LabResult lr = labResultRepository.findOne(rowInvestigation.getValue(ir.RESULT_ID));
						//sb.append(lr.getName());

					} else {
						sb.append(row.get(pi.RESULT));

					}

				});
		return sb.toString();
	}

	public Map<String, Object> getInvestigationResultAndDate(Long personId, Date from, Date to, Long investigationId) {
		Map<String, Object> resultDate = new HashMap<>();

		PERSON_INVESTIGATION pi = Tables.PERSON_INVESTIGATION.as("pi");
		INVESTIGATION_RESULT ir = Tables.INVESTIGATION_RESULT.as("ir");
		LAB_RESULT lr = Tables.LAB_RESULT.as("lr");
		log.debug("Date from>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + from);
		log.debug("Date to>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + to);
		// @formatter:off
		Record record = schema.select(pi.RESULT, ir.ID, lr.NAME,pi.RESULT_DATE,pi.ISSUE_DATE,pi.DATE).from(pi)
				.leftJoin(ir).on((ir.INVESTIGATION_ID.eq(pi.INVESTIGATION_ID))
				.and(ir.ID.eq(pi.RESULT.cast(SQLDataType.BIGINT))))
				.leftJoin(lr).on(lr.ID.eq(ir.RESULT_ID))
				.where(pi.PERSON_ID.eq(personId))
				.and(pi.DATE.between(new Timestamp(from.getTime()),new Timestamp(to.getTime())))
				.and(pi.INVESTIGATION_ID.eq(investigationId))
				.orderBy(pi.DATE.desc())
				.limit(1)
				.fetchOne();
		// @formatter:on
		System.out.println(
				"<><>><><><><><><><><><<<<<<><><><><><><><<<<<<><><><><><><><<<<<<><><><><><><><<<<<<><><><><><><><<<<<");
		if (record != null) {
			if (record.getValue(pi.RESULT) != null) {
				resultDate.put("date", record.getValue(pi.DATE));
				resultDate.put("resultDate", record.getValue(pi.RESULT_DATE));
				resultDate.put("issueDate", record.getValue(pi.ISSUE_DATE));
				resultDate.put("result",
						record.getValue(ir.ID) != null ? record.getValue(lr.NAME) : record.getValue(pi.RESULT));
			} else {
				resultDate.put("resultDate", null);
				resultDate.put("result", "No Result");
			}

		} else {
			resultDate.put("result", "-");
		}
		return resultDate;
	}

	public Map<String, Object> getInvestigationResult(Long personInvestigationId) {
		Map<String, Object> resultDate = new HashMap<>();

		PERSON_INVESTIGATION pi = Tables.PERSON_INVESTIGATION.as("pi");
		INVESTIGATION_RESULT ir = Tables.INVESTIGATION_RESULT.as("ir");
		LAB_RESULT lr = Tables.LAB_RESULT.as("lr");
		// @formatter:off
		Record record = schema.select(pi.RESULT, ir.ID, lr.NAME,pi.RESULT_DATE).from(pi)
				.leftJoin(ir).on((ir.INVESTIGATION_ID.eq(pi.INVESTIGATION_ID))
				.and(ir.ID.eq(pi.RESULT.cast(SQLDataType.BIGINT))))
				.leftJoin(lr).on(lr.ID.eq(ir.RESULT_ID))
				.where(pi.ID.eq(personInvestigationId))
				.orderBy(pi.DATE.desc()).limit(1) 
				.fetchOne();
		// @formatter:on

		if (record != null) {
			if (record.getValue(pi.RESULT) != null) {
				resultDate.put("resultDate", record.getValue(pi.RESULT_DATE));
				resultDate.put("result",
						record.getValue(ir.ID) != null ? record.getValue(lr.NAME) : record.getValue(pi.RESULT));
			} else {
				resultDate.put("resultDate", null);
				resultDate.put("result", "No Result");
			}

		} else {
			resultDate.put("result", "-");
		}
		return resultDate;
	}

	public List<Map<String, Object>> getInvestigationTests(Long personId, Long encounterId,
			Long personInvestigationId) {
		PERSON_INVESTIGATION pi = Tables.PERSON_INVESTIGATION.as("pi");
		PERSON_INVESTIGATION_TEST pit = Tables.PERSON_INVESTIGATION_TEST.as("pit");
		TEST_KIT tk = Tables.TEST_KIT.as("tk");
		TEST_KIT_BATCH tkb = Tables.TEST_KIT_BATCH.as("tkb");
		INVESTIGATION_RESULT ir = Tables.INVESTIGATION_RESULT.as("ir");
		LAB_RESULT lr = Tables.LAB_RESULT.as("lr");

		List<Map<String, Object>> result = new ArrayList<>();
		// @formatter:off
		this.schema.select(pi.RESULT,ir.ID,lr.NAME,pit.RESULT,tk.NAME.as("testkitname"),tkb.EXPIRY_DATE.as("expiryDate"),tkb.BATCH_NUMBER.as("batchNumber"))
				.from(pit)
				.join(pi).on(pi.ID.eq(pit.PERSON_INVESTIGATION_ID))
				.leftJoin(ir).on((ir.INVESTIGATION_ID.eq(pi.INVESTIGATION_ID))
				.and(ir.ID.eq(pit.RESULT.cast(SQLDataType.BIGINT))))
				.leftJoin(lr).on(lr.ID.eq(ir.RESULT_ID))
				.leftJoin(tk).on(tk.ID.eq(pit.TEST_KIT_ID))
				.leftJoin(tkb).on(tkb.ID.eq(pit.TEST_KIT_BATCH_ID))
				.where(pi.ID.eq(personInvestigationId))
				.groupBy(pit.ID)
				.forEach((row) -> {
		// @formatter:on

					Map<String, Object> entry = new HashMap<>();
					entry.put("testkitname", row.get("testkitname"));
					entry.put("expiryDate", row.get("expiryDate"));
					entry.put("batchNumber", row.get("batchNumber"));

					if (row.getValue(pi.RESULT) != null) {
						entry.put("result",
								row.getValue(ir.ID) != null ? row.getValue(lr.NAME) : row.getValue(pit.RESULT));
					} else {
						entry.put("result", "No Result");
					}

					/*
					 * Record rowInvestigation =
					 * schema.select(ir.RESULT_ID).from(ir)
					 * .where(ir.INVESTIGATION_ID.eq(row.getValue(pi.
					 * INVESTIGATION_ID))) .and(arg0) .limit(1).fetchOne(); if
					 * (rowInvestigation != null) { if (row.getValue(pit.RESULT)
					 * != null) { LabResult lr =
					 * labResultRepository.findOne(rowInvestigation.getValue(ir.
					 * RESULT_ID)); entry.put("result", lr.getName()); }
					 * 
					 * } else { entry.put("result", row.get(pi.RESULT));
					 * 
					 * }
					 */

					result.add(entry);

				});
		return result;
	}

	public String getOpdOutcome(Long opdId) {
		OPD o = Tables.OPD.as("o");
		REFERRAL r = Tables.REFERRAL.as("r");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		ADMISSION_ENCOUNTER ae = Tables.ADMISSION_ENCOUNTER.as("ae");

		Record rowReferral = schema.select().from(oe).join(r).on(oe.ENCOUNTER_ID.eq(r.ENCOUNTER_ID)).join(o)
				.on(o.ID.eq(oe.OPD_ID)).where(o.ID.eq(opdId).and(o.CLOSED.eq(true))).fetchOne();
		if (rowReferral != null) {
			return "Referred";
		}
		Record rowAdmission = schema.select().from(oe).join(ae).on(oe.ENCOUNTER_ID.eq(ae.ENCOUNTER_ID)).join(o)
				.on(o.ID.eq(oe.OPD_ID)).where(o.ID.eq(opdId).and(o.CLOSED.eq(true))).fetchOne();
		if (rowAdmission != null) {
			return "Admitted";
		}
		Record rowDischarged = schema.select().from(o).where(o.ID.eq(opdId).and(o.CLOSED.eq(true))).fetchOne();
		if (rowAdmission == null && rowAdmission == null && rowDischarged != null) {
			return "Discharged";
		}

		return "";
	}

	public String getPhoneNumbers(Long personId) {
		PHONE p = Tables.PHONE.as("p");
		StringBuffer sb = new StringBuffer();
		this.schema.select(p.NUMBER).from(p).where(p.PERSON_ID.eq(personId)).fetch().forEach((phone) -> {

			if (phone.getValue(p.NUMBER) != null) {
				sb.append(phone.getValue(p.NUMBER).toString() + ", ");
			}
		});

		if (sb.length() > 0) {
			sb.toString().substring(0, sb.length() - 2);
		}

		return sb.toString();
	}

	public String getPurpose(Long opdId) {

		return "";
	}

	public String getBirthVaccination(Long personId, java.util.Date from, java.util.Date to) {

		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());

		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		DRUG_NAME dn = Tables.DRUG_NAME.as("dn");
		DRUG_OPTION dop = Tables.DRUG_OPTION.as("dop");
		DRUG_SUFFIX ds = Tables.DRUG_SUFFIX.as("ds");
		ZEPI_DRUG_NAME zdn = Tables.ZEPI_DRUG_NAME.as("zdn");
		StringBuffer sb = new StringBuffer();
		// @formatter:off
		this.schema.select(dn.NAME.as("name"), ds.NAME.as("option"),dn.ALIAS.as("alias"))
				.from(pm)
				.join(dn).on(dn.ID.eq(pm.DRUG_NAME_ID))
				.join(zdn).on(dn.ID.eq(zdn.DRUG_NAME_ID))
				.leftJoin(dop).on(dop.ID.eq(pm.DRUG_OPTION_ID))
				.leftJoin(ds).on(dop.SUFFIX_ID.eq(ds.ID))
				.where(pm.PERSON_ID.eq(personId))
				.and(pm.DATE.between(new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime())))
				.fetch()
				.forEach((row)->{
					if (row != null) {
							if(row.getValue("alias") != null && row.getValue("option") != null){
								sb.append(row.getValue("alias").toString() + ' ' + row.getValue("option").toString() + ", ");
							}else if (row.getValue("alias") != null && row.getValue("option") == null) {
								sb.append(row.getValue("alias").toString() + ", ");
							}							
							else{
								sb.append(row.getValue("name").toString() + ", ");
							}
					}

				});;;
		// @formatter:on

		if (sb.length() > 0) {
			return sb.toString().substring(0, sb.length() - 2);
		} else {
			return "";
		}
	}

	public String onArt(Long artId, Date date) {
		String result = "No";
		/**/
		return result;
	}

	public Record artInitiated(Long artId, Date from, Date to) {
		SITE_SETTING s = Tables.SITE_SETTING.as("s");
		PERSON_ART_STATUS p = Tables.PERSON_ART_STATUS.as("p");

		String startId = "";//schema.select(s.VALUE).from(s).where(s.NAME.eq(ArtStatusService.ART_START_STATUS_ID))
				//.fetchOne().getValue(s.VALUE);

		// @formatter:off				

		return schema.select().from(p)
				.where(p.ART_ID.eq(artId))
				.and(p.ART_STATUS_ID.eq(Long.parseLong(startId)))
				.and(p.DATE.between(from, to))
				.orderBy(p.DATE.asc())
				.limit(1)
				.fetchOne();
		// @formatter:on
	}

	public Map<String, Object> getAncInformation(Long ancId, Date date) {
		ANC a = Tables.ANC.as("a");
		Map<String, Object> result = new HashMap<>();
		Record row = schema.select((dateDiff(date, a.LNMP).as("gestationalAge")), a.LNMP).from(a).where(a.ID.eq(ancId))
				.fetchOne();

		if (row != null && row.getValue(a.LNMP) != null
				&& (Integer.parseInt(row.getValue("gestationalAge").toString()) / 7) >= 0) {

			result.put("gestationalAgeWeeks", Integer.parseInt(row.getValue("gestationalAge").toString()) / 7);
			result.put("gestationalAgeDays", Integer.parseInt(row.getValue("gestationalAge").toString()) % 7);

			if ((Integer.parseInt(row.getValue("gestationalAge").toString().toString()) / 7) <= 12) {
				result.put("trimester", "FIRST");

			} else if ((Integer.parseInt(row.getValue("gestationalAge").toString()) / 7) > 12
					&& (Integer.parseInt(row.getValue("gestationalAge").toString()) / 7) < 28) {
				result.put("trimester", "SECOND");
			} else if ((Integer.parseInt(row.getValue("gestationalAge").toString()) / 7) >= 28) {
				result.put("trimester", "THIRD");
			}

			if (row.getValue(a.LNMP) != null) {
				result.put("edd", dateToString(row.getValue(a.LNMP), "yyyy-MM-dd"));
			} else {
				result.put("edd", null);
			}
		}

		return result;
	}

	public int getDangerSigns(Long opdId) {

		PERSON_COMPLAINT pc = Tables.PERSON_COMPLAINT.as("pc");
		ENCOUNTER_COMPLAINT ec = Tables.ENCOUNTER_COMPLAINT.as("ec");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		SITE_SETTING s = Tables.SITE_SETTING.as("s");
		List<String> dangerList = Arrays.asList(schema.select(s.VALUE).from(s)
				.where(s.NAME.eq("")).fetchOne().getValue(s.VALUE).split(","));
		List<Long> complaintIds = new ArrayList<>();
		dangerList.forEach((l) -> {
			complaintIds.add(Long.parseLong(l));
		});
		// @formatter:off	
		Record row = schema.select(count().as("count"))
				.from(ec)
				.join(pc).on(pc.ID.eq(ec.PERSON_COMPLAINT_ID))
				.join(oe).on(oe.ENCOUNTER_ID.eq(ec.ENCOUNTER_ID))
				.where(oe.OPD_ID.eq(opdId)).and(pc.COMPLAINT_ID.in(complaintIds))
				.fetchOne();
		// @formatter:ON	
		if (row != null) {
			return Integer.parseInt(row.getValue("count").toString());
		}

		return 0;
	}
	
	public Map<String, Integer> getParaAndGravida(Long personId, Date date) {
		ANC a = Tables.ANC.as("a");
		DELIVERY d = Tables.DELIVERY.as("d");
		INFANT i = Tables.INFANT.as("i");
		Map<String, Integer> result = new HashMap<>();
		// @formatter:off
		/*Record gravida = schema.select(count().as("gravida")).from(a)
				.where(a.PERSON_ID.eq(personId))
				.and(a.DATE.lessOrEqual(date))
				.fetchOne();*/
		
		Record para = schema.select(count().as("para")).from(i)
				.join(d).on(d.ID.eq(i.DELIVERY_ID))
				.where(d.PERSON_ID.eq(personId))
				.and(d.DATE.lessOrEqual(new Timestamp(date.getTime())))
				.fetchOne();
		// @formatter:on
		result.put("gravida", 0);
		result.put("parity", Integer.parseInt(para.getValue("para").toString()));

		return result;
	}

	public String checkImmunisation(Long personId, int age) {
		String result = "";

		IMMUNIZATION_SCHEDULE im = Tables.IMMUNIZATION_SCHEDULE.as("im");
		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");
		// @formatter:off
		Record possible = schema.select(count().as("count"))
				.from(im)
				.where(im.TIMELINE.lessOrEqual(age))
				.and(im.PRIMARY_DRUG.eq(true))
				.fetchOne();

		int given = schema.select(count().as("count"))
				.from(pm)
				.join(im).on(pm.DRUG_NAME_ID.eq(im.DRUG_NAME_ID))
				.and((pm.DRUG_OPTION_ID.equal(im.DRUG_OPTION_ID))
						.or((im.DRUG_OPTION_ID.isNull()).and(pm.DRUG_OPTION_ID.isNull())))
				.where(pm.PERSON_ID.eq(personId)).and(im.TIMELINE.lessOrEqual(age))
				.groupBy(pm.DRUG_NAME_ID, pm.DRUG_OPTION_ID)
				.fetch().size();
		
		// @formatter:on
		if (given >= Integer.parseInt(possible.getValue("count").toString())) {
			result = "YES";
		} else {
			result = "NO";
		}

		return result;
	}

	public String dateToString(java.util.Date date, String format) {
		SimpleDateFormat stringFormat = new SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
			c.add(Calendar.DATE, 281);
			return stringFormat.format(c.getTime());
		}
		return "";
	}

	public java.util.Date stringToDate(String inString, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		java.util.Date date = null;

		try {
			date = formatter.parse(inString);

			Calendar cal = Calendar.getInstance();

			cal.setTime(date);

			return cal.getTime();

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}

	}

	public String getPatientManagement(Long opdId) {
		String procedureRow = getProcedures(opdId);
		String drugsRow = getOpdMedication(opdId);
		StringBuffer sb = new StringBuffer();
		if (procedureRow != null) {
			sb.append(procedureRow + ", ");
		}
		if (drugsRow != null) {
			sb.append(drugsRow);
		}

		return sb.toString();
	}

	public String getOpdPurposes(Long opdId) {
		OPD o = Tables.OPD.as("o");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		ENCOUNTER e = Tables.ENCOUNTER.as("e");
		DEPARTMENT dpt = Tables.DEPARTMENT.as("d");
		String result = "";
		// @formatter:off
		Record rowed = this.schema.select(groupConcatDistinct(dpt.NAME).as("name"))
				.from(o)
				.join(oe).on(o.ID.eq(oe.OPD_ID))
				.join(e).on(e.ID.eq(oe.ENCOUNTER_ID))
				.join(dpt).on(dpt.ID.eq(e.DEPARTMENT_ID))
				.where(o.ID.eq(opdId))
				.groupBy(o.ID)
				.fetchOne();
		// @formatter:on
		if (rowed != null) {

			result = rowed.getValue("name").toString();

		}

		return result;
	}

	public Date dateScreened(Long personId, java.sql.Date from, java.sql.Date to) {
		final Date result = null;
		ENCOUNTER_EXAMINATION ea = Tables.ENCOUNTER_EXAMINATION.as("ea");
		PERSON_EXAMINATION pe = Tables.PERSON_EXAMINATION.as("pe");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		OPD o = Tables.OPD.as("o");
		PERSON p = Tables.PERSON.as("p");
		SITE_SETTING s = Tables.SITE_SETTING.as("s");

		List<String> tbExams = Arrays.asList(this.schema.select(s.VALUE).from(s)
				.where(s.NAME.eq("")).fetchOne().getValue(s.VALUE).split(","));
		List<Long> tbExamIds = new ArrayList<>();
		tbExams.forEach((l) -> {
			tbExamIds.add(Long.parseLong(l));
		});
		//@formatter:off
			List<Record2<Long, java.sql.Date>> list = this.schema.select(o.ID,pe.DATE).from(ea)
				.join(pe).on(pe.ID.eq(ea.PERSON_EXAMINATION_ID))
				.join(oe).on(oe.ENCOUNTER_ID.eq(ea.ENCOUNTER_ID))
				.join(o).on(o.ID.eq(oe.OPD_ID))
				.join(p).on(p.ID.eq(o.PERSON_ID))
				.where(pe.EXAMINATION_ID.in(tbExamIds)).and(pe.PERSON_ID.eq(personId))
				.and(o.DATE.between(from, to))
				.groupBy(o.ID)
				.orderBy(o.DATE.desc())
				.fetch();
			//@formatter:on

		for (Record row : list) {
			String tbStatus = "";
			if (tbStatus.equals("Presumptive")) {
				return row.getValue(pe.DATE);
			}
		}
		return result;
	}

	public boolean medicationInitiated(Long personId, java.sql.Date from, java.sql.Date to, List<Long> drugList) {
		boolean result = false;
		PERSON_MEDICATION pm = Tables.PERSON_MEDICATION.as("pm");

		//@formatter:off
		Record previous = this.schema.select(count().as("count"))
				.from(pm)
				.where(pm.PERSON_ID.eq(personId))
				.and(pm.DATE.lessThan(new Timestamp(from.getTime())).and(pm.DRUG_NAME_ID.in(drugList)))
				.fetchOne();
		
		Record current = this.schema.select(count().as("count"))
				.from(pm)
				.where(pm.PERSON_ID.eq(personId).and(pm.DATE.between(new Timestamp(from.getTime()), new Timestamp(to.getTime()))).and(pm.DRUG_NAME_ID.in(drugList)))
				.fetchOne();
		//@formatter:on

		if (Integer.parseInt(previous.getValue("count").toString()) == 0
				&& Integer.parseInt(current.getValue("count").toString()) > 0) {
			result = true;
		}
		return result;
	}

	public java.util.Date addToCurrent(java.util.Date inDate, int number) {
		Calendar c = Calendar.getInstance();
		c.setTime(inDate);
		c.add(Calendar.DATE, number);

		return c.getTime();
	}

	public boolean retestedAt(Long personId, java.sql.Date from, java.sql.Date to) {
		boolean result = false;
		PERSON_INVESTIGATION pi = Tables.PERSON_INVESTIGATION.as("pi");
		SITE_SETTING s = Tables.SITE_SETTING.as("s");

		String hivId = this.schema.select(s.VALUE).from(s).where(s.NAME.eq("")).fetchOne()
				.getValue(s.VALUE);

		String hivPcrId = this.schema.select(s.VALUE).from(s).where(s.NAME.eq(""))
				.fetchOne().getValue(s.VALUE);

		List<Long> hivIds = new ArrayList<>();
		hivIds.add(Long.parseLong(hivId));
		hivIds.add(Long.parseLong(hivPcrId));

		//@formatter:off
				Record previous = this.schema.select(count().as("count"))
						.from(pi)
						.where(pi.PERSON_ID.eq(personId).and(pi.DATE.lessThan(new Timestamp(from.getTime()))).and(pi.INVESTIGATION_ID.in(hivIds)))
						.fetchOne();
				
				Record current = this.schema.select(count().as("count"))
						.from(pi)
						.where(pi.PERSON_ID.eq(personId))
						.and(pi.DATE.between(new Timestamp(from.getTime()), new Timestamp(to.getTime()))).and(pi.INVESTIGATION_ID.in(hivIds))
						.fetchOne();
		//@formatter:on

		if (Integer.parseInt(previous.getValue("count").toString()) > 0
				&& Integer.parseInt(current.getValue("count").toString()) > 0) {
			result = true;
		}

		return result;
	}

	public boolean procedureDone(Long personId, Date from, Date to, List<Long> procedureList) {
		boolean result = false;
		PERSON_PROCEDURE p = Tables.PERSON_PROCEDURE.as("p");

		// @formatter:off
		int count = schema.select().from(p)
				.where(p.PERSON_ID.eq(personId))
				.and(p.DATE.between(new java.sql.Date(from.getTime()),new java.sql.Date(to.getTime())))
				.and(p.PROCEDURE_ID.in(procedureList))
				.fetchCount();
		// @formatter:on
		if (count > 0) {
			return true;
		}
		return result;
	}

	public String getOpdNote(Long opdId) {
		String result = "";
		ENCOUNTER_NOTE en = Tables.ENCOUNTER_NOTE.as("en");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		OPD o = Tables.OPD.as("o");
		// @formatter:off
		Record rowed = this.schema.select(groupConcatDistinct(en.NOTE).as("note")).from(en)
		.join(oe).on(oe.ENCOUNTER_ID.eq(en.ENCOUNTER_ID))
		.join(o).on(o.ID.eq(oe.OPD_ID))
		.where(o.ID.eq(opdId))
		.groupBy(o.ID)
		.fetchOne();
		// @formatter:on
		if (rowed != null) {

			result = rowed.getValue("note").toString();

		}

		return result;
	}

	public String getDiagnosis(Long personId, Date from, Date to) {
		DIAGNOSIS d = Tables.DIAGNOSIS.as("d");
		PERSON_DIAGNOSIS pd = Tables.PERSON_DIAGNOSIS.as("pd");
		OPD_ENCOUNTER oe = Tables.OPD_ENCOUNTER.as("oe");
		// @formatter:off
		Record row = schema.select(groupConcatDistinct(d.NAME).as("diagnosis"))
				.from(pd)
				.join(d).on(d.ID.eq(pd.DIAGNOSIS_ID))
				.where(pd.DATE.between(from,to))
				.and(pd.PERSON_ID.eq(personId))
				.groupBy(pd.PERSON_ID)
				.limit(1)
				.fetchOne();
		// @formatter:on
		if (row != null) {
			return row.getValue("diagnosis").toString();
		}

		return "";
	}
}