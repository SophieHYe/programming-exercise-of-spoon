package exercise.spoon.analyzer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	    private static final String FORMAT = "yyyyMMddHHmmss";

	    private String utilName;
	   
	    public DateUtil() {
			super();
			// TODO Auto-generated constructor stub
		}



		public DateUtil(String utilName) {
			super();
			this.utilName = utilName;
		}



		public static String getIdByTime(){
	        Date now = new Date();
	        SimpleDateFormat simple = new SimpleDateFormat(FORMAT);
	        return simple.format(now);
	    }

}
