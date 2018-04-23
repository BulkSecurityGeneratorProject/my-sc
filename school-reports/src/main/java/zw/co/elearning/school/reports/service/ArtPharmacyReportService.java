package zw.co.elearning.school.reports.service;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.ART;
import zw.co.elearning.school.db.tables.ART_VISIT;
import zw.co.elearning.school.db.tables.ART_VISIT_STATUS;
import zw.co.elearning.school.db.tables.ARV_COMBINATION_REGIMEN;
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
import zw.co.elearning.school.reports.dto.ArtPharmacyDTO;
import zw.co.elearning.school.reports.util.QueryUtil;

@Component
public class ArtPharmacyReportService extends ReportService<SubReportData<ArtPharmacyDTO>> {

	private final Logger log = LoggerFactory.getLogger(ArtPharmacyReportService.class);

	@Autowired
	private QueryUtil q;

	@Override
	public String getGroup() {
		return "Registers";
	}

	@Override
	public String getId() {
		return "register_art_pharmacy_register";
	}

	@Override
	public String getName() {
		return "ART PHARMACY REGISTER";
	}

	@Override
	protected Collection<SubReportData<ArtPharmacyDTO>> generateData(Date from, Date to, String[] deptIds) {
		List<ArtPharmacyDTO> data = new ArrayList<>();
		Timestamp fromDate = new Timestamp(from.getTime());
		Timestamp toDate = new Timestamp(to.getTime());

		PERSON p = Tables.PERSON.as("p");
		ART a = Tables.ART.as("a");
		ART_VISIT av = Tables.ART_VISIT.as("av");
		ART_VISIT_STATUS avs = Tables.ART_VISIT_STATUS.as("avs");
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
		ARV_COMBINATION_REGIMEN acr = Tables.ARV_COMBINATION_REGIMEN.as("acr");

		List<Long> drugIds = new ArrayList<>();

		/*
		 * select d.date,a.art_number,concat(p.lastname,' ', p.firstname) as
		 * fullname,p.birthdate,p.sex,dn.alias,dn.name,d.quantity from dispense
		 * d join person_medication pm on pm.id=d.person_medication_id join
		 * person p on p.id=pm.person_id join art a on a.person_id=pm.person_id
		 * join drug_name dn on dn.id=pm.drug_name_id where d.drug_id in (select
		 * drug_id from arv_combination_regimen) and d.date between '2017-03-01'
		 * and'2017-03-31';
		 */

		// @formatter:off	
		this.schema().select().from(acr).fetch().forEach((row) -> {
			drugIds.add(row.getValue(acr.DRUG_ID));
		});
		this.schema().select(p.ID,d.DATE, a.ART_NUMBER, concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("fullname"),
				p.BIRTHDATE, p.SEX, dn.ALIAS, dn.NAME, d.QUANTITY).from(d)
		.join(pm).on(pm.ID.eq(d.PERSON_MEDICATION_ID))
		.join(p).on(p.ID.eq(pm.PERSON_ID))
		.join(a).on(a.PERSON_ID.eq(pm.PERSON_ID))
		.join(dn).on(dn.ID.eq(pm.DRUG_NAME_ID))
		.where(d.DATE.between(fromDate,toDate))
		.and(d.DRUG_ID.in(drugIds))
		.orderBy(a.DATE.desc())
				.fetch().forEach((row) -> {

					ArtPharmacyDTO dto = new ArtPharmacyDTO();

					
					dto.setName(row.getValue("fullname").toString());
					dto.setAge(q.getAgeYears(row.getValue(p.BIRTHDATE).toLocalDate(), q.fromDate(row.getValue(d.DATE))));		
					dto.setAddress(q.getCurrentAddress(row.getValue(p.ID)));
					dto.setDate(row.getValue(av.DATE));		
					dto.setArtNumber(row.getValue(a.ART_NUMBER));
					dto.setTreatment(row.getValue(dn.NAME) 
							.concat("")
							.concat(row.getValue(dn.ALIAS)));
					dto.setQuantity(row.getValue(d.QUANTITY));
					dto.setSex(row.getValue(p.SEX));
				
					data.add(dto);
				});
		
		List<SubReportData<ArtPharmacyDTO>> result = new ArrayList<>();

		result.add(new SubReportData<ArtPharmacyDTO>(data));
		
		return result;

		
	}

	@Override
	public String getTemplateUrl() {
		return "reports/registers/pharmacy-consumption.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a4_landscape.jasper";
	}

}
