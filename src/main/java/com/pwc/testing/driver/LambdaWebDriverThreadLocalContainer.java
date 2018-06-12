package com.pwc.testing.driver;

import com.codeborne.selenide.impl.WebDriverThreadLocalContainer;

public class LambdaWebDriverThreadLocalContainer extends WebDriverThreadLocalContainer {

    public LambdaWebDriverThreadLocalContainer() {
        factory = new LambdaWebDriverFactory();
    }
}
