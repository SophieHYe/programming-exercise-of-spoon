package com.abc.programmingtest;

import java.util.HashSet;

public class TestElements {
	public static void main(String[] args) {
		if (new HashSet<>().size() > 10)
			throw new IndexOutOfBoundsException();	
	}
}