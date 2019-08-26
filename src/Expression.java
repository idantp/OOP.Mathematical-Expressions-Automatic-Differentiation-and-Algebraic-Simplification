/*
 * Idan Twito
 * 311125249
 */

import java.util.List;
import java.util.Map;

/**
 * Expression interface can define an unary and binary expressions such as plus minus,sinus, power etc.
 * we can evaluate expressions, calculate their deriative, assign numbers to their variables and
 * simplify them.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public interface Expression {

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment TreeMap which maps values to variables in expressions.
     * @return the result of the given expression
     * @throws Exception throws an exception when an ERROR occures.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the result of the given expression
     * @throws Exception throws an exception for an empty assignment
     */
    double evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List<String>
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     *
     * @return a String
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the Var we want to replace with the provided expression
     * @param expression the expression we replace with var
     * @return the new Expression after the assignment
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return the deriative Expression
     */
    Expression differentiate(String var);

    /**
     * Returns a simplified version of the current expression.
     *
     * @return a simplified Expression
     */
    Expression simplify();

}
