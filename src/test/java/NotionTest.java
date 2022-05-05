import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Random;
import java.util.Properties;
import java.io.FileInputStream;


public class NotionTest {
    public WebDriver driver;
    public Random random;
    public Properties props;

    private String userMail;
    private String userPass;
    

    private PagePair[] pagePairs = new PagePair[] {
        new PagePair("https://www.notion.so/", "One workspace."),
        new PagePair("https://www.notion.so/templates", "Template Gallery"),        
        new PagePair("https://www.notion.so/pricing", "Macedonian Makako", false),
        new PagePair("https://www.notion.so/enterprise", "One tool for your entire company to share"),
    };

    public Boolean proptrue(String name) {
        String val = props.getProperty(name);
        return val == null || !val.equals("true");
    }

    public String propstr(String name) {
        return props.getProperty(name);
    }
    
    @Before
    public void setup() {
        random = new Random();
        WebDriverManager.chromedriver().setup();

        //Load config
        props = new Properties();
        try {
            props.load(new FileInputStream("test.conf"));
        } catch (Exception e) {
            Assert.fail();
        }

        //Setup chrome
        ChromeOptions options = new ChromeOptions();
        if (!proptrue("sandbox")) {
            options.addArguments("--no-sandbox");
        }
        if (proptrue("headless")) {
            options.addArguments("--headless");
        }
        if (!proptrue("devshm")) {
            options.addArguments("--disable-dev-shm-usage");
        }

        options.addArguments("--window-size=" + propstr("window.width") + "x" + propstr("window.height"));

        userMail = propstr("user.mail");
        userPass = propstr("user.pass");

        // Init chrome driver
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
