package gr.louridas.numerals;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Numerals app. Handles numbers in greek, roman, and decimal
 * notation and carries out simple operations.
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
    
    public static void main(String[] args )
        throws UnsupportedEncodingException, ParseException {
    	Options options = new Options();
    	options.addOption("c", true, "encoding");
    	CommandLineParser parser = new DefaultParser();
    	CommandLine cmd = parser.parse( options, args);
    	String encoding = "UTF-8";
    	if (cmd.hasOption("c")) {
    	   encoding = cmd.getOptionValue("c");
    	}
        Scanner sc = new Scanner(System.in, encoding);
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
