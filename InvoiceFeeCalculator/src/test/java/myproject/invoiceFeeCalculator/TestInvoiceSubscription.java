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
	public void testInvoiceAboveHundred(){
		setup();
		double invoiceMoney1 = 200000.00;
		double invoiceMoney2 = 990000.00;		
		double invoiceFee = calc.invoiceFeeCalculator(invoiceMoney1);
		double invoiceFee2 = calc.invoiceFeeCalculator(invoiceMoney2);
		
		assertEquals(20000.0, invoiceFee);
		assertEquals(99000.0, invoiceFee2);		
	}
}
