/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taska1;

/**
 *
 * @author r0man_000
 */
public class WrongAgeValueException extends Exception {
    public WrongAgeValueException(int src){
        super("'" + src + "' out of range");
    }
}
