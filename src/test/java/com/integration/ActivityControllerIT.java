package com.integration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.model.UserActivity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActivityControllerIT {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate1;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/activity/get");
	}

	@Test
	public void getActivity() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		String plainCreds = "user:password";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(headers);

//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//		// Add the Jackson Message converter
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		// Note: here we are making this converter to process any kind of
//		// response,
//		// not only application/*json, which is the default behaviour
//		// converter.setSupportedMediaTypes(Arrays.asList({MediaType.ALL}));
//
//		MediaType[] arr = { MediaType.ALL };
//		converter.setSupportedMediaTypes(Arrays.asList(arr));
//
//		messageConverters.add(converter);
//		restTemplate.setMessageConverters(messageConverters);

		ResponseEntity<UserActivity> response = restTemplate.exchange("http://localhost:7777/activity/get",
				HttpMethod.GET, request, UserActivity.class);
		System.out.println("response is : " + response);
		UserActivity activity = response.getBody();
		System.out.println("data is : " + activity);
	}

}
