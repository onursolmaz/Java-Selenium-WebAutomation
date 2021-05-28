import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GittiGidiyorTest extends BaseTest {




    @Order(1)
    @Test
    public void HomePage() {
        homePage.openHomePage();

    }

    @Order(2)
    @Test
    public void LoginPage() {
        loginPage.login();
        loginPage.isLoggedIn();
    }

    @Order(3)
    @Test
    public void search() {
        searchPage.search("Bilgisayar");
    }

    @Order(4)
    @Test
    public void produtcs() {
        productsPage.secondProductPage();

    }

    @Order(5)
    @Test
    public void addToCart() {
        productDetailPage.add_to_cart();

    }

    @Order(6)
    @Test
    public void Basket() {
        String productPrice = productDetailPage.getProductPrice();
        basketPage.goBasket();
        basketPage.checkBasket(productPrice);

    }


}
