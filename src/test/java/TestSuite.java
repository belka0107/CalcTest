import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liza on 26.09.15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Addition.class,
    Subtraction.class,
    Product.class,
    Division.class
})
public class TestSuite {
    private static Data instance;

    public static Data getData()
    {
        if( instance == null )
            instance = new Data();

        return instance;
    }

    static class Data {

        public List<Object> sumArgs = new ArrayList<>();
        public List<Object> prodArgs = new ArrayList<>();
        public List<Object> subArgs = new ArrayList<>();
        public List<Object> divArgs = new ArrayList<>();

        public Data() {
            ClassLoader classLoader = Data.class.getClassLoader();
            File file = new File(classLoader.getResource("data").getFile());

            try(Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] params = line.split(";");

                    Object[] pars = new Object[]{Integer.valueOf(params[0]),
                            Integer.valueOf(params[1]),
                            Double.valueOf(params[3])};

                    switch (params[2].trim().charAt(0))
                    {
                        case '+':
                            sumArgs.add(pars);
                            break;

                        case '-':
                            subArgs.add(pars);
                            break;

                        case '/':
                            divArgs.add(pars);
                            break;

                        case '*':
                            prodArgs.add(pars);
                            break;
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
