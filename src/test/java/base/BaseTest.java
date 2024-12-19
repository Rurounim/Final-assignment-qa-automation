
package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "https://demo.automationtesting.in/Register.html";
        Configuration.timeout = 10000;
        Configuration.browser = "firefox"; // Change this configuration to use a different browser
        open(Configuration.baseUrl);

        String url = WebDriverRunner.url();
        assert(url).equals(Configuration.baseUrl);

    }

    @AfterMethod
    public void refreshWindow() {
        refresh();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}
