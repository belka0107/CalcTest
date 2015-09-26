import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by liza on 22.09.15.
 */
@Title("Тестирование вычитания")
@RunWith(Parameterized.class)
public class Subtraction extends Operations{

    public Subtraction(int operand1, int operand2, double result) {
        super(operand1, operand2, result);
    }

    @Parameterized.Parameters
    public static Collection initialize() throws IOException{
        return TestSuite.getData().subArgs;
    }

    @Test
    @Step("Проверка результата")
    @Title("Тестирование равенства ожидаемого и вычисленного результата вычитания")
    public void subtract() {
        assertEquals(result, subtract(operand1, operand2), 0);
    }

    @Step("Вычитание {1} из {0}")
    private double subtract(int arg1, int arg2)
    {
        return arg1-arg2;
    }
}
