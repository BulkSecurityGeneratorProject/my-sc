package zw.co.elearning.school.reports;

import java.util.Collection;
import java.util.Date;

public interface ReportSource<T> {

	String getGroup();

	String getId();

	String getName();

	void generate(Date from, Date to, String[] deptIds);

	String getTemplateUrl();

	Collection<T> getData();

	String getLayoutTemplateUrl();
	
	ReportFrequency getFrequency();
	

}
