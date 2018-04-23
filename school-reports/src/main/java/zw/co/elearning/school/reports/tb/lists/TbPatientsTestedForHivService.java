package zw.co.elearning.school.reports.tb.lists;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.ENCOUNTER;
import zw.co.elearning.school.db.tables.HTS;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.PERSON_INVESTIGATION;
import zw.co.elearning.school.db.tables.TB;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;
import zw.co.elearning.school.reports.util.QueryUtil;


@Component
public class TbPatientsTestedForHivService extends ReportService<SubReportData<TbPatientsTestedForHivData>> {

	@Autowired
	private QueryUtil q;


	@Override
	public String getGroup() {
		return "TbLists";
	}

	@Override
	public String getId() {
		return "tb-patients-tested-for-hiv";
	}

	@Override
	public String getName() {
		return "Tb Patients Tested For Hiv";
	}

	@Override
		protected Collection<SubReportData<TbPatientsTestedForHivData>> generateData(Date from, Date to,
				String[] deptIds) {
			
			List<TbPatientsTestedForHivData> data = new ArrayList<>();
			
			PERSON p = Tables.PERSON.as("p");
			TB t = Tables.TB.as("t");
			HTS h = Tables.HTS.as("h");
			PERSON_INVESTIGATION pi = Tables.PERSON_INVESTIGATION.as("pi");
			ENCOUNTER en = Tables.ENCOUNTER.as("en");
			
			java.sql.Date fromDate = new java.sql.Date(from.getTime());
			java.sql.Date toDate = new java.sql.Date(to.getTime());
			
			
			// @formatter:off
			this.schema()
			.select(concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("fullname"),t.DATE,
					p.SEX,p.ID, t.PERSON_ID, pi.PERSON_ID, p.BIRTHDATE, h.INVESTIGATION_ID, t.OUTCOME).from(h)
			.join(pi).on(pi.ID.eq(h.INVESTIGATION_ID))
			.join(t).on(t.PERSON_ID.eq(pi.PERSON_ID))
			.join(p).on(p.ID.eq(t.PERSON_ID))
			.orderBy(t.DATE.desc())
			.fetch().forEach((row) -> {
			
			
			TbPatientsTestedForHivData tbhiv = new TbPatientsTestedForHivData();
			
			// @formatter:off
			tbhiv.setFullname(row.getValue("fullname").toString());
			tbhiv.setDate(row.getValue(t.DATE));
			tbhiv.setAge(q.getAgeYears(row.getValue(p.BIRTHDATE), row.getValue(en.DATE)));
			Map<String, Object> hiv = q.getInvestigationResult(row.getValue(h.INVESTIGATION_ID));
			if(hiv.get("result")!=null){
				tbhiv.setHivStatus(hiv.get("result").toString());
			}
			
			tbhiv.setSex(row.getValue(p.SEX));
			tbhiv.setAddress(q.getCurrentAddress(row.getValue(p.ID)));
			tbhiv.setTbstatus(row.getValue(t.OUTCOME));
			
			data.add(tbhiv);
			
			});
		

		List<SubReportData<TbPatientsTestedForHivData>> result = new ArrayList<>();

		result.add(new SubReportData<TbPatientsTestedForHivData>(data));

		return result;
	}
	  
		@Override
		public String getTemplateUrl() {
			return "reports/tb_lists/tb-patients-tested-hiv.jasper";
		}
		
		@Override
		public String getLayoutTemplateUrl() {
			return "reports/a4_potrait.jasper";
		}
	}
