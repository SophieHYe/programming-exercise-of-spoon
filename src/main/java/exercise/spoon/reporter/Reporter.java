package exercise.spoon.reporter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Reporter implements Serializable{
			
	private int packageNo;
	private List<String> packageNames;
	private Map<String,ClassReporter> ClassesAnalyzer;
	
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
