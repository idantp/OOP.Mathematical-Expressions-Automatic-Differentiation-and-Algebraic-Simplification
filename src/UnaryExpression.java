/*
 * Idan Twito
 * 311125249
 */

import java.util.ArrayList;
import java.util.List;

/**
 * UnaryExpression indicates unary expressions such Sin,Cos,Neg. it's an abstract class which
 * extends BaseExpression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression expression;

    /**
     * Constructor.
     *
     * @param expression - Expression Interface.
     */
    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Constructor.
     *
     * @param num - Num Object
     */
    public UnaryExpression(double num) {
        this.expression = new Num(num);
    }

    /**
     * Constructor.
     *
     * @param var - Var Object
     */
    public UnaryExpression(String var) {
        this.expression = new Var(var);
    }

    /**
     * return this Expression.
     *
     * @return this.expression
     */
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List<String> varsList varsFinalList
     */
    public List<String> getVariables() {
        List<String> varsList = this.expression.getVariables();
        //this list makes sure there are no duplications
        List<String> varsFinalList = new ArrayList<String>();
        //making sure we remove all the duplicated variables
        for (String string : varsList) {
            if (!(varsFinalList.contains(string))) {
                varsFinalList.add(string);
            }
        }
        return varsFinalList;
    }
}
