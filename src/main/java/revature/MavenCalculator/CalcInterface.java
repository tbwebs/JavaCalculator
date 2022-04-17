package revature.MavenCalculator;
/*
 * I chose to return all methods as (double) for now but I could overload methods to account for int's.
 * */
public interface CalcInterface {

	double add(double x, double y);
	
	double subtract(double x, double y);
	
	double multiply(double x, double y);
	
	double divide(double x, double y);
	
	double modulo(double x, double y);
	
	double calculate(String input);
	
	double round(double x);
	
}
