package exercise.spoon.analyzer;

import java.util.ArrayList;
import java.util.List;

import exercise.spoon.reporter.Reporter;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * Analysis packages information
 * 
 * @author yehe
 *
 */
public class PackageAnalyzer implements Analyzer {

	/**
	 * Identify the useful full packages
	 * 
	 * @param packageList
	 * @return
	 */
	private static List<CtPackage> getUsefulPackages(List<CtPackage> packageList) {
		for (int i = 0; i < packageList.size(); i++) {
			CtPackage cp = packageList.get(i);
			if (cp.isUnnamedPackage()) {
				packageList.remove(i);
			}
			CtElement parent = (CtElement) cp.getParent();
			if (parent instanceof CtPackage) {
				if (null != parent && packageList.contains(parent)) {
					packageList.remove(parent);
					i--;
				}
			}
		}
		return packageList;
	}

	/**
	 * Identify package numbers
	 */
	public void analyzer(CtElement ctElement, Reporter reporter) {
		List<CtPackage> packageList = ctElement.getElements(new TypeFilter<CtPackage>(CtPackage.class));
		List<CtPackage> packages = getUsefulPackages(packageList);
		reporter.setPackageNo(packages.size());
		List<String> packageNames = new ArrayList<String>();
		for (CtPackage cp : packages) {
			packageNames.add(cp.getQualifiedName());
		}
		reporter.setPackageNames(packageNames);
	}

}
