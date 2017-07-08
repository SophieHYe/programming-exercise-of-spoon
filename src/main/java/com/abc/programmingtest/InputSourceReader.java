package com.abc.programmingtest;

import java.util.ArrayList;
import java.util.List;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.visitor.chain.CtQuery;
import spoon.reflect.visitor.filter.TypeFilter;

public class InputSourceReader {
	
	public static void sourceReader(String path){
		final SpoonAPI spoon = new Launcher();
		//spoon.addInputResource("D:\\java_projects\\spoon\\programmingtest\\src\\main\\java");
		spoon.addInputResource(path);
		spoon.buildModel();
		spoon.getModel().getRootPackage().getElements(new TypeFilter<CtClass>(CtClass.class) {
			@Override
			public boolean matches(CtClass element) {
				
				//System.out.println("class" + element);
				
				String name = element.getSimpleName();
				if(name.contains("Util")||name.contains("util")){
					System.out.println("Util" + element);
				}
				
				System.out.println("name" + name);
				return true;
			}
					
		}).forEach(System.out::println);

	}

}
