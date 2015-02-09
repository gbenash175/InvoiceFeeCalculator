package myproject.invoiceFeeCalculator;

public class InvoiceSubscription {
	
	
	protected double calc20PercentFee(double invoiceMoney ){
		return 20 * invoiceMoney / 100;
	}
	
	protected double calc10PercentFee(double invoiceMoney){
		return 10 * invoiceMoney / 100;
	}

}

  