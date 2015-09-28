import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by liza on 22.09.15.
 */
@Title("Тестирование деления")
@RunWith(Parameterized.class)
public class Division extends Operations{
    public Division(long operand1, long operand2, double result) {
        super(operand1, operand2, result);
    }

    @Parameterized.Parameters
    public static Collection initialize() throws IOException{
        return TestSuite.getInstance().getArguments('/');
    }

    @Test
    @Step("Проверка результата")
    @Title("Тестирование равенства ожидаемого и вычисленного результата деления")
    public void divide() {
        assertEquals(result, divide(operand1,operand2), 0.001);
    }

    @Step("Деление {0} на {1}")
    private double divide(long arg1, long arg2)
    {
        return (double)arg1/arg2;
    }
}
