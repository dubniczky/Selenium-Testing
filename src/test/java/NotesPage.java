import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class NotesPage extends PageBase {

    private By sidebarToggler = By.className("notion-sidebar-switcher");
    private By logoutButton = By.xpath("//div[text()='Log out all']");
    private By settingsButtonLocator = By.xpath("//div[text()='Settings & Members']");

    NotesPage(WebDriver driver) { 
        super(driver);
    }

    public MainPage logout() {
        waitAndReturnElement(sidebarToggler).click();
        waitAndReturnElement(logoutButton).click();
        wait(10);
        return new MainPage(driver);
    }

    public String togglerText() {
        return waitAndReturnElement(sidebarToggler).getText();
    }

    public SettingsPage openSettingsPage() {
        waitAndReturnElement(settingsButtonLocator).click();
        return new SettingsPage(driver);
    }
}
