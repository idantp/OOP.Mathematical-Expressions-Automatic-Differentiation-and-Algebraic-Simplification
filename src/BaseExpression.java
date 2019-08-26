/*
 * Idan Twito
 * 311125249
 */

import java.util.TreeMap;

/**
 * BaseExpression is the the Super-Class in the inheritance of this task. it's an abstract class which
 * implements Expression interface.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public abstract class BaseExpression implements Expression {
    /**
     * In this function we evaluate expressions.
     *
     * @return - the expressions evaluation.
     * @throws Exception - the function can throw an exception.
     */
    public double evaluate() throws Exception {
        return evaluate(new TreeMap<>());

    }
}
