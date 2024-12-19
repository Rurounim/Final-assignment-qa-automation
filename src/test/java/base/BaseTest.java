
package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    public String baseUrl = "https://qatest-dev.indvp.com/";

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = baseUrl;
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
