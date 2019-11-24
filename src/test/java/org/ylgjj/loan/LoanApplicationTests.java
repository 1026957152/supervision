package org.ylgjj.loan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.ylgjj.loan.domain.Query;
import org.ylgjj.loan.domain.ReturnResult;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoanApplicationTests {

/*
	@Autowired
	private MockMvc mvc;
	@Test
	public void contextLoads() {
		System.out.println("开始测试-----------------");
	}
	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
			throws Exception {


		mvc.perform(get("/api/employees")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(alex.getName())));
	}
*/



    @LocalServerPort
    private int port;

/*
    @Autowired
    private TestRestTemplate restTemplate;
*/


    TestRestTemplate restTemplate;
    URL base;
/*    @LocalServerPort int port;*/

    @Before
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        base = new URL("http://localhost:" + port);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Query querry = new Query();
        querry.setZjhm("612724198409210339");
        this.restTemplate.postForObject("http://localhost:" + port + "/loan_share/public/xfd/gjjgrzhxxcx.service",
                querry, ReturnResult.class);


      /*  assertThat().contains("Hello World");*/
    }
}
