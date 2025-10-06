package utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateRangeUtil {

	public static String getWeekRangeString() {
        LocalDate today = LocalDate.now();

        //week starts on Sunday
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() % 7);
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        String start = formatDate(startOfWeek);
        String end = formatDate(endOfWeek);

        return start + " - " + end;
    }

    private static String formatDate(LocalDate date) {
        String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH); // e.g., "Jul"
        int day = date.getDayOfMonth(); // e.g., 27
        String suffix = getDaySuffix(day);

        return month + " " + day + suffix;
    }

    private static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) return "th";
        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }

    public static void main(String[] args) {
        String dateRange = getWeekRangeString();
            
    }
}