package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sun.rmi.runtime.Log;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage{

    protected WebDriver driver;
    protected Actions actions;
    private String url = "https://www.gittigidiyor.com/";
    private By loginBtnSelector=By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a");
    private By cookiesSelector=By.xpath("//*[@id=\"__next\"]/main/section/section/a");


    public HomePage(WebDriver driver,Actions actions) {
        super(driver,actions);
        this.driver = driver;
        this.actions=actions;
    }

    public void openHomePage() {
        String controlUrl = driver.getCurrentUrl();
        assertEquals(url, controlUrl);
        click(cookiesSelector);
        System.out.println("Controlled homepage");
        System.out.println(driver);

        WebElement waitElement = driver.findElement(By.xpath("//*[@class='gekhq4-5 grTfZj']/div[1]"));
        actions.moveToElement(waitElement).build().perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        click(loginBtnSelector);

        System.out.println("opened homepage");
    }



}
