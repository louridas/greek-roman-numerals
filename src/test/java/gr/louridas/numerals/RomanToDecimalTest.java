package gr.louridas.numerals;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanToDecimalTest {

    @Parameters(name = "{index}: RomanToDecimal({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {         
            { "I", 1 },
            { "IV", 4},
            { "VIII", 8 }, 
            { "IX", 9 }, 
            { "XIII", 13 },
            { "XLII", 42 },  
            { "XLIX", 49 }, 
            { "XCIX", 99 },
            { "C", 100 },
            { "DCLXVI", 666 },
            { "DCCCLXXXVIII", 888 },
            { "CMXCIX", 999 }  
        });
    }
    private String input;
    private int expected;

    public RomanToDecimalTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testConversion() {
        RomanNumeral romanNumeral = new RomanNumeral(input);
        assertEquals(expected, romanNumeral.getValue()); 
    }
}
