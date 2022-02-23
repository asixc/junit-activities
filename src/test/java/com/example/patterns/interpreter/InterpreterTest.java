package com.example.patterns.interpreter;

import com.example.demo.behavioral.interpreter.Parser;
import com.example.demo.behavioral.interpreter.expression.Expression;
import com.example.demo.behavioral.interpreter.expression.NumberExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InterpreterTest {

    @Test
    void test1() {
        String formula = "2 + 1 - 2";
        Parser parser = new Parser(formula);

        int result = 0;
        while (!parser.isEmptyOperators()) {
            Expression operator = parser.popOperator();
            result = operator.interpret(parser);
        }
        assertEquals(1, result);
    }

    @Test
    void test2() {
        String formula = "2 + 1";
        Parser parser = new Parser(formula);
        Expression exp = parser.popNumber();
        assertInstanceOf(NumberExpression.class, exp);
        NumberExpression numberExp = (NumberExpression) exp;

    }
}
