package ru.netology.web;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FormTest {
    private Webdriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromeDriver().setup();

        @BeforeEach
                public void setUp(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get("http://localhost:9999");
        }
    @AfterEach
            public void tearDown() {
            driver.quit();
            driver = null;
        }
    }
    @Test
    void completedBlank() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Антон Сидоров");
        $("[data-test-id=phone] input").setValue("+79781214364");
        $("[data-test-id=agreement]").click();
        $("button[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
