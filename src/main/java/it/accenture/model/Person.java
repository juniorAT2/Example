package it.accenture.model;


import it.accenture.model.abstractions.WithId;
import lombok.NoArgsConstructor;

@NoArgsConstructor


public class Person implements WithId<Long> {
    private Long id;
    private String name;
    private String surname;

    public Person(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
