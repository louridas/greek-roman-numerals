package gr.louridas.numerals;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DecimalToRomanTest {

    @Parameters(name = "{index}: DecimalToRoman({0})={1}")
    public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {  
	    { 1, "I" },
	    { 4, "IV" },
	    { 8, "VIII" }, 
	    { 9, "IX" }, 
	    { 13, "XIII" },
	    { 42, "XLII" },  
	    { 49, "XLIX" }, 
	    { 99, "XCIX" },
	    { 100, "C" },
	    { 666, "DCLXVI" },
	    { 888, "DCCCLXXXVIII" },
	    { 999, "CMXCIX" }
	});
    }
    private int input;
    private String expected;

    public DecimalToRomanTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testConversion() {
        RomanNumeral romanNumeral = new RomanNumeral(input);
        assertEquals(expected, romanNumeral.toString());
    }
}
