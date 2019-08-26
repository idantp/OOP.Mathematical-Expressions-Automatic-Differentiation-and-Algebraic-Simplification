/*
 * Idan Twito
 * 311125249
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class creates Num object which consists of double variable. The class defines a number in an Expression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Num implements Expression {
    //member
    private double num;

    /**
     * constructor.
     *
     * @param num the value of Num
     */
    public Num(double num) {
        this.num = num;
    }


    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment - mapping the values of variables to numbers
     * @return - this.num
     * @throws Exception - never
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }


    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return - this.num
     * @throws Exception - never
     */
    public double evaluate() throws Exception {
        return this.num;
    }

    /**
     * Returns an  empty list of the variables in the expression.
     *
     * @return new ArrayList<String>()
     */
    public List<String> getVariables() {
        return new ArrayList<String>();
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return - Double.toString(this.num)
     */
    public String toString() {
        return Double.toString(this.num);
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the Var we want to replace with the provided expression
     * @param expression the expression we replace with var
     * @return this
     */
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - we calculate the derivative according to this var
     * @return - the derivative expression
     */
    public Expression differentiate(String var) {
        return new Num(0);
    }

    /**
     * Returns a simplified version of the current expression.
     *
     * @return this Num
     */
    public Expression simplify() {
        return this;
    }
}
