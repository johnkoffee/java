/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taska2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author r0man_000
 */
public class MyPrintStreamTest {
    OutputStream outputStream = null;
    Map<Integer, String> hierarchy = null;        
    
    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        hierarchy = new HashMap<Integer, String>();
    }
    
    @After
    public void tearDown() throws IOException {
        outputStream.close();
        hierarchy.clear();
    }

    /**
     * Test of print method, of class MyPrintStream.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Map content = null;
        MyPrintStream instance = null;
        instance.print(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of println method, of class MyPrintStream.
     */
    @Test
    public void testPrintln() {
        System.out.println("println");
        Map content = null;
        MyPrintStream instance = null;
        instance.println(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void fillMap( Map<Integer, String> map ){
        map.clear();
        map.put(1                                                                                                                                                                                                                                                                                           , "")
    }
}
