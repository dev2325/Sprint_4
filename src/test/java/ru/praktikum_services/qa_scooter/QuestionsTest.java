package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;

import static org.junit.Assert.*;

public class QuestionsTest extends BaseTest {

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        objHomePage = new HomePage(driver);
        driver.get(objHomePage.homePageUrl);
        objHomePage.waitForLoadMainImg();
    }

    @org.junit.Test
    public void checkQuestionPriceShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionPrice);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionPrice);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerPrice);
        // проверка появившегося текста
        String expected = objHomePage.answerPriceString;
        String actual = driver.findElement(objHomePage.answerPrice).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionSeveralItemsShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionSeveralItems);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionSeveralItems);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerSeveralItems);
        // проверка появившегося текста
        String expected = objHomePage.answerSeveralItemsString;
        String actual = driver.findElement(objHomePage.answerSeveralItems).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionRentalTimeShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionRentalTime);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionRentalTime);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerRentalTime);
        // проверка появившегося текста
        String expected = objHomePage.answerRentalTimeString;
        String actual = driver.findElement(objHomePage.answerRentalTime).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionTodayDeliveryShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionTodayDelivery);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionTodayDelivery);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerTodayDelivery);
        // проверка появившегося текста
        String expected = objHomePage.answerTodayDeliveryString;
        String actual = driver.findElement(objHomePage.answerTodayDelivery).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionProlongShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionProlong);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionProlong);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerProlong);
        // проверка появившегося текста
        String expected = objHomePage.answerProlongString;
        String actual = driver.findElement(objHomePage.answerProlong).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionChargingShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionCharging);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionCharging);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerCharging);
        // проверка текста
        String expected = objHomePage.answerChargingString;
        String actual = driver.findElement(objHomePage.answerCharging).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionCancellationShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionCancellation);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionCancellation);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerCancellation);
        // проверка появившегося текста
        String expected = objHomePage.answerCancellationString;
        String actual = driver.findElement(objHomePage.answerCancellation).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @org.junit.Test
    public void checkQuestionRemoteDeliveryShowCorrectAnswer() {
        // скролл до локатора
        objHomePage.scrollToElement(objHomePage.questionRemoteDelivery);
        // клик по вопросу
        objHomePage.clickElement(objHomePage.questionRemoteDelivery);
        // дождемся видимости элемента
        objHomePage.waitForvisibilityOfElement(objHomePage.answerRemoteDelivery);
        // проверка появившегося текста
        String expected = objHomePage.answerRemoteDeliveryString;
        String actual = driver.findElement(objHomePage.answerRemoteDelivery).getText();
        assertEquals("Ожидаемый текст не совпадает с фактическим", expected, actual);
    }

    @After
    public void clearBrowserData() {
        driver.manage().deleteAllCookies();
        ((WebStorage) driver).getSessionStorage().clear();
        ((WebStorage) driver).getLocalStorage().clear();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
