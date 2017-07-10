package exercise.spoon.reporter;

/**
 * This enum specifies the warning level of analysis result
 * 
 * @author yehe
 *
 */
public enum WarningLevel {
	/**
	 * Error warning level is designed for serious code problems
	 */
	ERROR,
	/**
	 * Warning level is designed for normal code problems which is recommended
	 * to be fixed
	 */
	WARNING,
	/**
	 * Passes level is designed for code which look fine
	 */
	PASSED
}
