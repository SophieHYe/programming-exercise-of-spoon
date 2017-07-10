package exercise.spoon.reporter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The reporter includes all analysis information of the input source path
 * 
 * @author yehe
 *
 */
public class Reporter implements Serializable {

	/**
	 * Calculate the number of useful packages
	 */
	private int packageNo;

	/**
	 * List all packages' name
	 */
	private List<String> packageNames;

	/**
	 * ClassesAnalyzer is the collection of all classes analysis report Key of
	 * ClassesAnalyzer is the class name Value of ClassesAnalyzer is the class
	 * analysis report
	 */

	private Map<String, ClassReporter> ClassesAnalyzer;

	public int getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}

	public List<String> getPackageNames() {
		return packageNames;
	}

	public void setPackageNames(List<String> packageNames) {
		this.packageNames = packageNames;
	}

	public Map<String, ClassReporter> getClassesAnalyzer() {
		return ClassesAnalyzer;
	}

	public void setClassesAnalyzer(Map<String, ClassReporter> classesAnalyzer) {
		ClassesAnalyzer = classesAnalyzer;
	}

}