package com.bilch.nim;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartControllerIT {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void testStart() {
		ResponseEntity<String> response = template.getForEntity(base.toString() + "/start", String.class);
		assertThat(response.getBody(), equalTo("13"));
	}

	@Test
	public void testDraw() {
		ResponseEntity<String> response = template.getForEntity(base.toString() + "/start/draw/1", String.class);
		assertThat(Integer.valueOf(response.getBody()),lessThan(13));
	}

}
