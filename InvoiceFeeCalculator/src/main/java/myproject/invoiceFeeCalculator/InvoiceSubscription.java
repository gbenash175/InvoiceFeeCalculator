package myproject.invoiceFeeCalculator;


public class InvoiceSubscription {
	
	public double invoiceFeeCalculator(double invoiceMoney){
		if(isPositive(invoiceMoney)){
			return calcInvoiceFee(invoiceMoney);
		}else {
			return invoiceMoney;
		}
	   	
	}
		
	private double calcInvoiceFee(double invoiceMoney){
		if(invoiceMoney<=100000){
	   		return calc20PercentFee(invoiceMoney);
	   	}else if (invoiceMoney >100000 && invoiceMoney <=500000){
	   		return calc10PercentFee(invoiceMoney);
	   	}else {
	   		return calcFivePercentFee(invoiceMoney);
	   	}
	}
	
	private double calc20PercentFee(double invoiceMoney ){
		return 20 * invoiceMoney / 100;
	}
	
	private double calc10PercentFee(double InitialInvoiceMoney){
		double totalChargedFee = 20000.0;
		double calcInvoiceMoney = InitialInvoiceMoney - 100000.0;
		while(calcInvoiceMoney >= 100000.0){
			calcInvoiceMoney = calcInvoiceMoney - 100000.0;
			totalChargedFee = totalChargedFee + 10000;
		}
		if(calcInvoiceMoney < 100000){
			totalChargedFee += 10 * calcInvoiceMoney / 100;
		}
		return totalChargedFee;
	}
	
	private double calcFivePercentFee(double InitialInvoiceMoney ){
		double totalChargedFee = 60000.0;
		double calcInvoiceMoney = InitialInvoiceMoney - 500000.0;
		while(calcInvoiceMoney >= 100000.0){
			calcInvoiceMoney = calcInvoiceMoney - 100000.0;
			totalChargedFee = totalChargedFee + 5000;
		}
		if(calcInvoiceMoney < 100000){
			totalChargedFee += 5 * calcInvoiceMoney / 100;
		}
		return totalChargedFee;
	}

	protected  boolean isPositive(double d) {
	     return Double.doubleToRawLongBits(d) > 0;
	}
}

  