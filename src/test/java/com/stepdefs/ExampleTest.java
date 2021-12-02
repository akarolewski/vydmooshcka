package com.stepdefs;

import com.helpers.CommonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.locators.ExampleLocators.SEARCH_INPUT;
import static com.locators.ExampleLocators.SUBMIT_SEARCH_BUTTON;

public class ExampleTest extends CommonUtils {

  @Given("I open wikipedia")
  public void iOpenWikipedia() {
    getDriver().get("https://wikipedia.com");
  }

  @When("I search for {string}")
  public void iSearchFor(String phrase) {
    type(phrase, SEARCH_INPUT);
  }

  @And("I press submit search button")
  public void iPressSubmitSearchButton() {
    click(SUBMIT_SEARCH_BUTTON);
  }

  @Then("I can see the results page")
  public void iCanSeeTheResultsPage() {
    //do something
  }
}
