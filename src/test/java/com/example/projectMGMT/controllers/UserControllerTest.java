package com.example.projectMGMT.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.projectMGMT.models.User;
import com.example.projectMGMT.response.ResponseModel;
import com.example.projectMGMT.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { UserControllerTest.class})
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @InitBinder
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void shouldReturnOKResponse() throws Exception {
        User user = new User();
        user.setFirstName("chetan");
        user.setLastName("Mahajan");

        Mockito.when(userService.addUser(Mockito.any())).thenReturn(getFixedResponse());

        ObjectMapper mapper = new ObjectMapper();
        String requestAsString = mapper.writeValueAsString(user);

        String uri = "/insertUser";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                .content(requestAsString).contentType(MediaType.APPLICATION_JSON)).andReturn();

        ResponseEntity<ResponseModel> responseProcessor = (ResponseEntity<ResponseModel>) mvcResult
                .getAsyncResult();
        assertEquals(responseProcessor.getStatusCodeValue(), HttpStatus.OK.value());
    }

    public ResponseModel getFixedResponse() {
        ResponseModel response = new ResponseModel();
        response.setStatusCode(200);
        response.setMessage("OK");
        return response;

    }

}
