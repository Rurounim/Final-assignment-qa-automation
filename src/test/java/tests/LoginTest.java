package tests;

import base.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {
    @Test()
    @Description("Login attempt with invalid parameters should fail")
    public void invalidLogin() {
        HomePage home = new HomePage();
        String email = "non-existent@gmail.com";
        String password = "Password123";

        home.openSignInWindow();
        home.enterEmail(email);
        home.enterPassword(password);
        home.submit();

        String currentUrl = WebDriverRunner.url(); // Selenide method to get current URL
        assert currentUrl.equals(this.baseUrl);
    }

}