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

public class NotesPage extends PageBase {

    private By sidebarToggler = By.className("notion-sidebar-switcher");
    private By logoutButton = By.xpath("//div[text()='Log out all']");

    NotesPage(WebDriver driver) { 
        super(driver);
    }

    public MainPage logout() {
        waitAndReturnElement(sidebarToggler).click();
        waitAndReturnElement(logoutButton).click();
        wait(10);
        return new MainPage(driver);
    }

    public String toggerText() {
        return waitAndReturnElement(sidebarToggler).getText();
    }
}
