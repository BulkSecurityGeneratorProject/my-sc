package zw.co.elearning.school.reports.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import zw.co.elearning.school.reports.ReportFrequency;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;
@Component
public class WeeklySurveillanceService  extends ReportService<SubReportData<WeeklySurvillanceUnder19Data>> {

	@Override
	public String getGroup() {
		return "Lists";
	}

	@Override
	public String getId() {

		return "weekly-surveillance";
	}

	@Override
	public String getName() {
		return "Weekly Surveillance";
	}

	@Override
	public ReportFrequency getFrequency() {
		return ReportFrequency.WEEKLY;
	}
	
	@Override
	protected Collection<SubReportData<WeeklySurvillanceUnder19Data>> generateData(Date from, Date to,
			String[] deptIds) {
		
		List<WeeklySurvillanceUnder19Data> data = new ArrayList<>();
		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());

		WeeklySurvillanceUnder19Data weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Suspected Malaria");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Tested Malaria");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Positive Malaria");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Malaria Deaths");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Diarrhoea Cases ");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Diarrhoea Death");
		weekly.setNumber(4);
		data.add(weekly);
		
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dysentery Cases");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dysentery Death");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Acute Respiratory Infection Cases");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Acute Respiratory Infection Death");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Maternal Deaths");
		weekly.setNumber(4);
		data.add(weekly);
		
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dog Bite Cases");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dog Bite Death");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dogs Vaccinated");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dogs Unvaccinated");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Dogs Unknown Status");
		weekly.setNumber(4);
		data.add(weekly);
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Bilateral Oedemia / Kwashiokor");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Severe wasting / Marasmus");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Marasmic Kwashiokor");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Cholera Cases");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Cholera Deaths");
		weekly.setNumber(4);
		data.add(weekly);
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Typhoid Cases");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Typhoid Death");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Measles Cases");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Measles Death");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Acute Flacid Paralysis Cases");
		weekly.setNumber(4);
		data.add(weekly);
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Acute Flacid Paralysis Death");
		weekly.setNumber(4);
		data.add(weekly);
		
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Snake Bite Cases");
		weekly.setNumber(4);
		data.add(weekly);
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Snake Bite Deaths");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Anthrax Cases");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Anthrax Death");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Rabies Cases");
		weekly.setNumber(5);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Rabies Deaths");
		weekly.setNumber(4);
		data.add(weekly);
		
		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Neonatal Tetanus Cases");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Neonatal Tetanus Death");
		weekly.setNumber(6);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Meningococcal Meningitis Cases");
		weekly.setNumber(7);
		data.add(weekly);

		weekly = new WeeklySurvillanceUnder19Data();
		weekly.setLabel("Meningococcal Meningitis Death");
		weekly.setNumber(5);
		data.add(weekly);


		List<SubReportData<WeeklySurvillanceUnder19Data>> result = new ArrayList<>();

		result.add(new SubReportData<WeeklySurvillanceUnder19Data>(data));

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
