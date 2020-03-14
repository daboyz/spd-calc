package com.calculatoria.test;

import com.calculatoria.step.BaseCalcSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    protected static BaseCalcSteps baseCalcSteps;

    protected static WebDriver driver;

    public BaseTest() {

    }

    @BeforeAll
    public static void suiteSetup() {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//marionette//chromedriver");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void suiteCleanup() {
        driver.close();
    }

}