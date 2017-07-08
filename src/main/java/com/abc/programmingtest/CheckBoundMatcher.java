package com.abc.programmingtest;

import java.util.Collection;

import spoon.template.TemplateParameter;

public class CheckBoundMatcher {
	// Step 1:
	public TemplateParameter<Collection<?>> _col_;

	// Step 2
	public void matcher1() {
		if (_col_.S().size() > 10)
			throw new IndexOutOfBoundsException();
	}
}
