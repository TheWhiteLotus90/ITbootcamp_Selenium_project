package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{	
//	Test #1	
//	Postaviti EN jezik stranice
//	Klik na login dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 1)
	public void visitTheLoginPage() {	
		navPage.getChooseALanguageBtn().click();
		navPage.getENLangBtn().click();
		navPage.getLoginBtn().click();

		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should be contains /login.");
	}	
//	Test #2	
//	Klik na login dugme iz navigacije
//	Verifikovati da polje za unos emaila za atribut type ima vrednost email
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
	
	@Test(priority = 2)
	public void checkInputTypes() {
		navPage.getLoginBtn().click();
		Assert.assertEquals(
				loginPage.getEmailInput().getAttribute("type"), 
				"email",
				"ERROR: Input type should be email");

		Assert.assertEquals(
				loginPage.getPassInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
	}	
//	Test #3
//	email: non-existing-user@gmal.com
//	password: password123
//	Koraci: 
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Klik na login dugme
//	Sacekati da popu za prikaz greske bude vidljiv
//	Verifikovati da greska sadrzi poruku User does not exists
//	Verifikovati da se u url-u stranice javlja /login ruta 
	
	@Test(priority = 3)
	public void displaysErrorsWhenUserDoesNotExist() {
		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPassInput().sendKeys("password123");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUpVisibility();

		Assert.assertTrue(
				messagePopUpPage.getElementsWithTextMessages()
				.getText()
				.equals("User does not exists"),
				"ERROR: Message should be User does not exist.");

		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should be contains /login.");
	}	
//	Test #4	
//	email: admin@admin.com
//	password: password123
//	Koraci: 
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Klik na login dugme
//	Sacekati da popu za prikaz poruke bude vidljiv
//	Verifikovati da greska sadrzi poruku Wrong password
//	Verifikovati da se u url-u stranice javlja /login ruta 
	
	@Test(priority = 4)
	public void displaysErrorsWhenPasswordIsWrong() {	
		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPassInput().sendKeys("password123");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUpVisibility();

		Assert.assertTrue(
				messagePopUpPage.getElementsWithTextMessages()
				.getText()
				.equals("Wrong password"),
				"ERROR: Message should be Wrong password");

		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should be contains /login.");
	}	
//	Test #5
//	email: admin@admin.com
//	password: 12345
//	Koraci: 
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Verifikovati da se u url-u stranice javlja /home ruta
	
	@Test(priority = 5)
	public void  login() throws InterruptedException {
		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPassInput().sendKeys("12345");
		loginPage.getLoginBtn().click();
		Thread.sleep(1000);
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/home"),
				"ERROR: Url should be contains /home.");
	}	
//	Test #6
//	Verifikovati da je dugme logout vidljivo na stranici
//	Kliknuti na logout dugme	
	
	@Test(priority = 6)
	public void logout() {
		Assert.assertTrue(
				navPage.getLogoutBtn().isDisplayed(),
				"ERROR: Logout button is not displayed.");
		navPage.getLogoutBtn().click();

	}
}

