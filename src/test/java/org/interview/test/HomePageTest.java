package org.interview.test;

import org.interview.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    WebDriver driver;

    StoryPage storyPage;

    SolutionPage solutionPage;

    TendablePage tendablePage;

    ContactUsPage contactUsPage;



    @Test(priority = 1,enabled = true)
    public void homePage_Verification() throws InterruptedException {

        Assert.assertTrue(homePage.isAboutUsVisible());
        storyPage  = homePage.storyClick();
        Thread.sleep(5000);
        Assert.assertTrue(storyPage.getCurrentUrl().equalsIgnoreCase("https://www.tendable.com/our-story"));
        Assert.assertTrue(homePage.requestDemoPresent());
        Assert.assertTrue(homePage.requestDemoEnabled());
        solutionPage  = homePage.solutionClick();
       // Thread.sleep(5000);
        Assert.assertTrue(solutionPage.getCurrentUrl().equalsIgnoreCase("https://www.tendable.com/our-solution"));
        Assert.assertTrue(homePage.requestDemoPresent());
        Assert.assertTrue(homePage.requestDemoEnabled());
        tendablePage  = homePage.tendableClick();
       // Thread.sleep(5000);
        Assert.assertTrue(tendablePage.getCurrentUrl().equalsIgnoreCase("https://www.tendable.com/why-tendable"));
        Assert.assertTrue(homePage.requestDemoPresent());
        Assert.assertTrue(homePage.requestDemoEnabled());






    }

    @Test(priority = 2,enabled = true)
    public void contactUs_Verification() throws InterruptedException {
      contactUsPage = homePage.contactUsClick();
      contactUsPage.submitForm();

      Assert.assertEquals(contactUsPage.validateErrorMessage(),"Sorry, there was an error submitting the form. Please try again.");
    }
}
