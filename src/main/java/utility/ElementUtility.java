package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constant.Constant;

public class ElementUtility { //include scroll, radiobutton,dropdown
	WebDriver driver;
	public ElementUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public void dateSelect(WebElement element,String dateValue) {

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);

	}
	public static String readPropertiesFile(String key) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		String fileName=Constant.Propertyurl;
		String value=null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return value;
	}
	
		public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
		{
			
		    int counter=0;
			for(int i=0;i<tableRowData.size();i++)
			{
				String value=tableRowData.get(i).getText();
				if(expectedValue.equalsIgnoreCase(value))
				{
					counter=i+1;
					break;
				}
				
			}
			return counter;
		}
	
	public void selectRadioButton(List<WebElement> element,int index)
	{
		element.get(index).click();
	}
	public void selectDropDownByValue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
}
