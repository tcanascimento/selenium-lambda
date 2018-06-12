package com.pwc.testing.lambda;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface LambdaSeleniumService {
    @LambdaFunction(functionName = "lambda-selenium-pwc-function")
    TestResult runTest(TestRequest testRequest);
}
