package zw.co.elearning.school.reports.t5.opd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.ADDRESS;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class OpdGeneralReportService extends ReportService<SubReportData<OpdGeneralDTO>> {

	private final Logger log = LoggerFactory.getLogger(OpdGeneralReportService.class);

	@Override
	public String getGroup() {
		return "T5";
	}

	@Override
	public String getId() {
		return "t5_opg_general";
	}

	@Override
	public String getName() {
		return "Out Patient General Condition";
	}

	@Override
	protected Collection<SubReportData<OpdGeneralDTO>> generateData(Date from, Date to, String[] deptIds) {
		List<OpdGeneralDTO> data = new ArrayList<>();

		PERSON p = Tables.PERSON.as("p");
		ADDRESS a = Tables.ADDRESS.as("a");

		this.schema().select().from(p).fetch().forEach((row) -> {
			OpdGeneralDTO dto = new OpdGeneralDTO();

			dto.setCondition(row.getValue(p.FIRSTNAME));

			data.add(dto);
		});

		List<SubReportData<OpdGeneralDTO>> result = new ArrayList<>();

		result.add(new SubReportData<OpdGeneralDTO>(data));

		return result;

	}

	@Override
	public String getTemplateUrl() {
		return "/reports/t5/opd.jasper";
	}

}
