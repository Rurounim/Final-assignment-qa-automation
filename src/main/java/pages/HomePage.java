package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;

public class HomePage {
    protected final SelenideElement signInButtonLocator = $("button[aria-label='Open my account']");
    protected SelenideElement emailFieldLocator = $("input[name='email']");
    protected SelenideElement passwordFieldLocator = $("input[name='password']");
    protected final SelenideElement submitButtonLocator = $("button[type='submit']");

    @Step("Click Sign-in button")
    public void openSignInWindow() {
        signInButtonLocator.click();
    }

    @Step("Enter email")
    public void enterEmail(String email) {
        emailFieldLocator.setValue(email);
    }

    @Step("Enter password")
    public void enterPassword(String pass) {
        passwordFieldLocator.setValue(pass);
    }

    @Step("Submit")
    public void submit() {
        submitButtonLocator.click();
    }
}
