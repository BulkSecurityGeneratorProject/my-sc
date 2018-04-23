package zw.co.elearning.school.reports.registers;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.OPD;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.SITE_SETTING;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class StiRegisterService extends ReportService<SubReportData<StiRegisterData>>  {



	
	@Override
	public String getGroup() {
		return "Registers";
	}

	@Override
	public String getId() {
		return "sti-register";
	}

	@Override
	public String getName() {
           return "Sti Register";
	}

	//@formatter:off
	@Override
	protected Collection<SubReportData<StiRegisterData>> generateData(Date from, Date to, String[] deptIds) {
		
		List<StiRegisterData> data = new ArrayList<>();
		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());

		PERSON p = Tables.PERSON.as("p");
		OPD o = Tables.OPD.as("o");
		SITE_SETTING s = Tables.SITE_SETTING.as("s");
		
		this.schema().select(o.DATE,concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("fullname"),o.PERSON_ID,p.BIRTHDATE,o.ID,p.SEX)
		.from(o).join(p).on(o.PERSON_ID.eq(p.ID)).where(o.DATE.between(fromDate,toDate)).fetch()
				.forEach((row) -> {

					StiRegisterData sti = new StiRegisterData();
					
					sti.setDate(row.getValue(o.DATE));
					sti.setFullname("tinashe");
					sti.setSex("male");
					sti.setAddress("1405");
					sti.setAge(23);		
					sti.setTypeofSexAnal("typeofSexAnal");
					sti.setGud("gud");
					sti.setUds("uds");
					sti.setVds("vds");
					sti.setGenitalBlisters("genitalBlisters");
					sti.setGenitalWarts("genitalWarts");
					sti.setScrotalSwelling("scrotalSwelling");
					sti.setTreatment("treatment");
					sti.setTypeofSexVaginal("typeofSexVaginal");
					sti.setSyphillisTestsResultNonPregFemale("syphillisTestsResultNonPregFemale");
					sti.setSyphillisTestsResultmale("syphillisTestsResultmale");
					sti.setTestedforHiv("testedforHiv");
					sti.setHivResult("hivResult");
					sti.setTypeofSexOral("typeofSexOral");
					sti.setContactSlipsIssued("contactSlipsIssued");
					sti.setContactSlipsReceived("contactSlipsReceived");
					

					
					data.add(sti);
				});

		List<SubReportData<StiRegisterData>> result = new ArrayList<>();

		result.add(new SubReportData<StiRegisterData>(data));

		return result;
	}
	
  
	@Override
	public String getTemplateUrl() {
		return "reports/registers/sti.jasper";
	}
	
	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a2_landscape.jasper";
	}
}
