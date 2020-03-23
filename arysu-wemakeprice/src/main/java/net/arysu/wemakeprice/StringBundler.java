package net.arysu.wemakeprice;

import org.springframework.stereotype.Component;

@Component
public class StringBundler {

	public StringBundle createBundle(String text, int bundleCount) {
		
		String quotientString = "";
		String remainderString = "";
		
		int length = text.length();
		int remainder = length % bundleCount;
		if (remainder > 0) {
			quotientString = text.substring(0, length - remainder);
			remainderString = text.substring(length - (1 + remainder), length - 1);
		} else {
			quotientString = text;
		}
		
		return new StringBundle(quotientString, remainderString);
	}
}
