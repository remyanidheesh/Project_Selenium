package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class EstimatePage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Estimates']")
	WebElement estimates;
	@FindBy(xpath="//span[text()='Estimate List']")
	WebElement estimatelist;
	@FindBy(xpath="//a[text()=' Add estimate']")
	WebElement addestimate;
	@FindBy(xpath="//input[@placeholder='Estimate date']")
	WebElement estimatedate;
	@FindBy(xpath="//input[@placeholder='Valid until']")
	WebElement validuntil;
	@FindBy(xpath="//div[@id='s2id_estimate_client_id']")
	WebElement clientdropdown;
	@FindBy(xpath="//input[@id='s2id_autogen9_search']")
	WebElement clientsearch;
	@FindBy(xpath="//ul[@class='select2-results']//li[1]//div//span")
	WebElement clientoption;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement close;
	WaitUtility waitutility;
	ElementUtility elementutility;
	public EstimatePage(WebDriver driver)
	{
		this.driver=driver;
		waitutility=new WaitUtility(driver);
		elementutility=new ElementUtility(driver);
		PageFactory.initElements(driver,this);
	}
	public void doEstimate(String dateestimate,String date,String searchclient)
	{
		
		estimates.click();
		waitutility.WaitClickable(estimatelist);
		estimatelist.click();
		waitutility.WaitClickable(addestimate);
		addestimate.click();
		waitutility.WaitVisibility(estimatedate);
		elementutility.dateSelect(estimatedate, dateestimate);
		waitutility.WaitVisibility(validuntil);
		elementutility.dateSelect(validuntil, date);
		clientdropdown.click();
		clientsearch.sendKeys(searchclient);
		clientoption.click();
		save.click();
		close.click();
		
		
		}
	
}


