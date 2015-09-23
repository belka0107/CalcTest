import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static org.junit.Assert.assertEquals;

/**
 * Created by liza on 22.09.15.
 */
@Title("This is our cool test suite")
public class SimpleTest {

    @Title("Simple test title")
    @Test
    public void SimpleTest()
    {
        assertEquals(1, 1);
    }
}
