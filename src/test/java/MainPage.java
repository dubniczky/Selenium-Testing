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


class MainPage extends PageBase {

    private By loginButtonLocator = By.xpath("//a[@href='/login']");
    private By footerLocator = By.tagName("footer");
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://notion.so/");
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerLocator).getText();
    }
}