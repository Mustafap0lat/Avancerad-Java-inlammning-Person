package com.company;

import java.awt.image.ImageProducer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>() {{

            add(new Person("Ali", "Male", 56000));
            add(new Person("Suad", "Male", 36000));
            add(new Person("Semir", "Male", 25000));
            add(new Person("Xherald", "Male", 26000));
            add(new Person("Peter", "Male", 16000));

            add(new Person("Karin", "Female", 45000));
            add(new Person("Mona", "Female", 35000));
            add(new Person("Lisa", "Female", 25000));
            add(new Person("Maria", "Female", 20000));
            add(new Person("Ebba", "Female", 15000));


        }};

        Map<String, Double> avgSalary = people.stream()
                .collect(Collectors.
                        groupingBy(Person::getGender, Collectors.averagingDouble(Person::getSalary)));
        System.out.println("\n The average salary for Females and Males are: \n " + avgSalary + "\n--------------------------------------");

        Optional<Person> maxSalary = people.stream().max(Comparator.comparingDouble(Person::getSalary));
        System.out.println("The highest salary is: " + maxSalary.get().getSalary()+" Name is: " +maxSalary.get().getName());

        Optional<Person> minSalary = people.stream().min(Comparator.comparingDouble(Person::getSalary));
        System.out.println("The highest salary is: " + minSalary.get().getSalary()+" Name is: " +minSalary.get().getName());

    }
}


