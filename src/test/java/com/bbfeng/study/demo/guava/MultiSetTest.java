package com.bbfeng.study.demo.guava;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetTest {

	private Multiset<String> cms;

	@Before
	public void init() {
		String[] children = new String[] { "bobo", "lily", "bobo", "wang", "lily", "lily" };

		cms = HashMultiset.create();
		cms.addAll(Arrays.asList(children));
	}

	@Test
	public void testCount() {

		assertEquals(2, cms.count("bobo"));
		assertEquals(3, cms.count("lily"));

		cms.remove("lily", 2);
		assertEquals(1, cms.count("lily"));
	}

	@Test
	public void testLoop() {
		for (Multiset.Entry<String> entry : cms.entrySet()) {
			System.out.println("Element: " + entry.getElement() + ", Occurrence(s): " + entry.getCount());
		}
		System.out.println("]");
	}

}
