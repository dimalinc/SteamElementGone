package com.example.SteamElementGone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

public class MarketPage {

    String  startingUrl = "https://steamcommunity.com/market/search?q=golden&category_570_Hero%5B0%5D=tag_npc_dota_hero_life_stealer&category_570_Slot%5B0%5D=any&category_570_Type%5B0%5D=any&category_570_Rarity%5B0%5D=tag_Rarity_Immortal";

    @FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    @FindBy(xpath = "//div[contains(@class, 'menu-main__item') and text() = 'Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test=menu-main-icon-search]")
    public WebElement searchButton;


    //////////

    @FindBy(xpath = "//*[@id=\"BG_bottom\"]/div[1]/div/a[4]")
    public WebElement goldenFilter;

    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
