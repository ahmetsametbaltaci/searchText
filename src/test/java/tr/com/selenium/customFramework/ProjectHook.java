package tr.com.selenium.customFramework;


import com.thoughtworks.gauge.*;
import tr.com.selenium.utils.PropertyUtils;


public class ProjectHook extends ProjectSeleniumWebDriverImpl {


    @BeforeSuite
    public void beforeSuite(ExecutionContext context) {
        PropertyUtils.initUserProperties();
        PropertyUtils.initDefaultProperties();
        setup();
    }

    @AfterSuite
    public void afterSuite(ExecutionContext context) {
        teardown();
    }

    @BeforeSpec
    public void beforeSpec(ExecutionContext context) {


    }

    @AfterSpec
    public void afterSpec(ExecutionContext context) {

    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext context) {


    }

    @AfterScenario
    public void afterScenario(ExecutionContext context) {


    }

    @BeforeStep
    public void beforeStep(ExecutionContext context) {

    }

    @AfterStep
    public void afterStep(ExecutionContext context) {


    }
}
