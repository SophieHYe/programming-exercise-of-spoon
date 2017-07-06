package com.abc.programmingtest;

import java.util.List;
import java.util.Set;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtBodyHolder;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.AbstractFilter;
import spoon.reflect.visitor.filter.NameFilter;
import spoon.template.TemplateMatcher;
import spoon.template.TemplateParameter;

public class UtilClassChecker {

	public TemplateParameter<CtConstructor<?>> _col_;

	public CheckResult checkPubConstructor() {
		Set<ModifierKind> modifierSet = _col_.S().getModifiers();
		for (ModifierKind mk : modifierSet) {
			if (modifierSet.size() == 1 && (ModifierKind.PUBLIC).equals(mk)) {
				return new CheckResult(WarningLevel.WARNING, WarningMessage.PUBLIC_MODIFIER);
			}

		}
		return new CheckResult(WarningLevel.WARNING, WarningMessage.NULL_MODIFIER);

	}

	public static void main(String[] args) {
		SpoonAPI spoon = new Launcher();
	 	spoon.addInputResource("D:\\geren\\PHD\\TestPublicConstructorClass.java");
		Factory factory = spoon.getFactory();
		CtClass<?> templateKlass = factory.Class().get(UtilClassChecker.class);
		CtMethod  el =   (CtMethod) templateKlass.getElements(new NameFilter("checkPubConstructor")).get(0);
		CtBlock body = el.getBody();
		System.out.println("elems");
		
		CtStatement cs = body.getStatement(0);
		
		
		CtIf templateRoot = (CtIf) ((CtMethod) templateKlass.getElements(new NameFilter("checkPubConstructor")).get(0)).getBody().getStatement(0);
		TemplateMatcher matcher = new TemplateMatcher(templateRoot);
		List<CtConstructorCall> elments =  spoon.getFactory().Package().getRootPackage().getElements(new AbstractFilter<CtConstructorCall>(){});
		for (CtElement elems : matcher.find((CtElement) spoon.getFactory().Package().getRootPackage().getElements(new AbstractFilter<CtConstructorCall>(){}))) { 
			System.out.println("elems"+elems);
			
		};
	}

}
