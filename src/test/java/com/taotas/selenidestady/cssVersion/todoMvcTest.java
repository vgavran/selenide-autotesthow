package com.taotas.selenidestady.cssVersion;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class todoMvcTest {

    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        $("#new-todo").setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();
        $$("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));

        $("#todo-list>li:nth-of-type(2) .toggle").click();
        $$("#todo-list>li.completed").shouldHave(exactTexts("b"));
        $$("#todo-list>li:not(.completed)")
                .shouldHave(exactTexts("a", "c"));
    }
}