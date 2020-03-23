package net.arysu.wemakeprice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest()
class OperationActionTest {

	private ObjectMapper mapper;
	private MockMvc mvc;

	@Autowired
	private OperationService service;
	
	@BeforeEach
	void init() {
		mapper = new ObjectMapper();

		OperationAction action = new OperationAction(service);
		mvc = MockMvcBuilders.standaloneSetup(action).build();
	}
	
	@Test
	void testOperation() throws Exception {
		
		OperationTO to = new OperationTO();
		to.setUrl("https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/apidocs/");
		to.setExcludeTag(false);
		to.setBundleCount(3);
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(to);
		mvc.perform(post("/v1/operation").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print());

	}

}
