package com.serpro;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Person person = new Person();
        person.setId(1);
        person.setName("João");
        person.setEmail("joao@teste.com");
        person.setBirthDate(LocalDate.of(1990, 2, 20));

        System.out.println("ID: " + person.getId());
        System.out.println("Nome: " + person.getName());
        System.out.println("E-mail: " + person.getEmail());
        System.out.println("Data de nascimento: " + person.getBirthDate());
    }
}
