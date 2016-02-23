package gview.clientservice.api;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;

import gview.clientservice.ClientServiceAppConfig;
import gview.clientservice.repository.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientServiceAppConfig.class)
@WebIntegrationTest@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")   // 4
public class ClientServiceRestControllerTest {

	@Autowired   // 5
    ClientRepository repository;
	
	@Value("${local.server.port}")   // 6
    int port;
	
	private MockMvc mockMvc;
 
    @Before
    public void setUp() {
        // 7
        /* mickey = new Character("Mickey Mouse");
        minnie = new Character("Minnie Mouse");
        pluto = new Character("Pluto");
 
        // 8
        repository.deleteAll();
        repository.save(Arrays.asList(mickey, minnie, pluto));*/
 
        // 9
        RestAssured.port = port;
    }
    
    @Test
    public void canFetchMickey() {
       
        when().
                get("/characters/{id}", mickeyId).
        then().
                statusCode(HttpStatus.SC_OK).
                body("name", Matchers.is("Mickey Mouse")).
                body("id", Matchers.is(mickeyId));
    }
}
