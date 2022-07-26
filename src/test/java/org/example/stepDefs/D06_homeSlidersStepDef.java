package org.example.stepDefs;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage slider = new P03_homePage();
    @When("user clicks on first slider")
    public void user_clicks_first_slider() throws InterruptedException {
       slider.locateFirstSlider().click();
    }
    @And("user select product of first slider")
    public void user_select_first_product() throws InterruptedException {
        slider.selectFirstProduct().click();
    }

    @Then("user go to first product page")
    public void user_go_first_product_page()
    {
        slider.getFirstSliderProductUrl();
    }

    @When("user clicks on second slider")
    public void user_clicks_second_slider() throws InterruptedException {
        slider.locateSecondSlider().click();
    }
    @And("user select product of Second slider")
    public void user_select_second_product() throws InterruptedException {
        slider.selectSecondProduct().click();
    }

    @Then("user go to second product page")
    public void user_go_second_product_page()  {

        slider.getSecondSliderProductUrl();
    }
}
