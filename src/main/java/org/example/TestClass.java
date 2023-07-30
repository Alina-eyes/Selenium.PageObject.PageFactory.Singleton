package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@FixMethodOrder(MethodSorters.JVM)
public class TestClass {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        // додайте перевірку на успішний вхід
    }

    @Test
    public void productsTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        // додайте тест для перевірки, що всі товари відображаються
    }

    @Test
    public void sortProductsByPriceTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortProductsByPriceLowToHigh();
        // додайте тест для перевірки, що товари відсортовані за ціною від низької до високої
    }

    @Test
    public void addToCartTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        // додайте тест для додавання товарів в корзину та перевірки їх відображення
    }

    @Test
    public void logoutTest() {
        // додайте тест для виходу з магазину
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
