package org.example.stepDefs;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage searchbar = new P03_homePage();

    @When("user clicks in search filed")
   public void user_clicks_search_field()
    {
        searchbar.searchBox();
    }
    @A("^user Type product name as \"(.*)\"$")
    public void user_type_product_name(String productname)
    {
        searchbar.typeProductName(productname);
        searchbar.searchBtn().click();
    }

    @Then("user find relevant products")
    public void user_find_relevant_products()
    {
        searchbar.searchResult();
    }

    @When("^user Type product sku as \"(.*)\"$")
    public void user_type_product_sku(String sku) throws InterruptedException {
        searchbar.typeProductSku(sku);
        searchbar.searchBtn().click();
        Thread.sleep(2000);
    }

    @Then("^\"(.*)\" shown in result page")
    public void sku_shown_in_result_page(String sku) throws InterruptedException
    {
        searchbar.skuResult(sku);
    }
}
