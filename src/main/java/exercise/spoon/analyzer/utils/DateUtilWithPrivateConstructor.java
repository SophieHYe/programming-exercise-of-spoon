package exercise.spoon.analyzer.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test utility class contains one private constructor
 * @author yehe
 *
 */
public  final class DateUtilWithPrivateConstructor {
	
	    private static final String FORMAT = "yyyyMMddHHmmss";	  
	    
	    /**
	     * private constructor in utility class
	     */
	    private DateUtilWithPrivateConstructor(){
	    	
	    }

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
