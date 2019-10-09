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

import com.example.projectMGMT.models.Project;
import com.example.projectMGMT.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { ProjectControllerTest.class })
public class ProjectControllerTest {

	@Mock
	private ProjectService projectService;

	@InjectMocks
	private ProjectController projectController;

	private MockMvc mockMvc;

	@Before
	public void init() throws Exception {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();

	}

	@Test
	public void shouldReturnOKResponseinsertProject() throws Exception {
		Project project = new Project();
		project.setProjectId(1l);
		project.setProjectName("Java");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(project);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/insertProject").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponseupdateProject() throws Exception {
		Project project = new Project();
		project.setProjectId(1l);
		project.setProjectName("Java");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(project);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/updateProject").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsedeleteProject() throws Exception {
		Project project = new Project();
		project.setProjectId(1l);
		project.setProjectName("Java");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(project);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/deleteProject").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsegetallProject() throws Exception {
		Project project = new Project();
		project.setProjectId(1l);
		project.setProjectName("Java");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(project);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getallProject").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void shouldReturnOKResponsegetProjectbyid() throws Exception {
		Project project = new Project();
		project.setProjectId(1l);
		project.setProjectName("Java");
		ObjectMapper mapper = new ObjectMapper();
		String requestAsString = mapper.writeValueAsString(project);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/getProjectbyid").content(requestAsString)
						.accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
	}

}
