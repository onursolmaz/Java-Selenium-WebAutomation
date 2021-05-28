import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import java.util.concurrent.TimeUnit;
@ExtendWith(Logger.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    Actions actions;
    HomePage homePage;
    LoginPage loginPage;
    SearchPage searchPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;
    BasePage basePage;
    public String url = "https://www.gittigidiyor.com/";


    @BeforeAll
    public void setUp(){
        // Initial arg
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-web-security");
//        options.addArguments("--allow-running-insecure-content");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver90.exe");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.get(url);

        //Initialized pages
        basePage=new BasePage(driver,actions);
        homePage = new HomePage(driver,actions);
        loginPage = new LoginPage(driver);
        searchPage=new SearchPage(driver);
        productsPage =new ProductsPage(driver);
        productDetailPage= new ProductDetailPage(driver);
        basketPage=new BasketPage(driver,actions);

    }

    @AfterAll
    public void tearDown(){
        System.out.println("Test finished");
        driver.quit();
    }

}
