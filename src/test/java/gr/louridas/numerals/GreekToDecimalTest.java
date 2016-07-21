package gr.louridas.numerals;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        String encoding = System.getProperty("file.encoding");
        ClassLoader classLoader = 
            Thread.currentThread().getContextClassLoader();
        String filename = "greek_to_decimal_" + encoding + ".txt";
        String pathString = 
            classLoader.getResource(filename).getFile();
        List<Object[]> testData = new LinkedList<Object[]>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathString), 
                Charset.forName(encoding));
            for (String line: lines) {
                String[] pair = line.split(" ");
                testData.add(new Object[]{ 
                    pair[0], Integer.parseInt(pair[1])
                });
            }
        } catch (IOException e) {
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
        assertEquals(expected, GreekNumeral.greekToDecimal(input)); 
    }
}
