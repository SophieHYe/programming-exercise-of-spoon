package exercise.spoon.reporter;

/**
 * This class specifies the warning message of analysis report
 * 
 * @author yehe
 *
 */

public class WarningMessage {

	/**
	 * prevent the class to be inherit
	 */
	private WarningMessage() {

	}

	public static final String UTIL_CLASS_PUBLIC_CONSTRUCTOR = "Utility classes should not have public constructors";
	public static final String UTIL_CLASS_IMPLICIT_PUBLIC_CONSTRUCTOR = "Utility classes should not have  implicit public constructors";
	public static final String PUBLIC_MODIFIER = "Utility classes should not have public constructors";
	public static final String NULL_MODIFIER = "null modifier is NOT recommended";

}
