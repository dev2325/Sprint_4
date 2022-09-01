package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderStatusPage extends BasePage {

    protected OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    protected By notFoundImage = By.cssSelector(".Track_NotFound__6oaoY");

    public boolean isElementDisplayed(By locator) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(locator).isDisplayed();
    }
}
