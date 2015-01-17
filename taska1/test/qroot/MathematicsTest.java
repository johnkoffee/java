package qroot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathematicsTest {
    public MathematicsTest() {
    }

    @Test
    public void testQuadraticEquation_3args() throws Exception {
        System.out.println("QuadraticEquation 3 args");
        double e = 0.0001;
        double a = 2.0;
        double b = 3.0;
        double c = -2.0;
        double[] expResult = {0.5, -2};
        double[] result = Mathematics.QuadraticEquation(a, b, c);
        if (expResult.length != result.length) fail("Results have dirfferent lengths");
        for(int i = 0; i < expResult.length; i++){
            if (Math.abs(expResult[i] - result[i]) > e ){
                fail("not equals");
            }
        }
        assert(true);
    }
    @Test(expected = InfinityNumberOfSolutionsException.class)
    public void testQuadraticEquation_InfSol() throws Exception {
        System.out.println("QuadraticEquation: inf sol");
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double[] result = Mathematics.QuadraticEquation(a, b, c);
        
    }
    @Test(expected = HasNotSolutionException.class)
    public void testQuadraticEquation_HasNot() throws Exception {
        System.out.println("QuadraticEquation: hasn't sol");
        double a = 1.0;
        double b = 1.0;
        double c = 1.0;
        double[] result = Mathematics.QuadraticEquation(a, b, c);
    }

    /**
     * Test of QuadraticEquation method, of class Mathematics.
     */
    @Test
    public void testQuadraticEquation_4args() throws Exception {
        System.out.println("QuadraticEquation 4 args");
        double e = 0.0001;
        double a = 2.0;
        double b = 4.0;
        double c = 5.0;
        double y = 5.0;
        double[] expResult = Mathematics.QuadraticEquation(a, b, c - y);
        double[] result = Mathematics.QuadraticEquation(a, b, c, y);
        if (expResult.length != result.length) fail("Results have dirfferent lengths");
        for(int i = 0; i < expResult.length; i++){
            if (Math.abs(expResult[i] - result[i]) > e ){
                fail("not equals");
            }
        }
        assert(true);
    }
    
}
