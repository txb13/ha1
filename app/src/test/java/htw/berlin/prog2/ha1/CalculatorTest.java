package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {



    @Test
    @DisplayName("Should not display -0")
     void testNegativZero(){
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(0);
        calculator.pressBinaryOperationKey("-");

        String expected = "0";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    @Test
    @DisplayName("should display the correct result for percentage calculation")
    void testPercentage() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(8);
        calculator.pressDigitKey(0);
        calculator.pressUnaryOperationKey("%");

        String expected = "0.8";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display the correct result for negative percentage calculation")
    void testNegativePercentage() {
        Calculator calculator = new Calculator();


        calculator.pressDigitKey(8);
        calculator.pressNegativeKey();
        calculator.pressUnaryOperationKey("%");

        String expected = "-0.08";
        String actual = calculator.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should display an empty display")
    void testClearKey(){
        Calculator calculator = new Calculator();

        String test = calculator.readScreen();
        calculator.pressDigitKey(5);
        calculator.pressClearKey();

        String actual = calculator.readScreen();
        assertEquals(test, actual);
    }
    @Test
    @DisplayName("Should display maximum of 10 digits")
    void testMultipleDigitKey(){
        Calculator calculator = new Calculator();

        for (int i = 0; i < 13; i++) {
            calculator.pressDigitKey(5);
        }

        String expected = "5555555555";
        String actual = calculator.readScreen();
        assertEquals(expected, actual);
    }
}

