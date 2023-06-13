package com.rd.person;

public class Woman extends Person{

    private final String oldLastName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.oldLastName = lastName;
    }

    @Override
    protected void changePartner(Person partner) {
        super.changePartner(partner);
        if (partner == null) {
            this.setLastName(this.oldLastName);
        } else {
            this.setLastName(partner.getLastName());
        }

    }
    @Override
    public boolean isRetired() {
        return this.getAge() >= 60;
    }

}
