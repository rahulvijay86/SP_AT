package apppages;


import org.openqa.selenium.WebDriver;

import common.ExtendedLibrary;

import actions.Button;
import actions.Element;
import actions.ResultUtil;
import actions.Sync;
import actions.TextBox;

public class Login extends ExtendedLibrary{

	public void login(String userName, String password, WebDriver driver){
		try{
			//Logging into the application
			ResultUtil.report("INFO", "Verify login Page", "", "", driver);
			
			if(Element.verify("Login Box", driver, "CLASS", "box")){
				//Element.highlightElement(driver, "CLASS", "box");			
				
				TextBox.clearValue("UserName", "ID", getXPATHValue("USERNAME"), driver);
				
				TextBox.enterValue("UserName", "ID", getXPATHValue("USERNAME"), userName, driver);
				
				TextBox.clearValue("Password", "ID", getXPATHValue("PASSWORD"), driver);

                TextBox.enterValue("Password", "ID", getXPATHValue("PASSWORD"), userName, driver);
				//TextBox.enterPasswordValue("Password", "ID", getXPATHValue("PASSWORD"), password, driver);
			
				Button.click("LOGIN", "ID", getXPATHValue("BTN_LOGIN"), driver);
				
				
				Sync.waitForSeconds(5, driver);
			}

		}catch(Exception e){
			
		}
		
		
	}

	

}
