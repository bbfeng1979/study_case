package com.bbfeng.study.demo.guava;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.junit.Test;

public class PreconditionsTest {

	@Test(expected=NullPointerException.class)
	public void testPreCondition() {
		String hello = null;
		checkNotNull(hello);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCHeckStateWhenFailed() {
		
		boolean stat = false;
		checkState(stat, "the stat is false dd");
	}

}
