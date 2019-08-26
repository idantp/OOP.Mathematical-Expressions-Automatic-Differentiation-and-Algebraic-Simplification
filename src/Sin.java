/*
 * Idan Twito
 * 311125249
 */

import java.util.Map;

/**
 * Sin extends UnaryExpression and implements Expression. it indicates the sin of an expression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Sin extends UnaryExpression implements Expression {

    /**
     * Constructor.
     *
     * @param expression - Expression Interface.
     */
    public Sin(Expression expression) {
        super(expression);
    }

    /**
     * Constructor.
     *
     * @param num - Num Object
     */
    public Sin(double num) {
        super(num);
    }

    /**
     * Constructor.
     *
     * @param var - Var Object
     */
    public Sin(String var) {
        super(var);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment TreeMap which maps values to variables in expressions.
     * @return the result of sin of this expression
     * @throws Exception - not implemented here
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.sin(Math.toRadians(this.getExpression().evaluate(assignment)));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String.
     */
    public String toString() {
        return "sin(" + this.getExpression().toString() + ")";
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
        return new Sin(this.getExpression().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return deriative Expression
     */
    public Expression differentiate(String var) {
        return new Mult(new Cos(this.getExpression()), this.getExpression().differentiate(var));
    }

    /**
     * Returns a simplified version of the current expression.
     *
     * @return new Sin(expression) simplified
     */
    public Expression simplify() {
        Expression expression = this.getExpression().simplify();
        try {
            return new Num(new Sin(expression).evaluate());
        } catch (Exception exception) {
            return new Sin(expression);
        }
    }
}
