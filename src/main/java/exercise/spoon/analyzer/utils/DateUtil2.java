package exercise.spoon.analyzer.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public  final class DateUtil2 {
	
	    private static final String FORMAT = "yyyyMMddHHmmss";

	    private String utilName;
	   
	   


		public static String getIdByTime(){
	        Date now = new Date();
	        SimpleDateFormat simple = new SimpleDateFormat(FORMAT);
	        return simple.format(now);
	    }

}
