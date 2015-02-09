package myproject.invoiceFeeCalculator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class TestInvoiceSubscription extends TestCase {

	InvoiceSubscription calc = null;
	
	@Before
	public void setup(){
		
	}
	
	
	@Test
	public void testInvoiceBelowHundred(){
		calc = new InvoiceSubscription();
		double invoiceMoney1 = 900.00;
		double invoiceMoney2 = 99000.00;		
		double invoiceFee = calc.calc20PercentFee(invoiceMoney1);
		double invoiceFee2 = calc.calc20PercentFee(invoiceMoney2);
		
		assertEquals(180.0, invoiceFee);
		assertEquals(19800.0, invoiceFee2);		
	}
	
	@Test
	public void testInvoiceAboveHundred(){
		calc = new InvoiceSubscription();
		double invoiceMoney1 = 200000.00;
		double invoiceMoney2 = 990000.00;		
		double invoiceFee = calc.calc10PercentFee(invoiceMoney1);
		double invoiceFee2 = calc.calc10PercentFee(invoiceMoney2);
		
		assertEquals(20000.0, invoiceFee);
		assertEquals(99000.0, invoiceFee2);		
	}
}
