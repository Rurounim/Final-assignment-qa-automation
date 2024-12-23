package tests;

import base.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LoginWindow;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

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
    @Description("Login attempt with valid parameters should pass")
    public void validLogin() {
        LoginWindow login = new LoginWindow();
        String email = "user03@gmail.com";
        String password = "Password123";

        login.openSignInWindow();
        $("button.Button.Button_isHollow").click();

        $(".MyAccountOverlay-Action.MyAccountOverlay-Action_state_createAccount").shouldBe(Condition.visible);



    }
}