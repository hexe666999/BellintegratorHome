package ru.BellIntegratorTask1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class Tests extends WebDriverSettings {

    @Test
    public void checkYandexSearchResults() throws InterruptedException {
        System.out.println("firstTestTitle");
        driver.get("https://yandex.ru/search/?lr=213&text=" + "Гладиолус");
        Thread.sleep(5000);

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

    @Test
    public void checkResultsWithAllure () throws InterruptedException {
        Steps.goingToCheckPage(driver);
        Steps.checkLink(driver);
    }

}


