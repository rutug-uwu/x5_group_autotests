package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement

            chooseLanguageInput = $(".header__lang"),
            footerInput = $(".footer__address"),
            footerAddressInput = $(".footer__address"),
            feedbackFormInput = $(byText("Обратная связь")),
            chooseRoleInput = $(byText("Выберите роль")),
            headerInput = $(".header__nav-list"),
            searchIcon = $(".header-search"),
            searchInput = $("#search-term-header");

    private final ElementsCollection
            listOfRoles = $$(".css-bjwmxh"),
            resultsListInput = $$(".search-results__list");

    @Step("Открываем главную страницу")
    public HomePage openPage() {
        open("https://www.x5.ru/ru/");

        return this;
    }

    @Step("Кликаем на кнопку 'EN' для перехода сайта на английский язык")
    public HomePage clickSwitchLangButton() {
        chooseLanguageInput.click();

        return this;
    }

    @Step("Пролистываем до подвала сайта")
    public HomePage scrollToFooter() {
        footerInput.scrollIntoView(true);

        return this;
    }

    @Step("Проверяем корректность отображения адреса организации")
    public void verifyAddress(String value) {
        footerAddressInput.shouldBe(visible).shouldHave(text(value));

    }

    @Step("Пролистываем до формы обратной связи")
    public HomePage scrollToFeedbackForm() {
        feedbackFormInput.scrollIntoView(true);

        return this;
    }

    @Step("Открываем список доступных ролей формы обратной связи")
    public HomePage openFeedbackRolesList() {
        chooseRoleInput.click();

        return this;

    }

    @Step("Проверяем наличие роли {value} в списке ролей формы обратной связи")
    public void verifyRoleInList(String value) {
        listOfRoles.shouldHave(texts(value));
    }

    @Step("Проверяем отображение раздела {value} в заголовке сайта")
    public void checkSectionAvailability(String value) {
        headerInput.shouldHave(text(value));
    }

    @Step("Кликаем на иконку поиской строки")
    public HomePage clickSearchIcon() {
        searchIcon.click();

        return this;
    }

    @Step("Вводим значение {value} в поисковую строку и жмем enter")
    public HomePage enterInSearchField(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Проверяем результат поиска")
    public void verifySearchResult() {
        resultsListInput.shouldBe(sizeGreaterThan(0));
    }
}
