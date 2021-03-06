package com.bilch.nim;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StartControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/start"));
	}

	@Test
	public void testStart() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/start").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("13")));
	}

	@Test
	public void testDraw() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/start/draw/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testDrawToMany() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/start/draw/4").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("13")));
	}

	@Test
	public void testDrawZero() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/start/draw/0").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("13")));
	}

	@Test
	public void testDrawOver() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/start").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().string(equalTo("13")));
		mvc.perform(MockMvcRequestBuilders.get("/start/draw/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/start/draw/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/start/draw/3").accept(MediaType.APPLICATION_JSON));
	}

}
