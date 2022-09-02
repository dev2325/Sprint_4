package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для клика нужного элемента
    public void clickElement(By locator) {
        if (driver.findElement(locator).isEnabled()) {
            driver.findElement(locator).click();
        }
    }

    // метод ожидания видимости нужного элемента
    public void waitForvisibilityOfElement(By locator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // метод печати текста в поле
    public void sendKeysToField(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    // скролл до нужного элемента
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод для ожидания наличия текста в элементе
    public void waitTextToBePresentInElement(By locator, String text) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}
