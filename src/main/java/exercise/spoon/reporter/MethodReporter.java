package exercise.spoon.reporter;

import java.io.Serializable;

public class MethodReporter implements Serializable {


	
	

	@Override
	public String toString() {
		return "MethodReport [lineNo=" + lineNo + ", codeSnippet=" + codeSnippet + ", warningLevel=" + warningLevel
				+ ", WarningMessage=" + WarningMessage + "]";
	}

	

	public MethodReporter(int lineNo, String codeSnippet, WarningLevel warningLevel, String warningMessage) {
		super();
		this.lineNo = lineNo;
		this.codeSnippet = codeSnippet;
		this.warningLevel = warningLevel;
		WarningMessage = warningMessage;
	}



	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public String getCodeSnippet() {
		return codeSnippet;
	}

	public void setCodeSnippet(String codeSnippet) {
		this.codeSnippet = codeSnippet;
	}

	public WarningLevel getWarningLevel() {
		return warningLevel;
	}

	public void setWarningLevel(WarningLevel warningLevel) {
		this.warningLevel = warningLevel;
	}

	public String getWarningMessage() {
		return WarningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		WarningMessage = warningMessage;
	}

	private int lineNo;
	
	private String codeSnippet;
	
	private WarningLevel warningLevel;
	
	private String WarningMessage;
	
	
	
}
