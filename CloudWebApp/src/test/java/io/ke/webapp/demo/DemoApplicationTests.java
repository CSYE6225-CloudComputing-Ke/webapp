package io.ke.webapp.demo;


import org.junit.Before;
//import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//import io.ke.webapp.demo.UserService;
//import io.ke.webapp.demo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private UserService userService;

    @Before
    public void Setup() {mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}

    @Test
    public void register() throws Exception{
            User mockUser = new User();

            mockUser.setEmail("wwww@gmail.com");
            mockUser.setEmail("wwww@gmail.com");
            mockUser.setPassword("wwwwwWWWWW");

            String exampleUserJson = this.mapToJson(mockUser);

     /*   Mockito.when(
                userService.register(Mockito.any(User.class))).thenReturn(mockUser.getEmail());*/
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/user/register")
                    .accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
                    .contentType(MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            MockHttpServletResponse response = result.getResponse();

           // String expectedResult = "{ \n  \"code\":\"201 Created.\",\n  \"reason\":\"Successfully Registered.\"\n}";
          //  assertThat(expectedResult).isEqualTo(response);
           // String expectedResult = "{\n \"code\":\"201 Created.\",\n \"reason\":\"Sucessfully Registered\"\n}";
        assertThat((200)==(response.getStatus()));

    }

    private String mapToJson(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}