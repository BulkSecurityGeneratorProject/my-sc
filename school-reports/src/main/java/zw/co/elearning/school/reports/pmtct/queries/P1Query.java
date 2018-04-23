package zw.co.elearning.school.reports.pmtct.queries;

import java.sql.Date;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import zw.co.elearning.school.db.Tables;
import zw.co.elearning.school.db.tables.ANC_VISIT;
import zw.co.elearning.school.db.tables.ENCOUNTER;

@Component
public class P1Query {

	@Inject
	DSLContext dsl;

	public int query(Date fromDate, Date toDate) {
		ANC_VISIT av = Tables.ANC_VISIT.as("av");
		ENCOUNTER e = Tables.ENCOUNTER.as("e");
		long visitNumber = 1;

		// @formatter:off
		int count = dsl.selectCount().from(av).join(e).on(av.ENCOUNTER_ID.eq(e.ID))
				.where(e.DATE.between(fromDate, toDate)).and(av.VISIT_NUMBER.eq(visitNumber)).fetchOne(0, int.class);
		// @formatter:on
		return count;
	}

}
