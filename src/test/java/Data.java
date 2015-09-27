import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liza on 27.09.15.
 */
public class Data {

    public static List<Object> getArgs(char oper){
        List<Object> args = new ArrayList<>();
        ClassLoader classLoader = Data.class.getClassLoader();
        File file = new File(classLoader.getResource("data").getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] s = line.split(";");

                if(line.length() == 0 || s[2].indexOf(oper) == -1)
                    continue;

                Object[] pars = new Object[3];

                for(int i=0; i < s.length; i++ )
                {
                    if( i <= 1 )
                        pars[i] = Long.parseLong(s[i]);
                    else if( i == 3 ) {
                        pars[i - 1] = Double.parseDouble(s[i].replace(',', '.'));
                    }
                }

                args.add(pars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return args;
    }
}
