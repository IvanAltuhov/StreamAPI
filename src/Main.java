import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Nodes.collect;


public class Main {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );

        }

        Stream stream1 = persons.stream().filter(person -> person.getAge() < 18);
        long count = stream1.count();
        System.out.println(count);

        Stream streamArmy = persons.stream().filter(person ->  person.getAge() > 18 && person.getAge() < 27);
        Stream streamArmyMan = streamArmy.filter(person -> Sex.MAN.equals(Sex.MAN));
        long countMan = streamArmyMan.count();
        List <String> man = streamArmyMan.map(streamArmyMan.filter(families));
        collect(Collectors.toList(man);
        System.out.println(countMan);

        //List<String> familie = persons.stream().map(streamArmyMan.filter(families));
        //collect(Collectors.toList());





        //Predicate<Person> min18 = person -> person.getAge() < 18;
        //persons.removeIf(min18);
        //System.out.println(persons);

       //Stream stream = Person.stream();
      // Stream stream1 =  stream.filter(Person -> persons.getAge() < 18);
      // long count = stream1.count();
      // System.out.println(count);


    }
}
