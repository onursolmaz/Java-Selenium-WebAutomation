package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ProductsPage extends BasePage{

    private WebDriver driver;
    private By secondBtnSelector=By.xpath("//*[@id='best-match-right']/div[5]/ul/li[2]/a");


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;

    }


    public void secondProductPage() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement webElement = find(secondBtnSelector);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);

        System.out.println("opened the second product page");

        String page = "Bilgisayar - GittiGidiyor - 2/100";
        String pageControl = driver.getTitle();
        assertEquals(page, pageControl);

        System.out.println("Checked the whether it's on page 2");
    }




}
