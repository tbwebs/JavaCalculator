# JavaCalculator

This is a console calculator built in Java. This project was originally a simple exercise to practice Test Driven Development on mathematical methods. I took that exercise and made it a little more complex in order to apply concepts learned from my Revature course.

It currently can only handle one operation at a time, and there has to be two numerical variables in order for the calculation to work properly. Despite those limitations it does a good job of parsing the strings and getting rid of unneccissary characters.

## Classes/Methods Overview

#### Driver
 > `main()` method to run the app. Utilizes the `Scanner` class.

#### CalcInterface
> Holds the abstract classes for the Calculator class: `add()`, `subtract()`, `multiply()`, `divide()`, `modulo()`, `calculate()`, and a `round()` method that utilizes the `BigDecimal` class.

#### Calculator
> Holds the implementations of methods from the `CalcInterface` interface. Basically contains all the math for the app.

#### CleanUpScannerInput
> This class holds two methods `cleanEquation()` and `splitEquation()`. These methods help format inputed strings from the user in order to pull appropriate characters for operations.

#### CalculatorTest (located in src/test/java)
> Contains all the tests for the `Calculator` class along with one for the `cleanEquation()` method.

## Future Improvements

- Implement multiple operations for one query.
- Continuing an operation with the previous equations result.
- Implement more tests to account for unintended results (like dividing by 0).
- A way to calculate more operations like variables raised to powers and such.
- Implement a logging (log4j).

# Conclusions

I have a greater understanding of the four pillars of OOP after building this app. I learned how to implement regular expressions as well which seems like a useful tool. I know how to compare strings better now, and the BigDecimal class will be used in the future for sure. Implementing tests was frustrating at first, but very useful once I got the hang of it. It was convenient to be able to test a variety of different inputs with my methods.