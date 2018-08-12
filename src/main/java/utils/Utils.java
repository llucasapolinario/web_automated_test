package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static utils.Constants.SCREENSHOT_FOLDER;


public abstract class Utils {


    public static void screenshotPage(WebDriver driver, String label) {

        try {
            File pageImageFile = new File(SCREENSHOT_FOLDER + label + ".png");

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, pageImageFile);

        } catch (IOException ignored) {
        }

    }

    public static void screenshotEntirePage(WebDriver driver, String label) {

        try {
            File entirePageImageFile = new File(SCREENSHOT_FOLDER + label + ".png");

            Screenshot entirePageScreenShot = new AShot().
                    shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

            ImageIO.write(entirePageScreenShot.getImage(), "PNG", entirePageImageFile);

        } catch (IOException ignored) {
        }

    }

}
