package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomePageTests extends TestBase {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка, что по клику на 'EN' сайт переходит на английский")
    void checkLanguageSwitchingFunctionalityTest() {
        homePage.openPage()
                .clickSwitchLangButton()
                .scrollToFooter()
                .verifyAddress("119049, Russia, Moscow, Koroviy Val street, 5, building 1");
    }

    @Test
    @DisplayName("Проверка корректности отображения адреса на главной странице сайта")
    void validateOrganizationAddressFooterTest() {
        homePage.openPage()
                .scrollToFooter()
                .verifyAddress("119049, Россия, г. Москва, улица Коровий Вал, 5, стр. 1");
    }

    @Test
    @DisplayName("Проверка отображения роли покупателя в окне с обратной связью")
    void shouldDisplayRequiredRoleInFeedbackTest() {
        homePage.openPage()
                .scrollToFeedbackForm()
                .openFeedbackRolesList()
                .verifyRoleInList("Я покупатель");
    }

    @Test
    @DisplayName("Проверка отображения раздела 'Покупателю' в заголовке сайта")
    void verifySectionExistsTest() {
        homePage.openPage()
                .checkSectionAvailability("Покупателю");
    }

    @Test
    @DisplayName("Для поиского запроса 'Покупателю' должен возвращаться не пустой список")
    void searchReturnsNonEmptyResultsTest() {
        homePage.openPage()
                .clickSearchIcon()
                .enterInSearchField("Покупателю")
                .verifySearchResult();
    }
}
