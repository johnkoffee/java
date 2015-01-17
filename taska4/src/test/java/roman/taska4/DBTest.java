package roman.taska4;

import org.junit.AfterClass;
import  org.junit.BeforeClass;
import  org.junit.Test;
import static org.junit.Assert.*;

public class DBTest {
    static DB db = null;
    
    public DBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        db = new DB();
        db.Register("admin", "admin", "NP", "");
        db.Register("kirill", "1", "SKA", "Hi!");
        db.Register("alex", "1", "AAS", "Hello!");
        db.Register("pes", "1", "AAF", "Here!");
        db.Login("kirill", "1");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //db.ClearDB();
    }


    @Test
    public void testTopByTime() {
        System.out.println("TopByTime");
        Integer count = 10;
        Boolean last = false;
        String endl = "\r\n";
        String expResult = ""
                + "1. NP > 2015-01-17" + endl
                + "2. SKA > 2015-01-17" + endl
                + "3. AAS > 2015-01-17" + endl
                + "4. AAF > 2015-01-17" + endl;
        String result = db.TopByTime(count, last);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("BAD");
    }

    @org.junit.Test
    public void testDisplayCount() {
        System.out.println("DisplayCount");
        Integer c = db.DisplayCount();
        assertEquals(4, c);
        fail("BAD");
    }

    @org.junit.Test
    public void testDisplayMessage() {
        System.out.println("DisplayMessage");
        DB instance = new DB();
        String endl = "\r\n";
        String expResult = ""
                + "Message: " + endl
                + "Hi!" + endl;
        String result = db.DisplayMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
