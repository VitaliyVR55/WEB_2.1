package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    private String makeDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }


    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        form.$("[data-test-id=name] input").setValue("Васильев Василий");
        form.$("[data-test-id=phone] input").setValue("+79271234567");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        form.$(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}