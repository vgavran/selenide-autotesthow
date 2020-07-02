package com.taotas.selenidestady.xpathrefactoring;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import selenidestady.utils.XPath;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {

    @Test
    void completesTaskByXPathRef() {
        open("http://todomvc.com/examples/emberjs/");

        $(By.xpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        $(By.xpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        $(By.xpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        $$(By.xpath("//*[@id='todo-list']/li"))
                .shouldHave(exactTexts("a", "b", "c"));

        $(By.xpath("//*[@id='todo-list']/li[.//text()='b']//*["
                + XPath.hasCssClass("toggle") + "]"))
                .click();
        $$(By.xpath("//*[@id='todo-list']/li["
                + XPath.hasCssClass("completed") + "]"))
                .shouldHave(exactTexts("b"));
        $$(By.xpath("//*[@id='todo-list']/li[not("
                + XPath.hasCssClass("completed") + ")]"))
                .shouldHave(exactTexts("a", "c"));
    }
}
