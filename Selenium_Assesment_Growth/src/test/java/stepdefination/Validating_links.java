package stepdefination;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reusability_Growth.Utility;

public class Validating_links extends Utility{
	
	public String productslink = "//nav[@role='navigation']//ul[@id='menu-1-14f67f5']//child::a[contains(.,'$linkName')]";
	public String product_check = "//ul[@id='menu-1-14f67f5']//child::a[contains(text(),'$linkname')]";
	public String getTouch_button = "//a[@id='contact-button']//span[@class='elementor-button-content-wrapper']//child::span[contains(.,'GET IN TOUCH')]";
    public String logo = "//img[@alt='Growth Engineering White Logo' and @class='attachment-full size-full lazyloaded']//parent::a";
    

    @Given("^user landed in growthengineering Home Page$")
public void user_landed_in_growthengineering_Home_Page() throws Throwable {
  browserConfigurations();
	System.out.println("Browser Launched Successfully");
     
}

@When("^user clicks on link \"([^\"]*)\"$")
public void user_clicks_on_link(String link) throws Throwable {
	alert();
	moveToElement(productslink.replace("$linkName", link));
	alert();
 	driver.findElement(By.xpath((productslink.replace("$linkName", link)))).click();
	Thread.sleep(1000);
	String title = driver.getTitle();
	System.out.println(title);
 
	
}
@When("^user clicks on button \"([^\"]*)\"$")
public void user_clicks_on_button(String link) throws Throwable {
	alert();
	moveToElement(getTouch_button);
	Thread.sleep(1000);
	alert();
 	driver.findElement(By.xpath(getTouch_button)).click();
	Thread.sleep(1000);
	String title = driver.getTitle();
	System.out.println(title);
 
	
	
        
}
@And("^user clicks on logo closes the browser$")
public void user_closes_browser() throws Throwable {
clickElement(logo);
browserClose();
	
}

@Then("^user should be landed into any one of the product which is mentioend in dropdown$")
public void user_should_be_landed_into_any_one_of_the_product_which_is_mentioend_in_dropdown() throws Throwable {
 	  System.out.println("Page is navigated to Mentioned link from home bar" + " "+ getPageTitle());
     
}

@Then("^user can be able to navigate to another link \"([^\"]*)\" under \"([^\"]*)\" from dropdown from the present page$")
public void user_can_be_able_to_navigate_to_another_link_from_dropdown_from_the_present_page(String links, String Parent) throws Throwable {
	alert();
	waitUnitlVisible(productslink.replace("$linkName",Parent));
	moveToElement(productslink.replace("$linkName", Parent));
	alert();
    waitUnitlVisible(product_check.replace("$linkname",links));
    clickElement(product_check.replace("$linkname",links));
}


}
