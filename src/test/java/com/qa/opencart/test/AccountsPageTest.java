package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstants;
//import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(), Appconstants.ACCOUNTS_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}
	
	@Test
	public void accPageURLTest() {
		Assert.assertTrue(accPage.getAccPageURL().contains(Appconstants.ACC_PAGE_FRACTION_URL), AppError.URL_NOT_FOUND);
	}
	

	@Test
	public void accPageHeadersTest() {
		List<String> accPageHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(accPageHeadersList, Appconstants.ACC_PAGE_HEADERS_LIST, AppError.LIST_IS_NOT_MATCHED);
	}
	@Test
	public void searchTest() {
		searchResultsPage = accPage.doSearch("macbook");
		Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 3, AppError.LIST_IS_NOT_MATCHED);
}

}





