package net.arysu.wemakeprice;

public class StringBundle {

	private String quotient;
	private String remainder;
	
	public StringBundle(String quotient, String remainder) {
		this.quotient = quotient;
		this.remainder = remainder;
	}

	public String getQuotient() {
		return quotient;
	}
	public void setQuotient(String quotient) {
		this.quotient = quotient;
	}
	public String getRemainder() {
		return remainder;
	}
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}

	@Override
	public String toString() {
		return "StringBundle [quotient=" + quotient + ", remainder=" + remainder + "]";
	}
	
	
}
