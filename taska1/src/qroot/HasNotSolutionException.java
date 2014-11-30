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
public class HasNotSolutionException extends Exception {
    public HasNotSolutionException(String equation) {
        super("Equation " + equation + " has not solution.");
    }
}
