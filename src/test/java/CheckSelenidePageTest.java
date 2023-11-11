import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


/**
 * Created by anton on 07.11.2023
 */
public class CheckSelenidePageTest {

    @BeforeAll
    public static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://github.com";
        Configuration.holdBrowserOpen=false;

    }

    @Test
    void checkGithubSelenidePage(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $(byText("SoftAssertions")).click();
        $(".gh-header-title").shouldHave(text("SoftAssertions"));

        $("#user-content-3-using-junit5-extend-test-class+div").$("pre")
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "@Test\n" +
                "void test() {\n" +
                "Configuration.assertionMode = SOFT;\n" +
                "open(\"page.html\");\n" +
                "$(\"#first\").should(visible).click();\n" +
                "$(\"#second\").should(visible).click();\n" +
                "}\n" +
                "}\n"
                ));

    }

}
