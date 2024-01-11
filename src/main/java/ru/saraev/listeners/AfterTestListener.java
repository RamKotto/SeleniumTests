package ru.saraev.listeners;

import static ru.saraev.utils.StringUtils.getUniqueString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.saraev.utils.ScreenshotUtils;

@Slf4j
public class AfterTestListener implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        if (extensionContext.getExecutionException().isPresent()) {
            String target = "/screenshots/" + getUniqueString("fail-") + ".png";
            ScreenshotUtils.takeScreenshot(target);
            log.info("Screenshot saved: " + target);
        }
    }
}
