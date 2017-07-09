package exercise.spoon.app;



import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import exercise.spoon.analyzer.ClassAnalyzer;
import exercise.spoon.analyzer.PackageAnalyzer;
import exercise.spoon.reporter.ClassReporter;
import exercise.spoon.reporter.Reporter;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.visitor.chain.CtQuery;
import spoon.reflect.visitor.filter.TypeFilter;

public class App {
	
	public static void main (String[] args) {		
		validateInputPath("D:\\current_project\\spoon\\programming-exercise-of-spoon\\src\\main\\java");				
	}
	
	
	public static void validateInputPath(String path){
		sourceReader(path);
	}
	
	public static Object sourceReader(String path){
		final SpoonAPI spoon = new Launcher();		
		spoon.addInputResource(path);
		spoon.buildModel();		
		CtElement  rootElement = spoon.getModel().getRootPackage().getElements(new TypeFilter<CtElement>(CtElement.class)).get(0);
		Reporter reporter = new Reporter();
		new PackageAnalyzer().analyzer(rootElement,reporter);	
		new ClassAnalyzer().analyzer(rootElement,reporter);	
		//Remove empty classesAnalyzer
		Map<String, ClassReporter> classesAnalyzers = reporter.getClassesAnalyzer();
			
		Iterator<Entry<String, ClassReporter>> it = classesAnalyzers.entrySet().iterator();
		while(it.hasNext()){  
            Entry<String, ClassReporter> entry=it.next();  
            if(null==entry.getValue().getMethodReport()) it.remove();
		}
				
		System.out.println(JSON.toJSON(reporter));
		return JSON.toJSON(reporter);
		
	}

}
