package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertEquals;



public class BasketPage extends BasePage {

    private WebDriver driver;
    private Actions actions;
    private By basketSelector=By.xpath("//*[@id='header_wrapper']/div[4]/div[3]/a");
    private By goToBasketSelector=By.xpath("//*[@id='header_wrapper']/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a");
    private By basketPriceSelector=By.cssSelector("[class='total-price']");
    private By optionMenuSelector=By.xpath("//*[@class='amount']");
    private By amountOptionSelector=By.xpath("//*[@class='amount']/option[2]");
    private By basketPieceSelector=By.xpath("//*[@id='submit-cart']/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]");
    private By cleanBasketBtnSelector=By.xpath("//*[@class='gg-icon gg-icon-bin-medium']");

    public BasketPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        this.actions=actions;
        this.driver=driver;
    }


    public void goBasket(){
        WebElement basket = find(basketSelector);
        actions.moveToElement(basket).build().perform();
        click(goToBasketSelector);

        System.out.println("opened the basket page");

    }


    public void checkBasket(String productPrice) {
        String basketPrice = getText(basketPriceSelector);
        assertEquals("Prices not match ", productPrice, basketPrice);  // Son günlerde Gittigidiyor'da indirim
        System.out.println("Compared product price and basket price");        // olduğundan dolayı sepete indirim uygulanıyor bu test genelde geçmiyor.


        click(optionMenuSelector);
        click(amountOptionSelector);
        waitForLoad(2);
        String basketPiece = getText(basketPieceSelector);
        assertEquals(basketPiece, "Ürün Toplamı (2 Adet)");
        System.out.println("Compared product count");

        click(cleanBasketBtnSelector);
        waitForLoad(2);
        String basketEmpty = getText(basketPieceSelector);
        assertEquals( basketEmpty,"Ürün Toplamı (0 Adet)");
        System.out.println("Product deleted and checked whether it's empty");
    }







}
