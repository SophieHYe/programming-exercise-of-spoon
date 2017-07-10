package exercise.spoon;



import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.alibaba.fastjson.JSON;
import exercise.spoon.analyzer.ClassAnalyzer;
import exercise.spoon.analyzer.PackageAnalyzer;
import exercise.spoon.analyzer.utils.FileUtils;
import exercise.spoon.reporter.ClassReporter;
import exercise.spoon.reporter.Reporter;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * Entrance of spoon checker
 * 
 * @author yehe
 *
 */
public class App {
	
	/**
	 * Entrance method of spoon checker
	 * @param args provides input path of java source files
	 */
	
	public static void main (String[] args) {	
		System.out.println("Starting to analyze the code..");
		FileUtils.renameFile("", "report.js", "report.js"+System.currentTimeMillis());
		try{	
		Object result = sourceReader(args[0]);	
		FileUtils.writeJson("", "window.analyzerReport = " +result, "report.js");
		System.out.println("Done");
		}catch (Exception e){
			System.out.println("Incorrect file path, please correct it and try again! ");
		}
	}
	
	
	/**
	 * 
	 * @param path is the input path of java source files
	 * @return
	 */
	public static Object sourceReader(String path){
		final SpoonAPI spoon = new Launcher();				
		spoon.addInputResource(path);
		spoon.buildModel();	
		//Get the root element of spoon elements
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
		return JSON.toJSON(reporter);
		
	}

}
