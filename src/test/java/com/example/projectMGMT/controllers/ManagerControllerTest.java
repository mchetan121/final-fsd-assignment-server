package com.example.projectMGMT.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.projectMGMT.models.Manager;
import com.example.projectMGMT.service.ManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { ManagerControllerTest.class })
public class ManagerControllerTest {

	@Mock
	private ManagerService managerService;

	@InjectMocks
	private ManagerController managerController;

	private MockMvc mockMvc;

	@Before
	public void init() throws Exception {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(managerController).build();

	}

	@Test
	public void shouldReturnOKResponseInsertManager() throws Exception {
		Manager manager = new Manager();
		manager.setManagerId(1l);
		manager.setManagerName("chetan");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(manager);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/insertManager").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponseUpdateManager() throws Exception {
		Manager manager = new Manager();
		manager.setManagerId(1l);
		manager.setManagerName("chetan");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(manager);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/updateManager").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponseDeleteManager() throws Exception {
		Manager manager = new Manager();
		manager.setManagerId(1l);
		manager.setManagerName("chetan");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(manager);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/deleteManager").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponseGetallManager() throws Exception {
		Manager manager = new Manager();
		manager.setManagerId(1l);
		manager.setManagerName("chetan");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(manager);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/getallManager").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponseGetallManagerGetManagerbyid() throws Exception {
		Manager manager = new Manager();
		manager.setManagerId(1l);
		manager.setManagerName("chetan");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(manager);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getManagerbyid").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}
}
