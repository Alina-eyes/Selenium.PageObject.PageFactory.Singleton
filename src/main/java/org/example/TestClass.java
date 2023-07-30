package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    public void loginTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        // додайте перевірку на успішний вхід
    }

    @Test
    @Order(2)
    public void productsTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        // додайте тест для перевірки, що всі товари відображаються
    }

    @Test
    @Order(3)
    public void sortProductsByPriceTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortProductsByPriceLowToHigh();

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        Double price1 = Double.valueOf(prices.get(0).getText().replace("$", ""));
        Double price2 = Double.valueOf(prices.get(1).getText().replace("$", ""));

        System.out.println("Price 1 " + price1 + " price 2 " + price2);

        assertTrue(price1 < price2);
        // додайте тест для перевірки, що товари відсортовані за ціною від низької до високої
    }

    @Test
    @Order(4)
    public void addToCartTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        // додайте тест для додавання товарів в корзину та перевірки їх відображення
    }

    @Test
    @Order(5)
    public void logoutTest() {
        // додайте тест для виходу з магазину
    }

    @AfterClass
    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
