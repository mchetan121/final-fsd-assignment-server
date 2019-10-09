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

import com.example.projectMGMT.models.Task;
import com.example.projectMGMT.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { TaskControllerTest.class })
public class TaskControllerTest {

	@Mock
	private TaskService taskService;

	@InjectMocks
	private TaskController taskController;

	private MockMvc mockMvc;

	@Before
	public void init() throws Exception {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();

	}

	@Test
	public void shouldReturnOKResponseinsertTask() throws Exception {
		Task task = new Task();
		task.setTaskId(1l);
		task.setTask("Add");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(task);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/insertTask").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnOKResponseupdateTask() throws Exception {
		Task task = new Task();
		task.setTaskId(1l);
		task.setTask("Add");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(task);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/updateTask").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}
	@Test
	public void shouldReturnOKResponsedeleteTask() throws Exception {
		Task task = new Task();
		task.setTaskId(1l);
		task.setTask("Add");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(task);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/deleteTask").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}
	@Test
	public void shouldReturnOKResponsegetallTask() throws Exception {
		Task task = new Task();
		task.setTaskId(1l);
		task.setTask("Add");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(task);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getallTask").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}
	@Test
	public void shouldReturnOKResponsegetallparenttaskbypid() throws Exception {
		Task task = new Task();
		task.setTaskId(1l);
		task.setTask("Add");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(task);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getallparenttaskbypid").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}
	@Test
	public void shouldReturnOKResponsegetTaskbyid() throws Exception {
		Task task = new Task();
		task.setTaskId(1l);
		task.setTask("Add");

		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(task);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getTaskbyid").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

}
