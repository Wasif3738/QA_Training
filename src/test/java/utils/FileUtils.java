package utils;

import lombok.experimental.UtilityClass;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.io.File;
import java.time.Duration;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.getConfiguration;

@UtilityClass
public class FileUtils {

    public boolean isFileDownloaded(String fileName) {
        String downloadDir = getBrowser().getDownloadDirectory();
        Duration timeout = getConfiguration().getTimeoutConfiguration().getCondition();
        File file = new File(downloadDir + File.separator + fileName);

        try {
            Awaitility.await().atMost(timeout).until(file::exists);
            return true;
        } catch (ConditionTimeoutException e) {
            return false;
        }
    }
}
