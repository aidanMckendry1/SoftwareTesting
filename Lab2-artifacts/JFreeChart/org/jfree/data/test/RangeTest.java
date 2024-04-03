package org.jfree.data.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jfree.data.Range;
import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		rangeObjectUnderTest = new Range(-5.0, 5.0); 
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 
			     0, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	
	// constrain() tests
	
	
	// combine() tests
	
	
	// centralValue() tests
	
	
	// expandToInclude() tests
	@Test
	public void testExpandToIncludeWithNullRange() {
		Range nullRangeObject;
		double valueToInclude = 0.0;
		nullRangeObject.expandToInclude(nullRangeObject, valueToInclude);
		
		assertEquals("The lower bound should be 0.0", 
			     0.0, nullRangeObject.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 0.0", 
			     0.0, nullRangeObject.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueLessThanLowerBound() {
		double valueToInclude = -6.0;
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertEquals("The lower bound should be -6.0", 
			     -6.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 5.0", 
			     5.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueAtLowerBound() {
		double valueToInclude = -5.0;
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertEquals("The lower bound should be -5.0", 
			     -5.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 5.0", 
			     5.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueAtUpperBound() {
		double valueToInclude = 5.0;
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertEquals("The lower bound should be -5.0", 
			     -5.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 5.0", 
			     5.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueAtMedian() {
		double valueToInclude = 5.0;
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertEquals("The lower bound should be -5.0", 
			     -5.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 5.0", 
			     5.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueAtUpperBound() {
		double valueToInclude = 5.0;
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertEquals("The lower bound should be -5.0", 
			     -5.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 5.0", 
			     5.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueGreaterThanUpperBound() {
		double valueToInclude = 6.0;
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertEquals("The lower bound should be -5.0", 
			     -5.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 6.0", 
			     6.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	
	// contains() tests
	// Should this be testing -5.1 instead ....
	@Test
	public void testContainsLessThanLowerBound() {
		assertEquals("The contains method should return false", 
			     false, rangeObjectUnderTest.contains(-6.0), 0.000000001d); 
	}
	@Test
	public void testContainsAtLowerBound() {
		assertEquals("The contains method should return true", 
			     true, rangeObjectUnderTest.contains(-5.0), 0.000000001d); 
	}
	@Test
	public void testContainsAtMedianRange() {
		assertEquals("The contains method should return true", 
			     true, rangeObjectUnderTest.contains(0.0), 0.000000001d); 
	}
	@Test
	public void testContainsAtUpperBound() {
		assertEquals("The contains method should return true", 
			     true, rangeObjectUnderTest.contains(5.0), 0.000000001d); 
	}
	// Should this be testing 5.1 instead ....
	@Test
	public void testContainsGreaterThanUpperBound() {
		assertEquals("The contains method should return false", 
			     false, rangeObjectUnderTest.contains(6.0), 0.000000001d); 
	}
}
