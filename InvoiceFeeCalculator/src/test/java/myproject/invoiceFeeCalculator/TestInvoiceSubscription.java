package myproject.invoiceFeeCalculator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class TestInvoiceSubscription extends TestCase {

	private InvoiceSubscription calc;
	
	@Before
	public void setup(){
			calc = new InvoiceSubscription();
	}
	
	@Test
	public void testPositiveAmount(){
		setup();
		double invoiceMoney = 100;	
		assertTrue(calc.isPositive(invoiceMoney));
	}
	
	@Test
	public void testNagativeAmount(){
		setup();
		double invoiceMoney = -100;	
		assertFalse(calc.isPositive(invoiceMoney));
	}
	
	@Test
	public void testInvoiceIsHundred(){
		setup();
		double invoiceMoney = 100000.00;
		double invoiceFee = calc.invoiceFeeCalculator(invoiceMoney);
		assertEquals(20000.0, invoiceFee);
	}
	
	@Test
	public void testInvoiceBelowHundred(){
		setup();
		double invoiceMoney1 = 900.00;
		double invoiceMoney2 = 99000.00;		
		double invoiceFee = calc.invoiceFeeCalculator(invoiceMoney1);
		double invoiceFee2 = calc.invoiceFeeCalculator(invoiceMoney2);
		
		assertEquals(180.0, invoiceFee);
		assertEquals(19800.0, invoiceFee2);		
	}
	
	@Test
	public void testInvoiceBetweenHundredAndFiveHundred(){
		setup();
		double invoiceMoney1 = 200000.00;
		double invoiceFee = calc.invoiceFeeCalculator(invoiceMoney1);
		assertEquals(30000.0, invoiceFee);
		
		setup();
		double invoiceMoney2 = 300000.00;
		double invoiceFee1 = calc.invoiceFeeCalculator(invoiceMoney2);
		assertEquals(40000.0, invoiceFee1);
	}
	
	// USE CASE TWO 
	@Test
	public void testForInvoiceAboveFiveHundred(){
		setup();
		double invoiceMoney = 600000.00;
		double invoiceFee = calc.invoiceFeeCalculator(invoiceMoney);
		assertEquals(65000.0, invoiceFee);
	}
	
	// USE CASE THREE
	
	//USE CASE FOUR
	//Given a cost basis of $400,000 and a new invoice for $200,000, the fee for the new invoice 	should be $15,000!

	@Test
	public void testCostBasis(){
		setup();
		double costBasisInvoice = 400000.0;
		double newInvoice = 200000.00;
		double invoiceFee = calc.invoiceFeeWithCostBasis(costBasisInvoice,newInvoice );
		assertEquals(15000.0, invoiceFee);
	}
	
}