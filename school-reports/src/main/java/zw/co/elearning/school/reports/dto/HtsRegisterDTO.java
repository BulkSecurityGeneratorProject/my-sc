package zw.co.elearning.school.reports.dto;

import java.util.Date;

public class HtsRegisterDTO {
	
	private Date date;
	private String name;
	private String address;
	private int age;
	private String sex;
	private boolean preTestCounselling;
	private boolean resultsIssued;
	private boolean couple;
	private String htcModel;
	private String reasonForNotIssuingResult;
	private boolean retest;
	private String approach;
	private boolean opt = false;
	
	private String testPurpose;
	private String testType;
	private String pregnancytest;
	private String pregnancytestNull;
	private boolean postTestCounselling;
	private String referedService;
	private String result ;
	private String test1TestKit;
	private String test1ExpiryDate;
	private String test1BatchNumber;
	private String test1Result;
	private String test2TestKit;
	private String test2ExpiryDate;
	private String test2BatchNumber;
	private String test2Result;
	private String test3TestKit;
	private String test3ExpiryDate;
	private String test3BatchNumber;
	private String test3Result;
	private boolean groupEducation;
	
	

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}

	
	public String getReferedService() {
		return referedService;
	}
	public void setReferedService(String referedService) {
		this.referedService = referedService;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public boolean isPreTestCounselling() {
		return preTestCounselling;
	}
	public void setPreTestCounselling(boolean preTestCounselling) {
		this.preTestCounselling = preTestCounselling;
	}
	public boolean isResultsIssued() {
		return resultsIssued;
	}
	public void setResultsIssued(boolean resultsIssued) {
		this.resultsIssued = resultsIssued;
	}
	public boolean isCouple() {
		return couple;
	}
	public void setCouple(boolean couple) {
		this.couple = couple;
	}
	
	
	public String getHtcModel() {
		return htcModel;
	}
	public void setHtcModel(String htcModel) {
		this.htcModel = htcModel;
	}
	public String getReasonForNotIssuingResult() {
		return reasonForNotIssuingResult;
	}
	public void setReasonForNotIssuingResult(String reasonForNotIssuingResult) {
		this.reasonForNotIssuingResult = reasonForNotIssuingResult;
	}
	public String getTestPurpose() {
		return testPurpose;
	}
	public void setTestPurpose(String testPurpose) {
		this.testPurpose = testPurpose;
	}
	public boolean isPostTestCounselling() {
		return postTestCounselling;
	}
	public void setPostTestCounselling(boolean postTestCounselling) {
		this.postTestCounselling = postTestCounselling;
	}

	public void setGroupEducation(boolean groupEducation) {
		this.groupEducation = groupEducation;
	}
	

	public String getTest1BatchNumber() {
		return test1BatchNumber;
	}
	public void setTest1BatchNumber(String test1BatchNumber) {
		this.test1BatchNumber = test1BatchNumber;
	}
	public String getTest1Result() {
		return test1Result;
	}
	public void setTest1Result(String test1Result) {
		this.test1Result = test1Result;
	}
	public String getTest2TestKit() {
		return test2TestKit;
	}
	public void setTest2TestKit(String test2TestKit) {
		this.test2TestKit = test2TestKit;
	}

	public String getTest2BatchNumber() {
		return test2BatchNumber;
	}
	public void setTest2BatchNumber(String test2BatchNumber) {
		this.test2BatchNumber = test2BatchNumber;
	}
	public String getTest2Result() {
		return test2Result;
	}
	public void setTest2Result(String test2Result) {
		this.test2Result = test2Result;
	}
	public String getTest3TestKit() {
		return test3TestKit;
	}
	public void setTest3TestKit(String test3TestKit) {
		this.test3TestKit = test3TestKit;
	}

	public String getTest3BatchNumber() {
		return test3BatchNumber;
	}
	public void setTest3BatchNumber(String test3BatchNumber) {
		this.test3BatchNumber = test3BatchNumber;
	}
	public String getTest3Result() {
		return test3Result;
	}
	public void setTest3Result(String test3Result) {
		this.test3Result = test3Result;
	}
	public boolean isGroupEducation() {
		return groupEducation;
	}
	public String getPregnancytest() {
		return pregnancytest;
	}
	public void setPregnancytest(String pregnancytest) {
		this.pregnancytest = pregnancytest;
	}
	public String getPregnancytestNull() {
		return pregnancytestNull;
	}
	public void setPregnancytestNull(String pregnancytestNull) {
		this.pregnancytestNull = pregnancytestNull;
	}
	public String getTest1TestKit() {
		return test1TestKit;
	}
	public void setTest1TestKit(String test1TestKit) {
		this.test1TestKit = test1TestKit;
	}
	public String getApproach() {
		return approach;
	}
	public void setApproach(String approach) {
		this.approach = approach;
	}
	public String getTest1ExpiryDate() {
		return test1ExpiryDate;
	}
	public void setTest1ExpiryDate(String test1ExpiryDate) {
		this.test1ExpiryDate = test1ExpiryDate;
	}
	public String getTest2ExpiryDate() {
		return test2ExpiryDate;
	}
	public void setTest2ExpiryDate(String test2ExpiryDate) {
		this.test2ExpiryDate = test2ExpiryDate;
	}
	public String getTest3ExpiryDate() {
		return test3ExpiryDate;
	}
	public void setTest3ExpiryDate(String test3ExpiryDate) {
		this.test3ExpiryDate = test3ExpiryDate;
	}
	public boolean isRetest() {
		return retest;
	}
	public void setRetest(boolean retest) {
		this.retest = retest;
	}
	public boolean isOpt() {
		return opt;
	}
	public void setOpt(boolean opt) {
		this.opt = opt;
	}

	
	
	


	
}
