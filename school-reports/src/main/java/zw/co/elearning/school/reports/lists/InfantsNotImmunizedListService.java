package zw.co.elearning.school.reports.lists;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.dateDiff;
import static org.jooq.impl.DSL.val;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.SITE_SETTING;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;
import zw.co.elearning.school.reports.util.QueryUtil;

@Component
public class InfantsNotImmunizedListService extends ReportService<SubReportData<InfantsNotImmunizedListData>> {

	private final Logger log = LoggerFactory.getLogger(InfantsNotImmunizedListService.class);
	@Autowired
	private QueryUtil q;

	@Override
	public String getGroup() {
		return "Lists";
	}

	@Override
	public String getId() {
		return "infants-not-immunised";
	}

	@Override
	public String getName() {
		return "List of infants not immunised";
	}

	@Override
	protected Collection<SubReportData<InfantsNotImmunizedListData>> generateData(Date from, Date to,
			String[] deptIds) {
		List<InfantsNotImmunizedListData> data = new ArrayList<>();
		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());
		PERSON p = Tables.PERSON.as("p");

		SITE_SETTING s = Tables.SITE_SETTING.as("s");

		// @formatter:off
		
		this.schema().select(concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("fullname"),p.SEX,dateDiff(toDate,p.BIRTHDATE).as("age"),p.ID).from(p)
		.where(dateDiff(toDate,p.BIRTHDATE).lessOrEqual(1825))
		.fetch().forEach((row)->{
			if(q.checkImmunisation(row.getValue(p.ID),Integer.parseInt(row.getValue("age").toString())).equals("NO")){
				InfantsNotImmunizedListData detail = new InfantsNotImmunizedListData();
				detail.setAge(Integer.parseInt(row.getValue("age").toString())/30);
				detail.setFullname(row.getValue("fullname").toString());
				detail.setSex(row.getValue(p.SEX));

				data.add(detail);
			}
			
		});
		// @formatter:on

		List<SubReportData<InfantsNotImmunizedListData>> result = new ArrayList<>();

		result.add(new SubReportData<InfantsNotImmunizedListData>(data));

		return result;
	}

	

	@Override
	public String getTemplateUrl() {
		return "reports/mbp/infantsnotimmunised.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a4_potrait.jasper";
	}
}
