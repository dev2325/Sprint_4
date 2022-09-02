package ru.praktikum_services.qa_scooter;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrderErrorsTextTest extends BaseTest {

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        objOrderPage = new OrderPage(driver);
        driver.get(OrderPage.ORDER_PAGE_URL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // дождемся загрузки страницы
        objOrderPage.clickElement(objOrderPage.cookieMessageButton); // согласимся с сообщением про куки
        // покажем все ошибки сразу: введем некорректное имя и нажмем "Далее"
        String incorrectName = "nnnnnnnnn";
        objOrderPage.sendKeysToField(objOrderPage.nameLocator, incorrectName);
        objOrderPage.clickElement(objOrderPage.orderFormButtonNext);
    }

    /*
       Логика тестов: вызываем ошибку (например, "Введите корректную фамилию") -> по этой ошибке получаем
       локатор родителя (инпут) -> проверяем что в инпуте содержится верное значение (например, "* Фамилия").
       Локатор родителя ошибки внутри уже содержит нужный текст ошибки
    */
    @org.junit.Test
    public void checkOrderFormFieldNameErrorTextIsCorrect() {
        // дождемся появления текста нужной ошибки
        objOrderPage.waitForvisibilityOfElement(objOrderPage.alertIncorrectNameLocator);
        // очистим поле чтобы затем сравнивать не введенное значение, а дефолтный текст подсказки
        driver.findElement(objOrderPage.nameLocator).clear();

        // возьмем текст из родительского инпута и сравним с дефолтным
        String actualTextInNameField = driver.findElement(objOrderPage.parentIncorrectNameLocator).
                getAttribute("placeholder");
        String expectedTextInNameField = objOrderPage.defaultNameString;
        Assert.assertEquals("У поля неверный текст ошибки", expectedTextInNameField, actualTextInNameField);
    }

    @org.junit.Test
    public void checkOrderFormFieldSurnameErrorTextIsCorrect() {
        // дождемся появления текста нужной ошибки
        objOrderPage.waitForvisibilityOfElement(objOrderPage.alertIncorrectSurnameLocator);

        // возьмем текст из родительского инпута и сравним с дефолтным
        String actualTextInSurnameField = driver.findElement(objOrderPage.parentIncorrectSurnameLocator).
                getAttribute("placeholder");
        String expectedTextInSurnameField = objOrderPage.defaultSurnameString;
        Assert.assertEquals("У поля неверный текст ошибки", expectedTextInSurnameField, actualTextInSurnameField);
    }

    @org.junit.Test
    public void checkOrderFormFieldMetroErrorTextIsCorrect() {
        // дождемся появления текста нужной ошибки
        objOrderPage.waitForvisibilityOfElement(objOrderPage.alertIncorrectMetroStationLocator);

        // возьмем текст из родительского инпута и сравним с дефолтным
        String actualTextInMetroStationField = driver.findElement(objOrderPage.parentIncorrectMetroStationLocator).
                getAttribute("placeholder");
        String expectedTextInMetroStationField = objOrderPage.defaultMetroStationString;
        Assert.assertEquals("У поля неверный текст ошибки", expectedTextInMetroStationField, actualTextInMetroStationField);
    }

    @org.junit.Test
    public void checkOrderFormFieldPhoneErrorTextIsCorrect() {
        // дождемся появления текста нужной ошибки
        objOrderPage.waitForvisibilityOfElement(objOrderPage.alertIncorrectPhoneLocator);

        // возьмем текст из родительского инпута и сравним с дефолтным
        String actualTextInPhoneField = driver.findElement(objOrderPage.parentIncorrectPhoneLocator).
                getAttribute("placeholder");
        String expectedTextInPhoneField = objOrderPage.defaultPhoneString;
        Assert.assertEquals("У поля неверный текст ошибки", expectedTextInPhoneField, actualTextInPhoneField);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
