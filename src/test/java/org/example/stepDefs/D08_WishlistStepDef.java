package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage wishlist = new P03_homePage();
    @When("user add product to wishlist")
    public void user_add_product_to_wishlist() throws InterruptedException {
        wishlist.addProductToWishlist().click();
        Thread.sleep(4000);
    }

    @Then("wishlist notification success is visible")
    public void wishlist_notification_success_visible()
    {
       wishlist.getsuccessMsg();
    }

    @When("user add product to wishlist again")
    public void add_product_agian() throws InterruptedException {
        user_add_product_to_wishlist();
    }


    @And("user go to wishlist page")
    public void user_go_to_wishlist_page()
    {
       wishlist.getWishList().click();

    }
    @Then("number of quantity is greater than zero in wishlist page")
    public void quantity_greater_than_zero()
    {

        wishlist.getWishlistQuantity();
    }
}
