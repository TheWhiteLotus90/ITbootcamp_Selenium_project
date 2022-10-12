package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
//	Test #1
//	Ucitati /home stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 1)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");	
	}
//	Test #2	
//	Ucitati /profile stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 2)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	}
//	Test #3
//	Ucitati /admin/cities stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 3)
	public void  forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

		driver.get(baseUrl + "/admin/cities");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	}
//	Test #4
//	Ucitati /admin/users stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 4)
	public void  forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	}
}
