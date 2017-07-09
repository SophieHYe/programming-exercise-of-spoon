package exercise.spoon.analyzer;

import java.util.List;

import exercise.spoon.reporter.Reporter;
import spoon.reflect.declaration.CtElement;
public interface Analyzer {

	public abstract void analyzer(CtElement ctElement, Reporter reporter);
	
}
