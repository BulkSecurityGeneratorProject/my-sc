package zw.co.elearning.school.reports;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.NotSupportedException;

import net.sf.jasperreports.engine.JRException;

public interface ReportGenerator {

	List<String> reportsGroups();

	List<Map<String, String>> reportsInGroup(String group);

	File generate(String reportId, Date from, Date to, String[] deptIds, String format)
			throws IOException, JRException, NotSupportedException;

	void add(ReportSource<?> abstractReportSource);

}
