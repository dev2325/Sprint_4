package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class LogoTest extends BaseTest {

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objHomePage = new HomePage(driver); // объект класса главной страницы
        driver.get(HomePage.HOME_PAGE_URL);
        objHomePage.waitForLoadMainImg(); // дождемся загрузки
        objHomePage.clickElement(objHomePage.cookieMessageButton); // согласимся с сообщением про куки
    }

    @org.junit.Test
    public void checkClickLogoScooterOpenHomePage() {
        // особый клик открывающий ссылку в новой вкладке
        String clicklnk = Keys.chord(Keys.CONTROL, Keys.ENTER);
        driver.findElement(objHomePage.logoScooter).sendKeys(clicklnk);

        // переключение на следующую вкладку
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // дождемся загрузки новой страницы и проверим текущий url
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Ожидаемый URL не совпадает с фактическим", HomePage.HOME_PAGE_URL, actualUrl);
    }

    @org.junit.Test
    public void checkClickLogoYandexOpenYandexPage() {
        // клик по элементу
        objHomePage.clickElement(objHomePage.logoYandex);
        // переключение на следующую вкладку
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        // дождемся загрузки новой страницы и проверим текущий url
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Ожидаемый URL не совпадает с фактическим", "https://yandex.ru/", actualUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
