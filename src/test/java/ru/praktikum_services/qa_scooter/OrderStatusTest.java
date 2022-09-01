package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderStatusTest extends BaseTest {

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objHomePage = new HomePage(driver); // объект класса главной страницы
        driver.get(objHomePage.homePageUrl);
        objHomePage.waitForLoadMainImg(); // дождемся загрузки
        objHomePage.clickElement(objHomePage.cookieMessageButton); // согласимся с сообщением про куки
    }

    @Test
    public void orderNotFoundShouldBeDisplayed() {
        // нажмем "Статус заказа"
        objHomePage.clickElement(objHomePage.buttonOrderStatus);

        // дождемся появления формы ввода номера заказа
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objHomePage.orderStatusField));

        // введем несуществующий номер заказа и нажмем "Go"
        objHomePage.sendKeysToField(objHomePage.orderStatusField, "-1");
        objHomePage.clickElement(objHomePage.buttonGo);

        // дождемся загрузки новой страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // объект класса страницы заказа
        OrderStatusPage objOrderStatusPage = new OrderStatusPage(driver);
        // проверим что появилась картинка 'Такого заказа нет'
        boolean isNotFoundImgDisplayed = objOrderStatusPage.isElementDisplayed(objOrderStatusPage.notFoundImage);
        Assert.assertTrue("Картинка 'Такого заказа нет' не появилась", isNotFoundImgDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
