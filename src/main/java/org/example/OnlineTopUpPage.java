import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnlineTopUpPage {

    private WebDriver driver;

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By connectionServiceTab = By.id("connectionService");
    private By homeInternetTab = By.id("homeInternet");
    private By installmentTab = By.id("installment");
    private By debtTab = By.id("debt");
    private By continueButton = By.id("continueButton");
    private By phoneNumberField = By.id("phoneNumber");
    private By cardNumberField = By.id("cardNumber");
    private By cardExpiryDateField = By.id("expiryDate");
    private By cardCvvField = By.id("cvv");
    private By paymentSystemIcons = By.cssSelector(".payment-system-icons");
    private By amountField = By.id("amount");

    public void selectConnectionService() {
        driver.findElement(connectionServiceTab).click();
    }

    public void selectHomeInternet() {
        driver.findElement(homeInternetTab).click();
    }

    public void selectInstallment() {
        driver.findElement(installmentTab).click();
    }

    public void selectDebt() {
        driver.findElement(debtTab).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(phoneNumberField);
    }

    public WebElement getCardNumberField() {
        return driver.findElement(cardNumberField);
    }

    public WebElement getCardExpiryDateField() {
        return driver.findElement(cardExpiryDateField);
    }

    public WebElement getCardCvvField() {
        return driver.findElement(cardCvvField);
    }

    public WebElement getPaymentSystemIcons() {
        return driver.findElement(paymentSystemIcons);
    }

    public WebElement getAmountField() {
        return driver.findElement(amountField);
    }
}
