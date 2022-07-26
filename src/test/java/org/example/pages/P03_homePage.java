package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
public class P03_homePage {

public void selectEuro() throws InterruptedException {
    WebElement euro = Hooks.driver.findElement(By.name("customerCurrency"));
    Select select = new Select(euro);
    Thread.sleep(2000);
    select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

    }
        public void euroSymbol()
        {
          int count =  Hooks.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).size();
          for (int x = 0; x<count; x++)
          {
            String text = Hooks.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).get(x).getText();
            Assert.assertTrue(text.contains("€"));
          }
    }


        public WebElement searchBox()
        {
            By searchBox =  By.id("small-searchterms");
            WebElement searchBoxEle = Hooks.driver.findElement(searchBox);
            return searchBoxEle;
        }
         public WebElement searchBtn()
        {
        By searchBtn =  By.className("button-1");
        WebElement searchBtnEle = Hooks.driver.findElement(searchBtn);
        String searchUrl = Hooks.driver.getCurrentUrl();
        System.out.println(searchUrl);
        String expectedUrl = "https://demo.nopcommerce.com/search?";
        Assert.assertTrue(expectedUrl.contains(searchUrl));
        return searchBtnEle;

        }

        public void typeProductName(String productname)
        {

            int pcount = Hooks.driver.findElements(By.id("small-searchterms")).size();
            for (int x = 0; x<pcount; x++)
            {
                Hooks.driver.findElements(By.id("small-searchterms")).get(x).sendKeys(productname);
            }

        }
        public void searchResult()
        {

            int item = Hooks.driver.findElements(By.id("small-searchterms")).size();
            for (int x = 0; x<item; x++)
            {
                 String itemname =   Hooks.driver.findElements(By.className("product-item")).get(x).getText();
                 String searchinput =  Hooks.driver.findElements(By.id("small-searchterms")).get(x).getText();
                 Assert.assertTrue(itemname.contains(searchinput));
            }
        }

        public void typeProductSku(String sku) throws InterruptedException
        {
            int scount = Hooks.driver.findElements(By.id("small-searchterms")).size();
             for (int x = 0; x<scount; x++)
             {
            Hooks.driver.findElements(By.id("small-searchterms")).get(x).sendKeys(sku);
            Thread.sleep(2000);
             }
        }

        public void skuResult(String sku) throws InterruptedException {


            Hooks.driver.findElement(By.className("picture")).click();
           Thread.sleep(3000);
            String actualsku =  Hooks.driver.findElement(By.className("sku")).getText();
            System.out.println("actual  " + actualsku);
            System.out.println("expected  " + sku);
            String tag = "SKU: ";
            Assert.assertEquals(tag.concat(sku), actualsku);
        }



        public void hoverCategories() throws InterruptedException {
            Actions action = new Actions(Hooks.driver);
            List<WebElement> mainCategories = Hooks.driver.findElements
                    (By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
            int count = mainCategories.size();
            System.out.println(count);
            int min = 0;
            int max = count - 1;
            int selectedMainCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            action.moveToElement(mainCategories.get(selectedMainCategory)).perform();
            String selectedMainCategoryName = mainCategories.get(selectedMainCategory).getText();
            System.out.println("The selected main category name is : " + selectedMainCategoryName);



            String locator = "(//ul[@class='top-menu notmobile']//ul)[" +Integer.toString(selectedMainCategory+1)+"]/li";
            List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
            Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            if(!subCategoryLinks.isEmpty())
            {
                int subCount = subCategoryLinks.size();
                System.out.println("The selected sub category count is  " + subCount);
                int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
                String selectedSubCategoryName = subCategoryLinks.get(selectedSubCategory).getText();
                System.out.println("The selected sub category name is  " + selectedSubCategoryName);
                subCategoryLinks.get(selectedSubCategory).click();
                String subCategoryTitle = Hooks.driver.getCurrentUrl();
                System.out.println("Sub Category Title is :" + subCategoryTitle);
                Assert.assertTrue(subCategoryTitle.contains(selectedSubCategoryName.toLowerCase().trim()));            }
            else
            {
                mainCategories.get(selectedMainCategory).click();

                Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(selectedMainCategoryName.toLowerCase().trim()));
            }

            Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        }

    public WebElement locateFirstSlider() throws InterruptedException {
        By firstSlider = By.xpath("//a[@rel=\"0\"]");
        WebElement firstSliderEle = Hooks.driver.findElement(firstSlider);
        Thread.sleep(1000);

        System.out.println(firstSliderEle.getText());
        return firstSliderEle;
    }
    public WebElement selectFirstProduct() throws InterruptedException {
        By firstSliderProduct =  By.xpath("//*[@id=\"nivo-slider\"]/a[1]");
        WebElement firstSliderProductEle = Hooks.driver.findElement(firstSliderProduct);
        Thread.sleep(1000);
        return firstSliderProductEle;
    }
    public void getFirstSliderProductUrl()
    {

        String firstSliderProductUrl = Hooks.driver.getCurrentUrl();
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println(firstSliderProductUrl);
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(firstSliderProductUrl, expectedUrl);
    }



    public WebElement locateSecondSlider() throws InterruptedException {
        By secondSlider =  By.xpath("//a[@rel=\"1\"]");
        WebElement secondSliderEle = Hooks.driver.findElement(secondSlider);
        Thread.sleep(1000);
        System.out.println(secondSliderEle.getText());
        return secondSliderEle;
    }

    public WebElement selectSecondProduct() throws InterruptedException {
        By SecondSliderProduct =   By.xpath("//*[@id=\"nivo-slider\"]/a[2]");
        WebElement secondSliderProductEle = Hooks.driver.findElement(SecondSliderProduct);

        Thread.sleep(1000);

        return secondSliderProductEle;
    }
    public void getSecondSliderProductUrl()
    {

        String SecondSliderProductUrl = Hooks.driver.getCurrentUrl();
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println(SecondSliderProductUrl);
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(SecondSliderProductUrl, expectedUrl);

    }

    public WebElement clickfacebookLink()
    {
        WebElement faceBookEle = Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
        String faceBookLink = faceBookEle.getText();
        System.out.println(faceBookLink);
        return faceBookEle;
    }

    public WebElement clickTwitterLink()
    {
        WebElement twitterEle = Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
        String twitterLink = twitterEle.getText();
        System.out.println(twitterLink);
        return twitterEle;
    }

    public WebElement clickRssLink()
    {
        WebElement rssEle = Hooks.driver.findElement(By.className("rss"));
        String rssLink = rssEle.getText();
        System.out.println(rssLink);
        return rssEle;
    }


    public WebElement clickUtubeLink()
    {
        WebElement uTubeEle = Hooks.driver.findElement(By.className("youtube"));
        String uTubeLink = uTubeEle.getText();
        System.out.println(uTubeLink);
        return uTubeEle;
    }
    public WebElement addProductToWishlist()  {
        WebElement htcBtnEle = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
        String htcBtn = htcBtnEle.getText();

        System.out.println(htcBtn);

        return htcBtnEle;
    }
    public void getsuccessMsg()
    {
        WebElement successBar = Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));
        String succesMsgColor = successBar.getCssValue("background-color");
        String expectedColor = Color.fromString(succesMsgColor).asHex();


        SoftAssert soft = new SoftAssert();
        soft.assertTrue(successBar.isDisplayed(), "success notification bar is not displayed");
        soft.assertEquals(expectedColor,"#4bb07a");
        soft.assertAll();
        System.out.println("actual color is : " +succesMsgColor);
        System.out.println("expected color is :" +expectedColor);
        System.out.println("actual color is : " +succesMsgColor);
        System.out.println("expected color is :" +expectedColor);
    }
    public WebElement getWishList()
    {
        WebElement wishListEle = Hooks.driver.findElement(By.xpath("//a[@href=\"/wishlist\"]"));
        return wishListEle;
    }
    public void getWishlistQuantity()
    {
        WebElement  wishlistquantityEle = Hooks.driver.findElement(By.xpath("//input[@value=\"1\"]"));
        String wishlistquantity = wishlistquantityEle.getAttribute("value");
        System.out.println(wishlistquantity);
            Integer actualQuantity = Integer.parseInt(wishlistquantity);
        Assert.assertTrue(actualQuantity  > 0 );

    }









}











