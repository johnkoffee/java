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


public class MyPrintStreamTest {
    OutputStream stream = null;
    Map<String, String> map = null;        
    
    @Before
    public void initTest() {
        System.out.print("Begin test: ");
        stream = new ByteArrayOutputStream();
        map = new HashMap<String, String>();
    }
    
    @After
    public void finTest() throws IOException {
        stream.close();
        map.clear();
    }

   @Test
    public void testPrint() {
        System.out.println("Print()");
        MyPrintStream mps = new MyPrintStream(stream);
        map.put("key0", "value0");
        map.put("key1", "value1");
        mps.print(map);
        assertEquals(map.toString(), stream.toString());
    }

    @Test
    public void testPrintln() {
        System.out.println("Println()");
        MyPrintStream mps = new MyPrintStream(stream);
        map.put("key0", "value0");
        map.put("key1", "value1");
        mps.println(map);
        assertEquals(map.toString() + "\r\n", stream.toString());
    }
    
    public void fillMap( Map<Integer, String> map ){
        map.clear();
        map.put(1, "");
    }
}
