package zw.co.elearning.school.domain.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public final class DateUtils {
	public LocalDateTime[] getDateFromAndTo(LocalDateTime date) {

		LocalDateTime[] result = new LocalDateTime[2];
		if (date != null) {
			result[0] = LocalDateTime.of(date.toLocalDate(), LocalTime.parse("00:00:00"));
			result[1] = LocalDateTime.of(date.toLocalDate(), LocalTime.parse("23:59:59"));
		}
		return result;

	}

	public List<LocalDateTime> getIntervals(LocalDateTime start, LocalDateTime end, int interval) {
		List<LocalDateTime> result = new ArrayList<>();
		
		for (LocalDateTime date = start; !date.isAfter(end); date = date.plusMinutes(interval)) {
			result.add(date);
	    }

		return result;
	}

}
