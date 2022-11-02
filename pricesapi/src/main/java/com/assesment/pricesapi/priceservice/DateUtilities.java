package com.assesment.pricesapi.priceservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtilities {

	public static Long getDaysDifference(String date) throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		final Date selectedDate = sdf.parse(date);
		final Date nowDate = sdf.parse(sdf.format(new Date()));

		final long diffInMillies = Math.abs(selectedDate.getTime() - nowDate.getTime());
		final long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		return diff;
	}

	public static Long getDaysDifference(String date, String dateTwo) throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		final Date selectedDate = sdf.parse(date);
		final Date fromDate = sdf.parse(dateTwo);

		final long diffInMillies = Math.abs(selectedDate.getTime() - fromDate.getTime());
		final long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		return diff;
	}

	public static List<LocalDate> generateDates(String date_target) throws ParseException {

		int daysBefore = 3;
		int daysAfter = 3;

		List<LocalDate> dates = new ArrayList<>();

		LocalDate selectedDate = LocalDate.parse(date_target);
		LocalDate todayDate = LocalDate.now();

		long daysDifference = getDaysDifference(date_target.toString(), todayDate.toString());

		if (daysDifference < 3) {
			daysBefore = (int) (daysBefore - (3 - daysDifference));
			daysAfter = (int) (daysAfter + (3 + daysDifference));
		}

		for (int i = 1; i <= daysBefore; i++) {
			dates.add(selectedDate.minusDays(i));
		}

		dates.add(selectedDate);

		for (int i = 1; i <= daysAfter; i++) {
			dates.add(selectedDate.plusDays(i));
		}
		Collections.sort(dates);

		return dates;
	}

}
