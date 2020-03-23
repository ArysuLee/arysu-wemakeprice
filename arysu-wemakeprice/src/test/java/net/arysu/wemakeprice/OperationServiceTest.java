package net.arysu.wemakeprice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class OperationServiceTest {

	@Autowired
	private OperationService service;
	
	@Test
	void testOperateCharacter() throws Exception {
		
		String url = "https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/apidocs/";
		boolean excludeTag = false;
		int bundleCount = 3;
		
		StringBundle bundle = assertDoesNotThrow(() -> {
			return service.operateCharacter(url, excludeTag, bundleCount);
		});
		
		assertNotNull(bundle.getQuotient());
		assertNotNull(bundle.getRemainder());
	}

}
