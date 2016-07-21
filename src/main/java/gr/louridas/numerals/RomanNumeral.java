package gr.louridas.numerals;

import java.util.Hashtable;
import java.util.Map;

public class RomanNumeral extends Numeral {
    private static char characters[] = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };

    public static final Map<Character, Integer> SYMBOLS = 
       new Hashtable<Character, Integer>();
    static {
        SYMBOLS.put('I', 1);
        SYMBOLS.put('V', 5);
        SYMBOLS.put('X', 10);
        SYMBOLS.put('L', 50);
        SYMBOLS.put('C', 100);
        SYMBOLS.put('D', 500);
        SYMBOLS.put('M', 1000);
    }
    
    private String roman;

    public RomanNumeral(int value) {
        super(value);
        this.roman = decimalToRoman(value);
    }
    
    public RomanNumeral(String roman) {
        this.roman = roman;
        int value = romanToDecimal(roman);
        setValue(value);
    }

    static int romanToDecimal(String roman) {
        int total_val = 0;
        int prev_val = 0;
        int cur_val = 0;
        int len = roman.length();
        for (int i = len - 1; i >= 0; i--) {
            prev_val = cur_val;
            cur_val = SYMBOLS.get(roman.charAt(i));
            if (cur_val < prev_val) {
                cur_val = -cur_val;
            }
            total_val += cur_val;
        }
        return total_val;
    }

    static String decimalToRoman(int decimal) {

        StringBuffer romanBuf = new StringBuffer();
        int romanIndex = 0; // start index in the characters array
        while (decimal > 0) {
            /* Convert each decimal digit to a different Roman numeral */
            StringBuffer chunk = new StringBuffer();
            int remainder = decimal % 10;
            if (remainder >= 5) {
                if (remainder == 9) {
                    chunk.insert(0, characters[romanIndex + 2]);
                    chunk.insert(0, characters[romanIndex]);
                } else {
                    chunk.insert(0, characters[romanIndex + 1]);
                    remainder -= 5;
                    for (int i = 0; i < remainder; i++) {
                        chunk.append(characters[romanIndex]);
                    }
                }
            } else {
                if (remainder == 4) {
                    chunk.insert(0, characters[romanIndex + 1]);
                    chunk.insert(0, characters[romanIndex]);
                } else {
                    for (int i = 0; i < remainder; i++) {
                        chunk.append(characters[romanIndex]);
                    }
                }
            }
            /* 
             * Prepend to the final result the Roman numeral for the 
             * current digit 
             */
            romanBuf.insert(0, chunk);
            romanIndex += 2;
            decimal /= 10;
        }
        return romanBuf.toString();
    }

    public String toString() {
        return this.roman;
    }
}
