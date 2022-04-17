package revature.MavenCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/*
 * 
 * This test class tests the methods of the calculator class.
 * Each test method checks for different types of input, and if the math checks out.
 * */
public class CalculatorTest 
{
	Calculator calc = new Calculator();
	CleanUpScannerInput cleanUp = new CleanUpScannerInput();
	
	@Test
	public void testAdd() {
		 
		assertEquals(calc.add(11, 5), 16);
		assertEquals(calc.add(-1, 3), 2);
		assertEquals(calc.add(4, -2), 2);
		assertEquals(calc.add(-1, -3), -4);
		assertEquals(calc.add(2, 0), 2);
		assertEquals(calc.add(2.1, 1.3), 3.4);
		assertEquals(calc.add(2.3, 2), 4.3);
		assertEquals(calc.add(2, 2.3), 4.3);

		
	}
	
	@Test
	public void testSubtract() {
		
		assertEquals(calc.subtract(11, 5), 6);
		assertEquals(calc.subtract(5, 11), -6);
		assertEquals(calc.subtract(-2, 3), -5);
		assertEquals(calc.subtract(3, -2), 5);
		assertEquals(calc.subtract(-11, -5), -6);
		assertEquals(calc.subtract(2.5, 1.1), 1.4);
		assertEquals(calc.subtract(2.3, 5), -2.7);
		assertEquals(calc.subtract(11, 5.1), 5.9);
		assertEquals(calc.subtract(11, 0), 11);
		
	}
	
	@Test
	public void testMultiply() {
		
		assertEquals(calc.multiply(11, 5), 55);
		assertEquals(calc.multiply(11, -5), -55);
		assertEquals(calc.multiply(-11, -5), 55);
		assertEquals(calc.multiply(2.2, 5), 11);
		assertEquals(calc.multiply(4, 2.43), 9.72);
		assertEquals(calc.multiply(2.3, 1.3), 2.99);
		assertEquals(calc.multiply(11, 0), 0);
		assertEquals(calc.multiply(11, 1), 11);

	}
	
	@Test
	public void testDivide() {
		
		assertEquals(calc.divide(4, 2), 2);
		assertEquals(calc.divide(2, 4), 0.5);
		assertEquals(calc.divide(5, 2), 2.5);
		assertEquals(calc.divide(2, 5), 0.4);
		assertEquals(calc.divide(4, 4), 1);
		assertEquals(calc.divide(4.5, 2.6), 1.73);
		assertEquals(calc.divide(0, 5), 0.0);
		assertEquals(calc.divide(6.3, 2), 3.15);
		assertEquals(calc.divide(4, 1.6), 2.5);
		assertEquals(calc.divide(-3, 2), -1.5);
		assertEquals(calc.divide(3, -2), -1.5);
		assertEquals(calc.divide(-2, -1), 2);
		assertEquals(calc.divide(9, 1), 9);
//		assertEquals(calc.divide(4, 0), ???); // I'm not sure how to account for this in testing

	}
	
	@Test
	public void testModulo() {
		
		assertEquals(calc.modulo(10, 9), 1.0);
		assertEquals(calc.modulo(9, 10), 9.0);
		assertEquals(calc.modulo(-10, 9), -1.0);
		assertEquals(calc.modulo(9, -12), 9.0);
		assertEquals(calc.modulo(-9, -2), -1.0);
		// I would add more but my understanding of modulo laws are limited
		
	}
	
	@Test
	public void testCalculate() {
		
		assertEquals(calc.calculate("5 + 5"), 10);
		assertEquals(calc.calculate("5 - 3"), 2);
		assertEquals(calc.calculate("5 * 3"), 15);
		assertEquals(calc.calculate("6 / 2"), 3);
		assertEquals(calc.calculate("5+3"), 8);
		assertEquals(calc.calculate("5 -3"), 2);
		assertEquals(calc.calculate("5* 3"), 15);
		assertEquals(calc.calculate(" 10 % 9 "), 1);
		assertEquals(calc.calculate("0121 + 4"), 125);
		assertEquals(calc.calculate("2.3 * 1.3"), 2.99);
		assertEquals(calc.calculate("0 - 2"), -2);
		assertEquals(calc.calculate("2.1+1.3"), 3.4);
		
	}
	
	@Test
	public void testRound() {
		
		assertEquals(calc.round((2.3 * 1.3)), 2.99);
		assertEquals(calc.round((2.1 + 1.3)), 3.4);
		assertEquals(calc.round(4 / 2), 2);
		assertEquals(calc.round(0 - 2), -2);
		assertEquals(calc.round(10 % 9), 1);
		
	}
	
	// This test will fail unless cleanEquation() line in Calculator.calculate()
	//   is uncommented.
	@Test
	public void testCleanUpInput() {
		
		assertEquals(cleanUp.cleanEquation("5 + 5"), "5+5");
		assertEquals(cleanUp.cleanEquation("5-5"), "5-5");
		assertEquals(cleanUp.cleanEquation("    4    73 * 8"), "473*8");
		assertEquals(cleanUp.cleanEquation("5nk/2  "), "5/2");
		assertEquals(cleanUp.cleanEquation("1@0%'9"), "10%9");
		
	}
	
	@BeforeEach
	public void beforeEach() {
		assertNotNull(calc);
	}
}
