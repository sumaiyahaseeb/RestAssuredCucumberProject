package apiTest;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIStepDefs {
	RequestSpecification request;
	Response response;

	@Given("I have the endpoint as {string}")
	public void i_have_the_endpoint_as(String endpoint) {

		request = RestAssured.given().baseUri(endpoint);
	}

	@When("I perform the Get operation")
	public void i_perform_the_Get_operation() {

		response = request.get();
	}

	@Then("I should get the response as {int}")
	public void i_should_get_the_response_as(int expresponse) {

		Assert.assertEquals(expresponse, response.getStatusCode());
	}

	@When("I perform the Post operation with below data")
	public void i_perform_the_Post_operation_with_below_data(Map<String, String> datamap) {

		response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datamap).post();

		System.out.println("The response is " + response.getBody().asString());

	}

	@Then("the fname should be {string} in response")
	public void the_fname_should_be_in_response(String name) {
		Assert.assertEquals(name, response.jsonPath().get("firstName"));

	}

}
