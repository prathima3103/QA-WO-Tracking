package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseUtil {

    private BaseUtil base;

    public Hooks(BaseUtil base)
    {
        this.base = base;
    }
//Initialization of Chrome driver
    @Before
    public void InitializeTest()
    {
        System.setProperty("webdriver.chrome.driver","G:\\Selenium\\Chromedriver 2.37\\chromedriver.exe");
        System.out.println("Opening Chrome browser");
        base.driver = new ChromeDriver();
    }


    @After
    public void TearDownTest(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            System.out.println(scenario.getName());
            scenario.embed(((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES), "image/png");

// Prints the screenshot in your local drive mentioned
            File scrFile = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.FILE);
            try
            {
                FileUtils.copyFile(scrFile, new File("G:\\QA-WO-Tracking\\screenshot.png"));
            }
            catch (IOException e)  {
                e.printStackTrace();
            }
        }
    }


}


