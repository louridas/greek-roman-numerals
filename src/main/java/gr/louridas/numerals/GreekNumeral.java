package gr.louridas.numerals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

public class GreekNumeral extends Numeral {

    private static char[] characters;
    public final static Map<Character, Integer> SYMBOLS = 
            new Hashtable<Character, Integer>();
         
    static {
        ClassLoader classLoader = 
             Thread.currentThread().getContextClassLoader();
        InputStream greekFile = 
            classLoader.getResourceAsStream("greek_UTF-8.txt");
        try {
            BufferedReader in = 
                new BufferedReader(new InputStreamReader(greekFile, "UTF-8"));
            characters = in.readLine().toCharArray();
            for (int i = 0; i < characters.length; i++) {
                int power = i / 9;
                int units = i % 9 + 1;
                int value = (int) (units * Math.pow(10,  power));
                SYMBOLS.put(characters[i], value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String greek;

    public GreekNumeral(int value) {
        super(value);
        this.greek = decimalToGreek(value);
    }
    
    public GreekNumeral(String greek) {
        this.greek = greek;
        int value = greekToDecimal(greek);
        setValue(value);
    }
    
    static int greekToDecimal(String greek) {
        int total = 0;
        for (int i = 0; i < greek.length(); i++) {
            total += SYMBOLS.get(greek.charAt(i));
        }
        return total;
    }
    
    static String decimalToGreek(int decimal) {
   
        StringBuffer greekBuf = new StringBuffer();
        int greekIndex = 0; // start index in the characters array
        while (decimal > 0) {
            int remainder = decimal % 10;
            if (remainder != 0) {
                greekBuf.insert(0, characters[greekIndex + remainder - 1]);
            }
            greekIndex += 9;
            decimal /= 10;
        }
        return greekBuf.toString();
    }
    
    public String toString() {
        return this.greek;
    }
}
