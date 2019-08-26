/*
 * Idan Twito
 * 311125249
 */

import java.util.Map;

/**
 * Cos extends UnaryExpression and implements Expression. it indicates the cos of an expression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Cos extends UnaryExpression implements Expression {

    /**
     * Constructor.
     *
     * @param expression - Expression Interface.
     */
    public Cos(Expression expression) {
        super(expression);
    }

    /**
     * Constructor.
     *
     * @param num - Num Object
     */
    public Cos(double num) {
        super(num);
    }

    /**
     * Constructor.
     *
     * @param var - Var Object
     */
    public Cos(String var) {
        super(var);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment TreeMap which maps values to variables in expressions.
     * @return the result of cos of this expression
     * @throws Exception - not implemented here
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.cos(Math.toRadians(this.getExpression().evaluate(assignment)));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String.
     */
    public String toString() {
        return "cos(" + this.getExpression().toString() + ")";
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the Var we want to replace with the provided expression
     * @param expression the expression we replace with var
     * @return the new Expression after the assignment
     */
    public Expression assign(String var, Expression expression) {
        return new Cos(this.getExpression().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return deriative Expression
     */
    public Expression differentiate(String var) {
        return new Neg(new Mult(new Sin(this.getExpression()), this.getExpression().differentiate(var)));
    }

    /**
     * Returns a simplified version of the current expression.
     *
     * @return new Cos(expression) simplified
     */
    public Expression simplify() {
        Expression expression = this.getExpression().simplify();
        try {
            return new Num(new Cos(expression).evaluate());
        } catch (Exception exception) {
            return new Cos(expression);
        }
    }
}
