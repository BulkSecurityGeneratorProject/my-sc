package zw.co.elearning.school.reports.registers;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.db.tables.TB;
import zw.co.elearning.school.db.tables.TB_CATEGORY;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class MalnourisheReportServices extends ReportService<SubReportData<MalnourisheData>> {

	@Override
	public String getGroup() {

		return "Registers";
	}

	@Override
	public String getId() {

		return "malnourishe-register";
	}

	@Override
	public String getName() {

		return " Malnourishe register";
	}

	//@formatter:off
	
	@Override
	protected Collection<SubReportData<MalnourisheData>> generateData(Date from, Date to, String[] deptIds) {
		
		List<MalnourisheData> data = new ArrayList<>();
		
		
		PERSON p = Tables.PERSON.as("p");
		TB_CATEGORY c = Tables.TB_CATEGORY.as("c");
		TB t = Tables.TB.as("t");
		
		this.schema()
		.select(concat(p.LASTNAME, val(" "), p.FIRSTNAME).as("fullname"),t.DATE,
				p.SEX, t.TYPE,c.NAME).from(t)
		.leftJoin(p).on(p.ID.eq(t.PERSON_ID))
		.leftJoin(c).on(c.ID.eq(t.CATEGORY_ID))
		.fetch().forEach((row) -> {
			
			MalnourisheData mal = new MalnourisheData();
			
			mal.setFullname(row.getValue("fullname").toString());
			mal.setClassification("classification");
			mal.setAge(22);
			mal.setWeight("weight");
			mal.setGender("gender");
			
			
			data.add(mal);
		});
		

	List<SubReportData<MalnourisheData>> result = new ArrayList<>();

	result.add(new SubReportData<MalnourisheData>(data));

	return result;
	}
	
	@Override
	public String getTemplateUrl() {
		return "reports/registers/malnourishe.jasper";
		
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a3_landscape.jasper";
	}

}
