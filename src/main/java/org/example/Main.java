package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        System.out.println(person.getName());

        Person x = new Person();
        x.setName("Masha");

        Supplier<Person> personSupplier = () -> x;
        context.registerBean("person1", Person.class, personSupplier, bean -> bean.setPrimary(true));

        Person p = context.getBean(Person.class);
        System.out.println(p.getName());
    }
}