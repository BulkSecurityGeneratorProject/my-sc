package zw.co.elearning.school.reports.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

public class WeekySurvaillanceUnder19Service extends ReportService<SubReportData<WeekySurvaillanceUnder19Data>> {

	@Override
	public String getGroup() {
		return "Lists";
	}

	@Override
	public String getId() {
		return "weekly-survillance";
	}

	@Override
	public String getName() {
		return "Weekly Survillance Under 19";
	}

	@Override
	protected Collection<SubReportData<WeekySurvaillanceUnder19Data>> generateData(Date from, Date to,
			String[] deptIds) {
		
		List<WeekySurvaillanceUnder19Data> data = new ArrayList<>();
		
		WeekySurvaillanceUnder19Data weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Suspected Malaria");
		weekly.setNumber(6);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Tested Malaria");
		weekly.setNumber(8);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Positive Malaria");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Malaria Deaths");
		weekly.setNumber(8);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Diarrhoea Cases");
		weekly.setNumber(2);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Diarrhoea Death");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dysentery Cases");
		weekly.setNumber(3);
		data.add(weekly);
	
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dysentery Death");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Acute Respiratory Infection Cases");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Acute Respiratory Infection Death");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Maternal Deaths");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dog Bite Cases");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dog Bite Deaths");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dog Vaccinated");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dogs Unvaccinated");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Dogs Unknown Status");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Bilateral Oedemia / Kwashiokor");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Severe wasting / Marasmus");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Marasmic Kwashiokor");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Cholera Cases");
		weekly.setNumber(3);
		data.add(weekly);
		
		weekly = new WeekySurvaillanceUnder19Data();
		weekly.setLabel("Cholera Deaths");
		weekly.setNumber(3);
		data.add(weekly);
		
				
		List<SubReportData<WeekySurvaillanceUnder19Data>> result = new ArrayList<>();

		result.add(new SubReportData<WeekySurvaillanceUnder19Data>(data));

		return result;

	}

	@Override
	public String getTemplateUrl() {
		return "reports/atb/weeklysurvillance.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a3_landscape.jasper";
	}

} 
