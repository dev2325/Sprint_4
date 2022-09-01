package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
