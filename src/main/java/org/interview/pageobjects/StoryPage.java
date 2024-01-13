package org.interview.pageobjects;

import org.interview.abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoryPage extends AbstractComponent {
    public StoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }







}
