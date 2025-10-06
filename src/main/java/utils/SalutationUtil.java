package utils;

import java.time.LocalTime;

public class SalutationUtil {

	public  static String ExpectedSalutation() {
		
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		
		if(hour >= 5 && hour < 12) {
			return "Good morning";
		}else if (hour >=12 && hour < 17) {
			return "Good afternoon";
		}else if (hour >=17 && hour < 24) {
			return "Good evening";
		}else  {
			return "Good morning";
		}
		
	

	}
       
    

    
}