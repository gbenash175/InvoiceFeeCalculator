package myproject.invoiceFeeCalculator;


public class InvoiceSubscription {
	
	public double invoiceFeeCalculator(double invoiceMoney){
	   	if(isPositive(invoiceMoney)){
	      return (invoiceMoney > 100000.0 ) ? calc10PercentFee(invoiceMoney) :
		   calc20PercentFee( invoiceMoney);
	   	}else
	   	return invoiceMoney;	
	}
		
	private double calc20PercentFee(double invoiceMoney ){
		return 20 * invoiceMoney / 100;
	}
	
	private double calc10PercentFee(double invoiceMoney){
		return 10 * invoiceMoney / 100;
	}

	protected  boolean isPositive(double d) {
	     return Double.doubleToRawLongBits(d) > 0;
	}
}

  