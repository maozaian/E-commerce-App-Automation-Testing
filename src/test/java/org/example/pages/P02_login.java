package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

    public class P02_login {
    public WebElement loginBtn()
    {
        WebElement loginBtn =   Hooks.driver.findElement(By.className("ico-login"));
        return loginBtn;
    }

    public WebElement validEmail()
    {
        By validEmail = By.id("Email");

        WebElement validEmailEle = Hooks.driver.findElement(validEmail);

        return validEmailEle;
    }
    public WebElement validPassword()
    {
        By validPassword =  By.id("Password");
        WebElement validPasswordEle = Hooks.driver.findElement(validPassword);
        return validPasswordEle;
    }
    public WebElement invalidEmail()
    {
        By invalidEmail = By.id("Email");

        WebElement invalidEmailEle = Hooks.driver.findElement(invalidEmail);

        return invalidEmailEle;
    }
    public WebElement invalidPassword()
    {
        By invalidPassword =  By.id("Password");
        WebElement invalidPasswordEle = Hooks.driver.findElement(invalidPassword);
        return invalidPasswordEle;
    }


    public WebElement logBtn() throws InterruptedException {
    WebElement logBtn =   Hooks.driver.findElement(By.className("login-button"));
    Thread.sleep(3000);
    return logBtn;
    }

    public void successLogin() {

        String actualResult = Hooks.driver.getCurrentUrl();
        System.out.println(actualResult);
        String expectedResult = "https://demo.nopcommerce.com/";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualResult, expectedResult);

        WebElement accountTab = Hooks.driver.findElement(By.className("ico-account"));
        soft.assertTrue(accountTab.isDisplayed(), String.valueOf(true));

        soft.assertAll();
    }

    public void unSuccessLogin() {
        String actualMsg = Hooks.driver.findElement(By.className("message-error")).getText();
        System.out.println(actualMsg);

        String expectedMsg = "Login was unsuccessful";

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualMsg.contains(expectedMsg));

        String  actualColor = Hooks.driver.findElement(By.className("message-error")).getCssValue("color");
        String expectedColor = Color.fromString(actualColor).asHex();

        soft.assertEquals(expectedColor,"#e4434b");
        soft.assertAll();
    }

}
