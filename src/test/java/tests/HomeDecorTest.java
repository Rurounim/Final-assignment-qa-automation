package tests;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class HomeDecorTest {
    String homeDecorUrl = "https://qatest-dev.indvp.com/home-decor/";
    SelenideElement h1ElementLocator = $("h1");

    @Test()
    @Description("Home decor page should be found")
    public void testH1DoesNotContain404() {
        open(homeDecorUrl);
        h1ElementLocator
                .shouldBe(Condition.visible)
                .shouldNotBe(Condition.text("404"));
    }
}
