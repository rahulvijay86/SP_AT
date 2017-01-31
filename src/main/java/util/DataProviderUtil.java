package util;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	public static class staticProviderClass{
			
		@DataProvider(name="Sharepoint",parallel=false)
		public static Iterator<Object[]> Sharepoint(){
			Iterator<Object[]> testData=ExcelUtils.getTestData("Input/Browser.xls", "Sharepoint");
			return testData;
		}
	


	}
}


