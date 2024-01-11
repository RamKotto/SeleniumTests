package test;

import static ru.saraev.constants.tags.TestTags.NEW_FEATURE;
import static ru.saraev.constants.tags.TestTags.TEST;
import base_test.BaseTest;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.saraev.providers.DataProvider;

public class MainTest extends BaseTest {

    @Test
    // для запуска по тегу - запустить с параметром -Dtag=<какой-то тэг
    @Tags({@Tag(NEW_FEATURE), @Tag(TEST)})
    @Step("Hello world!")
    public void test() {
        System.out.println(DataProvider.HOST);
        System.out.println(DataProvider.LOGIN);
        System.out.println(DataProvider.PASSWORD);
        // для отображения - запустить с параметром -Dlogin=<какой-то логин>
        System.out.println(System.getProperty("login"));
    }
}
