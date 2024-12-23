package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;

public class RegisterWindow {
    protected SelenideElement firstNameLocator = $("#firstname");
    protected SelenideElement lastNameLocator = $("#lastname");
    protected SelenideElement emailLocator = $("#email");
    protected SelenideElement passwordLocator = $("#password");
    protected SelenideElement confirmPasswordLocator = $("#confirm_password");


    @Step("Enter first name")
    public void enterFirstName(String fn) {
        firstNameLocator.setValue(fn);
    }
    @Step("Enter last name")
    public void enterLastName(String ln) {
        lastNameLocator.setValue(ln);
    }

    @Step("Enter email")
    public void enterEmail(String email) {
        emailLocator.setValue(email);
    }

    @Step("enter password")
    public void enterPass(String pass) {
        passwordLocator.setValue(pass);
    }

    @Step("confirm password")
    public void confirmPass(String pass) {
        confirmPasswordLocator.setValue(pass);
    }
}
