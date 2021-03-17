
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"C:\\Eclipse\\Selenium_Practise\\Selenium_Assesment_Growth\\src\\test\\resources\\feature"}, glue = "stepdefination"
,plugin= {"pretty","html:target/cucumber"}
, tags = {"@Positive_Scenario"}
)

public class testrunner {

}