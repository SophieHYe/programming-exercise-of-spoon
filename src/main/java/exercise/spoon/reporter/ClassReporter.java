package exercise.spoon.reporter;

import java.io.Serializable;
import java.util.List;

public class ClassReporter implements Serializable {

	private List<MethodReporter> methodReport;
	
	public List<MethodReporter> getMethodReport() {
		return methodReport;
	}
	public void setMethodRport(List<MethodReporter> methodReport) {
		this.methodReport = methodReport;
	}

	
}
