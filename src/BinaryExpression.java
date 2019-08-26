/*
 * Idan Twito
 * 311125249
 */

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryExpression indicates binary expressions such plus,minus,power etc. it's an abstract class which
 * extends BaseExpression.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public abstract class BinaryExpression extends BaseExpression {
    //members
    private Expression leftExpression;
    private Expression rightExpression;

    /**
     * Constructor.
     *
     * @param leftExpression  first Expression
     * @param rightExpression second Expression
     */
    public BinaryExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    /**
     * Constructor.
     *
     * @param leftExpression first Expression
     * @param var            second Expression
     */
    public BinaryExpression(Expression leftExpression, String var) {
        this.leftExpression = leftExpression;
        this.rightExpression = new Var(var);
    }

    /**
     * Constructor.
     *
     * @param var            first Expression
     * @param leftExpression second Expression
     */
    public BinaryExpression(String var, Expression leftExpression) {
        this.leftExpression = new Var(var);
        this.rightExpression = leftExpression;
    }

    /**
     * Constructor.
     *
     * @param var1 first Expression
     * @param var2 second Expression
     */
    public BinaryExpression(String var1, String var2) {
        this.leftExpression = new Var(var1);
        this.rightExpression = new Var(var2);
    }

    /**
     * Constructor.
     *
     * @param var1 first Expression
     * @param num  second Expression
     */
    public BinaryExpression(String var1, double num) {
        this.leftExpression = new Var(var1);
        this.rightExpression = new Num(num);
    }

    /**
     * Constructor.
     *
     * @param num  first Expression
     * @param var1 second Expression
     */
    public BinaryExpression(double num, String var1) {
        this.leftExpression = new Num(num);
        this.rightExpression = new Var(var1);
    }

    /**
     * Constructor.
     *
     * @param num1 first Expression
     * @param num2 second Expression
     */
    public BinaryExpression(double num1, double num2) {
        this.leftExpression = new Num(num1);
        this.rightExpression = new Num(num2);
    }

    /**
     * Constructor.
     *
     * @param num1           first Expression
     * @param leftExpression second Expression
     */
    public BinaryExpression(double num1, Expression leftExpression) {
        this.leftExpression = new Num(num1);
        this.rightExpression = leftExpression;
    }

    /**
     * Constructor.
     *
     * @param leftExpression first Expression
     * @param num1           second Expression
     */
    public BinaryExpression(Expression leftExpression, double num1) {
        this.leftExpression = leftExpression;
        this.rightExpression = new Num(num1);
    }

    /**
     * return the first Expression.
     *
     * @return return this.leftExpression
     */
    public Expression getExp1() {
        return this.leftExpression;
    }

    /**
     * return the second Expression.
     *
     * @return return this.rightExpression
     */
    public Expression getExp2() {
        return this.rightExpression;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return List<String> varsList varsFinalList
     */
    public List<String> getVariables() {
        List<String> leftExpressionVarsList = this.leftExpression.getVariables();
        List<String> rightExpressionVarsList = this.rightExpression.getVariables();
        //this list makes sure there are no duplications
        List<String> varsFinalList = new ArrayList<String>();
        //making sure we remove all the duplicated variables
        for (String string : leftExpressionVarsList) {
            if (!(varsFinalList.contains(string))) {
                varsFinalList.add(string);
            }
        }
        //making sure we remove all the duplicated variables
        for (String string : rightExpressionVarsList) {
            if (!(varsFinalList.contains(string))) {
                varsFinalList.add(string);
            }
        }
        return varsFinalList;
    }
}