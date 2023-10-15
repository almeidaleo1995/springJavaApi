package com.studyapi.qaTest.stepsDefinitions;

import com.studyapi.qaTest.domain.QaDomain;
import com.studyapi.qaTest.requests.QaRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.ParameterType;
import io.cucumber.datatable.DataTable;
import okhttp3.Response;

public class QaSteps {

    private QaRequest qaClient; // Crie uma instância da classe QaRequestClient
    private Response response;

    QaDomain qaDomain = new QaDomain();

    public QaSteps() {
        // Substitua "http://localhost:8080" pela URL da sua API
        String baseUrl = "http://localhost:8080";
        qaClient = new QaRequest(baseUrl);
    }
    @Given("a QA with ID")
    public void aQAWithIdExists() throws Exception {
        response = qaClient.createQa("TestNotUpdate", "China");
        String responseBody = response.body().string();
        qaDomain.setId(qaClient.extractIdFromJsonResponse(responseBody));
    }

    @Given("the client makes a POST request qa with name {string} and country {string}")
    public void theClientMakesAPostRequestToCreateQA(String name, String country) throws Exception {
        response = qaClient.createQa(name, country);
    }
    @When("a news info qa is  name {string} and country {string}")
    public void aNewInfoQAIs(String name, String country) throws Exception {
        response = qaClient.updateQa(qaDomain.getId(), name, country);
    }
    @When("the client makes a DELETE")
    public void theClientMakesADeleteRequest() throws Exception {
        response = qaClient.deleteQa(qaDomain.getId());
    }

    @When("the client makes a get all QAs")
    public void theClientMakesAGetAllQAs() throws Exception {
        response = qaClient.getAllQas();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.code();
        assert actualStatusCode == expectedStatusCode : "Expected status code: " + expectedStatusCode
                + ", but got: " + actualStatusCode;
        response.close();
    }

}
