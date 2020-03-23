package net.arysu.wemakeprice;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Component
public class WebScraper {

	public ByteHolder scrap(String url, boolean excludeTag) throws RuntimeException {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);

		ResponseHandler<ByteHolder> responseHandler = new ResponseHandler<ByteHolder>() {

			@Override
			public ByteHolder handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

				int httpStatus = response.getStatusLine().getStatusCode();
				if (httpStatus == HttpStatus.SC_OK) {

					InputStream is = response.getEntity().getContent();
					ByteHolder holder = new ByteHolder();

					boolean inTag = false;
					int data;
					while ((data = is.read()) != -1) {

						if (excludeTag) {
							
							if (data == 60) {
								inTag = true;
							} else if (data == 62) {
								inTag = false;
							}
							
							if (inTag) {
								continue;
							}
						}

						if (ByteHolder.isNumeric(data)) {
							holder.writeNumeric(data);
						}

						if (ByteHolder.isLowerAlphabet(data)) {
							holder.writeLowerAlphabet(data);
						}
						
						if (ByteHolder.isUpperAlphabet(data)) {
							holder.writeUpperAlphabet(data);
						}
					}

					return holder;
				} else {
					throw new ClientProtocolException("Unexpected http status: " + httpStatus);
				}

			}

		};

		try {

			ByteHolder holder = client.execute(httpGet, responseHandler);
			return holder;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
