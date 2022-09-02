package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// класс главной страницы
public class HomePage extends BasePage {

    // конструктор
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // локаторы для кнопок
    protected By buttonPlaceOrderLocator;
    protected By buttonPlaceOrderTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    protected By buttonPlaceOrderDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    protected By buttonOrderStatus = By.className("Header_Link__1TAG7");
    protected By buttonGo = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    protected By cookieMessageButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // локаторы для вопросов "Вопросы о важном"
    protected By questionPrice = By.xpath(".//div[@data-accordion-component='AccordionItem'][1]");
    protected By questionSeveralItems = By.xpath(".//div[@data-accordion-component='AccordionItem'][2]");
    protected By questionRentalTime = By.xpath(".//div[@data-accordion-component='AccordionItem'][3]");
    protected By questionTodayDelivery = By.xpath(".//div[@data-accordion-component='AccordionItem'][4]");
    protected By questionProlong = By.xpath(".//div[@data-accordion-component='AccordionItem'][5]");
    protected By questionCharging = By.xpath(".//div[@data-accordion-component='AccordionItem'][6]");
    protected By questionCancellation = By.xpath(".//div[@data-accordion-component='AccordionItem'][7]");
    protected By questionRemoteDelivery = By.xpath(".//div[@data-accordion-component='AccordionItem'][8]");

    // локаторы для ответов "Вопросы о важном"
    protected By answerPrice = By.xpath(".//div[@class='accordion__item'][1]/div[@class='accordion__panel']");
    protected By answerSeveralItems = By.xpath(".//div[@class='accordion__item'][2]/div[@class='accordion__panel']");
    protected By answerRentalTime = By.xpath(".//div[@class='accordion__item'][3]/div[@class='accordion__panel']");
    protected By answerTodayDelivery = By.xpath(".//div[@class='accordion__item'][4]/div[@class='accordion__panel']");
    protected By answerProlong = By.xpath(".//div[@class='accordion__item'][5]/div[@class='accordion__panel']");
    protected By answerCharging = By.xpath(".//div[@class='accordion__item'][6]/div[@class='accordion__panel']");
    protected By answerCancellation = By.xpath(".//div[@class='accordion__item'][7]/div[@class='accordion__panel']");
    protected By answerRemoteDelivery = By.xpath(".//div[@class='accordion__item'][8]/div[@class='accordion__panel']");

    // ожидаемый текст ответов "Вопросы о важном"
    protected String answerPriceString = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    protected String answerSeveralItemsString = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    protected String answerRentalTimeString = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    protected String answerTodayDeliveryString = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    protected String answerProlongString = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    protected String answerChargingString = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    protected String answerCancellationString = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    protected String answerRemoteDeliveryString = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public static final String HOME_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    protected By orderStatusField = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");

    // для факультативной части
    protected By imgScooterBlueprint = By.xpath(".//img[@src='/assets/blueprint.png']");
    protected By logoScooter = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    protected By logoYandex = By.xpath(".//img[@alt='Yandex']");

    // метод ожидания загрузки картинки самоката
    public void waitForLoadMainImg() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(imgScooterBlueprint));
    }

    // метод для получения локатора нужной кнопки "Заказать" по ее порядковому номеру (1 - самая верхняя)
    public By getButtonPlaceOrderLocator(int numberOfButtonPlaceOrder) {
        if (numberOfButtonPlaceOrder == 1) {
            buttonPlaceOrderLocator = buttonPlaceOrderTop;
        } else {
            buttonPlaceOrderLocator = buttonPlaceOrderDown;
        }
        return buttonPlaceOrderLocator;
    }
}
