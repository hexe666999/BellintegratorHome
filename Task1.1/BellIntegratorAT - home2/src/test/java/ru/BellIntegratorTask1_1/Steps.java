package ru.BellIntegratorTask1_1;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Steps extends WebDriverSettings {



    @Step("Переход на страницу Яндекса с результатами поиска слова \"Гладиолус\"")
    public static void goingToCheckPage(WebDriver driver) throws InterruptedException {

        driver.get("https://yandex.ru/search/?lr=213&text=" + "Гладиолус");
        Thread.sleep(5000);
    }

    @Step("Проверка на наличие ссылки на википедию")
    public static void checkLink(WebDriver driver) {

        Boolean chek = false;
        List<WebElement> listOfWebElement = new ArrayList<>();
        listOfWebElement.addAll(driver.findElements(By.xpath("//*[@class='path path_show-https organic__path']//a[1]")));
        for (WebElement element : listOfWebElement) {
            if (element.getAttribute("href").equals("https://ru.wikipedia.org/")) {
                chek = true;
                break;
            }
        }
        Assertions.assertTrue(chek);
    }
}

