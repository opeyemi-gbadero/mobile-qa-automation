package utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarHeaderUtil {

    public static String getExpectedCalendarHeader() {
        LocalDate today = LocalDate.now();

        String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // "July"
        int year = today.getYear(); // 2025

        return month + " " + year + "\n" +
                "SUN\nMON\nTUE\nWED\nTHU\nFRI\nSAT\n" +
                "Bible Reading\nDevotional\nVerse of the Day";
    }

    public static void main(String[] args) {
        String expectedHeader = getExpectedCalendarHeader();
        //System.out.println("Expected Accessibility ID:\n" + expectedHeader);

      
    }
}