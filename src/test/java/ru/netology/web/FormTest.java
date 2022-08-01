
    package ru.netology.web;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


    public class FormTest {
        @Test
        void completedBlank() {
            open("http://localhost:9999/");
            $("[data-test-id=name] input").setValue("Антон Сидоров");
            $("[data-test-id=phone] input").setValue("+79781214364");
            $("[data-test-id=agreement]").click();
            $("button[type=button]").click();
            $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        }

    }

}
