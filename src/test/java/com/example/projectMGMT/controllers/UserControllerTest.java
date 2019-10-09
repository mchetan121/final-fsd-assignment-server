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

import com.example.projectMGMT.models.User;
import com.example.projectMGMT.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { UserControllerTest.class })
public class UserControllerTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@Before
	public void init() throws Exception {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

	}

	@Test
	public void shouldReturnOKResponseinsertUser() throws Exception {
		User user = new User();
		user.setFirstName("chetan");
		user.setLastName("Mahajan");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/insertUser").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponseupdateUser() throws Exception {
		User user = new User();
		user.setFirstName("chetan");
		user.setLastName("Mahajan");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/updateUser").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsedeleteUser() throws Exception {
		User user = new User();
		user.setFirstName("chetan");
		user.setLastName("Mahajan");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/deleteUser").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsegetallUser() throws Exception {
		User user = new User();
		user.setFirstName("chetan");
		user.setLastName("Mahajan");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getallUser").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsegetUserbyid() throws Exception {
		User user = new User();
		user.setFirstName("chetan");
		user.setLastName("Mahajan");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getUserbyid").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsegetUserbytid() throws Exception {
		User user = new User();
		user.setFirstName("chetan");
		user.setLastName("Mahajan");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getUserbytid").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

}
