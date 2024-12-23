package tests;

import base.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LoginWindow;

import com.codeborne.selenide.Condition;
import pages.RegisterWindow;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class LoginTest extends BaseTest {
    @Test()
    @Description("Login attempt with invalid parameters should fail")
    public void invalidLogin() {
        LoginWindow login = new LoginWindow();
        String email = "non-existent@gmail.com";
        String password = "Password123";

        login.openSignInWindow();
        login.enterEmail(email);
        login.enterPassword(password);
        login.submit();

        String currentUrl = WebDriverRunner.url();
        assert currentUrl.equals(this.baseUrl);
    }

    @Test()
    @Description("Users should be logged in after successfully creating a new account")
    public void validLogin() {
        String dashboardUrl = "https://qatest-dev.indvp.com/my-account/dashboard";
        LoginWindow login = new LoginWindow();
        String email = "user03@gmail.com";
        String password = "Password123";

        login.openSignInWindow();
        $("button.Button.Button_isHollow").click();

        $(".MyAccountOverlay-Action.MyAccountOverlay-Action_state_createAccount").shouldBe(Condition.visible);

        // Register a user
        RegisterWindow register = new RegisterWindow();
        register.enterFirstName("Mariam");
        register.enterLastName("Mmmmir");
        register.enterEmail(email);
        register.enterPass(password);
        register.confirmPass(password);

        $("button[type='submit']").click();

        String currentUrl = WebDriverRunner.url();
        assert currentUrl.equals(dashboardUrl);

    }
}