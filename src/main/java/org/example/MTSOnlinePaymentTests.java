import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MTSOnlinePaymentTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); //Надо прописать свой путь
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://mts.by");
    }

    @Test
    public void testBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]")));
        assertEquals("Онлайн пополнение без комиссии", title.getText());
    }

    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(By.cssSelector(".payment-systems img"));
        assertTrue("Логотипы платежных систем не найдены", logos.size() > 0);
    }

    @Test
    public void testServiceDetailsLink() {
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        link.click();
        wait.until(ExpectedConditions.urlContains("details"));
        assertTrue(driver.getCurrentUrl().contains("details"));
    }

    @Test
    public void testContinueButtonFunctionality() {
        WebElement serviceField = driver.findElement(By.id("service"));
        serviceField.sendKeys("Услуги связи");

        WebElement numberField = driver.findElement(By.id("phone-number"));
        numberField.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation")));
        assertTrue("Кнопка 'Продолжить' не работает корректно", result != null);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
