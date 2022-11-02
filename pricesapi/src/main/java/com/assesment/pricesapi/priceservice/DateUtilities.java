package com.assesment.pricesapi.priceservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtilities {

	public static Long getDaysDifference(String date)
			throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd", Locale.ENGLISH);
		final Date selectedDate = sdf.parse(date);
		final Date nowDate = sdf.parse(sdf.format(new Date()));

		final long diffInMillies = Math
				.abs(selectedDate.getTime() - nowDate.getTime());
		final long diff = TimeUnit.DAYS.convert(diffInMillies,
				TimeUnit.MILLISECONDS);

		return diff;
	}

	public static Long getDaysDifference(String date, String dateTwo)
			throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd", Locale.ENGLISH);
		final Date selectedDate = sdf.parse(date);
		final Date fromDate = sdf.parse(dateTwo);

		final long diffInMillies = Math
				.abs(selectedDate.getTime() - fromDate.getTime());
		final long diff = TimeUnit.DAYS.convert(diffInMillies,
				TimeUnit.MILLISECONDS);

		return diff;
	}

}
