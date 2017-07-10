package exercise.spoon.analyzer;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exercise.spoon.reporter.ClassReporter;
import exercise.spoon.reporter.MethodReporter;
import exercise.spoon.reporter.Reporter;
import exercise.spoon.reporter.WarningLevel;
import exercise.spoon.reporter.WarningMessage;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.ModifierKind;

/**
 * Analyzing if the utility classes have public constructor
 * 
 * @author yehe
 *
 */
public class UtilConstructorAnalyzer implements Analyzer {

	@Override
	public void analyzer(CtElement element, Reporter reporter) {
		if(element instanceof CtClass){
			ClassReporter cr= reporter.getClassesAnalyzer().get(((CtClass) element).getQualifiedName());	
			List<MethodReporter> methodRportList = new ArrayList<MethodReporter>();
			Set<CtConstructor> constructors = ((CtClass) element).getConstructors();
	    	for(CtConstructor each : constructors){
	    		Set<ModifierKind> modifiers = each.getModifiers();	    		    				    			   			
	    		if(modifiers.contains(ModifierKind.PUBLIC)) {	    			    			
	    			MethodReporter methodRport;
	    			if(each.isImplicit()) {
	    				int lineNo = element.getPosition().getLine();
	    				methodRport = new MethodReporter(lineNo,each.toString(),WarningLevel.WARNING,WarningMessage.UTIL_CLASS_IMPLICIT_PUBLIC_CONSTRUCTOR,element.getPosition().toString());
	    			} else {
	    				int lineNo = each.getPosition().getLine();
	    				methodRport = new MethodReporter(lineNo,each.toString(),WarningLevel.WARNING,WarningMessage.UTIL_CLASS_PUBLIC_CONSTRUCTOR,each.getPosition().toString());
	    			}	
	    			methodRportList.add(methodRport);	    			
	    		}
	    		cr.setMethodRport(methodRportList);
	    	}
		}
	}

	

}
