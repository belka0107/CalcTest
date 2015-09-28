import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liza on 27.09.15.
 */
public class Data {

    public static Set<Object[]> getArgs() {

        try {
            ClassLoader classLoader = Data.class.getClassLoader();

            InputStream is = new FileInputStream(new File(classLoader.getResource("data").getFile()));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            Set<Object[]> results = br.lines()
                    .filter(r -> !r.equals(""))
                    .map(r -> {
                        String[] s = r.split(";");
                        Object[] pars = new Object[4];

                        for (int i = 0; i < s.length; i++) {
                            if (i <= 1)
                                pars[i] = Long.parseLong(s[i]);
                            else if (i == 3) {
                                pars[i] = Double.parseDouble(s[i].replace(',', '.'));
                            }
                            else if( i == 2)
                                pars[i] = s[i];
                        }
                        return pars;
                    })
                    .collect(Collectors.toSet());

            return results;
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
