package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static utils.Constants.SCREEN_SHOT_FOLDER;


public abstract class Utils {

    public static void screenShotPage(WebDriver driver, String label) {

        try {
            File pageImageFile = new File(SCREEN_SHOT_FOLDER + label + ".png");

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, pageImageFile);

        } catch (IOException ignored) {
        }

    }

    public static void screenShotEntirePage(WebDriver driver, String label) {

        try {
            File entirePageImageFile = new File(SCREEN_SHOT_FOLDER + label + ".png");

            Screenshot entirePageScreenShot = new AShot().
                    shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

            ImageIO.write(entirePageScreenShot.getImage(), "PNG", entirePageImageFile);

        } catch (IOException ignored) {
        }

    }

    public static void createPath(String path) {
        File testDirectory = new File(path);

        if (!testDirectory.exists()) {

            if (testDirectory.mkdir()) {

                System.out.println("Directory: " + path + " is created!");

            } else {

                System.out.println("Failed to create directory: " + path);
            }

        } else {

            System.out.println("Directory already exists: " + path);
        }

    }

    static Platform getCurrentPlatform() {

        Platform platform = null;
        String openSys = System.getProperty("os.name").toLowerCase();

        if (openSys.contains("win")) {

            platform = Platform.WINDOWS;

        } else if (openSys.contains("nix") || openSys.contains("nux") || openSys.contains("aix")) {

            platform = Platform.LINUX;

        } else if (openSys.contains("mac")) {

            platform = Platform.MAC;
        }

        return platform;
    }
}
