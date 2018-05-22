package Jenkins_Demo.Jenkins_Demo;

import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSTest extends BaseTest {

	private String testName = "Jenkins Demo iOS Phone";
    protected IOSDriver<IOSElement> driver = null;

	@Before
	public void setUp() throws Exception{
        dc.setCapability("testName", testName);
        driver = new IOSDriver<>(new URL("https://sales.experitest.com/wd/hub"), dc);
	}

	@Test
	public void test(){
        driver.executeScript("seetest:client.install(\"cloud:uniqueName=testEribankIOS\", \"true\", \"false\")");
		driver.executeScript("seetest:client.launch(\"cloud:com.experitest.ExperiBank\", \"true\", \"true\")");
		dc.setCapability(MobileCapabilityType.APP, "cloud:uniqueName=testEribankIOS");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("instrumentApp", true);
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
