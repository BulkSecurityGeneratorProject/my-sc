package zw.co.elearning.school.reports.registers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class VaccinationRegisterService extends ReportService<SubReportData<VaccinationRegisterData>> {

	@Override
	public String getGroup() {
	
		return "Registers";
	}

	@Override
	public String getId() {
		
		return "vaccination-reg";
	}

	@Override
	public String getName() {
		
		return "VACCINATIONS (and Vitamin A supplement)";
	}

	@Override
	protected Collection<SubReportData<VaccinationRegisterData>> generateData(Date from, Date to, String[] deptIds) {
		List<VaccinationRegisterData> data = new ArrayList<>();
		
		VaccinationRegisterData vaccination = new VaccinationRegisterData();
		
		vaccination.setAdverseEffects("XXXXXX");
		vaccination.setCondition("condition");
	    vaccination.setOnePlusFemale(4);
	    vaccination.setOnePlusMale(2);
	    vaccination.setUnder1Female(8);
	    vaccination.setUnder1Male(19);
	    
	    data.add(vaccination);
	    
	    
		List<SubReportData<VaccinationRegisterData>> result = new ArrayList<>();
		
		
		
		
		

		result.add(new SubReportData<VaccinationRegisterData>(data));
		return result;
		
	}

	@Override
	public String getTemplateUrl() {
		return "reports/t5/vaccination.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a2_landscape.jasper";
	}


}
