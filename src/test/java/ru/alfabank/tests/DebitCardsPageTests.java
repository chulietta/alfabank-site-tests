package ru.alfabank.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.alfabank.lifecycle.WebTestLifeCycleExtension;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("web")
@ExtendWith(WebTestLifeCycleExtension.class)
public class DebitCardsPageTests {

    @Test
    @DisplayName("Debit cards page should be loaded")
    void debitCardsPageLoadedTest() {
        step("Check page title", () -> {
            $("h1").shouldHave(text("Дебетовые карты"));
        });
    }

    @Test
    @DisplayName("Debit cards blocks should be loaded")
    void debitCardBlocksLoadedTest() {
        step("Check debit cards count", () -> {
            $("#all-cards").$$("[data-widget-name=CatalogCard]").shouldHave(size(10));
        });
        step("Check debit cards titles", () -> {
            assertThat($("#alfacard-benefit h2").innerText()).isEqualTo("Дебетовая Альфа-Карта");
            assertThat($("#mir h2").innerText()).isEqualTo("Дебетовая карта МИР");
            assertThat($("#alfacard-premium h2").innerText()).isEqualTo("Дебетовая Альфа-Карта Premium");
            assertThat($("#alfa-travel h2").innerText()).isEqualTo("Дебетовая карта Alfa Travel");
            assertThat($("#alfa-travel-premium h2").innerText()).isEqualTo("Дебетовая карта Alfa Travel Premium");
            assertThat($("#aeroflot h2").innerText()).isEqualTo("Дебетовая карта Аэрофлот");
            assertThat($("#aeroflot-premium h2").innerText()).isEqualTo("Дебетовая карта Аэрофлот Black Edition");
            assertThat($("#pyaterochka h2").innerText()).isEqualTo("Дебетовая карта Пятёрочка");
            assertThat($("#childcard h2").innerText()).isEqualTo("Дебетовая Детская карта");
            assertThat($("[id='1-5-25'] h2").innerText()).isEqualTo("Кэшбэк 1-5-25");
        });
    }

    @Test
    @DisplayName("Can open archive cards area")
    void canOpenArchiveCardsByLinkClickTest() {
        step("Click by link", () -> $(byText("Архивные карты")).click());
        step("Check text on archived card", () -> $(byText("Карта больше не выпускается")).shouldBe(visible));
    }


    @Test
    @DisplayName("Check cards filter by premium parameter")
    void premiumFilterTest() {
        step("Click Premium Button", () -> $("[data-test-id=tabs-list-tabTitle-1]").click());
        step("Check premium cards count", () -> $$("#premium-cards h2").shouldHave(size(3)));
        step("Check premium cards titles", () -> {
            $("#alfacard-premium h2").shouldHave(text("Дебетовая Альфа-Карта Premium"));
            $("#alfa-travel-premium h2").shouldHave(text("Дебетовая карта Alfa Travel Premium"));
            $("#aeroflot-premium h2").shouldHave(text("Дебетовая карта Аэрофлот Black Edition"));
        });
    }

    @Test
    @DisplayName("Check cards filter by trip parameter")
    void tripFilterTest() {
        step("Click trip button", () -> $("[data-test-id=tabs-list-tabTitle-2]").click());
        step("Check trip cards count", () -> $$("#travel-cards h2").shouldHave(size(4)));
        step("Check trip cards titles", () -> {
            $("#alfa-travel h2").shouldHave(text("Дебетовая карта Alfa Travel"));
            $("#alfa-travel-premium h2").shouldHave(text("Дебетовая карта Alfa Travel Premium"));
            $("#aeroflot h2").shouldHave(text("Дебетовая карта Аэрофлот"));
            $("#aeroflot-premium h2").shouldHave(text("Дебетовая карта Аэрофлот Black Edition"));
        });
    }

    @Test
    @DisplayName("Check cards filter by shopping parameter")
    void shoppingFilterTest() {
        step("Click shopping button", () -> $("[data-test-id=tabs-list-tabTitle-3]").click());
        step("Check shopping cards count", () -> $$("#shopping-cards h2").shouldHave(size(2)));
        step("Check shopping cards titles", () -> {
            $("#alfacard-benefit h2").shouldHave(text("Дебетовая Альфа-Карта"));
            $("#pyaterochka h2").shouldHave(text("Дебетовая карта Пятёрочка"));
        });
    }
}
