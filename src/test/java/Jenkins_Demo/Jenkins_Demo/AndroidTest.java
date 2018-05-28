package Jenkins_Demo.Jenkins_Demo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {

	private String testName = "Jenkins Demo Android Phone";
	protected AndroidDriver<AndroidElement> driver = null;
	protected DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
		dc.setCapability("deviceQuery", System.getenv("deviceQuery"));
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("stream", "jenkins_android_phone");
		dc.setCapability("build.number", System.getenv("BUILD_NUMBER"));
		dc.setCapability("accessKey", System.getenv("accessKey")); 
        driver = new AndroidDriver<AndroidElement>(new URL(System.getenv("url")), dc);
    }

    @Test
    public void test1() {
        driver.executeScript("seetest:client.install(\"cloud:uniqueName=testEribankAndroid_" + System.getenv("BUILD_NUMBER") + "\", \"true\", \"false\")");
		driver.executeScript("seetest:client.launch(\"cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity\", \"true\", \"true\")");
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
    }
    
    @Test
    public void test2() {
        driver.executeScript("seetest:client.install(\"cloud:uniqueName=testEribankAndroid_" + System.getenv("BUILD_NUMBER") + "\", \"true\", \"false\")");
		driver.executeScript("seetest:client.launch(\"cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity\", \"true\", \"true\")");
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}