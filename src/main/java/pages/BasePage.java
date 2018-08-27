package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.Utils;

public class BasePage {

//    initialize ExtentReports and attach the HtmlReporter
//    private ExtentReports extent = new ExtentReports();
//    private ExtentTest test = extent.createTest("Test");

    public void goToPage(String page) {
        Driver.getDriverInstance().get(page);
        Driver.getDriverInstance().navigate().to(page);
    }

    protected void click(By elementLocation) throws ElementClickInterceptedException {
        System.out.println("click -> ");
//        waitForElement(elementLocation);
        System.out.println("click -> ");
        Utils.screenShotPage(Driver.getDriverInstance(), "ante de cliclar em logar");
        Driver.getDriverInstance().findElement(elementLocation).click();
        Utils.screenShotPage(Driver.getDriverInstance(), "depois de cliclar em logar");
        System.out.println("click -> ");
    }

    protected void writeText(By elementLocation, String text) {
        waitForElement(elementLocation);
        Driver.getDriverInstance().findElement(elementLocation).clear();
        Driver.getDriverInstance().findElement(elementLocation).sendKeys(text);
        Utils.screenShotPage(Driver.getDriverInstance(), "write  " + text);
        System.out.println("write -> "+ text);
//            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    }

    protected String readText(By elementLocation) {
        waitForElement(elementLocation);
        return Driver.getDriverInstance().findElement(elementLocation).getText();
    }

    protected WebElement waitForElement(By elementLocation) {
        return Driver.getWaitInstance().until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    protected void selectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement checkBox = Driver.getDriverInstance().findElement(elementLocation);

        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    protected void unSelectCheckBox(By elementLocation) throws ElementClickInterceptedException {
        WebElement checkBox = Driver.getDriverInstance().findElement(elementLocation);

        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    protected void selectSpinnerElement(By elementLocation, String value) {
        waitForElement(elementLocation);
        Driver.getDriverInstance().findElement(elementLocation).click();
        new Select(Driver.getDriverInstance().findElement(elementLocation)).selectByVisibleText(value);
    }

//    public IWebElement ElementToBeClickable(IWebElement element){
//        try
//        {
//            Thread.Sleep(TIMEOUTBETWEENEVENTS);
//            return new WebDriverWait(_driver, TimeSpan.FromSeconds(TIMEOUT)).Until(Clickable(element));
//        }
//        catch (Exception e)
//        {
//            var path = General.TakeScreenshot(_driver);
//            _driver.Quit();
//            throw new Exception("SCREENSHOT GENERATED => " + "url(" + path + ")", e.InnerException);
//        }
//    }

//    public IWebElement ElementToBeClickable(By element)
//    {
//        try
//        {
//            Thread.Sleep(TIMEOUTBETWEENEVENTS);
//            return new WebDriverWait(_driver, TimeSpan.FromSeconds(TIMEOUT)).Until(Clickable(element));
//        }
//        catch (Exception e)
//        {
//            var path = General.TakeScreenshot(_driver);
//            _driver.Quit();
//            throw new Exception("SCREENSHOT GENERATED => " + "url(" + path + ")", e.InnerException);
//        }
//    }

//    public IWebElement ElementToBeVisible(By element) {
//        try
//        {
//            Thread.Sleep(TIMEOUTBETWEENEVENTS);
//            return new WebDriverWait(_driver, TimeSpan.FromSeconds(TIMEOUT)).Until(ElementIsVisible(element));
//        }
//        catch (Exception e)
//        {
//            var path = General.TakeScreenshot(_driver);
//            _driver.Quit();
//            throw new Exception("SCREENSHOT GENERATED => " + "url(" + path + ")", e.InnerException);
//        }
//    }

//    public bool ElementExists(By element) {
//        try
//        {
//            Thread.Sleep(TIMEOUTBETWEENEVENTS);
//            _driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(2);
//
//            if (new WebDriverWait(_driver, TimeSpan.FromSeconds(2)).Until(Exists(element)) != null &&
//                    new WebDriverWait(_driver, TimeSpan.FromSeconds(2)).Until(Exists(element)).Size.ToString() != "0")
//            {
//                return true;
//            }
//
//            return false;
//        }
//        catch (Exception)
//        {
//            return false;
//        }
//        finally
//        {
//            _driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(TIMEOUT);
//        }
//    }


//    private Func<IWebDriver, IWebElement> Exists(By locator) {
//        return (driver) =>{
//            return driver.FindElement(locator);
//        }
//        ;
//    }

//    private IWebElement ElementIfVisible(IWebElement element) {
//        return element.Displayed ? element : null;
//    }

//    private Func<IWebDriver, IWebElement> Clickable(By locator) {
//        return (driver) =>
//        {
//            var element = ElementIfVisible(driver.FindElement(locator));
//            try {
//                if (element != null && element.Enabled) {
//                    return element;
//                } else {
//                    return null;
//                }
//            } catch (StaleElementReferenceException) {
//                return null;
//            }
//        } ;
//    }

//    private Func<IWebDriver, IWebElement> ElementIsVisible(By locator) {
//        return (driver) =>
//        {
//            try {
//                return ElementIfVisible(driver.FindElement(locator));
//            } catch (StaleElementReferenceException) {
//                return null;
//            }
//        } ;
//    }

//    private Func<IWebDriver, IWebElement> Clickable(IWebElement element) {
//        return (driver) =>
//        {
//            try {
//                if (element != null && element.Displayed && element.Enabled) {
//                    return element;
//                } else {
//                    return null;
//                }
//            } catch (StaleElementReferenceException) {
//                return null;
//            }
//        } ;
//    }


//    public static int Random(int from, int to) {
//        return new Random().Next(from, to);
//    }

//    public static string GetCurrentDate(string format, string addDays ="0") {
//        return DateTime.Today.AddDays(Convert.ToDouble(addDays)).ToString(format);
//    }

//    public static void ScrollTo(IWebDriver driver, IWebElement element) {
//        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].scrollIntoView(true); ", element);
//        Thread.Sleep(500);
//    }

//    public static string TakeScreenshot(IWebDriver driver) {
//        var dateTime = GetCurrentDate("yyyy-MM-dd");
//        var testName = TestContext.CurrentContext.Test.Name;
//        var screenshotPath = AppDomain.CurrentDomain.BaseDirectory.Replace("bin\\Debug\\", "Screenshots");
//
//        if (!Directory.Exists(screenshotPath + "\\" + dateTime)) {
//            Directory.CreateDirectory(screenshotPath + "\\" + dateTime);
//        }
//
//        var tempo = string.Format("{0:yyyy-MM-dd-hh-mm-ss}", DateTime.Now);
//        var fileName = screenshotPath + "\\" + dateTime + "\\" + tempo + "-" + testName + ".png";
//
//        ((ITakesScreenshot) driver).GetScreenshot().SaveAsFile(fileName, ScreenshotImageFormat.Png);
//
//        return fileName;
//    }

//    public static IEnumerable ReadCSVFile(string csvPath) {
//        using(StreamReader sr = new StreamReader(csvPath, System.Text.Encoding.GetEncoding(1252)))
//        {
//            string line;
//            while ((line = sr.ReadLine()) != null) {
//                ArrayList result = new ArrayList();
//                result.AddRange(line.Split(';'));
//                yield return result;
//            }
//        }
//    }

//    public static int Parallelism(string key) {
//        return 1;
//    }
}
