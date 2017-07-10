package exercise.spoon.analyzer;

import exercise.spoon.reporter.Reporter;
import spoon.reflect.declaration.CtElement;

/**
 * This interface defines an analyzer declaration
 * 
 * @author yehe
 *
 */
public interface Analyzer {

	/**
	 * ctElement is the root element that starting to analyze the code. Analysis
	 * information will be added in the reporter
	 * 
	 * @param ctElement
	 * @param reporter
	 */

	public abstract void analyzer(CtElement ctElement, Reporter reporter);

}
