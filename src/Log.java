/*
 * Idan Twito
 * 311125249
 */

import java.util.Map;

/**
 * Log extends BinaryExpression and implements Expression. it indicates the Logarithm of an expression.
 * the left expression indicates the base and right expression is the result.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Log extends BinaryExpression implements Expression {

    /**
     * Constructor.
     *
     * @param leftExpression  first Expression
     * @param rightExpression second Expression
     */
    public Log(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    /**
     * Constructor.
     *
     * @param leftExpression first Expression
     * @param var            second Expression
     */
    public Log(Expression leftExpression, String var) {
        super(leftExpression, var);
    }

    /**
     * Constructor.
     *
     * @param var            first Expression
     * @param leftExpression second Expression
     */
    public Log(String var, Expression leftExpression) {
        super(var, leftExpression);
    }

    /**
     * Constructor.
     *
     * @param var1 first Expression
     * @param var2 second Expression
     */
    public Log(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * Constructor.
     *
     * @param var1 first Expression
     * @param num  second Expression
     */
    public Log(String var1, double num) {
        super(var1, num);
    }

    /**
     * Constructor.
     *
     * @param num  first Expression
     * @param var1 second Expression
     */
    public Log(double num, String var1) {
        super(num, var1);
    }

    /**
     * Constructor.
     *
     * @param num1 first Expression
     * @param num2 second Expression
     */
    public Log(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * Constructor.
     *
     * @param num1           first Expression
     * @param leftExpression second Expression
     */
    public Log(double num1, Expression leftExpression) {
        super(num1, leftExpression);
    }

    /**
     * Constructor.
     *
     * @param leftExpression first Expression
     * @param num1           second Expression
     */
    public Log(Expression leftExpression, double num1) {
        super(leftExpression, num1);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment TreeMap which maps values to variables in expressions.
     * @return the result of Logarithm of this expressions
     * @throws Exception - if the base of the log == 1 or <= 0. and if the result <= 0.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double base = this.getExp1().evaluate(assignment);
        double result = this.getExp2().evaluate(assignment);
        if (base <= 0 || base == 1) {
            throw new Exception("ERROR - invalid logarithm base");
        }
        if (result <= 0) {
            throw new Exception("ERROR - invalid logarithm result");
        }
        return (Math.log10(result)) / (Math.log10(base));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return String.
     */
    public String toString() {
        return ("log(" + this.getExp1().toString() + ", " + this.getExp2().toString() + ")");
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
        return new Log(this.getExp1().assign(var, expression), this.getExp2().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return deriative Expression
     */
    public Expression differentiate(String var) {
        Log log1 = new Log(new Var("e"), this.getExp2());
        Log log2 = new Log(new Var("e"), this.getExp1());
        Expression e1 = new Mult(log1.lnDerivative(var), log2);
        Expression e2 = new Mult(log2.lnDerivative(var), log1);
        Expression e3 = new Pow(log2, new Num(2));
        return new Div(new Minus(e1, e2), e3);
    }

    /**
     * this function assists calculating the deriative. helps differentiate Function.
     *
     * @param var - we calculate the deriative relating to this Var.
     * @return the deriative of Log log1/Log2.
     */
    public Expression lnDerivative(String var) {
        return new Div(this.getExp2().differentiate(var), this.getExp2());
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
            return new Num(new Log(leftExp, rightExp).evaluate());
        } catch (Exception exception) {
            //log(x, x) = 1
            if (leftExp.toString().equals(rightExp.toString())) {
                return new Num(1);
            }
            return new Log(leftExp, rightExp);
        }
    }
}
