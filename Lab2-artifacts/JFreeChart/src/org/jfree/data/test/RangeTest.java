package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {
	private Range rangeObjectUnderTest;


	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-5.0, 5.0); 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	// constrain() tests
	@Test
	public void testConstrainLessThanLowerBound() {
		double value = -5.1;
		double expected = -5.0;
		double actual = rangeObjectUnderTest.constrain(value);
			
		assertEquals("Constrain should return -5.0 for value -6.0 ", expected, actual, 0.000000001d);
	}
	@Test
	public void testConstrainAtLowerBound() {
		double value = -5.0;
		double expected = -5.0;
		double actual = rangeObjectUnderTest.constrain(value);
			
		assertEquals("Constrain should return -5.0 for value -5.0 ", expected, actual, 0.000000001d);
	}
	@Test
	public void testConstrainAtMedian() {
		double value = 0.0;
		double expected = 0.0;
		double actual = rangeObjectUnderTest.constrain(value);
			
		assertEquals("Constrain should return 0.0 for value 0.0 ", expected, actual, 0.000000001d);
	}
	@Test
	public void testConstrainAtUpperBound() {
		double value = 5.0;
		double expected = 5.0;
		double actual = rangeObjectUnderTest.constrain(value);
			
		assertEquals("Constrain should return 5.0 for value 6.0 ", expected, actual, 0.000000001d);
	}
	@Test
	public void testConstrainGreaterThanUpperBound() {
		double value = 5.1;
		double expected = 5.0;
		double actual = rangeObjectUnderTest.constrain(value);
			
		assertEquals("Constrain should return 5.0 for value 6.0 ", expected, actual, 0.000000001d);
	}
	
	
	// combine() tests
	@Test
	public void testCombineBothRangesNull() {
		rangeObjectUnderTest = null;
		Range rangeObjectUnderTest2 = null;
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("Combined range of two null ranges should be null", 
			     null, actualCombinedRange); 
	}
	@Test
	public void testCombineNullRangeWithValidRange() {
		rangeObjectUnderTest = null;
		Range rangeObjectUnderTest2 = new Range(1, 3);
		Range expectedCombinedRange = new Range(1, 3);
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("The combined null range should return other valid range", 
				expectedCombinedRange, actualCombinedRange); 
	}
	@Test
	public void testCombineValidRangeWithNullRange() {
		rangeObjectUnderTest = new Range(1, 3);
		Range rangeObjectUnderTest2 = null;
		Range expectedCombinedRange = new Range(1, 3);
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("The combined null range should return other valid range", 
				expectedCombinedRange, actualCombinedRange); 
	}
	@Test
	public void testCombinePositiveRangeAtUpperBound() {
		rangeObjectUnderTest = new Range(1, 3);
		Range rangeObjectUnderTest2 = new Range(2, 7);
		Range expectedCombinedRange = new Range(1, 7);
		try {
			Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
			assertEquals("The combined range should match expected", 
					expectedCombinedRange, actualCombinedRange); 
	    } catch(IllegalArgumentException e) {
	        fail("Unexpected illegal argument exception thrown");
	    }
	}
	@Test
	public void testCombinePositiveRangeAtLowerBound() {
		rangeObjectUnderTest = new Range(1, 3);
		Range rangeObjectUnderTest2 = new Range(0, 2);
		Range expectedCombinedRange = new Range(0, 3);
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("The combined range should match expected", 
				expectedCombinedRange, actualCombinedRange); 
	}
	@Test
	public void testCombineNegativeRanges() {
		rangeObjectUnderTest = new Range(-3, -1);
		Range rangeObjectUnderTest2 = new Range(-7, -2);
		Range expectedCombinedRange = new Range(-7, -1);
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("The combined range should match expected", 
				expectedCombinedRange, actualCombinedRange); 
	}
	@Test
	public void testCombineEqualRanges() {
		rangeObjectUnderTest = new Range(1, 3);
		Range rangeObjectUnderTest2 = new Range(1, 3);
		Range expectedCombinedRange = new Range(1, 3);
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("The combined range should match expected", 
				expectedCombinedRange, actualCombinedRange); 
	}
	@Test
	public void testCombineRangeGreaterThanUpperBound() {
		rangeObjectUnderTest = new Range(1, 3);
		Range rangeObjectUnderTest2 = new Range(5, 7);
		Range expectedCombinedRange = new Range(1, 7);
		try {
			Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
			assertEquals("The combined range should match expected", 
					expectedCombinedRange, actualCombinedRange); 
	    } catch(IllegalArgumentException e) {
	        fail("Unexpected illegal argument exception thrown");
	    }
	}
	@Test
	public void testCombineRangeLessThanUpperBound() {
		rangeObjectUnderTest = new Range(5, 7);
		Range rangeObjectUnderTest2 = new Range(1, 3);
		Range expectedCombinedRange = new Range(1, 7);
		Range actualCombinedRange = Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2);
				
		assertEquals("The combined range should match expected", 
				expectedCombinedRange, actualCombinedRange); 
	}
	
	
	// centralValue() tests
	@Test
	public void testCentralValueEqualPositive() {
		rangeObjectUnderTest = new Range(5.0, 5.0); 
		assertEquals("The central value of 5 and 5 should be 5", 
			     5, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	@Test
	public void testCentralValueNotEqualPositive() {
		rangeObjectUnderTest = new Range(2.0, 7.0); 
		assertEquals("The central value of 2 and 7 should be 4.5", 
			     4.5, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	@Test
	public void testCentralValueEqualZero() {
		rangeObjectUnderTest = new Range(0, 0); 
		assertEquals("The central value of 0 and 0 should be 0", 
			     0.0, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	@Test
	public void testCentralValueNotEqualNegative() {
		rangeObjectUnderTest = new Range(-10, -1); 
		assertEquals("The central value of -10 and -1 should be -5.5", 
			     -5.5, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	@Test
	public void testCentralValueEqualNegative() {
		rangeObjectUnderTest = new Range(-5, -5); 
		assertEquals("The central value of -5 and -5 should be -5", 
			     -5, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	@Test
	public void testCentralValueNegativeAndPositive() {
		rangeObjectUnderTest = new Range(-10, 5); 
		assertEquals("The central value of -10 and -1 should be -5.5", 
			     -2.5, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
	}
	
	// expandToInclude() tests
	@Test
	public void testExpandToIncludeWithNullRange() {
		Range nullRangeObject = null;
		double valueToInclude = 0.0;
		nullRangeObject = Range.expandToInclude(nullRangeObject, valueToInclude);
		
		assertEquals("The lower bound should be 0.0", 
			     0.0, nullRangeObject.getLowerBound(), 0.000000001d); 
		assertEquals("The upper bound should be 0.0", 
			     0.0, nullRangeObject.getUpperBound(), 0.000000001d); 
	}
	@Test
	public void testExpandToIncludeValueLessThanLowerBound() {
		double valueToInclude = -6.0;
		Range expectedRange = new Range(-6, 5);
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		
		assertEquals("Actual range should match expected when value is less than range ",expectedRange, rangeObjectUnderTest);
		
	}
	@Test
	public void testExpandToIncludeValueAtLowerBound() {
		double valueToInclude = -5.0;
		Range expectedRange1 = new Range(-5.0, 5.0);
		rangeObjectUnderTest = new Range(-5.0, 5.0); 
		try {
			Range rangeAfterExpand = Range.expandToInclude(rangeObjectUnderTest, valueToInclude);
			assertEquals("Actual range should match expected when value is in range",expectedRange1, rangeAfterExpand);
	    } catch(IllegalArgumentException e) {
	        fail("Unexpected illegal argument exception thrown");
	    }		
	}
	@Test
	public void testExpandToIncludeValueAtMedian() {
		double valueToInclude = 0.0;
		Range expectedRange = new Range(-5.0, 5.0);
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertTrue("The range objects should be equal when value is in range", 
			     rangeObjectUnderTest.equals(expectedRange)); 
	}
	@Test
	public void testExpandToIncludeValueAtUpperBound() {
		double valueToInclude = 5.0;
		Range expectedRange = new Range(-5, 5);
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertTrue("The range objects should be equal when value is in range", 
			     rangeObjectUnderTest.equals(expectedRange)); 
	}
	@Test
	public void testExpandToIncludeValueGreaterThanUpperBound() {
		double valueToInclude = 6.0;
		Range expectedRange = new Range(-5.0, 6.0);
		rangeObjectUnderTest.expandToInclude(rangeObjectUnderTest, valueToInclude);
		
		assertTrue("The range objects should be equal with value greater then upper bound", 
			     rangeObjectUnderTest.equals(expectedRange)); 
	}
	
	// contains() tests
	@Test
	public void testContainsLessThanLowerBound() {
		boolean contains = rangeObjectUnderTest.contains(-5.1);
		assertFalse("The contains variable should be false for -5.1", contains); 
	}
	@Test
	public void testContainsAtLowerBound() {
		boolean contains = rangeObjectUnderTest.contains(-5.0);
		assertTrue("The contains variable should be true for -5.0", contains); 
	}
	@Test
	public void testContainsAtMedianRange() {
		boolean contains = rangeObjectUnderTest.contains(0.0);
		assertTrue("The contains variable should be true for 0.0", contains); 
	}
	@Test
	public void testContainsAtUpperBound() {
		boolean contains = rangeObjectUnderTest.contains(5.0);
		assertTrue("The contains variable should be true for 5.0", contains); 
	}
	@Test
	public void testContainsGreaterThanUpperBound() {
		boolean contains = rangeObjectUnderTest.contains(5.1);
		assertFalse("The contains variable should be false for 5.1", contains); 
	}
	
	//getUpperBound tests
	@Test 
	public void getUpperBoundPositiveEqualToLower() {
		rangeObjectUnderTest = new Range(5,5);
		assertEquals("The upper bound should be 5", 5, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test 
	public void getUpperBoundPositive() {
		rangeObjectUnderTest = new Range(2,7);
		assertEquals("The upper bound should be 7", 7, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test 
	public void getUpperBoundEqualZero() {
		rangeObjectUnderTest = new Range(0,0);
		assertEquals("The upper bound should be 0", 0, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test 
	public void getUpperBoundNegativeEqualToLower() {
		rangeObjectUnderTest = new Range(-5,-5);
		assertEquals("The upper bound should be 5", -5, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test 
	public void getUpperBoundNegative() {
		rangeObjectUnderTest = new Range(-10,-1);
		assertEquals("The upper bound should be -1", -1, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
	@Test 
	public void getUpperBoundOnePositiveOneNegative() {
		rangeObjectUnderTest = new Range(-10,5);
		assertEquals("The upper bound should be 5", 5, rangeObjectUnderTest.getUpperBound(), 0.000000001d); 
	}
}
