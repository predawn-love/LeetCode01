package basic_functionality;

import org.junit.Test;

public class StringTest {
    @Test
    public void fun() {
        int i = "100".compareTo("001");
        System.out.println(i);

        int i2 = "200".compareTo("001");
        System.out.println(i2);

        int i3 = "100".compareTo("201");
        System.out.println(i3);

        int i4 = "201".compareTo("201");
        System.out.println(i4);
    }
}
