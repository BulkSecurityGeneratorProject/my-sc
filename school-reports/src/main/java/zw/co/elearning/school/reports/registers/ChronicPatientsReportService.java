package zw.co.elearning.school.reports.registers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class ChronicPatientsReportService extends ReportService<SubReportData<ChronicPatientsReportData>>  {

	@Override
	public String getGroup() {
		return "Registers";
	}

	@Override
	public String getId() {
		return "chronic-patients-report";
	}

	@Override
	public String getName() {
           return "Chronic Patients Report";
	}

	@Override
	protected Collection<SubReportData<ChronicPatientsReportData>> generateData(Date from, Date to,
			String[] deptIds) {
		
		List<ChronicPatientsReportData> data = new ArrayList<>();
		
		ChronicPatientsReportData chronic = new ChronicPatientsReportData();
		
		chronic.setCondition("Diabetes");
		chronic.setZeroTo24MaleNew(2);
		chronic.setZeroTo24FemaleNew(3);
		chronic.setTwo5PlusMaleNew(4);
		chronic.setTwo5PlusFemaleNew(3);
		chronic.setZeroTo24Malefollowup(3);
		chronic.setZeroTo24Femalefollowup(4);
		chronic.setTwo5PlusMalefollowup(6);
		chronic.setTwo5PlusFemalefollowup(6);
		chronic.setRegPatientsMale(6);
		chronic.setRegPatientsFemale(5);
		
		data.add(chronic);
	

	List<SubReportData<ChronicPatientsReportData>> result = new ArrayList<>();

	result.add(new SubReportData<ChronicPatientsReportData>(data));

	return result;
}
  
	@Override
	public String getTemplateUrl() {
		return "reports/registers/chronic-patients-report.jasper";
	}
	
	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a3_landscape.jasper";
	}
}
