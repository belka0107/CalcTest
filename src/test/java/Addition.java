import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by liza on 22.09.15.
 */
@Title("Тестирование суммирования")
@RunWith(Parameterized.class)
public class Addition extends Operations {

    public Addition(long operand1, long operand2, double result) {
        super(operand1, operand2, result);
    }

    @Parameterized.Parameters
    public static Collection initialize() throws IOException{
        List<Object> args = Data.getArgs('+');
        return args;

    }

    @Test
    @Step("Проверка результата")
    @Title("Тестирование равенства ожидаемого и вычисленного результата сложения")
    public void add() {
        assertEquals(result, sum(operand1, operand2), 0);
    }

    @Step("Суммирование {0} и {1}")
    private double sum(long arg1, long arg2)
    {
        return arg1+arg2;
    }
}
