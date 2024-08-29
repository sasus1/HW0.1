import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OnlineTopUpTests {

    private WebDriver driver;

    @Test
    public void testPaymentOptions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

        try {
            driver.get("https://mts.by/online-topup");

            OnlineTopUpPage topUpPage = new OnlineTopUpPage(driver);

            topUpPage.selectConnectionService();
            assertThat(topUpPage.getPhoneNumberField().getAttribute("placeholder"), equalTo("Введите номер телефона"));

            topUpPage.selectHomeInternet();
            assertThat(topUpPage.getPhoneNumberField().getAttribute("placeholder"), equalTo("Введите номер телефона"));

            topUpPage.selectInstallment();
            assertThat(topUpPage.getPhoneNumberField().getAttribute("placeholder"), equalTo("Введите номер телефона"));

            topUpPage.selectDebt();
            assertThat(topUpPage.getPhoneNumberField().getAttribute("placeholder"), equalTo("Введите номер телефона"));


            topUpPage.selectConnectionService();
            topUpPage.getPhoneNumberField().sendKeys("1234567890");
            topUpPage.clickContinue();


            assertThat(topUpPage.getAmountField().getText(), containsString("Ожидаемая сумма"));
            assertThat(topUpPage.getPhoneNumberField().getAttribute("value"), equalTo("1234567890"));
            assertThat(topUpPage.getCardNumberField().isDisplayed(), is(true));
            assertThat(topUpPage.getCardExpiryDateField().isDisplayed(), is(true));
            assertThat(topUpPage.getCardCvvField().isDisplayed(), is(true));
            assertThat(topUpPage.getPaymentSystemIcons().isDisplayed(), is(true));

        } finally {
            driver.quit();
        }
    }
}
