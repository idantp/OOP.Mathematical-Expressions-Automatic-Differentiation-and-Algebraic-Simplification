/*
 * Idan Twito
 * 311125249
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class creates Var object which consists of String variable. The class defines a variable in an Expression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class Var implements Expression {
    //member
    private String str;

    /**
     * constructor.
     *
     * @param str - the Var name
     */
    public Var(String str) {
        this.str = str;
    }


    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment - assigns a value to this variable
     * @return - the value of this Var
     * @throws Exception - if this variable does not exist
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if (assignment.containsKey(this.str)) {
            return assignment.get(this.str);
        }
        throw new Exception("ERROR - This variable was not assigned with a value");
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return None
     * @throws Exception - because the assignment is empty
     */
    public double evaluate() throws Exception {
        throw new Exception("ERROR - No variables values were found");
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List<String> variablesList.
     */
    public List<String> getVariables() {
        List<String> variablesList = new ArrayList<String>();
        variablesList.add(this.str);
        return variablesList;
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return this.str
     */
    public String toString() {
        return this.str;
    }


    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the Var we want to replace with the provided expression
     * @param expression the expression we replace with var
     * @return this or Expression expression
     */
    public Expression assign(String var, Expression expression) {
        if (this.str.equals(var)) {
            return expression;
        }
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
        if (var.equals(this.str)) {
            return new Num(1);
        }
        return new Num(0);
    }

    /**
     * Returns a simplified version of the current expression.
     *
     * @return this
     */
    public Expression simplify() {
        return this;
    }
}
