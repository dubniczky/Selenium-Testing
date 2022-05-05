import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {

    private By loginButtonLocator = By.xpath("//a[@href='/login']");
    private By headerLocator = By.xpath("//header");
    private By footerLocator = By.xpath("//footer");    
    private String url = "https://notion.so";
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get(url);

        driver.manage().addCookie(new Cookie("notion_check_cookie_consent", "false"));
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerLocator).getText();
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerLocator).getText();
    }

    public LoginPage openLoginPage() {
        waitAndReturnElement(loginButtonLocator).click();
        wait(10);
        return new LoginPage(driver);
    }
}
