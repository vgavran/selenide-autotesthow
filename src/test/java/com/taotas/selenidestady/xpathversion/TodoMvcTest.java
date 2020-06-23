package com.taotas.selenidestady.xpathversion;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {

    @Test
    void completesTaskByXPath() {
        open("http://todomvc.com/examples/emberjs/");

        $(By.xpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        $(By.xpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        $(By.xpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        $$(By.xpath("//*[@id='todo-list']/li")).shouldHave(exactTexts("a", "b", "c"));

        $(By.xpath("//*[@id='todo-list']/li[.//text()='b']" +
                "//*[contains(concat(' ', normalize-space(@class), ' '), ' toggle ')]"))
                .click();
        $$(By.xpath("//*[@id='todo-list']" +
                "/li[contains(concat(' ', normalize-space(@class), ' '), ' completed ')]"))
                .shouldHave(exactTexts("b"));
        $$(By.xpath("//*[@id='todo-list']" +
                "/li[not(contains(concat(' ', normalize-space(@class), ' '), ' completed '))]"))
                .shouldHave(exactTexts("a", "c"));
    }
}
