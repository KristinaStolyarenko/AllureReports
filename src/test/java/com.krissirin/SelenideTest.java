package com.krissirin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public  void CheckRepositoryIssuesName() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").as("Поисковая строка главной страницы").click();
        $(".header-search-input").as("Поиск репозитория").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").as("Выбор первого значения").submit();

        $(linkText("eroshenkoam/allure-example")).as("Ссылка репозитория").click();
        $(partialLinkText("Issues")).as("Таб Issues").click();
        $("#issue_68_link").as("Issue с номером 68").should(Condition.visible);
    }
}
