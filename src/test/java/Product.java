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
@Title("Тестирование умножения")
@RunWith(Parameterized.class)
public class Product extends Operations{

    public Product(int operand1, int operand2, double result) {
        super(operand1, operand2, result);
    }

    @Parameterized.Parameters
    public static Collection initialize() throws IOException{
        return TestSuite.getData().prodArgs;
    }

    @Test
    @Step("Проверка результата")
    @Title("Тестирование равенства ожидаемого и вычисленного результата умножения")
    public void multiply() {
        assertEquals(result, multiply(operand1,operand2), 0);
    }

    @Step("Умножение {0} и {1}")
    private double multiply(int arg1, int arg2)
    {
        return arg1*arg2;
    }
}
