package ru.BellintegratorHome_1_3;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Steps extends WebDriverSettings {



    @Step("Переход на заданную страницу")
    public static void goingToCheckPage(PageFactoryYandex yandex) {

        yandex.goToPage();
    }

    @Step("Проверка на наличие сторонних брендов")
    public static void checkBrands(PageFactoryYandex yandex) {
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
