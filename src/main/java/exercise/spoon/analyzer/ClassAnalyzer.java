package exercise.spoon.analyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import exercise.spoon.reporter.ClassReporter;
import exercise.spoon.reporter.Reporter;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * This class starts to analyze target classes and their method
 * 
 * @author yehe
 *
 */

public class ClassAnalyzer implements Analyzer {

	@Override
	public void analyzer(CtElement ctElement, Reporter reporter) {
		Map<String, ClassReporter> classesAnalyzer = new HashMap<String, ClassReporter>();
		List<CtClass> klassList = ctElement.getElements(new TypeFilter<CtClass>(CtClass.class));
		for (CtClass ctKlass : klassList) {
			classesAnalyzer.put(ctKlass.getQualifiedName(), new ClassReporter());
			reporter.setClassesAnalyzer(classesAnalyzer);
			// Utility classes should not have public constructors
			if (isUtilClass(ctKlass))
				new UtilConstructorAnalyzer().analyzer(ctKlass, reporter);
			if (isInterface(ctKlass)) {
			}
		}
	}

	/**
	 * Indentify utility classes RULE : If all methods in this class are static,
	 * this class is considered as a utilcclass
	 * 
	 * @param klass
	 * @return true when the class is identified as a utility class or false
	 *         when it is not
	 */

	private Boolean isUtilClass(CtClass klass) {
		Set<CtMethod> methods = klass.getMethods();
		if (methods.size() == 0)
			return false;
		for (CtMethod each : methods) {
			Set<ModifierKind> modifiers = each.getModifiers();
			// public static void main is an exeception;
			if (each.toString().contains("public static void main")) {
				List<CtParameter> parameterList = each.getParameters();
				if (parameterList.size() == 1 && parameterList.get(0).toString().contains("java.lang.String[]"))
					return false;
			}
			if (!modifiers.contains(ModifierKind.STATIC))
				return false;
		}
		return true;
	}

	/**
	 * Identify interface
	 * 
	 * @param ctKlass
	 * @return
	 */
	private boolean isInterface(CtClass ctKlass) {
		// TODO Auto-generated method stub
		return false;
	}

}
