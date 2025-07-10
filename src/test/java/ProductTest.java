import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import Pages.ContactPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.TestCasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Automação de Testes")
@Feature("Verificacao de Produtos")
public class ProductTest extends BaseTest {

    private HomePage homePage;
    private ProductPage productPage;

    @BeforeEach
    void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test 
    @DisplayName("Test Case 8: Verify All Products and product detail page")
    @Description("Teste de verificação de produtos")
    @Story("Validacao de Produto")
    public void testViewProductDetails() {
      
        homePage.openHomePage();
        assertTrue(homePage.isHomePageVisible(), "Página inicial deve estar visível");

        homePage.clickProducts();
        assertTrue(productPage.isProductsPageVisible(), "'All Products' deve estar visível");


        // 6. The products list is visible
        assertTrue(productPage.isProductListVisible(), "Lista de produtos está visível");

        // 7. Click on 'View Product' of first product
        productPage.clickViewProductByIndex(1);

        // 8. User is landed to product detail page
        assertTrue("Página de detalhes do produto  está visível", productPage.isProductDetailPageVisible());

        // 9. Verify that detail is visible: product name, category, price, availability, condition, brand
        assertTrue("Nome do produto  está visível", productPage.isProductNameVisible());
        assertTrue("Categoria está visível", productPage.isCategoryVisible());
        assertTrue("Preço está visível", productPage.isPriceVisible());
        assertTrue("Disponibilidade está visível", productPage.isAvailabilityVisible());
        assertTrue("Condição  está visível", productPage.isConditionVisible());
        assertTrue("Marca está visível", productPage.isBrandVisible());
    }
}
