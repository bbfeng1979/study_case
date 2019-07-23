package com.bbfeng.study.demo.guava;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class ImmutableSetTest {

	private static final Set<Color> WEBSAFE_COLORS = new HashSet<Color>();
	public static final ImmutableSet<Color> GOOGLE_COLORS =
			ImmutableSet.<Color>builder()
			.addAll(WEBSAFE_COLORS)
			.add(new Color(0, 191, 255))
			.build();
	
	@Test
	public void testSize() {
		int n = GOOGLE_COLORS.size();
		assertEquals(n, 1);
	}
	


}
