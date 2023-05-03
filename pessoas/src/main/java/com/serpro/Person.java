package com.serpro;

import java.time.LocalDate;
import com.serpro.PersonDTO;

public class Person {
    private int id;
    private String name;
    private String email;
    private LocalDate birthDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void toPerson(PersonDTO personDTO) {
        this.setId(personDTO.getId());
        this.setName(personDTO.getName());
        this.setEmail(personDTO.getEmail());
        this.setBirthDate(personDTO.getBirthDate());
    }
}
