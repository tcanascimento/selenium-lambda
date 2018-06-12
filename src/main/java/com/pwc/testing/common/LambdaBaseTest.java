package com.pwc.testing.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.pwc.testing.driver.LambdaWebDriverThreadLocalContainer;
import com.pwc.testing.lambda.LambdaTestHandler;
import com.pwc.testing.testcontext.EnvironmentDetector;

import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public abstract class LambdaBaseTest {

    @BeforeClass
    public static void baseTestBeforeClass() {
        Configuration.browser = "chrome";
        Configuration.reopenBrowserOnFail = false;

        if (EnvironmentDetector.inLambda()) {
            WebDriverRunner.webdriverContainer = new LambdaWebDriverThreadLocalContainer();
        }
    }

    protected void screenshot(String description) {
        if (EnvironmentDetector.inLambda()) {
            LambdaTestHandler.addAttachment(description + ".png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver())
                            .getScreenshotAs(OutputType.BYTES));
        } else {
            Selenide.screenshot(description);
        }
    }
}
