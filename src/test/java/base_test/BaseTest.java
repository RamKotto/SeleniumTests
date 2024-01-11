package base_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.saraev.driver.DriverHandler;
import ru.saraev.listeners.AfterTestListener;
import ru.saraev.providers.DataProvider;
import ru.saraev.utils.DriverUtils;

@ExtendWith(AfterTestListener.class)
public abstract class BaseTest {

    public void setUp() {
        DriverHandler.createDriver();
        DriverUtils.setWindowSizeMaximize();
        DriverUtils.open(DataProvider.HOST);
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        DriverHandler.driverQuit();
    }
}
