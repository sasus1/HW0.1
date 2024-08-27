import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
package org.example;

public class OnlineTopUpTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Надо указать путь к личному WebDriver, я оставлю пустым
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mts.by");
    }

    @Test
    public void testPlaceholderText() {
        checkPlaceholderText("//input[@id='service-input']", "Услуги связи");
        checkPlaceholderText("//input[@id='internet-input']", "Домашний интернет");
        checkPlaceholderText("//input[@id='installment-input']", "Рассрочка");
        checkPlaceholderText("//input[@id='debt-input']", "Задолженность");
    }

    @Test(dependsOnMethods = "testPlaceholderText")
    public void testServicePayment() {
        WebElement serviceOption = driver.findElement(By.id("service-option"));
        serviceOption.click();

        WebElement phoneNumberField = driver.findElement(By.id("phone-number"));
        phoneNumberField.sendKeys("1234567890");

        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("100");

        WebElement continueButton = driver.findElement(By.id("continue-button"));
        continueButton.click();

        WebElement popup = driver.findElement(By.id("payment-popup"));

        WebElement displayedAmount = popup.findElement(By.id("displayed-amount"));
        Assert.assertEquals(displayedAmount.getText(), "100");

        WebElement displayedPhoneNumber = popup.findElement(By.id("displayed-phone-number"));
        Assert.assertEquals(displayedPhoneNumber.getText(), "297777777");

        checkPlaceholderText("//input[@id='card-number']", "Номер карты");
        checkPlaceholderText("//input[@id='expiry-date']", "Срок действия");
        checkPlaceholderText("//input[@id='cvv']", "CVV");

        WebElement paymentIcons = popup.findElement(By.id("payment-icons"));
        Assert.assertTrue(paymentIcons.findElements(By.className("visa")).size() > 0, "Иконка Visa отсутствует");
        Assert.assertTrue(paymentIcons.findElements(By.className("mastercard")).size() > 0, "Иконка MasterCard отсутствует");
    }

    private void checkPlaceholderText(String xpath, String expectedPlaceholder) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String placeholder = element.getAttribute("placeholder");
        Assert.assertEquals(placeholder, expectedPlaceholder, "Плейсхолдер не совпадает: " + xpath);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
