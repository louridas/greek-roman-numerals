package gr.louridas.numerals;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GreekToDecimalTest {

    @Parameters(name = "{index}: GreekToDecimal({0})={1}")
    public static Collection<Object[]> data() {
        ClassLoader classLoader = 
            Thread.currentThread().getContextClassLoader();
        String filename = "greek_to_decimal_UTF-8.txt";
        InputStream stream = classLoader.getResourceAsStream(filename);
        BufferedReader in;
        List<Object[]> testData = new LinkedList<Object[]>();
        try {
            in = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String line = null;            
            while ((line = in.readLine()) != null) {
                String[] pair = line.split(" ");
                testData.add(new Object[] { 
                    pair[0], Integer.parseInt(pair[1])
                });
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } 
        return testData;
    }
    
    private String input;
    private int expected;

    public GreekToDecimalTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testConversion() {
        GreekNumeral greekNumeral = new GreekNumeral(input);
        assertEquals(expected, greekNumeral.getValue()); 
    }
}
