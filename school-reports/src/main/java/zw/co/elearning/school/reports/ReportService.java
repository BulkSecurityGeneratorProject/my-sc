package zw.co.elearning.school.reports;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jooq.DSLContext;

public abstract class ReportService<T> implements ReportSource<T> {

	@Inject
	ReportGenerator reportGenerator;

	@Inject
	DSLContext dsl;

	private Collection<T> data;

	private Date from;

	private Date to;

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}

	public abstract String getGroup();

	public abstract String getId();

	public abstract String getName();

	public ReportFrequency getFrequency(){
		return ReportFrequency.MONTHLY;
	}
	
	public int getYear() {
		Calendar c = Calendar.getInstance();
		c.setTime(from);
		return c.get(Calendar.YEAR);
	}

	public int getMonth() {
		Calendar c = Calendar.getInstance();
		c.setTime(from);
		return c.get(Calendar.MONTH);
	}

	public String getMonthName() {
		Calendar c = Calendar.getInstance();
		c.setTime(from);
		return c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
	}

	public Date getReportDate() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}

	protected DSLContext schema() {
		return dsl;
	}

	public void generate(Date from, Date to, String[] deptIds) {
		this.from = from;
		this.to = to;
		data = generateData(from, to, deptIds);
	}

	protected abstract Collection<T> generateData(Date from, Date to, String[] deptIds);

	public abstract String getTemplateUrl();

	public String getLayoutTemplateUrl() {
		return getTemplateUrl();
	}

	public Collection<T> getData() {
		return data;
	}

	@PostConstruct
	protected void register() {
		reportGenerator.add(this);
	}
}
