/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qroot;

/**
 *
 * @author r0man_000
 */
public class Mathematics {
    public static double[] QuadraticEquation(double a, double b, double c) throws HasNotSolutionException, InfinityNumberOfSolutionsException{
        double[] res = null;
        String eq = a + "x^2 " + (b < 0?"- "+Math.abs(b):"+ "+b) + "x " + (c < 0?"- "+Math.abs(c):"+ "+c);
        double d = b*b - 4*a*c; 
        if (d < 0){
            throw new HasNotSolutionException(eq);
        }else if (d == 0){
            if (a == 0 & b == 0){
                throw new InfinityNumberOfSolutionsException(eq);
            }else{
                double x = (-b + Math.sqrt(d)) / (2*a);
                res = new double[1];
                res[0] = x;
            }
        }else{
            res = new double[2];
            res[0] = (-b + Math.sqrt(d)) / (2*a);
            res[1] = (-b - Math.sqrt(d)) / (2*a);
        }
        return res;
    }
    public static double[] QuadraticEquation(double a, double b, double c, double y) throws HasNotSolutionException, InfinityNumberOfSolutionsException{
        return QuadraticEquation(a,b, c - y);
    }
}
