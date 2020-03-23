package net.arysu.wemakeprice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WebScraperTest {

	private WebScraper webScraper;
	
	@BeforeEach
	void setup() {
		webScraper = new WebScraper();
	}
	
	
	@Test
	void testScrap() {
		
		String url = "https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/apidocs/";
		try {
			
			ByteHolder holder1 = webScraper.scrap(url, true);
			
			byte[] numericByteArray1 = holder1.toNumericByteArray();
			int numericByteArray1Length = numericByteArray1.length;
			for (byte b : numericByteArray1) {
				assertTrue(() -> {
					return ByteHolder.isNumeric(b);
				});
			}
			
			byte[] lowerAlphabetByteArray1 = holder1.toLowerAlphabetByteArray();
			int lowerAlphabetByteArray1Length = lowerAlphabetByteArray1.length;
			for (byte b : lowerAlphabetByteArray1) {
				assertTrue(() -> {
					return ByteHolder.isLowerAlphabet(b);
				});
			}
			
			byte[] upperAlphabetByteArray1 = holder1.toUpperAlphabetByteArray();
			int upperAlphabetByteArray1Length = upperAlphabetByteArray1.length;
			for (byte b : upperAlphabetByteArray1) {
				assertTrue(() -> {
					return ByteHolder.isUpperAlphabet(b);
				});
			}
			
			ByteHolder holder2 = webScraper.scrap(url, false);
			
			byte[] numericByteArray2 = holder2.toNumericByteArray();
			int numericByteArray2Length = numericByteArray2.length;
			for (byte b : numericByteArray2) {
				assertTrue(() -> {
					return ByteHolder.isNumeric(b);
				});
			}
			
			byte[] lowerAlphabetByteArray2 = holder2.toLowerAlphabetByteArray();
			int lowerAlphabetByteArray2Length = lowerAlphabetByteArray2.length;
			for (byte b : lowerAlphabetByteArray2) {
				assertTrue(() -> {
					return ByteHolder.isLowerAlphabet(b);
				});
			}
			
			byte[] upperAlphabetByteArray2 = holder2.toUpperAlphabetByteArray();
			int upperAlphabetByteArray2Length = upperAlphabetByteArray2.length;
			for (byte b : upperAlphabetByteArray2) {
				assertTrue(() -> {
					return ByteHolder.isUpperAlphabet(b);
				});
			}
			
	
			assertTrue(() -> {
				return numericByteArray1Length <= numericByteArray2Length;
			});
			
			assertTrue(() -> {
				return lowerAlphabetByteArray1Length <= lowerAlphabetByteArray2Length;
			});
			
			assertTrue(() -> {
				return upperAlphabetByteArray1Length <= upperAlphabetByteArray2Length;
			});
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
