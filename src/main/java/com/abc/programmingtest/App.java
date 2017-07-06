package com.abc.programmingtest;

import java.util.TreeSet;

import junit.framework.Assert;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.visitor.filter.AbstractFilter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpoonAPI spoon = new Launcher();
        
    	spoon.addInputResource("D:\\geren\\PHD\\TestPublicConstructorClass.java");
    	spoon.buildModel();    	
    	//spoon.run();
    	Assert.assertEquals(0, spoon.getFactory().Package().getRootPackage().getElements(new AbstractFilter<CtConstructorCall>() {
    		@Override
    		public boolean matches(CtConstructorCall element) {
    			  int index = 1;
    			 System.out.println( "LINE "+index );
    			 System.out.println( element.toString());
    			return element.getType().getActualClass().equals(TreeSet.class);
    		};
    	}).size());
    	spoon.prettyprint();
    	System.out.println("-------------End of Spoon------------");
    	System.out.println( spoon.getFactory().Package().getRootPackage().getElements(new AbstractFilter<CtConstructorCall>(){}));
    	
    	 
    	
    	 
    }
}
