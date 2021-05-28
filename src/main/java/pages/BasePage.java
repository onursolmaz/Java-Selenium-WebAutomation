package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver,Actions actions) {
        this.driver=driver;
        this.actions=actions;
    }

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }



    public WebElement find(By selector) {

        return driver.findElement(selector);
    }

    public void click(By selector) {

        find(selector).click();
    }

    public void type(By selector, String text) {

        find(selector).sendKeys(text);
    }

    public String getText(By selector){

       return  find(selector).getText();
    }


    public void waitForLoad(int seconds){
        try
        {
            Thread.sleep(seconds*1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }


    }


}
