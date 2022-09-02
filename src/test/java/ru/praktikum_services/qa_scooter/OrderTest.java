package ru.praktikum_services.qa_scooter;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final int orderButtonNum; // номер кнопки "Заказать" (1 - верхняя, 2 - нижняя)
    private final String nameString;
    private final String surnameString;
    private final String addressString;
    private final String metroStationString;
    private final String phoneString;
    private final String deliveryDateString;
    private final String rentalPeriodString;
    private final String colorString;
    private final String commentString;

    // конструктор
    public OrderTest(int orderButtonNum, String nameString, String surnameString, String addressString, String metroStationString,
                     String phoneString, String deliveryDateString, String rentalPeriodString, String colorString,
                     String commentString) {
        this.orderButtonNum = orderButtonNum;
        this.nameString = nameString;
        this.surnameString = surnameString;
        this.addressString = addressString;
        this.metroStationString = metroStationString;
        this.phoneString = phoneString;
        this.deliveryDateString = deliveryDateString;
        this.rentalPeriodString = rentalPeriodString;
        this.colorString = colorString;
        this.commentString = commentString;
    }

    // тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {1, "Иван", "Иванов", "Москва", "Сокольники", "+79001111111", "30.09.2022", "сутки", "black", "комментарий_Ивана"},
                {2, "Петр", "Петров", "Самара", "Лихоборы", "+79002222222", "01.10.2022", "семеро суток", "grey", ""},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        objHomePage = new HomePage(driver); // объект класса главной страницы
        driver.get(HomePage.HOME_PAGE_URL);
        objHomePage.waitForLoadMainImg(); // дождемся загрузки
        objHomePage.clickElement(objHomePage.cookieMessageButton); // согласимся с сообщением про куки
    }

    // метод проверяет успешное размещение нового заказа
    @Test
    public void checkPlaceOrderSuccess() {
        // получение локатора кнопки "Заказать", скролл до него и нажатие
        By buttonPlaceOrderLocator = objHomePage.getButtonPlaceOrderLocator(orderButtonNum);
        objHomePage.scrollToElement(buttonPlaceOrderLocator);
        objHomePage.clickElement(buttonPlaceOrderLocator);

        // создадим объект класса страницы заказа
        objOrderPage = new OrderPage(driver);
        // дождемся появления элемента
        objOrderPage.waitForvisibilityOfElement(objOrderPage.orderFormTitle);

        // заполним поля формы "Для кого самокат"
        objOrderPage.sendKeysToField(objOrderPage.nameLocator, nameString);
        objOrderPage.sendKeysToField(objOrderPage.surnameLocator, surnameString);
        objOrderPage.sendKeysToField(objOrderPage.addressLocator, addressString);
        objOrderPage.sendKeysToField(objOrderPage.phoneLocator, phoneString);

        // открытие списка станций метро, получение локатора станции, скролл до него и нажатие
        objOrderPage.clickElement(objOrderPage.metroListLocator);
        By metroStationLocator = objOrderPage.getMetroStationLocator(metroStationString);
        objOrderPage.scrollToElement(metroStationLocator);
        objOrderPage.clickElement(metroStationLocator);

        // нажмем "Далее"
        objOrderPage.clickElement(objOrderPage.orderFormButtonNext);
        // дождемся загрузки нужного заголовка
        objOrderPage.waitTextToBePresentInElement(objOrderPage.orderFormTitle, "Про аренду");

        // заполним поля формы "Про аренду"
        // ENTER - для снятия фокуса с дата-пикера
        objOrderPage.sendKeysToField(objOrderPage.deliveryDateLocator, deliveryDateString + Keys.ENTER);
        objOrderPage.sendKeysToField(objOrderPage.commentLocator, commentString);

        // открытие списка сроков аренды, получение локатора срока, скролл до него и нажатие
        objOrderPage.clickElement(objOrderPage.rentalPeriodListLocator);
        By rentalPeriodLocator = objOrderPage.getRentalPeriodLocator(rentalPeriodString);
        objOrderPage.scrollToElement(rentalPeriodLocator);
        objOrderPage.clickElement(rentalPeriodLocator);

        // по имени цвета получим нужный локатор и кликнем его
        By colorLocator = objOrderPage.getColorLocator(colorString);
        objOrderPage.clickElement(colorLocator);

        // нажмем "Заказать" в форме
        objOrderPage.clickElement(objOrderPage.orderFormButtonSubmit);
        // дождемся появления заголовка поп-апа
        objOrderPage.waitForvisibilityOfElement(objOrderPage.orderFormPopupTitle);
        // подтвердим заказ в поп-апе нажав "Да"
        objOrderPage.clickElement(objOrderPage.orderFormPopupButtonSubmit); // в этом месте баг приложения. в хром нажатие не срабатывает

        // подождем появления поп-апа с подтверждением заказа
        objOrderPage.waitForvisibilityOfElement(objOrderPage.orderFormPopupTitleSuccess);

        // проверим заголовок поп-апа с подтверждением заказа
        String expected = "Заказ оформлен";
        String actual = driver.findElement(objOrderPage.orderFormPopupTitleSuccess).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
