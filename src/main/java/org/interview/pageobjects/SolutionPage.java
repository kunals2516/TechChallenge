package org.interview.pageobjects;

import org.interview.abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SolutionPage extends AbstractComponent {
    public SolutionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Our Story')]")
    WebElement ourStory;

    WebDriver driver;

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
}
