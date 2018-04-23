package zw.co.elearning.school.reports.t5.opd;

public class OpdGeneralDTO {
	private String condition;

	private int under5male;
	private int under5female;
	private int over5male;
	private int over5female;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getUnder5male() {
		return under5male;
	}

	public void setUnder5male(int under5male) {
		this.under5male = under5male;
	}

	public int getUnder5female() {
		return under5female;
	}

	public void setUnder5female(int under5female) {
		this.under5female = under5female;
	}

	public int getOver5male() {
		return over5male;
	}

	public void setOver5male(int over5male) {
		this.over5male = over5male;
	}

	public int getOver5female() {
		return over5female;
	}

	public void setOver5female(int over5female) {
		this.over5female = over5female;
	}

}
