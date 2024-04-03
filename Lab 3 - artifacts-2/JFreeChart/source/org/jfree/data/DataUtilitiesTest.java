package org.jfree.data;

import static org.junit.Assert.*;

import java.text.Format;

import org.jfree.chart.block.Message;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	private Values2D values2D;
	private KeyedValues keyedValues;


	@Before
	public void setUp() throws Exception {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
		keyedValues = null;
	}
	
	/*
	 * Method under test Calculate Column Total
	 */
	
	@Test
	public void testCalculateColumnTotalZeroColumn()
	{ 
	  try 
	  { 
	    DataUtilities.calculateColumnTotal(null, 0); 
	    fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	  } 
	  catch (Exception e) 
	  { 
		assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
	  } 
	}
	
	@Test
	public void testCalculateColumnTotalNullDataValidColumn()
	{ 
	  try 
	  { 
	    DataUtilities.calculateColumnTotal(null, 5); 
	    fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	  } 
	  catch (Exception e) 
	  { 
		assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
	  } 
	}
	
	@Test
	public void testCalculateColumnTotalNullDataNegativeColumn()
	{ 
	  try 
	  { 
	    DataUtilities.calculateColumnTotal(null, -1); 
	    fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	  } 
	  catch (Exception e) 
	  { 
		assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
	  } 
	}

	@Test
	public void testCalculateColumnTotal() {
		
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalZeroValues() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		
		values2D = testValues;
		
		testValues.addValue(0, 0, 0);
		
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalFiveColumns() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		
		values2D = testValues;
		
		testValues.addValue(0, 0, 0);
		testValues.addValue(0, 0, 1);
		testValues.addValue(0, 0, 2);
		testValues.addValue(0, 0, 3);
		testValues.addValue(0, 0, 4);

		
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, 4),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalNegativeColumn() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0, 0, -1);

		
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalOneValue() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		
		values2D = testValues;
		
		testValues.addValue(1, 0, 0);

		
		assertEquals("Wrong sum returned. It should be 1", 1, DataUtilities.calculateColumnTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalOneColumnOneROw() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		
		values2D = testValues;
		
		testValues.addValue(1, 1, 0);

		
		assertEquals("Wrong sum returned. It should be 1", 1, DataUtilities.calculateColumnTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalFiveColumns2() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(1, 0, 1);
		testValues.addValue(1, 0, 2);
		testValues.addValue(1, 0, 3);
		testValues.addValue(1, 0, 4);
		

		
		assertEquals("Wrong sum returned. It should be 1", 1, DataUtilities.calculateColumnTotal(values2D, 4),0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalWithRow() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 1, 0);
		testValues.addValue(1, 0, 1);
		testValues.addValue(1, 0, 2);
		testValues.addValue(1, 0, 3);
		testValues.addValue(1, 0, 4);
		

		
		assertEquals("Wrong sum returned. It should be 1", 1, DataUtilities.calculateColumnTotal(values2D, 4),0.0000001d);
	}
	
	
	
	/*
	 * Method under test Calculate Row Total
	 */
	
	@Test
	public void testCalculateRowTotalNullData() {
		
		try {
			values2D = null;
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
		}
	}
	
	@Test
	public void testCalculateRowTotalNullDataValid() {
		
		try {
			values2D = null;
			DataUtilities.calculateRowTotal(values2D, 5);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
		}
	}
	
	@Test
	public void testCalculateRowTotalNullDataNegativeRow() {
		
		try {
			values2D = null;
			DataUtilities.calculateRowTotal(null, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
		}
		
	}
	@Test
	public void testCalculateRowTotal() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0, 0, 0);
		
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateRowTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalFiveRows() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0, 0, 0);
		testValues.addValue(0, 0, 0);
		testValues.addValue(0, 0, 0);
		testValues.addValue(0, 0, 0);
		testValues.addValue(0, 0, 0);
		
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateRowTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalNegativeRow() {
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
			values2D = testValues;
			testValues.addValue(0, 0, 0);
			
			DataUtilities.calculateRowTotal(values2D, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Incorrect exception type thrown", ArrayIndexOutOfBoundsException.class, e.getClass());
		}
	}
	
	@Test
	public void testCalculateRowTotalValid() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		
		assertEquals("Wrong sum returned. It should be 1", 1, DataUtilities.calculateRowTotal(values2D, 0),0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalRowOne() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		testValues.addValue(1, 0, 0);
		testValues.addValue(1, 1, 1);
		testValues.addValue(0, 0, 0);
		//values2D = testValues;
		
		assertEquals("Wrong sum returned. It should be 1", 1, DataUtilities.calculateRowTotal(testValues, 1),0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalRowFive() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(0, 1, 0);
		testValues.addValue(0, 2, 0);
		testValues.addValue(0, 3, 0);
		testValues.addValue(0, 4, 0);
		
		assertEquals("Wrong sum returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2D, 4),0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalWithColumn() {
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(1, 1, 1);
		testValues.addValue(1, 2, 0);
		testValues.addValue(1, 3, 0);
		testValues.addValue(1, 4, 0);
		
		assertEquals("Wrong sum returned. It should be 0", 1, DataUtilities.calculateRowTotal(values2D, 4),0.0000001d);
	}
	
	
	
	/*
	 * Method under test create number array
	 */
	
	@Test
	public void testCreateNumberArrayNull() {
		
		double[] testArray = null;
		
		try
		{
		
		DataUtilities.createNumberArray(testArray);
		fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		
		}
		catch (Exception e) {
			assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e.getClass());
		}
	}
	
	
	
	@Test
	public void testCreateNumberArrayEmpty() {
		
		double[] testArray = new double[] {};
		
		
		Number[] number = DataUtilities.createNumberArray(testArray);
		Number[] expectedResponse = new Number[0];
		
		assertEquals("Wrong number retruned. It shoud be 1", number, expectedResponse);
		
		
	}
	
	@Test
	public void testCreateNumberArrayOneValue() {
		
		double[] testArray =  new double[]{0.0};
		
		Number[] number = DataUtilities.createNumberArray(testArray);
		
		Number[] expectedResponse = new Number[1];
		expectedResponse[0] = 0.0;
		
		assertEquals("Expected number array does not match actual response", expectedResponse, number);
		// assertEquals("Wrong amount returned. It should be 2", 1, number.length);
		
	}
	
	@Test
	public void testCreateNumberArrayTwoValues() {
		
		double[] testArray =  new double[]{1.5,2.5};
		
		Number[] number = DataUtilities.createNumberArray(testArray);
		Number[] expectedResponse = new Number[2];
		expectedResponse[0] = 1.5;
		expectedResponse[1] = 2.5;

		
		assertEquals("Wrong amount returned. It should be 2.5", expectedResponse, number);
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateNumberArrayThreeValues() {
		
		double[] testArray =  new double[]{1.5,2.5,3.5};
		
		Number[] number = DataUtilities.createNumberArray(testArray);
		Number[] expectedResponse = new Number[3];
		expectedResponse[0] = 1.5;
		expectedResponse[1] = 2.5;
		expectedResponse[2] = 3.5;


		assertEquals("Wrong amount returned. It should be 3.5", expectedResponse, number);
		
	}



/*
 * Method under test create number array 2D
 */


 	@Test
 	public void testCreateNumberArray2DNull() {
 		
 		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e.getClass());
		}
 		
 	}
 	
 	@Test
 	public void testCreateNumberArray2DEmpty() {
 		
 		
 		 double[][] testArray = new double[][] {};
 		 

         
         Number[][] number = DataUtilities.createNumberArray2D(testArray);
         Number[][] expectedResponse = new Number[0][];
 		


 		assertEquals("Expected returned 2D array does not match actual ", expectedResponse, number);

       
 		
 	}
 	
 	@Test
 	public void testCreateNumberArray2DValid() {
 		

 		
 		 double[][] testArray = new double[][] { {1.5}, {2.5} };
 		 

 		 
         
         Number[][] number = DataUtilities.createNumberArray2D(testArray);
         
         assertEquals("Wrong number Amount. SHould be 2 ",2, number.length);
       
         
         
       
 		
 	}
 	
 	/*
 	 * Method under test : Get cumulative percentages
 	 */
 	@Test
 	public void testGetCumulativePercentagesNullData() {
		
 		try {
 			DefaultKeyedValues testValues = new DefaultKeyedValues();
 			KeyedValues keyedValues = null;
 			DataUtilities.getCumulativePercentages(keyedValues);
		
 		//testValues.setValue("0", 5);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Incorrect exception type thrown", IllegalArgumentException.class, e);
		}
 	
 	}
 	@Test
 	public void testGetCumulativePercentagesNullValue() {
		
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		KeyedValues keyedValues = testValues;
 		testValues.setValue("0", null);

		DataUtilities.getCumulativePercentages(keyedValues);
	
		assertEquals("Incorrect percentage.", null, DataUtilities.getCumulativePercentages(testValues).getValue(0));
 	
 	}
 	@Test
 	public void testgetCumulativePercentages() {
		
 		
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		keyedValues = testValues;
		
 		testValues.setValue("0", 5);
 	
 		assertEquals("Incorrect percentage.", 1, DataUtilities.getCumulativePercentages(testValues).getValue(0));
 		
 	
 	}
 	
	@Test
 	public void testgetCumulativePercentagesKey0() {
		
		
 		
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		keyedValues = testValues;
		
		
 		testValues.setValue("0", 5);
 		testValues.setValue("1", 7);
 		testValues.setValue("2", 10);
 		KeyedValues actual = DataUtilities.getCumulativePercentages(testValues);
 		
 	
 		assertEquals("Incoccrect Percentage. SHould be 0.21739130434 ", 0.21739130434, DataUtilities.getCumulativePercentages(testValues).getValue(0));
 		
 	
 	}
	
	@Test
 	public void testgetCumulativePercentagesKey1() {
		
 		
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		keyedValues = testValues;
		
		
 		testValues.setValue("0", 5);
 		testValues.setValue("1", 7);
 		testValues.setValue("2", 10);
 	
 		assertEquals("Incoccrect Percentage. SHould be 0.52173913043", 0.52173913043, DataUtilities.getCumulativePercentages(testValues).getValue(1));
 	
 	}
	
	@Test
 	public void testgetCumulativePercentagesKey2() {
		

		DefaultKeyedValues testValues = new DefaultKeyedValues();
		keyedValues = testValues;
		
		
 		testValues.setValue("0", 5);
 		testValues.setValue("1", 7);
 		testValues.setValue("2", 10);
 	
 		assertEquals("Incoccrect Percentage. Should be 1", 1, DataUtilities.getCumulativePercentages(testValues).getValue(2));
 	
 	}
}
