package ru.BellintegratorHome_1_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static ru.BellintegratorHome_1_3.WebDriverSettings.sleepSecond;

public class PageFactoryYandex {
    private WebDriver chromeDriver;
    private String url = "https://market.yandex.ru/";

    @FindBy(how = How.XPATH, using = "//a[@class =\"_3Lwc_UVFq4\"][contains(.,\"Электроника\")]")
    WebElement goToElectronics;

    @FindBy(how = How.XPATH, using="//*[@class=\"_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS\"][contains(.,'Смартфоны')]")
    WebElement goToSmartphones;

    @FindBy(how = How.XPATH, using="//*[@class = 'i-a11y-clickable _1e7iX1B2oW'][contains(.,\"Apple\")]")
    WebElement chooseApple;

    @FindBy(how = How.XPATH, using="//a[@class= 'button button_size_s button_theme_pseudo n-pager__button-next i-bem n-smart-link button_js_inited n-smart-link_js_inited']")
    WebElement goToNextPage;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@class='n-snippet-cell2__brand-name']"))
    List<WebElement> listOfWebElement;

    public PageFactoryYandex(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        chromeDriver.get(url);
        sleepSecond(6);
    }

    public void goToPage(){
        goToElectronics.click();
        sleepSecond(6);
        goToSmartphones.click();
        sleepSecond(6);
        chooseApple.click();
        sleepSecond(6);
    }

    public void goToNextPage() {
        goToNextPage.click();
        sleepSecond(6);
    }

    public List<WebElement> getListOfWebElement() {
        return listOfWebElement;
    }
}

