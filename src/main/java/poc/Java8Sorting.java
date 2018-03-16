package poc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Java8Sorting {
public static void main(String[] args) {
Person person= new Person("aaa","zzz",21);
Person person1= new Person("zzz","bbb",22);
Person person2= new Person("aaa","bbb",23);
Person person3= new Person("aaa","bbb",24);
Person person4= new Person("aaa","bbb",25);
Person person5= new Person("aaa","bbb",26);
Person person6= new Person("aaa","bbb",27);
Person person7= new Person("aaa","bbb",28);
Person person8= new Person("aaa","bbb",29);
Person person9= new Person("aaa","bbb",30);
ArrayList<Person> persons=new ArrayList<>(Arrays.asList(person1,person,person2,person3,person4,person5,person6,person7,person8,person9));
persons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getLname).thenComparing(Person::getAge).reversed());
System.out.println(persons.toString());
}
}
@Data
@AllArgsConstructor
class Person{
	private String name;
	private String lname;
	private int age;
}