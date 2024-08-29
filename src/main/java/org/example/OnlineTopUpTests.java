import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OnlineTopUpTests {

    private WebDriver driver;
    private OnlineTopUpPage topUpPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://mts.by/online-topup");
        topUpPage = new OnlineTopUpPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Step("Проверка надписей в незаполненных полях для каждого варианта оплаты")
    public void testPaymentOptions() {
        checkPlaceholderTextForPaymentOption(topUpPage::selectConnectionService, "Введите номер телефона");
        checkPlaceholderTextForPaymentOption(topUpPage::selectHomeInternet, "Введите номер телефона");
        checkPlaceholderTextForPaymentOption(topUpPage::selectInstallment, "Введите номер телефона");
        checkPlaceholderTextForPaymentOption(topUpPage::selectDebt, "Введите номер телефона");
    }

    private void checkPlaceholderTextForPaymentOption(Runnable selectOption, String expectedPlaceholder) {
        selectOption.run();
        Allure.step("Проверяем плейсхолдер для номера телефона");
        assertThat(topUpPage.getPhoneNumberField().getAttribute("placeholder"), equalTo(expectedPlaceholder));
    }

    @Test
    @Step("Проверка отображения суммы и полей ввода при варианте 'Услуги связи'")
    public void testConnectionServiceFields() {
        topUpPage.selectConnectionService();
        topUpPage.getPhoneNumberField().sendKeys("1234567890");
        topUpPage.clickContinue();

        Allure.step("Проверка суммы и поля номера телефона");
        assertThat(topUpPage.getAmountField().getText(), containsString("Ожидаемая сумма"));
        assertThat(topUpPage.getPhoneNumberField().getAttribute("value"), equalTo("1234567890"));

        Allure.step("Проверка полей для реквизитов карты и иконок платёжных систем");
        assertThat(topUpPage.getCardNumberField().isDisplayed(), is(true));
        assertThat(topUpPage.getCardExpiryDateField().isDisplayed(), is(true));
        assertThat(topUpPage.getCardCvvField().isDisplayed(), is(true));
        assertThat(topUpPage.getPaymentSystemIcons().isDisplayed(), is(true));
    }
}
