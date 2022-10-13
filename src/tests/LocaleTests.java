package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
//	Test #1	
//	Postaviti jezik na ES
//	Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
	
	@Test(priority = 1)
	public void setLocaleToES() {
		navPage.getChooseALanguageBtn().click();
		navPage.getESLangBtn().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Página de aterrizaje"),
				"ERROR: Heder should be - Página de aterrizaje");
	}
//	Test #2	
//	Postaviti jezik na EN
//	Verifikovati da se na stranici u hederu javlja tekst Landing
	
	@Test(priority = 2)
	public void setLocaleToEN() {
		navPage.getChooseALanguageBtn().click();
		navPage.getENLangBtn().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Landing"),
				"ERROR: Heder should be - Landing");
	}
//	Test #3	
//	Postaviti jezik na CN
//	Verifikovati da se na stranici u hederu javlja tekst 首页
	
	@Test(priority = 3)
	public void setLocaleToCN() {
		navPage.getChooseALanguageBtn().click();
		navPage.getCNLangBtn().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("首页"),
				"ERROR: Heder should be - 首页");
	}
//	Test #4	
//	Postaviti jezik na FR
//	Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
	
	@Test(priority = 4)
	public void setLocaleToFR() {
		navPage.getChooseALanguageBtn().click();
		navPage.getFRLangBtn().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Page d'atterrissage"),
				"ERROR: Heder should be - Page d'atterrissage");
	}
}
