/*
 * Idan Twito
 * 311125249
 */

import java.util.Map;

/**
 * Neg extends UnaryExpression and implements Expression. it indicates negativity of an expression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Neg extends UnaryExpression implements Expression {

    /**
     * Constructor.
     *
     * @param expression - Expression Interface.
     */
    public Neg(Expression expression) {
        super(expression);
    }

    /**
     * Constructor.
     *
     * @param num - Num Object
     */
    public Neg(double num) {
        super(num);
    }

    /**
     * Constructor.
     *
     * @param var - Var Object
     */
    public Neg(String var) {
        super(var);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment TreeMap which maps values to variables in expressions.
     * @return the negative result of this expression
     * @throws Exception - not implemented here
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.getExpression().evaluate(assignment) * (-1);
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String.
     */
    public String toString() {
        return ("(-" + this.getExpression().toString() + ")");
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
        return new Neg(this.getExpression().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return deriative Expression
     */
    public Expression differentiate(String var) {
        return new Neg(this.getExpression().differentiate(var));
    }

    /**
     * Returns a simplified version of the current expression.
     *
     * @return new Sin(expression) simplified
     */
    public Expression simplify() {
        Expression expression = this.getExpression().simplify();
        try {
            return new Num(new Neg(expression).evaluate());
        } catch (Exception exception) {
            return new Neg(expression);
        }
    }
}
