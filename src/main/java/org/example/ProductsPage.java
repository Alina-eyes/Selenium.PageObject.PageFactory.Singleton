package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productsList;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfProducts() {
        return productsList.size();
    }

    public void sortProductsByPriceLowToHigh() {
        sortDropdown.click();

        Select select = new Select(sortDropdown);
        select.selectByValue("lohi");

        // Виберіть опцію для сортування за ціною від низької до високої
        // Наприклад: driver.findElement(By.cssSelector("option[value='lohi']")).click();
    }
}

