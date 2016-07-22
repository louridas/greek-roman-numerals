package gr.louridas.numerals;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Numerals app. Handles numbers in Greek, Roman, and decimal
 * notation and carries out simple operations.
 *
 */
public class Numerals {
    
    public static Numeral convertToNumeral(String numeral) {
        for (int i = 0; i < numeral.length(); i++) {
            if (RomanNumeral.SYMBOLS.containsKey(numeral.charAt(i))) {
                RomanNumeral romanNumeral = new RomanNumeral(numeral);
                return romanNumeral;
            }
            if (GreekNumeral.SYMBOLS.containsKey(numeral.charAt(i))) {
                GreekNumeral greekNumeral = new GreekNumeral(numeral);
                return greekNumeral;
            } 
        }
        return new Numeral(Integer.parseInt(numeral));
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
            Numeral firstOperand = convertToNumeral(parts[0]);
            Numeral result = firstOperand;
            if (parts.length > 1) {
                Numeral secondOperand = convertToNumeral(parts[2]);
                switch (parts[1]) {
                case "+":
                    result = firstOperand.add(secondOperand);
                    break;
                case "-":
                    result = firstOperand.subtract(secondOperand);
                    break;
                case "*":
                    result = firstOperand.multiply(secondOperand);
                    break;
                case "/":
                    result = firstOperand.divide(secondOperand);
                    break;
                }
            }
            System.out.format("%d %s %s\n", result.getValue(), 
                new GreekNumeral(result.getValue()), 
                new RomanNumeral(result.getValue()));
            System.out.print(">> " );
        }
        sc.close();
    }
}
