import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import Pages.ContactPage;
import Pages.HomePage;
import Pages.TestCasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Automação de Testes")
@Feature("Verificacao de Paginas")
public class VerifyPages extends BaseTest {

    private ContactPage contactPage;
    private HomePage homePage;
    private TestCasePage testCasePage;

    @BeforeEach
    void setUp() {
        super.setUp();
        contactPage = new ContactPage(driver);
        homePage = new HomePage(driver);
        testCasePage = new TestCasePage(driver);
    }

    @Test
    @DisplayName("Test Case 6: Contact Us Flow")
    @Description("Acessar pagina de Contact Us Flow")
    @Story("Entrar em contato pelo formulario")
    void contactUsFlow() {
        String path = "C:/Users/alexa/Downloads/test.txt";

        homePage.openHomePage();
        assertTrue(homePage.isHomePageVisible(), "Página inicial deve estar visível");
        homePage.clickContactUs();

        assertTrue(contactPage.isGetInTouchVisible(), "'GET IN TOUCH' deve estar visível");
        contactPage.fillContactForm("Test Ale AT", "ate@AT.com", "Assunto AT", "Mensagem AT.");
        contactPage.uploadFile(path);
        contactPage.clickSubmit();

        driver.switchTo().alert().accept();

        assertTrue(contactPage.isSuccessMessageVisible(), "Mensagem de sucesso deve estar visível");
        contactPage.clickHome();
        assertTrue(homePage.isHomePageVisible(), "Página inicial deve estar visível");
    }

    @Test
    @DisplayName("Test Case 7: Verify Test Cases Page")
    @Description("Acessar pagina de Verify Test Cases Page")
    @Story("Entrar na pagina de Test Cases")
    void verifyTestCasesPage() {

        homePage.openHomePage();
        assertTrue(homePage.isHomePageVisible(), "Página inicial deve estar visível");
        homePage.clickTestCases();
        assertTrue(testCasePage.isTestCasesPageVisible());
    }
}
