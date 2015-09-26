import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by liza on 22.09.15.
 */
@Title("Тестирование деления")
@RunWith(Parameterized.class)
public class Division extends Operations{
    public Division(int operand1, int operand2, double result) {
        super(operand1, operand2, result);
    }

    @Parameterized.Parameters
    public static Collection initialize() throws IOException{
        return TestSuite.getData().divArgs;
    }

    @Test
    @Step("Проверка результата")
    @Title("Тестирование равенства ожидаемого и вычисленного результата деления")
    public void divide() {
        assertEquals(result, divide(operand1,operand2), 0);
    }

    @Step("Деление {0} на {1}")
    private double divide(int arg1, int arg2)
    {
        return (double)arg1/(double)arg2;
    }
}
