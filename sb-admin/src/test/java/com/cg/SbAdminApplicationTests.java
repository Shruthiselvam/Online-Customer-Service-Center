package com.cg;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.ocs.SbAdminApplication;
import com.ocs.model.*;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbAdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SbAdminApplicationTests {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

    @Test
    public void testCreateDepartment() {
         Department dept = new Department();
         dept.setDepartmentId(2);
         dept.setDepartmentName("Programmer");
        ResponseEntity<Department> postResponse = restTemplate.postForEntity(getRootUrl() + "/department/newDepartment", dept, Department.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    /* @Test
     public void testGetAllEmployees() {
        HttpHeaders headers = new HttpHeaders();	//Represents an HTTP request or response entity, consisting of headers and body.
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees/all",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }*/

    @Test
    public void testGetDepartmentById() {
        Department dept = restTemplate.getForObject(getRootUrl() + "/department/byId/2", Department.class);
        System.out.println("Department Name : "+dept.getDepartmentName());
        assertNotNull(dept);
    }

    @Test
    public void testUpdateDepartment() {
        int id = 2;
        Department dept = restTemplate.getForObject(getRootUrl() + "/department/byId/" + id, Department.class);
       dept.setDepartmentName("Developer");
        restTemplate.put(getRootUrl() + "/department/updateDepartment/" + id, dept);
        Department updatedDepartment = restTemplate.getForObject(getRootUrl() + "/department/byId/" + id, Department.class);
//        assertNotNull(updatedEmployee);
	assertEquals(dept.getDepartmentName(), updatedDepartment.getDepartmentName());
    }

    @Test
    public void testDeleteDepartment() {
         int id = 2;
         Department dept = restTemplate.getForObject(getRootUrl() + "/department/byId/" + id, Department.class);
//         assertNotNull(dept);
         restTemplate.delete(getRootUrl() + "/department/deleteEmployee/" + id);
         try {
              dept = restTemplate.getForObject(getRootUrl() + "/department/byId/" + id, Department.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
    
    // for  operator
    
    @Test
    public void testCreateOperator() {
    	Department dept=new Department();
    	dept.setDepartmentId(2);
    	dept.setDepartmentName("developer");
        Operator opt = new Operator();
        opt.setOperatorId(102);
         opt.setFirstName("Mark");
         opt.setLastName("smith");
         opt.setEmail("def@gmail.com");
         opt.setMobile("123456");
         opt.setCity("theni");
         opt.setDepartment(dept);
        ResponseEntity<Operator> postResponse = restTemplate.postForEntity(getRootUrl() + "/operator/newOperator", opt, Operator.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

     @Test
     public void testGetAllOperators() {
        HttpHeaders headers = new HttpHeaders();	//Represents an HTTP request or response entity, consisting of headers and body.
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/operators/all",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetOperatorById() {
        Operator opt = restTemplate.getForObject(getRootUrl() + "/operator/byId/101", Operator.class);
        System.out.println("Emp Name : "+opt.getFirstName());
        assertNotNull(opt);
    }

    @Test
    public void testUpdateOperator() {
        int id = 102;
        Operator opt = restTemplate.getForObject(getRootUrl() + "/Operator/byId/" + id, Operator.class);
       opt.setFirstName("shruthi");
        restTemplate.put(getRootUrl() + "/operators/updateOperator/" + id, opt);
        Operator updatedOperator = restTemplate.getForObject(getRootUrl() + "/operator/byId/" + id, Operator.class);
//        assertNotNull(updatedEmployee);
	assertEquals(opt.getFirstName(), updatedOperator.getFirstName());
    }

    @Test
    public void testDeleteOperator() {
         int id = 102;
         Operator opt = restTemplate.getForObject(getRootUrl() + "/operator/byId/" + id, Operator.class);
//         assertNotNull(opt);
         restTemplate.delete(getRootUrl() + "/operator/deleteOperator/" + id);
         try {
              opt = restTemplate.getForObject(getRootUrl() + "/operator/byId/" + id, Operator.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
