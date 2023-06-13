package com.rd.person;

public abstract class Person {
    private String  firstName;
    private String  lastName;
    private int age;
    private Person partner;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return this.partner;
    }

    protected void changePartner(Person partner) {
        this.partner = partner;
    }

    public abstract boolean isRetired();
    public void registerPartnership(Person partner){
        this.changePartner(partner);
        partner.changePartner(this);
    }
    public void deregisterPartnership(boolean shouldDeregister){
        if (shouldDeregister && this.getPartner() != null){
            Person partner = this.getPartner();
            this.changePartner(null);
            partner.changePartner(null);
        }

    }
}
