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
public class Person {
    String name = "";
    int age;
    public static int maxAge = 150;
    public static int minAge = 0;
    public static int defaultAge = 21;
    
    public Person(String name, int age){
        this.name = name;
        try{
            setAge(age);            
        } catch(WrongAgeValueException e){
            System.out.println(e);
            this.age = this.defaultAge;
        }
    }
    public void setAge(int age) throws WrongAgeValueException{
        if (age < minAge || age > maxAge) throw new WrongAgeValueException(age);
        this.age = age;
    }
    public int GetAge(){
        return age;
    }
    public String GetName(){
        return name;
    }
}
