package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"src/test/java/Feature"}, format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = "Steps")
public class Testrunner extends AbstractTestNGCucumberTests{

}




