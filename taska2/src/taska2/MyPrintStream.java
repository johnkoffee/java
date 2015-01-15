/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taska2;

import java.io.*;

/**
 *
 * @author r0man_000
 */
public class MyPrintStream extends PrintStream{
    public MyPrintStream(OutputStream out){
        super(out);
    }
    public print(Map content){
        super.print(content);
    }
    public println(Map content){
        super.println(content);
    }
}
