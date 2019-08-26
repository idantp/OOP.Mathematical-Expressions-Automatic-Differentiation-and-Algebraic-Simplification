/*
 * Idan Twito
 * 311125249
 */

import java.util.TreeMap;
import java.util.Map;


/**
 * This Class checks whether the code works or not.
 *
 * @ 05.05.18
 * @ author: Idan Twito
 */
public class ExpressionsTest {
    /**
     * Main method.
     *
     * @param args - Not in use
     */
    public static void main(String[] args) {
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        Expression expression = new Plus(new Plus(new Mult(new Num(2), new Var("x"))
                , new Sin(new Mult(new Num(4), new Var("y")))), new Pow(new Var("e"), new Var("x")));

        System.out.println(expression);

        try {
            System.out.println(expression.evaluate(assignment));
        } catch (Exception exception) {
            System.out.println(exception);
        }
        System.out.println(expression.differentiate("x"));

        try {
            System.out.println(expression.differentiate("x").evaluate(assignment));
        } catch (Exception exception) {
            System.out.println(exception);
        }
        System.out.println(expression.differentiate("x").simplify());
    }
}
