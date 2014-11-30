/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taska1;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author r0man_000
 */
public class PeopleTest{
    Random rand;
    People people;
    int count = 30;
    
    public PeopleTest() {
        rand = new Random();
        try{
            people = new People(count);
        }catch(Exception e){}
    }
    
    /**
     * Test of SetAge method, of class People.
     */
    @Test
    public void testSetAge() {
        System.out.println("SetAge");
        int negatives = 0;
        int exceptions = 0;
        for (int i = 0; i < count; i++){
            int c = rand.nextInt(200) - 100;
            if (c < Person.minAge || c > Person.maxAge) negatives++;
            try{
                people.SetAge(i, c);
            }catch(WrongAgeValueException e ){
                exceptions++;
            }
        }
        //fail("Bad");
        System.out.println("expected: " + negatives + " actual: " + exceptions);
        assertEquals(negatives, exceptions);
    }
    
}
