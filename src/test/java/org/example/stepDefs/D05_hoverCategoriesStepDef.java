package org.example.stepDefs;

import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;


public class D05_hoverCategoriesStepDef {

    P03_homePage category = new P03_homePage();
    @When("user could hover categories and select sub Category")
    public void user_hover_categories() throws InterruptedException {

        category.hoverCategories();
    }
}
