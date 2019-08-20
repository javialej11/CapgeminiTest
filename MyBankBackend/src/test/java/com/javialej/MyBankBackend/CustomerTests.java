package com.javialej.MyBankBackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import com.javialej.MyBankBackend.models.services.impl.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CustomerTests {
	
	@Autowired
    private TestRestTemplate template;
	
	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private BCryptPasswordEncoder passwordEncoder;
	
	// GET
	@Test
	public void findAll() throws Exception {
		
		ResponseEntity<String> result = template.withBasicAuth("frontendapp", "frontendsecret")
		          .getForEntity("/private/hello", String.class);
		
		System.out.println(result);
		
		
		/*
		Customer customer = new Customer();
		customer.setId(7L);
		customer.setName("");
		customer.setSurname("");
		customer.setCustomerId("javialej");
		customer.setEmail("");
		customer.setMobile("");
		customer.setPhone("");
		customer.setPassword("");
		customer.setEnabled(true);
		
		List<Customer> customers = Arrays.asList(customer);
        given(customerService.findAll()).willReturn(customers);
        
        this.mockMvc.perform(get("/api/1.0/customer/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]"));
         */
	}
	
	
	/* GET
	@Test
	@WithUserDetails("javialej")
	public void findById() throws Exception {
		
		Long ID = 7L;
		
		Customer customer = new Customer();
		customer.setId(7L);
		customer.setName("");
		customer.setSurname("");
		customer.setCustomerId("javialej");
		customer.setEmail("");
		customer.setMobile("");
		customer.setPhone("");
		customer.setPassword("");
		customer.setEnabled(true);
		
		Mockito.when(customerService.findById(ID)).thenReturn(customer);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/customer/"+ID+"/get")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
	// POST
	@Test
	public void createStudentCourse() throws Exception {
		
		Customer customer = new Customer();
		customer.setId(7L);
		customer.setName("");
		customer.setSurname("");
		customer.setCustomerId("javialej");
		customer.setEmail("");
		customer.setMobile("");
		customer.setPhone("");
		customer.setPassword("");
		customer.setEnabled(true);
		
		String exampleCustomer = "{ customer: 1 }";
		
		// studentService.addCourse to respond back with mockCourse
		Mockito.when(customerService.save(customer)).thenReturn(customer);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/customer/sign-up")
				.accept(MediaType.APPLICATION_JSON).content(exampleCustomer)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost:8080/api/1.0/customer/sign-up",
				response.getHeader(HttpHeaders.LOCATION));
	}
	
	*/

}
