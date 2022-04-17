package revature.MavenCalculator;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		boolean run = true; // for some reason a boolean wasn't breaking the loop when changed to false
		
		double previous = 0;
		
		//Welcome message and usage info
		System.out.println("Welcome Human! This is the Maven Calculator App!\n"
				+ "Enter \"quit\" at anytime to exit.\n");
		
		// Instantiate classes
		Calculator calc = new Calculator();
		Scanner sc = new Scanner(System.in);
		String equation = new String();
		double result;
		
		
		// Runs until user quits app
		while (run) {
			
			// Default functionality
			if (previous == 0) {
				
				System.out.print("Equation: ");
				
				// Pulls from scanner
				equation = sc.nextLine();
				
				// Checks if user wants to quit
				if (equation.equals("quit")) {
					
					System.out.println("Goodbye Human!");
					run = false;
					break;
				}
				
				result = calc.calculate(equation);
				
				// Set previous value to current result
				previous = result;
				System.out.print("=" + result + " : ");
				
			//TODO Include previous result in operation
			// This runs for the second operation and onward
			} else {
				
				equation = sc.nextLine();
				
				if (equation.equals("quit")) {
					
					System.out.println("Goodbye Human!");
					run = false;
					break;
				}
				
				result = calc.calculate(equation);
				previous = result;
				System.out.print("=" + result + " : ");
			}
			
			// Checks if run is false
			if (!run) {
				break;
			}
		}
	}
}
