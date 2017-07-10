package exercise.spoon.analyzer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test utility class that contain two public constructors
 * @author yehe
 *
 */
public class DateUtilWithTwoPublicConstructors {
	
	    private static final String FORMAT = "yyyyMMddHHmmss";

	    private String utilName;
	   
	    public DateUtilWithTwoPublicConstructors() {
			super();			
		}

		public DateUtilWithTwoPublicConstructors(String utilName) {
			super();
			this.utilName = utilName;
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
