package revature.MavenCalculator;

import java.math.BigDecimal;

public class Calculator implements CalcInterface {

	/*
	 * These methods are pretty self explanatory. I added a round function to account for
	 * long decimal numbers.
	 * */
	
	@Override
	public double add(double x, double y) {
		
		double sum = round(x + y);
		return sum;
	}

	@Override
	public double subtract(double x, double y) {
		
		double difference = round(x - y);
		return difference;
	}

	@Override
	public double multiply(double x, double y) {
		
		double product = round(x * y);
		return product;
	}

	@Override
	public double divide(double x, double y) {
		
		double quotient = round(x / y);
		return quotient;
	}

	@Override
	public double modulo(double x, double y) {
		
		double remainder = round(x % y);
		return remainder;
	}

	@Override
	public double calculate(String cleanedEquation) {
		
		/*
		 * TODO:
		 * Add multiple operations (with order of operations obviously)
		 * Continue operations from previous result
		 * */
		
		// Will hold array of two factors (probably wrong term but computers don't care) of equation
		double[] variables;
		
		// Holds output to return
		double output = 0;
		
		// String.contains() method checks for operator
		// I'm going to have to refactor this logic when adding multiple operations
		try {
			if (cleanedEquation.contains("+")) {
				
				// Utilizes helper function
				variables = CleanUpScannerInput.splitEquation(cleanedEquation, "+");
				output = add(variables[0], variables[1]);
				
			} else if (cleanedEquation.contains("-")) {
				
				variables = CleanUpScannerInput.splitEquation(cleanedEquation, "-");
				output = subtract(variables[0], variables[1]);
				
			} else if (cleanedEquation.contains("*")) {
				
				variables = CleanUpScannerInput.splitEquation(cleanedEquation, "*");
				output = multiply(variables[0], variables[1]);
				
			} else if (cleanedEquation.contains("/")) {
				
				variables = CleanUpScannerInput.splitEquation(cleanedEquation, "/");
				output = divide(variables[0], variables[1]);
			
			} else {
			
				variables = CleanUpScannerInput.splitEquation(cleanedEquation, "%");
				output = modulo(variables[0], variables[1]);
			}
			
			return output;
		} catch (Exception CalculatingException) {
			
			throw CalculatingException;
		}
			
	}

	@Override
	public double round(double variable) {
		
		// Rounding function for long doubles.
		// this variable sets how many decimal places to round to
		int round = 2;
		
		// rounding formula found from <https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/>
		variable = Math.round(variable*Math.pow(10,round))/Math.pow(10,round);
		
		// convert double to string for bd variable
		String roundedString = String.valueOf(variable);
		
		// BigDecimal Class object <https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html>
		BigDecimal bd = new BigDecimal(roundedString);
		
		// strips trailing zeros then converts to a (double)
		double finalValue = bd.stripTrailingZeros().doubleValue();
		
		return finalValue;
	}
	
    
}
