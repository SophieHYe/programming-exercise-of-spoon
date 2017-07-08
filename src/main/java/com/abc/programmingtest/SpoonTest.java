package com.abc.programmingtest;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.NameFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.template.TemplateMatcher;


public class SpoonTest {
	public static void main1 (String[] args) {
		final SpoonAPI spoon = new Launcher();
		spoon.addInputResource("D:\\java_projects\\spoon\\programmingtest\\src\\main\\java");
		spoon.buildModel();
		CtClass<?> templateKlass = spoon.getFactory().Class().get(CheckBoundMatcher.class);
		CtIf templateRoot = (CtIf) ((CtMethod) templateKlass.getElements(new NameFilter<>("matcher1")).get(0))
				.getBody()
				.getStatement(0);
		TemplateMatcher matcher = new TemplateMatcher(templateRoot);
		for (CtElement elems : matcher.find(spoon.getFactory().Package().getRootPackage())) {
			System.out.println(elems);
		}
		spoon.getModel().getRootPackage().getElements(new TypeFilter<CtConstructor>(CtConstructor.class) {
			@Override
			public boolean matches(CtConstructor element) {
				System.out.println(element);
				return true;
			}
		}).forEach(System.out::println);
	}
	
	public static void main (String[] args) {
				
		InputSourceReader.sourceReader("D:\\java_projects\\spoon\\programmingtest\\src\\main\\java");
		
		
		
		
	}
	
}
