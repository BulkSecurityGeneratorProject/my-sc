package zw.co.elearning.school.reports.lists;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.DELIVERY;
import zw.co.elearning.school.db.tables.LABOUR_SUMMARY;
import zw.co.elearning.school.db.tables.PERSON;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;

@Component
public class DeliveryPlaceOfBirthService extends ReportService<SubReportData<DeliveryPlaceOfBirthListData>> {

	@Override
	public String getGroup() {
		return "Lists";
	}

	@Override
	public String getId() {
		return "delivery-by-place-of-birth";
	}

	@Override
	public String getName() {
		return "Delivery By Place Of Birth";
	}

	@Override
	protected Collection<SubReportData<DeliveryPlaceOfBirthListData>> generateData(Date from, Date to,	String[] deptIds) {
		List<DeliveryPlaceOfBirthListData> data = new ArrayList<>();

		DELIVERY d = Tables.DELIVERY.as("d");
		LABOUR_SUMMARY ls = Tables.LABOUR_SUMMARY.as("ls");
		PERSON p = Tables.PERSON.as("p");

		java.sql.Timestamp fromDate = new Timestamp(from.getTime());
		java.sql.Timestamp toDate =new Timestamp(to.getTime());

		// @formatter:off
		this.schema().select().from(d).join(ls).on(d.LABOUR_SUMMARY_ID.eq(ls.ID))
		.join(p).on(d.PERSON_ID.eq(p.ID)).where(d.DATE.between(fromDate,toDate)).orderBy(d.DATE.desc()).forEach((row)->{
		
			DeliveryPlaceOfBirthListData detail = new DeliveryPlaceOfBirthListData();
			if(row.getValue(d.LABOUR_SUMMARY_ID)!=null){
				
				if(row.getValue(d.DATE)!=null){
					detail.setDateOfDelivery(row.getValue(d.DATE));
				}
				
				detail.setFullname(row.getValue(p.FIRSTNAME) + " "+ row.getValue(p.LASTNAME));
				
				if(row.getValue(ls.BIRTH_PLACE)!=null){
					
					detail.setPlaceOfBirth(row.getValue(ls.BIRTH_PLACE).replaceAll("_", " "));
				}
				
				data.add(detail);
			}
		
		});
		// @formatter:on
		
		List<SubReportData<DeliveryPlaceOfBirthListData>> result = new ArrayList<>();

		result.add(new SubReportData<DeliveryPlaceOfBirthListData>(data));

		return result;
	}

	@Override
	public String getTemplateUrl() {
		return "reports/mbp/deliveryplacepatientslist.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a4_potrait.jasper";
	}

}
