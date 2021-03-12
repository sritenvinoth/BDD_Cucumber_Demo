import org.junit.runner.RunWith

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber



@RunWith(Cucumber.class)
@CucumberOptions(features="Include/features/ServiceRequest.feature", glue="",
monochrome=true,
plugin=["pretty",
	"junit:C:/Users/vinothkumar.murugan/Desktop/Katalon/BDD_DEMO_Reports/cucumber.xml",
	"html:C:/Users/vinothkumar.murugan/Desktop/Katalon/BDD_DEMO_Reports",
	"json:C:/Users/vinothkumar.murugan/Desktop/Katalon/BDD_DEMO_Reports/cucumber.json"])

class RunnerFile {
	
}