package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ProductDetailPage extends BasePage {

    protected WebDriver driver;
    private String productPrice;
    private By productPriceSelector=By.xpath("//*[@id='sp-price-highPrice']");
    private By addToBasketSelector=By.cssSelector("[id='add-to-basket']");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void add_to_cart(){
        Random random = new Random();
        int rand = random.nextInt(48) + 1;
        driver.findElement(By.cssSelector(".products-container>li:nth-of-type(" + rand + ")")).click();
        String productPrice = getText(productPriceSelector);
        this.productPrice = productPrice;
        WebElement webElementBasket = find(addToBasketSelector);
        JavascriptExecutor jsBasket = (JavascriptExecutor) driver;
        jsBasket.executeScript("arguments[0].click();", webElementBasket);

        System.out.println("randomly selected product was added to basket");

    }

    public String getProductPrice(){

        return this.productPrice;
    }

}
