import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


public class LoginPage extends PageBase {

    private By emailInputLocator = By.xpath("//form/div/input[@id='notion-email-input-1']");
    private By continueButtonLocator = By.xpath("//form/div[@role='button']");
    private By passwdInputLocator = By.xpath("//form/div/input[@id='notion-password-input-2']");
    private By submitButtonLocator = By.xpath("//form/div[@role='button']");
    
    LoginPage(WebDriver driver) {
        super(driver);
    }

    public NotesPage login(String mail, String pass) {
        waitAndReturnElement(emailInputLocator).sendKeys(mail);
        waitAndReturnElement(continueButtonLocator).click();
        waitAndReturnElement(passwdInputLocator).sendKeys(pass);
        waitAndReturnElement(submitButtonLocator).click();
        wait(10);
        return new NotesPage(driver);
    }
}
