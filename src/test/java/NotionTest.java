import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Random;


public class NotionTest {
    public WebDriver driver;
    public Random random;

    private String userMail = "gohol92357@chokxus.com";
    private String userPass = "everyone loves a good selenium assignment";

    private PagePair[] pagePairs = new PagePair[] {
        new PagePair("https://www.notion.so/", "One workspace."),
        new PagePair("https://www.notion.so/templates", "Template Gallery"),        
        new PagePair("https://www.notion.so/pricing", "Macedonian Makako", false),
        new PagePair("https://www.notion.so/enterprise", "One tool for your entire company to share"),
    };
    
    @Before
    public void setup() {
        random = new Random();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    //@Test
    public void mainTest() {
        MainPage mainPage = new MainPage(this.driver);

        Assert.assertTrue( mainPage.getTitle().startsWith("Notion – ") );
        Assert.assertTrue( mainPage.getFooterText().contains("Pricing") );
        Assert.assertTrue( mainPage.getHeaderText().contains("Log in") );
    }

    //@Test
    public void loginTest() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLoginPage();
        NotesPage notesPage = loginPage.login(userMail, userPass);

        Assert.assertTrue( notesPage.togglerText().contains("Selenium's Notion") );

        mainPage = notesPage.logout();
    }

    //@Test
    public void settingsTest() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLoginPage();
        NotesPage notesPage = loginPage.login(userMail, userPass);
        SettingsPage settingsPage = notesPage.openSettingsPage();

        String newName = "Selenium - " + Math.abs(random.nextInt());
        settingsPage.updateDisplayName(newName);

        settingsPage = notesPage.openSettingsPage();

        //System.out.println(settingsPage.getDisplayName());

        Assert.assertTrue( settingsPage.getDisplayName().equals(newName) );

        mainPage = notesPage.logout();
    }

    @Test
    public void multiTest() {
        MultiPage multiPage = new MultiPage(this.driver);

        for (PagePair pagePair : pagePairs) {
            //System.out.println(pagePair.url);
            if (pagePair.contain) {
                Assert.assertTrue( multiPage.pageContains(pagePair.url, pagePair.text) );
            }
            else {
                Assert.assertFalse( multiPage.pageContains(pagePair.url, pagePair.text) );
            }
        }
        
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
