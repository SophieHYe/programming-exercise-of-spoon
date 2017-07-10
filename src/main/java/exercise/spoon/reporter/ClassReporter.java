package exercise.spoon.reporter;

import java.io.Serializable;
import java.util.List;

/**
 * The ClassReporter include all classes analysis information at class level
 * 
 * @author yehe
 *
 */
public class ClassReporter implements Serializable {

	/**
	 * methodReport collects a list of method report for a specific class
	 */
	private List<MethodReporter> methodReport;

	public List<MethodReporter> getMethodReport() {
		return methodReport;
	}

	public void setMethodRport(List<MethodReporter> methodReport) {
		this.methodReport = methodReport;
	}

}
