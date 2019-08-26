/*
 * Idan Twito
 * 311125249
 */

import java.util.Map;

/**
 * Div extends BinaryExpression and implements Expression. it indicates the Division of 2 expressions.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Div extends BinaryExpression implements Expression {

    /**
     * Constructor.
     *
     * @param leftExpression  first Expression
     * @param rightExpression second Expression
     */
    public Div(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    /**
     * Constructor.
     *
     * @param leftExpression first Expression
     * @param var            second Expression
     */
    public Div(Expression leftExpression, String var) {
        super(leftExpression, var);
    }

    /**
     * Constructor.
     *
     * @param var            first Expression
     * @param leftExpression second Expression
     */
    public Div(String var, Expression leftExpression) {
        super(var, leftExpression);
    }

    /**
     * Constructor.
     *
     * @param var1 first Expression
     * @param var2 second Expression
     */
    public Div(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * Constructor.
     *
     * @param var1 first Expression
     * @param num  second Expression
     */
    public Div(String var1, double num) {
        super(var1, num);
    }

    /**
     * Constructor.
     *
     * @param num  first Expression
     * @param var1 second Expression
     */
    public Div(double num, String var1) {
        super(num, var1);
    }

    /**
     * Constructor.
     *
     * @param num1 first Expression
     * @param num2 second Expression
     */
    public Div(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * Constructor.
     *
     * @param num1           first Expression
     * @param leftExpression second Expression
     */
    public Div(double num1, Expression leftExpression) {
        super(num1, leftExpression);
    }

    /**
     * Constructor.
     *
     * @param leftExpression first Expression
     * @param num1           second Expression
     */
    public Div(Expression leftExpression, double num1) {
        super(leftExpression, num1);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment TreeMap which maps values to variables in expressions.
     * @return the result of division of these expressions
     * @throws Exception - if we divide by 0
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if (this.getExp2().evaluate(assignment) == 0) {
            throw new Exception("ERROR - Division by 0 is not allowed");
        }
        return (this.getExp1().evaluate(assignment) / this.getExp2().evaluate(assignment));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String.
     */
    public String toString() {
        return ("(" + this.getExp1().toString() + " / " + this.getExp2().toString() + ")");
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
        return new Div(this.getExp1().assign(var, expression), this.getExp2().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return deriative Expression
     */
    public Expression differentiate(String var) {
        return new Div(new Minus(new Mult(this.getExp1().differentiate(var), (this.getExp2())),
                new Mult(this.getExp1(), this.getExp2().differentiate(var))),
                new Pow(this.getExp2(), new Num(2)));
    }

    /**
     * Returns a simplified version of the current expression.
     *
     * @return new simplified expression
     */
    public Expression simplify() {
        Expression leftExp = this.getExp1().simplify();
        Expression rightExp = this.getExp2().simplify();
        try {
            return new Num(new Div(leftExp, rightExp).evaluate());
        } catch (Exception exception) {
            // 0/X = 0
            if (leftExp.toString().equals("0.0")) {
                return new Num(0);
            }
            //X/X = 1
            if (leftExp.toString().equals(rightExp.toString())) {
                return new Num(1);
            }
            //X/1 = X
            if (rightExp.toString().equals("1.0")) {
                return leftExp;
            }
        }
        return new Div(leftExp, rightExp);
    }
}
