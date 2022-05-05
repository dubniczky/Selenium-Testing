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

public class MultiPage extends PageBase {

    MultiPage(WebDriver driver) {
        super(driver);
    }

    public Boolean pageContains(String url, String text) {
        this.driver.get(url);
        wait(10);
        return this.getBodyText().contains(text);
    }
}
