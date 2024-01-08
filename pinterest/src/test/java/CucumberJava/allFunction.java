package CucumberJava;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class allFunction {
    WebDriver driver;

    @Before
    public void beforeScenario() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  // 允許遠端控制瀏覽器
        //options.addArguments("--headless");  // 不開啟瀏覽器
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();  // 刪除瀏覽器所有 cookie
        driver.manage().window().maximize();  // 最大化瀏覽器
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get("https://www.pinterest.com/");  // 進入網址內容
    }

    //----------1:Register----------
    //進入註冊頁面
    @Given("user navigate to the register page")
    public void userNavigateToTheRegisterPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        WebElement element = driver.findElement(By.xpath("//div[@class = 'tBJ dyH iFc sAJ O2T tg7 H2s']"));
        element.click();
    }

    //輸入帳號
    @And("user enters {string} into the email field")
    public void userEnterEmailRegister(String email) throws InterruptedException {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    //輸入密碼
    @And("user enters {string} into the password field")
    public void userEnterPasswordRegister(String password) throws InterruptedException {
        WebElement element = driver.findElement(By.id("password"));
        element.sendKeys(password);
    }

    //輸入出生年月日
    @And("user enters {string} into the birthdate field")
    public void userEnterBirthday(String birthdate) throws InterruptedException {
        WebElement element = driver.findElement(By.id("birthdate"));
        element.click();
        element.sendKeys(birthdate);
    }

    //按下"繼續"按鈕
    @And("user clicks on the continue button")
    public void userClicksOnTheContinueButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//button[@class = 'red SignupButton active']"));
        button.click();
    }

    //顯示錯誤訊息1 -> 沒填email
    @Then("user should get an error message about forgetting to input email in register page")
    public void userGetErrorMessageAboutInvalidCredentialR1() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='xuA']"));

        WebElement [] str = new WebElement [10];
        for (int i = 0; i < 10 && i < elements.size(); i++) {
            str[i] = elements.get(i);
            System.out.println(str[i]);
        }
        Assert.assertTrue(str[9].getText().contains("你漏填了一個地方！別忘了填入電子郵件。"));
    }

    //顯示錯誤訊息2 -> email格式錯誤
    @Then("user should get an error message about error email in register page")
    public void userGetErrorMessageAboutInvalidCredentialR2() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='xuA']"));

        WebElement [] str = new WebElement [10];
        for (int i = 0; i < 10 && i < elements.size(); i++) {
            str[i] = elements.get(i);
            System.out.println(str[i]);
        }
        Assert.assertTrue(str[9].getText().contains("嗯…這看起來不像電子郵件地址。"));
    }

    //顯示錯誤訊息3 -> 不是有效的email
    @Then("user should get an error message about not belong to any email in register page")
    public void userGetErrorMessageAboutInvalidCredentialR3() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        WebElement elements = driver.findElement(By.xpath("(//div[@class='xuA'])[10]"));
        Assert.assertTrue(elements.getText().contains("很抱歉，這似乎不是有效的電子郵件"));
    }

    //----------2:Login----------
    //進入登入頁面
    @Given("user navigate to the login page")
    public void userAreOnTheLoginPage() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='tBJ dyH iFc sAJ xnr tg7 H2s']"));
        loginButton.click();
    }

    //輸入帳號
    @When("User enters valid email address {string} into the email field")
    public void userEnterEmail(String email) throws InterruptedException {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    //輸入密碼
    @And("User enters valid password {string} into the password field")
    public void userEnterPassword(String password) throws InterruptedException {
        WebElement element = driver.findElement(By.id("password"));
        element.sendKeys(password);
    }

    //按下登入按鈕
    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='red SignupButton active']"));
        loginButton.click();
    }

    //顯示錯誤訊息1 -> 沒填email
    @Then("user should get an error message about forgetting to input email in login page")
    public void userGetErrorMessageAboutInvalidCredentialL1() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='xuA']"));

        WebElement [] str = new WebElement [10];
        for (int i = 0; i < 10 && i < elements.size(); i++) {
            str[i] = elements.get(i);
            System.out.println(str[i]);
        }
        Assert.assertTrue(str[9].getText().contains("你漏填了一個地方！別忘了填入電子郵件。"));
    }

    //顯示錯誤訊息2 -> email格式錯誤
    @Then("user should get an error message about error email in login page")
    public void userGetErrorMessageAboutInvalidCredentialL2() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='xuA']"));

        WebElement [] str = new WebElement [10];
        for (int i = 0; i < 10 && i < elements.size(); i++) {
            str[i] = elements.get(i);
            System.out.println(str[i]);
        }
        Assert.assertTrue(str[9].getText().contains("嗯…這看起來不像電子郵件地址。"));
    }

    //顯示錯誤訊息3 -> 尚未註冊
    @Then("user should get an error message about not belong to any email in login page")
    public void userGetErrorMessageAboutInvalidCredentialL3() throws InterruptedException {
        WebElement elements = driver.findElement(By.xpath("(//div[@class='xuA'])[10]"));
        Assert.assertTrue(elements.getText().contains("輸入的電子郵件地址不屬於任何帳號。"));
    }

    //----------3:Search Keyword----------
    //查詢關鍵字(有登入的)
    @Then("user clicks on the searchbar for searching {string}")
    public void loginUserSearchesForKeyword(String keyword) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='searchBoxInput']"));
        searchBox.click();
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    //----------4:Search Keyword (Explore)----------
    //到探索的頁面
    @Given("user navigate to the explore page")
    public void userAreOnTheExplorePage() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='tBJ dyH iFc sAJ O2T zDA UK7 H2s']"));
        loginButton.click();
    }

    //按下搜索欄
    @When("User clicks on the explore button")
    public void userClickSearchBar() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='searchBoxInput']"));
        searchBox.click();
    }

    //輸入關鍵字(沒登入的)
    @Then("user searches for {string} from explore")
    public void userSearchForKeywordFromExplore(String keyword) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='searchBoxInput']"));
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.RETURN);
    }

    //----------5:Search category----------
    //查詢分類
    @Then("user click the category")
    public void UserClickTheCategory() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        WebElement element = driver.findElement(By.xpath("(//img[@class = 'hCL kVc L4E MIw N7A XiG'])[1]"));
        element.click();
    }

    //----------6:Save Picture----------
    //進入圖片頁面
    @And("user click the first picture")
    public void userClickTheFirstPicture() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement element = driver.findElement(By.xpath("(//div[@class='Yl- MIw Hb7'])[1]"));
        element.click();
    }

    //點擊"儲存"按鈕
    @Then("user save the picture")
    public void UserSaveThePicture() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        WebElement element = driver.findElement(By.xpath("//button[@class = 'RCK Hsu USg adn CCY NTm KhY oRi lnZ wsz YbY']"));
        element.click();
    }

    //----------7:Download Picture----------
    //按下功能選單
    @And("user click the function list")
    public void userClickTheFunctionList() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement element = driver.findElement(By.xpath("//div[@aria-label='更多選項']"));
        element.click();
    }

    //按下"儲存圖片"
    @And("user click the button of saving picture")
    public void userClickSavePicture() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement element = driver.findElement(By.xpath("//span[@title='下載圖片']"));
        element.click();
    }

    //----------8:Share Picture----------
    //按下"分享圖片"
    @And("user click the button of sharing picture")
    public void userClickSharePicture() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Send']"));
        element.click();
    }

    //按下"複製連結"
    @And("user click the button of copying path")
    public void userClickCopyPath() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Copy Link']"));
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    //----------9:Create Pin----------
    //按下"創建"
    @And("User clicks on the create button")
    public void userClicksOnTheCreateButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[aria-label='modal']")));
        WebElement createButton = driver.findElement(By.xpath("//div[@class='Eqh fZz fev zI7 iyn Hsu']"));
        createButton.click();
    }

    //上傳圖片
    @And("selects an image file to upload")
    public void selectsAnImageFileToUpload() throws InterruptedException {
        String filepath = "D:/SoftwareFinal/pinterest/src/test/java/CucumberJava/Jaemin.jpeg";
        WebElement fileInput = driver.findElement(By.xpath("//input[@id = 'storyboard-upload-input']"));
        fileInput.sendKeys(filepath);
    }

    //按下提交按鈕
    @Then("user clicks on the submit button")
    public void userClicksOnTheSubmitButton() throws InterruptedException {
        WebElement fileSubmit = driver.findElement(By.xpath("//div[@class = 'tBJ dyH iFc sAJ xnr tg7 H2s']"));
        fileSubmit.click();
    }


    @And("the user attempts to publish the Pin without uploading an image")
    public void theUserAttemptsToPublishThePinWithoutUploadingAnImage() {
        // Add your code to simulate the attempt to publish without uploading an image
        // For example, you can click on the "Publish" button directly
        WebElement publishButton = driver.findElement(By.xpath("//div[@class = 'tBJ dyH iFc sAJ xnr tg7 H2s']"));
        publishButton.click();
    }

    @Then("the user want to click publish button but should not see it")
    public void theUserWantToClickPublishButtonButShouldNotSeeIt() {
        try {
            // Try to find the element
            WebElement element = driver.findElement(By.xpath("//div[@class = 'tBJ dyH iFc sAJ xnr tg7 H2s']"));
            // If the element is found, throw an exception
            throw new AssertionError("Element should not be present, but found: " + "//div[@class = 'tBJ dyH iFc sAJ xnr tg7 H2s']");
        } catch (NoSuchElementException e) {
            // If NoSuchElementException is thrown, it means the element is not present (which is expected)
            // You can optionally log a message here
            System.out.println("Element not found: " + "//div[@class = 'tBJ dyH iFc sAJ xnr tg7 H2s']");
        }
    }

    @Then("close the window")
    public void close()
    {
        driver.quit();
    }
}