package com.rd.person;

public class Man extends Person{

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.getAge() >= 65;
    }
}
