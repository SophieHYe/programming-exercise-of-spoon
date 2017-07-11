package exercise.spoon.mockdata;


import java.text.SimpleDateFormat;
import java.util.Date;

public  final class DateUtilWithImplicitPublicConstructor {
	
	    private static final String FORMAT = "yyyyMMddHHmmss";	   
	    /**
		 * Format current time and return a string
		 * @return time string
		 */
		public static String dateToString(){
	        Date now = new Date();
	        SimpleDateFormat simple = new SimpleDateFormat(FORMAT);
	        return simple.format(now);
	    }

}
