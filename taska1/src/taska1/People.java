/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taska1;

import java.util.*;

/**
 *
 * @author r0man_000
 */
public class People {
    Person[] people;
    
    public People(int countOfPeoples){
        Random rand = new Random();
        if (countOfPeoples > 0){
            people = new Person[countOfPeoples];
            for (int i = 0; i < countOfPeoples; i++){
                int c = Person.defaultAge;
                people[i] = new Person("Bot_" + c, c);
                //System.in.read();
            }
        }
    }
    
    public void SetAge(int indexOfPerson, int newAge) throws WrongAgeValueException{
        if (people == null) return;
        if (!(indexOfPerson < 0 || indexOfPerson > people.length -1))
        people[indexOfPerson].setAge(newAge);
    }
    public int getAge(int indexOfPerson){
        if (people == null) return -1;
        if (indexOfPerson < 0 || indexOfPerson > people.length -1) return -1;
        return people[indexOfPerson].GetAge();
    }
    
    public void Show(){
        Show(true, true, true);
    }
    public void Show(boolean inColumn, boolean showNames, boolean showAges){
        if (!showNames && !showAges) return;
        for (Person person : people) {
            String str = (showNames ? person.GetName() : "") + (showAges ? (showNames ? " " : "") + person.GetAge() : "");
            if (inColumn)
                System.out.println(str);
            else
                System.out.print(str + ", ");
        }
    }
}
