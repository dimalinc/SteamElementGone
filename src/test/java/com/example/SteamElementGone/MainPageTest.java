package com.example.SteamElementGone;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and text()='Search']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.className("js-search-input"));
        assertEquals(searchPageField.getAttribute("value"), "Selenium");
    }

    @Test
    public void toolsMenu() {
        new Actions(driver)
                .moveToElement(mainPage.toolsMenu)
                .perform();

        WebElement menuPopup = driver.findElement(By.className("menu-main__popup-wrapper"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();

        WebElement productsList = driver.findElement(By.className("products-list"));
        assertTrue(productsList.isDisplayed());
        assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");
    }
}
