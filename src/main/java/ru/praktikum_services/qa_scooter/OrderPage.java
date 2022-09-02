package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы заказа
public class OrderPage extends BasePage {

    // конструктор
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public static final String ORDER_PAGE_URL = "https://qa-scooter.praktikum-services.ru/order";
    protected By cookieMessageButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // локатор заголовка формы
    protected By orderFormTitle = By.className("Order_Header__BZXOb");
    // локатор кнопки "Далее"
    protected By orderFormButtonNext =
            By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Далее')]");
    // локатор кнопки "Заказать"
    protected By orderFormButtonSubmit =
            By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");
    // локатор заголовока поп-ап окна при подтверждении заказа
    protected By orderFormPopupTitle = By.className("Order_ModalHeader__3FDaJ");
    // локатор кнопки подтверждения заказа в поп-ап окне
    protected By orderFormPopupButtonSubmit =
            By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Да')]");
    // локатор заголовока поп-ап окна при успешном размещении заказа
    protected By orderFormPopupTitleSuccess = By.xpath(".//div[text()='Заказ оформлен']");

    // локаторы формы "Для кого самокат"
    protected By nameLocator = By.xpath(".//input[@placeholder='* Имя']");
    protected By surnameLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    protected By addressLocator = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    protected By metroListLocator = By.xpath(".//input[@placeholder='* Станция метро']");
    protected By phoneLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    protected By metroStationLocator;

    // локаторы формы "Про аренду"
    protected By deliveryDateLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    protected By rentalPeriodListLocator = By.xpath(".//div[text()='* Срок аренды']");
    protected By commentLocator = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    protected By colorLocator;
    protected By rentalPeriodLocator;

    // локаторы ошибок (факультативная часть)
    protected By alertIncorrectNameLocator = By.xpath(".//div[text()='Введите корректное имя']");
    protected By alertIncorrectSurnameLocator = By.xpath(".//div[text()='Введите корректную фамилию']");
    protected By alertIncorrectMetroStationLocator = By.xpath(".//div[text()='Выберите станцию']");
    protected By alertIncorrectPhoneLocator = By.xpath(".//div[text()='Введите корректный номер']");

    // ожидаемые тексты полей заказа по умолчанию (факультативная часть)
    protected String defaultNameString = "* Имя";
    protected String defaultSurnameString = "* Фамилия";
    protected String defaultMetroStationString = "* Станция метро";
    protected String defaultPhoneString = "* Телефон: на него позвонит курьер";

    // локаторы родительских элементов ошибок (факультативная часть)
    protected By parentIncorrectNameLocator = By.xpath("//div[text()='Введите корректное имя']/parent::div/input");
    protected By parentIncorrectSurnameLocator = By.xpath("//div[text()='Введите корректную фамилию']/parent::div/input");
    protected By parentIncorrectMetroStationLocator = By.xpath(".//div[text()='Выберите станцию']/parent::div/div/div/input");
    protected By parentIncorrectPhoneLocator = By.xpath("//div[text()='Введите корректный номер']/parent::div/input");

    // метод для получения локатора цвета по его имени
    public By getColorLocator(String color) {
        colorLocator = By.xpath(".//label[@for='" + color + "']");
        return colorLocator;
    }

    // метод для получения локатора станции метро по ее имени
    public By getMetroStationLocator(String metroStation) {
        metroStationLocator = By.xpath(".//div[contains(text(),'" + metroStation + "')]");
        return metroStationLocator;
    }

    // метод для получения локатора срока аренды по его имени
    public By getRentalPeriodLocator(String rentalPeriod) {
        rentalPeriodLocator = By.xpath(".//div[contains(text(),'" + rentalPeriod + "')]");
        return rentalPeriodLocator;
    }
}
