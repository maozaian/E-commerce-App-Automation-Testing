package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;


public class D01_registerStepDef {
    P01_register reg = new P01_register();

    @Given("user go to register page")
    public void user_go_to_register_page()

    {
        reg.registerBtn().click();
    }
    @When("user select gender type")
    public void gender() throws InterruptedException {
       reg.gender();
    }

    @And ("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void first_last_name(String firstname, String lastname)
    {
        reg.first_name().sendKeys(firstname);
        reg.last_name().sendKeys(lastname);
    }


    @And("user enter date of birth")
    public void user_enter_date_of_birth() throws InterruptedException {
        reg.date_of_birth();
    }
    @And("^user enter email \"(.*)\" field$")
    public void user_enter_email(String email)
    {
        reg.email().sendKeys(email);
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void fills_password_fields(String password, String confPassword)
    {
        reg.fillPassword().sendKeys(password);
        reg.confirmPassword().sendKeys(confPassword);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        reg.registBtn().click();
    }
    @Then("success message is displayed")
    public void Success_message_displayed()
    {
        reg.result();

    }

}
