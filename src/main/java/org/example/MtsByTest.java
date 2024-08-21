import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

package org.example;

public class MtsByTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
        if (blockTitle.isDisplayed()) {
            System.out.println("Название найдено: " + blockTitle.getText());
        } else {
            System.out.println("Название не найдено");
        }

        WebElement logos = driver.findElement(By.xpath("//div[@class='payment-logos']"));
        if (logos.isDisplayed()) {
            System.out.println("Логотипы найдены");
        } else {
            System.out.println("Логотипы не найдены");
        }

        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();

        WebElement phoneNumberField = driver.findElement(By.id("phone_number"));
        phoneNumberField.sendKeys("89605555555");

        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        driver.quit();
    }
}
