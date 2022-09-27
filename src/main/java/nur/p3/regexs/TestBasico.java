package nur.p3.regexs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBasico {
    public static void main(String[] args) {
        final String regex = "[A-z0-9]+@([A-z]+\\.)+[A-z]{2,3}";
        final String string = "jorge@nuevo.com\n"
                + "juan@empresa.com\n"
                + "juan@telecel.com.bo\n"
                + "JaIme\n"
                + "alberto\n"
                + "vcalderon@nur.edu.bo\n"
                + "cebollita21@hotmail.com\n\n";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
