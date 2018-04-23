package zw.co.elearning.school.reports.registers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class ChronicPatientsRegisterService extends ReportService<SubReportData<ChronicPatientsRegisterData>>  {

	@Override
	public String getGroup() {
		return "Registers";
	}

	@Override
	public String getId() {
		return "chronic-patients-register";
	}

	@Override
	public String getName() {
           return "Chronic Patients Register";
	}

	@Override
	protected Collection<SubReportData<ChronicPatientsRegisterData>> generateData(Date from, Date to,
			String[] deptIds) {
		
		List<ChronicPatientsRegisterData> data = new ArrayList<>();
		
		ChronicPatientsRegisterData chronic = new ChronicPatientsRegisterData();
		
		chronic.setCondition("Diabetes");
		chronic.setFullname("Alufandika Rosemary");
		chronic.setSex("Female");
		chronic.setAddress("307 Mashambanhaka Primary School. Murewa");
		chronic.setAge("35");
	
		data.add(chronic);
	

	List<SubReportData<ChronicPatientsRegisterData>> result = new ArrayList<>();

	result.add(new SubReportData<ChronicPatientsRegisterData>(data));

	return result;
}
  
	@Override
	public String getTemplateUrl() {
		return "reports/registers/chronic-patients-register.jasper";
	}
	
	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a3_landscape.jasper";
	}
}
