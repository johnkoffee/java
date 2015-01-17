/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taska2;

import java.util.Map;
import java.util.HashMap;

public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, String> login = new HashMap<String, String>();
        login.put("admin", "admin");
        login.put("user0", "qwerty");
        login.put("user1", "123456");
        
        MyPrintStream mps = new MyPrintStream(System.out);
        mps.print(login);
        mps.println(login);
        mps.close();
    }
    
}
