package test.gview.clientservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import gview.clientservice.ClientServiceAppConfig;
import gview.clientservice.api.ClientContractDTO;

import static com.jayway.restassured.RestAssured.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientServiceAppConfig.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class TestClientService {
		@Value("${local.server.port}")   // 6
	    int port;
		
		 @Before
		 public void setUp() {
			 RestAssured.port = port;
		 }	 
		 
		 @Test
		 public void canAddClientContract() {
			 
			 ClientContractDTO dto = new ClientContractDTO();
			 dto.setContractId("contractid");
			 dto.setEmail("xbarrufetm@gmail.com");
			 dto.setGardenId("gardenId");
			 dto.setLocation("location");
			 dto.setDayOfWeek(5);
			 //Response nomes estar per printar, pot començar directament amb give()
			 Response response = given().
			 	contentType("application/json").
		        body(dto).
			 when().
			    post("/v1/clients");
			 response.then().statusCode(200);
			 System.out.println(response.asString());
			 /* sense consola i amb expect -->
			 given().
			 	contentType("application/json").
		        body(dto).
			 when().
			    post("/v1/clients");
			 then().
				statusCode(200);
				*/
	     }
}
	  
		 