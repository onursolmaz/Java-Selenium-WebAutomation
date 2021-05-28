package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePage{

    protected WebDriver driver;
    protected Actions actions;
    String username="onursolmaz555299";
    String password="1234OS";
    By usernameSelector=By.id("L-UserNameField");
    By passwordSelector=By.id("L-PasswordField");
    By loginBtnSelector=By.id("gg-login-enter");
    By loggedUsernameSelector=By.cssSelector("[class='gekhq4-4 egoSnI'] span");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }


    public void login(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        type(usernameSelector,username);
        type(passwordSelector,password);
        click(loginBtnSelector);
        waitForLoad(2);
        System.out.println("Clicked the login button");

    }

    public void isLoggedIn(){

        String LoggedUsername = getText(loggedUsernameSelector);
        assertEquals(LoggedUsername, username);
        System.out.println("User verified");
    }



}
