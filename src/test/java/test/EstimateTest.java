package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.EstimatePage;
import page.LoginPage;

public class EstimateTest extends BaseTest {
  @Test
  public void verifyEstimate() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  EstimatePage ep=new EstimatePage(driver);
	 
	
  }
}
