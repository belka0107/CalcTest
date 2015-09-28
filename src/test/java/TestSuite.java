import junit.framework.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static TestSuite instance;
    private Set<Object[]> objects;

    public static synchronized TestSuite getInstance() {
        if (instance == null) {
            instance = new TestSuite();
        }
        return instance;
    }

    public TestSuite()
    {
        objects = Data.getArgs();
    }

    public List<Object[]> getArguments(char oper)
    {
        List<Object[]> result = objects.stream()
                .filter( obj -> obj[2].toString().indexOf(oper) != -1 )
                .map( obj -> new Object[]{obj[0], obj[1], obj[3]})
                .collect(Collectors.toList());

        return result;
    }
}
