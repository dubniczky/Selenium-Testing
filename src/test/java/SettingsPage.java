import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class SettingsPage extends PageBase {

    private By myAccountButtonLocator = By.xpath("//div[text()='My account']");
    private By nameInputLocator = By.xpath("//label[text()='Preferred name']/following-sibling::div/input");
    private By updateButtonLocator = By.xpath("//div[text()='Update' and @class='notion-focusable']");
    private By closeButtonLocator = By.xpath("//div[text()='Cancel' and @class='notion-focusable']");

    SettingsPage(WebDriver driver) { 
        super(driver);
    }

    public void updateDisplayName(String name) {
        waitAndReturnElement(myAccountButtonLocator).click();

        WebElement nameInput = waitAndReturnElement(nameInputLocator);
        nameInput.clear();
        nameInput.sendKeys(name);

        waitAndReturnElement(updateButtonLocator).click();
    }

    public String getDisplayName() {
        waitAndReturnElement(myAccountButtonLocator).click();

        String name = waitAndReturnElement(nameInputLocator).getAttribute("value");

        waitAndReturnElement(closeButtonLocator).click();
        return name;
    }
}
