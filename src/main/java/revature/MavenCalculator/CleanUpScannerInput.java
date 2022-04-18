package revature.MavenCalculator;

public class CleanUpScannerInput {
	
	/*
	 * This class will edit data inputed from scanner and stings for calculate function
	 * This will probably be the parent of Scanner class to inherent cleaning of input
	 * Primarily uses regex in String.split() method to get rid of unwanted characters.
	 * */
		
	public static String cleanEquation(String scannerInput) {
		
		// cleaned equation holder
		String cleanedOutput = new String();
		
		// checks if the user wants to quit
		if (scannerInput.equals("quit")) {
			
			cleanedOutput = "quit";
			
		// check if the user only inputed alphabetical characters
		} else if (scannerInput.matches("[a-zA-Z]+")) {
			
			cleanedOutput = "Invalid Input";
			
		} else {
			
			// We use String.split() to remove unwanted characters to loop over the result 
			String[] stringArr = scannerInput.split("[\\sa-zA-Z_,;:'\"@&$#^!()]");
			
			// Loop over the created array with wanted characters strings
			for (String i : stringArr) {
				
				//concatenate strings to cleanedOutput variable
				cleanedOutput += i;
			}
		}
		
		return cleanedOutput;
	}
	
	// Helper function to split up equation for Calculator.calculate function
	// TODO: overload this method to account for a continued operation with previous result
	public static double[] splitEquation(String equation, String operator) {
		
		//Since string.split() takes in regex need to add escape character in order for this to work
		String[] variables = equation.split("\\" + operator);
		double x = Double.parseDouble(variables[0]);
		double y = Double.parseDouble(variables[1]);
		double[] output = {x, y};
		
		return output;
	}

}
