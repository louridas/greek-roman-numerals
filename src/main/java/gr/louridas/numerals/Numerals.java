package gr.louridas.numerals;

import java.util.Scanner;

/**
 * Numerals app.
 *
 */
public class Numerals {
    
    public static int convertToDecimal(String numeral) {
        for (int i = 0; i < numeral.length(); i++) {
            if (RomanNumeral.SYMBOLS.containsKey(numeral.charAt(i))) {
                return RomanNumeral.romanToDecimal(numeral);
            }
            if (GreekNumeral.SYMBOLS.containsKey(numeral.charAt(i))) {
                return GreekNumeral.greekToDecimal(numeral);
            } 
        }
        return Integer.parseInt(numeral);
    }
    
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
        String line = null;
        System.out.print(">> " );
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] parts = line.split("\\s");
            int firstOperand = convertToDecimal(parts[0]);
            int result = firstOperand;
            if (parts.length > 1) {
                int secondOperand = convertToDecimal(parts[2]);
                switch (parts[1]) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    result = firstOperand / secondOperand;
                    break;
                }
            }
            System.out.format("%d %s %s\n", result, 
                new GreekNumeral(result), 
                new RomanNumeral(result));
            System.out.print(">> " );
        }
        sc.close();
    }
}
