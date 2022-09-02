package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage extends BasePage {

    protected OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    protected By notFoundImage = By.cssSelector(".Track_NotFound__6oaoY");

    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
