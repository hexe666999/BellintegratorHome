package ru.BellintegratorHome_1_3;


import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class Tests extends WebDriverSettings {

    @Test
    @Description (value = "Тест яндекс.маркет")
    public void testYandexWithAllure (){
        PageFactoryYandex yandex = PageFactory.initElements(driver, PageFactoryYandex.class);
        Steps.goingToCheckPage(yandex);
        Steps.checkBrands(yandex);
    }

    @Test
    public void testYandex () {


        System.out.println("firstTestTitle");
        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//a[@class =\"_3Lwc_UVFq4\"][contains(.,\"Электроника\")]")).click();
        sleepSecond(5);
        driver.findElement(By.xpath("//*[@class=\"_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS\"][contains(.,'Смартфоны')]")).click();
        sleepSecond(5);
        driver.findElement(By.xpath("//*[@class = 'i-a11y-clickable _1e7iX1B2oW'][contains(.,\"Apple\")]")).click();
        sleepSecond(5);


        Boolean chek = true;
        for (int i = 0; i < 10; i++) {
            List<WebElement> listOfWebElement = new ArrayList<>();
            listOfWebElement.addAll(driver.findElements(By.xpath("//*[@class='n-snippet-cell2__brand-name']")));
            for (WebElement element : listOfWebElement) {
                if (!element.getText().equals("APPLE")) {
                    chek = false;
                    break;
                }
            }
            sleepSecond(5);
            try {
                driver.findElement(By.xpath("//a[@class= 'button button_size_s button_theme_pseudo n-pager__button-next i-bem n-smart-link button_js_inited n-smart-link_js_inited']")).click();
                sleepSecond(5);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                break;
            }
        }
        Assertions.assertTrue(chek);
    }

    @Test
    public void testYandexWithPageFactory() {
        System.out.println("findPageFactory");
        PageFactoryYandex yandex = PageFactory.initElements(driver, PageFactoryYandex.class);
        yandex.goToPage();

        Boolean chek = true;
        for (int i = 0; i < 10; i++) {
            for (WebElement element : yandex.getListOfWebElement()) {
                if (!element.getText().equals("APPLE")) {
                    chek = false;
                    break;
                }
            }
            try {
                yandex.goToNextPage();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                break;
            }
        }
        Assertions.assertTrue(chek);
    }
}




