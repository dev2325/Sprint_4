package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

// Класс страницы заказа
public class OrderPage extends BasePage {

    // конструктор
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    protected String orderPageUrl = "https://qa-scooter.praktikum-services.ru/order";
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
    protected By metroStationLocator = By.xpath(".//input[@placeholder='* Станция метро']");
    protected By phoneLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локаторы формы "Про аренду"
    protected By deliveryDateLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    protected By rentalPeriodLocator = By.xpath(".//div[text()='* Срок аренды']");
    protected By commentLocator = By.xpath(".//input[@placeholder='Комментарий для курьера']");

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

    // метод ожидания загрузки элемента
    public void waitForvisibilityOfElement(By locator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // метод печати текста в поле
    public void sendKeysToField(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    // метод для клика нужного элемента
    public void clickElement(By locator) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (driver.findElement(locator).isEnabled()) {
            driver.findElement(locator).click();
        }
    }
}
