package zw.co.elearning.school.reports.registers;

import static org.jooq.impl.DSL.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.DISPENSE;
import zw.co.elearning.school.db.tables.DRUG;
import zw.co.elearning.school.db.tables.DRUG_NAME;
import zw.co.elearning.school.db.tables.FORMULATION;
import zw.co.elearning.school.db.tables.UNIT;
import zw.co.elearning.school.reports.ReportService;
import zw.co.elearning.school.reports.SubReportData;
import zw.co.elearning.school.reports.util.QueryUtil;

@Component
public class DispenseRegistrySummaryService extends ReportService<SubReportData<DispenseRegistrySummaryData>> {

	@Autowired
	private QueryUtil q;

	@Override
	public String getGroup() {
		return "Registers";
	}

	@Override
	public String getId() {
		return "dispense-summary";
	}

	@Override
	public String getName() {
		return "Dispense Summary Report";
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Collection<SubReportData<DispenseRegistrySummaryData>> generateData(Date from, Date to,
			String[] deptIds) {

		List<DispenseRegistrySummaryData> data = new ArrayList<>();
		java.sql.Date fromDate = new java.sql.Date(from.getTime());
		java.sql.Date toDate = new java.sql.Date(to.getTime());

		DISPENSE di = Tables.DISPENSE.as("di");
		DRUG dr = Tables.DRUG.as("dr");
		DRUG_NAME drna = Tables.DRUG_NAME.as("drna");
		FORMULATION f = Tables.FORMULATION.as("f");
		UNIT u = Tables.UNIT.as("u");
		// @formatter:off	
		this.schema().select(
				drna.NAME, f.NAME, di.DATE,
				concat(dr.STRENGTH, val(" "), u.NAME).as("strength"),
				sum(di.QUANTITY)).from(di)
		
				.leftJoin(dr).on(di.DRUG_ID.eq(dr.ID))
				.leftJoin(drna).on(drna.ID.eq(dr.DRUG_NAME_ID))
				.leftJoin(f).on(dr.FORMULATION_ID.eq(f.ID))
				.leftJoin(u).on(dr.UNIT_ID.eq(u.ID))
				.where(di.DATE.between(new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime())))
				.groupBy(di.DRUG_ID)
				.orderBy(di.DATE.desc())
				.fetch().forEach((row) -> {
					// @formatter:on
					DispenseRegistrySummaryData detail = new DispenseRegistrySummaryData();

					detail.setMedication(row.getValue(drna.NAME));
					detail.setFormulation(row.getValue(f.NAME));
					detail.setStrength(row.getValue("strength").toString());
					detail.setTotal(row.getValue(sum(di.QUANTITY)).intValue());

					data.add(detail);
				});

		List<SubReportData<DispenseRegistrySummaryData>> result = new ArrayList<>();

		result.add(new SubReportData<DispenseRegistrySummaryData>(data));

		return result;
	}

	@Override
	public String getTemplateUrl() {
		return "reports/registers/dispense_report.jasper";
	}

	@Override
	public String getLayoutTemplateUrl() {
		return "reports/a4_potrait.jasper";
	}

}
