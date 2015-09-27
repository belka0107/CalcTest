import ru.yandex.qatools.allure.annotations.Parameter;

/**
 * Created by liza on 26.09.15.
 */
public abstract class Operations {

    @Parameter("First operand")
    long operand1;
    @Parameter("Second operand")
    long operand2;
    @Parameter("Expected result")
    Double result;

    public Operations(long operand1, long operand2, double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }
}
