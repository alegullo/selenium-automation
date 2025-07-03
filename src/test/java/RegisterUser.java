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
    private String emailPadrao = "alexandre.qa@teste.com";
    private String passwordPadrao = "12345";
    
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
    @Description(" Testa o login com credenciais corretas.")
    @Story("Login de Usuário")
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
    @Description(" Testa o login com credenciais incorretas.")
    @Story("Login de Usuário")
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

    @Test
    @DisplayName("Fazer login e depois logout")
    @Description("Testa o fluxo completo de login e logout.")
    @Story("Login e Logout de Usuário")
    void deveFazerLoginELogout() {

        // Act
        homePage.openHomePage();
        assertTrue(homePage.isHomePageVisible(), "A página inicial deve estar visível após o acesso.");
        homePage.clickSignupLoginButton();
        loginPage.loginAccountVisible();
        assertTrue(loginPage.isLoginAccountVisible(), "A tela de login foi exibida.");
        loginPage.realizarLogin(emailPadrao, passwordPadrao);
        homePage.userIconIsVisible();
        homePage.clickLogoutButton();
        loginPage.loginAccountVisible();
        assertTrue(loginPage.isLoginAccountVisible(), "A tela de login foi exibida.");
        }

    

}
