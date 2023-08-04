package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DBUtils;
import utils.Driver;
import java.time.Duration;

public class Hooks {

    @Before("not @DBsmoke")  // before each scenario
    public void setupScenario(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @After("not DBsmoke") // after each scenario
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshotFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFile, "image/png", "screenshot");
        }

        Driver.quitDriver();
    }

    @Before("@DB")
    public void setupScenarioForDB(){
        DBUtils.createConnection();
    }

    @After ("@DB") // after each scenario
    public void tearDownScenario2(){
        DBUtils.close();
    }

    @Before("@DBsmoke")
    public void setupScenarioForDBsmoke(){
        DBUtils.createConnection();
    }

    @After ("@DBsmoke") // after each scenario
    public void tearDownScenariodbsmoke(){
        DBUtils.close();
    }

}
