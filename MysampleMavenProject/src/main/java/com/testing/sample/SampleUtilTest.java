package com.testing.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SampleUtilTest {
   
	@Test
	public void testAdd() {
		System.out.println("add");
		Integer a = 15;
		Integer b = 15;
		
		Integer expResult =30;
		Integer result = SampleUtil.add(a, b);
		
		assertEquals(expResult, result);
		
		assertEquals(null, SampleUtil.add(15, null));
		assertEquals(null, SampleUtil.add(null, null));
	}
}
