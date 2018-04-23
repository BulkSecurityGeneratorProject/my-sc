package zw.co.elearning.school.reports;

import java.util.Collection;

public class SubReportData<T> {

	private Collection<T> data;

	public Collection<T> getData() {
		return data;
	}

	public SubReportData(Collection<T> data) {
		this.data = data;
	}

}
