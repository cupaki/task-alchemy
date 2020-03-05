package com.taskalchemy.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import com.task.alchemy.TaskAlchemyApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TaskAlchemyApplication.class)
@SpringBootTest
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void chechForAllEmployees() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(6))).andDo(print());
	}
	
	@Test
	public void findEmployeeById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/3").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").value(3))
			.andExpect(jsonPath("$.firstName").value("Gordana"))
			.andExpect(jsonPath("$.lastName").exists())
			.andExpect(jsonPath("$.email").exists())
			.andExpect(jsonPath("$.role").exists())
			.andDo(print());
	}
	
	@Test
	public void updateEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"id\":\"3\",\"firstName\":\"Sead\",\"lastName\":\"Kolasinac\",\"email\":\"gaca@alchemy.cloud\",\"role\":\"HR\"}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.firstName").exists())
			.andExpect(jsonPath("$.lastName").exists())
			.andExpect(jsonPath("$.firstName").value("Hasan"))
			.andExpect(jsonPath("$.lastName").value("Trubic"));
	}
	
	@Test
	public void deleteEmployeById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/6"));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5))).andDo(print());
	}
	
}
