package org.interview.pageobjects;

import org.interview.abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TendablePage extends AbstractComponent {
    public TendablePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Our Story')]")
    WebElement ourStory;

    @FindBy(xpath = "//a[contains(text(),'Our Solution')]")
    WebElement ourSolution;

    @FindBy(xpath = "//a[contains(text(),'Why Tendable?')]")
    WebElement whyTendable;

    @FindBy(xpath = "//a[contains(text(),'About Us')]")
    WebElement aboutUs;


    WebDriver driver;


    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
}
