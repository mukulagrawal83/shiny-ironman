package eu.shiny.ds;

import java.util.HashSet;
import java.util.Set;


public class Practise {
    
    
    public class Person{
        
        private int age;
        
        Person(int age){
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        
        public int hashCode(){
            return this.age;
        }
    }
    
    public static void main(String[] args) {
         Set<Person> set = new HashSet<Practise.Person>();
         Practise practise = new Practise();
         
         Person person = practise.new Person(21);
         
        practise.incrementAgeOfPerson(person);
         System.out.println("has person?? :" + person.getAge());
//         set.add(person);
//         
//         person.setAge(22);
//         
//         System.out.println("has person?? :" + set.contains(person));
//         System.out.println("has person?? : " + set.iterator().next().getAge());
         
    }
    
    private void incrementAgeOfPerson(Person person){
        person = new Person(42);
    }

}
