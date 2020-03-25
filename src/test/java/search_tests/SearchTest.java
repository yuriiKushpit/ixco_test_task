package search_tests;

import base_test_logic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    private static final String validSearchData = "NFL";
    private static final String invalidSearchData = "NFLFake";
    private static final String errorMessageFirstPart = "Your search for ";
    private static final String errorMessageSecondPart = " did not match any documents.";


    @Test
    public void searchForValidData() {
        SearchPage searchPage = homePage.navigateToSearchPage();
        searchPage.searchForData(validSearchData);
        Assert.assertFalse(searchPage.checkForErrorMessage());
    }

    @Test
    public void searchForInValidData() {
        SearchPage searchPage = homePage.navigateToSearchPage();
        searchPage.searchForData(invalidSearchData);
        Assert.assertTrue(searchPage.checkForErrorMessage());
        Assert.assertEquals(searchPage.getErrorMessageText(),
                errorMessageFirstPart + invalidSearchData + errorMessageSecondPart);
    }

}
