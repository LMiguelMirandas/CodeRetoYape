package com.auto.base;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriverService;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.auto.base", strict = true)
public class baseTest {

    public static String ANSI_GREEN = "\u001B[32m";

    @BeforeClass
    public static void messages() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.out.println(ANSI_GREEN + ANSI_GREEN);
    }

    @AfterClass
    public static void message() {
        System.out.println(ANSI_GREEN + ANSI_GREEN);
    }

}
