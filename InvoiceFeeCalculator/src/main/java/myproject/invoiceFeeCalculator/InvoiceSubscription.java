package myproject.invoiceFeeCalculator;


public class InvoiceSubscription {
	private static int INTERVAL = 100000;
	private int invoicePercentage = 20;
	private double invoiceBracket = 100000;
	
	
	
	public double invoiceFeeCalculator(double invoiceMoney){
		if(isPositive(invoiceMoney)){
			return calcInvoiceFee(invoiceMoney);
		}else {
			return invoiceMoney;
		}   	
	}
	
	public double invoiceFeeWithCostBasis(double costBasis, double newInvoice){
		 double invoiceFee =0;
		 double partialInterval;
		   while(costBasis > invoiceBracket ){
			   invoiceBracketAlgorithm();
		   }
		   partialInterval = invoiceBracket - costBasis;
		   if(partialInterval >= newInvoice){
			    invoiceFee = calcPercentageFee(newInvoice);
		   }else {
			   invoiceFee += calcPercentageFee(partialInterval);  
			   invoiceBracketAlgorithm();
			   invoiceFee += calcPercentageFee(newInvoice - partialInterval);   
		   }
		   return invoiceFee;  
	}
		  
		
	private double calcInvoiceFee(double invoiceMoney){
	 double partialInvoice = invoiceMoney;
	 double invoiceFee = 0;
	 double previousInvoiceBracket =0;
	  while (invoiceMoney > invoiceBracket){
		  invoiceFee += calcPercentageFee(invoiceBracket - previousInvoiceBracket);
		  previousInvoiceBracket = invoiceBracket;
		  invoiceBracketAlgorithm();
		  partialInvoice = invoiceMoney - previousInvoiceBracket;
	  }
	  return invoiceFee += calcPercentageFee(partialInvoice);
	}
	
	
	protected double calcPercentageFee(double value ){
		double fee =0;
		while(value > INTERVAL){
			value -= INTERVAL;
			fee += invoicePercentage * 1000;
		}
		return fee += invoicePercentage * value /100;
	}

	
	private void invoiceBracketAlgorithm(){
		  invoicePercentage= invoicePercentage/2;
		  invoiceBracket +=400000.0;
}
	
	protected  boolean isPositive(double d) {
	     return Double.doubleToRawLongBits(d) > 0;
	}
}

  