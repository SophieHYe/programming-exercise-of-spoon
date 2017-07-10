package exercise.spoon.reporter;

import java.io.Serializable;

/**
 * The MethodReporter include all methodes analysis information at method level
 * 
 * @author yehe
 *
 */
public class MethodReporter implements Serializable {

	/**
	 * Line number of the checking method
	 */

	private int lineNo;

	/**
	 * Code snippet of the checking method
	 */

	private String codeSnippet;

	/**
	 * Warning level of the checking method
	 */

	private WarningLevel warningLevel;

	/**
	 * Warning message of checking method
	 */

	private String WarningMessage;

	/**
	 * Absolute file of the checking method
	 */

	private String codePath;

	/**
	 * Constructor method of MethodReporter
	 * 
	 * @param lineNo
	 * @param codeSnippet
	 * @param warningLevel
	 * @param warningMessage
	 * @param codePath
	 */

	public MethodReporter(int lineNo, String codeSnippet, WarningLevel warningLevel, String warningMessage,
			String codePath) {
		super();
		this.lineNo = lineNo;
		this.codeSnippet = codeSnippet;
		this.warningLevel = warningLevel;
		WarningMessage = warningMessage;
		this.codePath = codePath;
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

	public String getCodePath() {
		return codePath;
	}

	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}

}
