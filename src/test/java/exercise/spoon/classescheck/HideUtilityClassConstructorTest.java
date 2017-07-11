package exercise.spoon.classescheck;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.visitor.filter.AbstractFilter;

/**
 * 
 * @author yehe
 *
 */
public class HideUtilityClassConstructorTest {
	/**
	 * Test the source code of this projects
	 * @throws Exception
	 */
	@Test
	public void testPublicConstructor() throws Exception {

		SpoonAPI spoon = new Launcher();
		spoon.addInputResource("..");
		spoon.buildModel();
		AbstractFilter<CtClass> filter = new AbstractFilter<CtClass>() {

			@Override
			public boolean matches(CtClass element) {

				Set<CtMethod> methods = element.getMethods();
				if (methods.size() == 0)
					return false;
				for (CtMethod each : methods) {
					Set<ModifierKind> modifiers = each.getModifiers();
					if (!modifiers.contains(ModifierKind.STATIC))
						return false;
				}

				Set<CtConstructor> constructors = element.getConstructors();
				for (CtConstructor each : constructors) {
					Set<ModifierKind> modifiers = each.getModifiers();
					if (modifiers.contains(ModifierKind.PUBLIC)) {
						System.out.println(element.getQualifiedName());
						return true;
					}
				}
				return false;
			};
		};

		List<CtClass> elements = spoon.getFactory().Package().getRootPackage().getElements(filter);

		Assert.assertEquals(4, elements.size());

	}

}