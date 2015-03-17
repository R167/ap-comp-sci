/****************************
 * File: RiemannSum.java
 * 
 * Author: Winston Durand
 * Modified: Mar 16, 2015
 ***************************/
package riemannsums;

import org.nfunk.jep.JEP;

/**
 * @author Winston Durand
 * 
 */
public class RiemannSum {
    private String expression;
    private double lower;
    private double upper;
    private int count;
    private SolveMethod method;

    /**
     * Enter an expression to solve using Riemann sums
     * 
     * @param expression
     *            The mathematical expression
     * @param lower
     *            Lower bounds
     * @param upper
     *            Upper bounds
     * @param count
     *            Number of subsections
     * @param method
     *            Method to use to approximate
     * @throws
     */
    public RiemannSum(String expression, double lower, double upper, int count, SolveMethod method) throws BadlyFormattedExpressionException {
        super();
        String expr = null;
        if (expression.indexOf('=') > -1) {
            expr = expression.replaceFirst("^ *y *=", "");
            expr = expr.replaceFirst("=\\s*y\\s*$", "");
            if (expr.indexOf('=') > -1) {
                throw new BadlyFormattedExpressionException("Too many equals signs/unable to isolate x for equtaion: " + expression);
            }
            expression = expr;
        }
        this.expression = expression;
        this.lower = lower;
        this.upper = upper;
        this.count = count;
        this.method = method;
    }

    public double solve() {
        JEP solver = new JEP();
        double size = (upper - lower) / count;
        
        double running = 0;

        solver.addStandardConstants();
        solver.addStandardFunctions();

        solver.addVariable("x", 0);
        solver.parseExpression(expression);
        
        for (int i = 0; i < count; i++) {
            switch (method) {
            case MIDDLE:
                solver.addVariable("x", lower + size * (i + 0.5));
                break;
            case RIGHT:
                solver.addVariable("x", lower + size * (i + 1));
                break;
            case LEFT:
                solver.addVariable("x", lower + size * i);
                break;
            case TRAPAZOID:
                solver.addVariable("x", lower + size * i);
                break;
            }
            
            if (method == SolveMethod.TRAPAZOID) {
                running += solver.getValue() * (i == 0 ? 1 : 2) * size;
                if (i == count - 1) {
                    solver.addVariable("x", lower + size * (i + 1));
                    running += solver.getValue() * size;
                }
            } else {
                running += solver.getValue() * size;
            }
        }
        
        return running * (method == SolveMethod.TRAPAZOID ? 0.5 : 1);
    }

}
