package com.example.SteamElementGone;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MarketPageTest {
    private WebDriver driver;
    private MarketPage marketPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("applicationCacheEnabled", false);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://steamcommunity.com/market/search?q=golden&category_570_Hero%5B0%5D=tag_npc_dota_hero_life_stealer&category_570_Slot%5B0%5D=any&category_570_Type%5B0%5D=any&category_570_Rarity%5B0%5D=tag_Rarity_Immortal");
        marketPage = new MarketPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void goldenFilterGone() {
        marketPage.goldenFilter.click();

        while (true)
        System.out.println(marketPage.goldenFilter.isDisplayed());


       /* Wait<WebDriver> wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.not
                (ExpectedConditions.visibilityOf(marketPage.goldenFilter)));*/
                /*ElementLocated(By.xpath("//*[@id=\"BG_bottom\"]/div[1]/div/a[4]"))*/

      /*  System.out.println(marketPage.goldenFilter.isDisplayed());
        System.out.println(marketPage.goldenFilter.isEnabled());
        System.out.println(marketPage.goldenFilter.isSelected());
*/


       // assertTrue(marketPage.goldenFilter.isDisplayed());
    }



//    assertTrue(menuPopup.isDisplayed());

}
