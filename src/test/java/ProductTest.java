import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Pages.HomePage;
import Pages.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

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
        assertEquals("https://www.automationexercise.com/products", driver.getCurrentUrl());        
        // 6. The products list is visible
        assertTrue(productPage.isProductListVisible(), "Lista de produtos está visível");

        // 7. Click on 'View Product' of first product
        productPage.clickViewProductByIndex(1);

        assertTrue(productPage.isProductNameVisible(), "Nome do produto está visível");
        assertTrue(productPage.isCategoryVisible(), "Categoria está visível");
        assertTrue(productPage.isPriceVisible(), "Preço está visível");
        assertTrue(productPage.isAvailabilityVisible(), "Disponibilidade está visível");
        assertTrue(productPage.isConditionVisible(), "Condição está visível");
        assertTrue(productPage.isBrandVisible(), "Marca está visível");

    }
}
