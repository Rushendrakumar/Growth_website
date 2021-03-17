package stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reusability_Growth.Utility;

public class Contact_validation extends Utility {
	
 public String getintouch = "//span[contains(text(),'GET IN TOUCH')]";
 public String fname ="//input[@name='firstname']";
 public String lname = "//input[@name='lastname']";
 public String wemail ="//input[contains(@type,'email')]";
 public String tel ="//input[@type='tel'and @name='phone']";
 public String compname ="//input[@id='company-63c6168e-e30a-4c79-ab68-77cedae08dfe' or @class='hs-input']";
 public String count ="//select[@name='country_']";
 public String learn_But ="(//input[@type='radio'])[1]//parent::label";
 public String role_but ="//select[@name='role_description']";
 public String purpose_enquiry ="//select[@name='what_is_the_purpose_of_your_enquiry_']";
 public String check_box_item ="//input[@type='checkbox' and @class='hs-input']";
 public String textField = "//label[@class='hs-error-msg']//..//..//../label/span[contains(text(),'$text')]";



@Given("^user clicks on Get in Touch link$")
public void user_clicks_on_Get_in_Touch_link() throws Throwable {
	moveToElement(getintouch);
	Thread.sleep(1000);
	clickElement(getintouch);
   
}

@When("^user enters the below details$")
public void user_enters_the_below_details(DataTable arg1) throws Throwable {
	
	List<Map<String, String>> contactform = arg1.asMaps(String.class, String.class);
	
	 
    String fName = contactform.get(0).get("First Name");
    String lName = contactform.get(0).get("Last Name");
    String wEmail = contactform.get(0).get("Work Email");
    String tele = contactform.get(0).get("Telephone");
    String company = contactform.get(0).get("Company Name");
    String country = contactform.get(0).get("Country");
    String learn = contactform.get(0).get("Learners");
    String role = contactform.get(0).get("Role Description");
    String enquire = contactform.get(0).get("Enquiry");
    System.out.println(fName + lName + wEmail + tele);
    scrollDown(800);
   sendElement(fname, fName);
    sendElement(lname, lName);
    sendElement(wemail, wEmail);
    sendElement(tel, tele);
    sendElement(compname, company);
    SelectByValue(count, country);
    clickElement(learn_But);
    SelectByValue(role_but, role);
    SelectByValue(purpose_enquiry , enquire);
   
    }

@Then("^user should click on check box$")
public void user_should_click_on_check_box() throws Throwable {
	 waitUnitlClickable(check_box_item);
    clickElement(check_box_item);
  
   
}

@Then("^user should get the inline error message if misses for any dropdown \"([^\"]*)\", \"([^\"]*)\" field \"([^\"]*)\"$")
public void user_should_get_the_inline_error_message_under_dropdown_field(String fieldtext, String fieldtex, String errorMessage) throws Throwable {
String error_message1 = driver.findElement(By.xpath(textField.replace("$text", fieldtext))).getText();
String error_message2 = driver.findElement(By.xpath(textField.replace("$text", fieldtex))).getText();
Assert.assertEquals(error_message1, errorMessage);
Assert.assertEquals(error_message2, errorMessage);

   }

@Then("^user should get the inline error message if misses for any text \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" field \"([^\"]*)\"$")
public void user_should_get_the_inline_error_message_under_text_field(String fieldtext1, String fieldtext2,String fieldtext3, String errorMessage) throws Throwable {
	String error_message1 = driver.findElement(By.xpath(textField.replace("$text", fieldtext1))).getText();
	String error_message2 = driver.findElement(By.xpath(textField.replace("$text", fieldtext2))).getText();
	String error_message3 = driver.findElement(By.xpath(textField.replace("$text", fieldtext3))).getText();
	Assert.assertEquals(error_message1, errorMessage);
	Assert.assertEquals(error_message2, errorMessage);
	Assert.assertEquals(error_message3, errorMessage);
   
}

}
