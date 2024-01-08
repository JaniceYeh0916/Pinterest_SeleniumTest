package CucumberJava;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GoHome {
    WebDriver driver;

    @Before
    public void beforeScenario() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");   // 允許遠端控制瀏覽器
        options.addArguments("--headless");                 // 不開啟瀏覽器
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();                 // 刪除瀏覽器所有 cookie
        driver.manage().window().maximize();                // 最大化瀏覽器
        // 設定 2 sec 的搜尋等待時間 (for driver.findElement)
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        driver.get("https://www.pinterest.com/pin/AVacOTqJCJGGZ4yN5EZywVPNtPTirL1do_ajPtII-n6Tiebw1mcZenS0-ZrtEbOWtnxtmDnh9V37mA66fRPqluQ/");     // 進入網址內容
    }
    @Given("user click the button to go home")
    public void userClickGoHome() throws InterruptedException {
        WebElement homeButton = driver.findElement(By.xpath("//div[@class='CCY S9z eEj iyn Tbt L4E e8F BG7']"));
        homeButton.click();
    }

    @Then("assert go home")
    public void assertGoHome() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on the B page", currentUrl.contains("https://www.pinterest.com/"));
    }
}