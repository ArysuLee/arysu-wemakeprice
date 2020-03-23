package net.arysu.wemakeprice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringBundlerTest {

	private StringBundler bundler;
	
	@BeforeEach
	void init() {
		this.bundler = new StringBundler();
	}
	
	
	@Test
	void testCreateBundle() {
		
		String allString = "A0a1B2b3C4c5D6d7E8e9FfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		int bundleCount = 7;
		StringBundle bundle = bundler.createBundle(allString, bundleCount);
	
		assertEquals(allString.length() % 7, bundle.getRemainder().length());
	}

}
