package ru.alfabank.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.alfabank.lifecycle.WebTestLifeCycleExtension;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("web")
@ExtendWith(WebTestLifeCycleExtension.class)
public class DebitCardsPageTests {

    @Test
    @DisplayName("Debit cards page should be loaded")
    void debitCardsPageHeaderTest() {
        step("Проверка заголовка страницы дебетовых карт", () -> {
            $("h1").shouldHave(text("Дебетовые карты"));
        });
    }

    @Test
    @DisplayName("Debit cards page should be loaded")
    void debitCardBlocksLoadedTest() {
        step("Проверка количества дебетовых карт на странице", () -> {
            $$("#all-cards h2").shouldHaveSize(12);
        });
        step("Проверка заголовков всех дебетовых карт", () -> {
            $("#alfacard-benefit h2").shouldHave(text("Альфа-Карта"));
            $("#alfacard-premium h2").shouldHave(text("Альфа-Карта Premium"));
            $("#alfa-travel h2").shouldHave(text("Alfa Travel"));
            $("#alfa-travel-premium h2").shouldHave(text("Alfa Travel Premium"));
            $("#aeroflot h2").shouldHave(text("Аэрофлот"));
            $("#aeroflot-premium h2").shouldHave(text("Аэрофлот Black Edition"));
            $("#yandex h2").shouldHave(text("Яндекс.Плюс"));
            $("#pyaterochka h2").shouldHave(text("Пятёрочка"));
            $("#perekrestok h2").shouldHave(text("Перекрёсток"));
            $("#mir h2").shouldHave(text("МИР"));
            $("#childcard h2").shouldHave(text("Детская карта"));
        });
    }

    @Test
    @DisplayName("Check archive cards link")
    void archiveCardsLinkTest() {
        step("Проверка перехода по ссылке в архивные карты", () -> {
            $("#archive-link a").shouldHave(href("/everyday/debit-cards-archive/"));
            $("#archive-link").$(byText("Архивные карты")).click();
            $("h1").shouldHave(text("Архивные карты"));
        });
    }

    @Test
    @DisplayName("Benefits block should be loaded")
    void benefitsBlockLoadedTest() {
        step("Проверка загрузки блока страхования", () -> {
            $("#benefit h3").shouldHave(text("Все деньги застрахованы"));
        });
    }

    @Test
    @DisplayName("SEO block should be loaded")
    void seoBlockLoadedTest() {
        step("Проверка загрузки блока SEO", () -> {
            $("#seo-text").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Check Premium filter")
    void premiumFilterTest() {
        step("Нажать на пункт Premium ", () -> {
            $("[data-test-id=tabs-list-tabTitle-1]").click();
        });
        step("Проверить количество и заголовки отфильтрованных карт", () -> {
            $$("#premium-cards h2").shouldHaveSize(3);
            $("#alfacard-premium h2").shouldHave(text("Альфа-Карта Premium"));
            $("#alfa-travel-premium h2").shouldHave(text("Alfa Travel Premium"));
            $("#aeroflot-premium h2").shouldHave(text("Аэрофлот Black Edition"));
        });
    }

    @Test
    @DisplayName("Check trip filter")
    void tripFilterTest() {
        step("Нажать на пункт Для путешествий", () -> {
            $("[data-test-id=tabs-list-tabTitle-2]").click();
        });
        step("Проверить количество и заголовки отфильтрованных карт", () -> {
            $$("#travel-cards h2").shouldHaveSize(4);
            $("#alfa-travel h2").shouldHave(text("Alfa Travel"));
            $("#alfa-travel-premium h2").shouldHave(text("Alfa Travel Premium"));
            $("#aeroflot h2").shouldHave(text("Аэрофлот"));
            $("#aeroflot-premium h2").shouldHave(text("Аэрофлот Black Edition"));
        });
    }

    @Test
    @DisplayName("Check shopping filter")
    void shoppingFilterTest() {
        step("Нажать на пункт Для покупок", () -> {
            $("[data-test-id=tabs-list-tabTitle-3]").click();
        });
        step("Проверить количество и заголовки отфильтрованных карт", () -> {
            $$("#shopping-cards h2").shouldHaveSize(4);
            $("#alfacard-benefit h2").shouldHave(text("Альфа-Карта"));
            $("#yandex h2").shouldHave(text("Яндекс.Плюс"));
            $("#pyaterochka h2").shouldHave(text("Пятёрочка"));
            $("#perekrestok h2").shouldHave(text("Перекрёсток"));
        });
    }
}
