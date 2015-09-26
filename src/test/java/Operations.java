import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by liza on 26.09.15.
 */
public abstract class Operations {

    @Parameter("First operand")
    int operand1;
    @Parameter("Second operand")
    int operand2;
    @Parameter("Expected result")
    double result;

    public Operations(int operand1, int operand2, double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }
}
