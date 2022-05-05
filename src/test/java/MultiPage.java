import org.openqa.selenium.WebDriver;

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
