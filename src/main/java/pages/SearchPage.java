package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    protected WebDriver driver;
    private By seacrhBoxSelector=By.cssSelector("[name='k']");
    private By searchButtonSelector=By.cssSelector("[data-cy='search-find-button']");


    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public void search(String searchText){

        type(seacrhBoxSelector,searchText);
        click(searchButtonSelector);
        System.out.println("Searched the product");
    }


}
