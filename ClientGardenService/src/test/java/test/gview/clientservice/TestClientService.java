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

import gview.clientgardenservice.ClientGardenServiceAppConfig;
import gview.clientgardenservice.ClientGardenServiceException;

import gview.clientgardenservice.api.GardenDTO;

import static com.jayway.restassured.RestAssured.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientGardenServiceAppConfig.class)
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
		 public void canAddClientContract() throws ClientGardenServiceException {
			 
			 GardenDTO garden = GardenDTO.getBuilder().
					 					gardenId("").
					 					email("gardeName").
					 					city("location").
					 					address("address").build();
			
			 //Response nomes estar per printar, pot començar directament amb give()
			 Response response = given().
			 	contentType("application/json").
		        body(garden).
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
	  
		 