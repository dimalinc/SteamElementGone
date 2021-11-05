package com.example.SteamElementGone;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class synchroniz {

    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("applicationCacheEnabled", false);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  driver.get("https://steamcommunity.com/market/search?q=golden&category_570_Hero%5B0%5D=tag_npc_dota_hero_life_stealer&category_570_Slot%5B0%5D=any&category_570_Type%5B0%5D=any&category_570_Rarity%5B0%5D=tag_Rarity_Immortal");
      //  marketPage = new MarketPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public  void main() {


        //	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
        driver.findElement(By.id("package-origin-hp-package")).sendKeys("barro");
        driver.findElement(By.id("package-origin-hp-package")).sendKeys(Keys.ENTER);


        driver.findElement(By.id("package-destination-hp-package")).sendKeys("anc");
        driver.findElement(By.id("package-departing-hp-package")).sendKeys(Keys.ENTER);

        WebDriverWait d=new WebDriverWait(driver,20);
        d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]")));
        //Thread.sleep(5000L);

        driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();





    }

}


