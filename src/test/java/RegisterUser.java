import java.util.Random;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Automação de Testes")
@Feature("Cadastro e Login de Usuários")
public class RegisterUser extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private Faker faker = new Faker();
    
    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test 
    @DisplayName("Register User")
    @Description("Teste de cadastro completo de usuário")
    @Story("Cadastro de Usuário")
    void registerUser() {
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 12);
        
        homePage.openHomePage();
        assertTrue(homePage.isHomePageVisible(), "Página inicial deve estar visível");
        homePage.clickSignupLoginButton();
        loginPage.newUserSingnupVisible();
        loginPage.enterNewUserName(name);
        loginPage.enterNewEmail(email);
        loginPage.clickSignupButton();
        registrationPage.verifyTitleIsVisible();
        registrationPage.enterAccountInformation(password, "10", "April", "1980", "First name", "Last Name", "Address", "Canada", "City", "123456", "1234567890");
        registrationPage.accountCreatedIsVisible();
        registrationPage.clickContinueButton();
        homePage.userIconIsVisible();
        homePage.clickDeleteAccountButton();
    }

    @Test
    @DisplayName("Login User with correct credentials")
    void loginUserCorrectCredentials() {

        homePage.openHomePage();
        homePage.isHomePageVisible();
        homePage.clickSignupLoginButton();
        loginPage.loginAccountVisible();
        loginPage.enterEmailLogin("alexandre.qa@teste.com");
        loginPage.enterPasswordLogin("12345");
        loginPage.clickLoginButton();
        homePage.userIconIsVisible();

    }

    @Test
    @DisplayName("Login com credenciais incorretas")
    void loginComCredenciaisIncorretas() {

    homePage.openHomePage();
    homePage.isHomePageVisible();
    homePage.clickSignupLoginButton();
    loginPage.loginAccountVisible();
    loginPage.enterEmailLogin("email_incorreto@teste.com");
    loginPage.enterPasswordLogin("senha_incorreta");
    loginPage.clickLoginButton();
    assertEquals("Your email or password is incorrect!", loginPage.getErrorMessage());
}

}
