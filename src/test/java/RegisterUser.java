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
    @DisplayName("Test Case 1: Register User")
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
    @DisplayName("Test Case 2: Login User with correct email and password")
    @Description("Testa o login com credenciais corretas.")
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
    @DisplayName("Test Case 3: Login User with incorrect email and password")
    @Description("Testa o login com credenciais incorretas.")
    @Story("Login de Usuário")
    void loginComCredenciaisIncorretas() {

        homePage.openHomePage();
        homePage.isHomePageVisible();
        homePage.clickSignupLoginButton();
        loginPage.loginAccountVisible();
        loginPage.enterEmailLogin("email_incorreto@teste.com");
        loginPage.enterPasswordLogin("senha_incorreta");
        loginPage.clickLoginButton();
        assertEquals("Your email or password is incorrect!", loginPage.getErrorMessageLogin());
}

    @Test
    @DisplayName("Test Case 4: Logout User")
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

    @Test
    @DisplayName("Test Case 5: Register User with existing email")
    @Description("Testa o cadastro de usuário com email já existente.")
    @Story("Cadastro de Usuário")
    void registerUserWithExistingEmail() {
        homePage.openHomePage();
        homePage.clickSignupLoginButton();
        loginPage.loginAccountVisible();
        loginPage.enterNewUserName("Alexandre");
        loginPage.enterNewEmail(emailPadrao);
        loginPage.clickSignupButton();
        assertEquals("Email Address already exist!", loginPage.getErrorMessageRegister());
        
    }

}
