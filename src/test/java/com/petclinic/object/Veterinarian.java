package com.petclinic.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Veterinarian {
    private String firstName;
    private String lastName;

    private List<String> listOfSpecialities = new ArrayList<>();


    public void setListOfSpecialities(List<String> specialities){
        this.listOfSpecialities = specialities;
    }
    public List<String> getListOfSpecialities(){
        return listOfSpecialities;
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

    public void setType(String type) {
        listOfSpecialities.add(type);
    }

    public String getType(){
        return listOfSpecialities.get(0);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listOfSpecialities=" + listOfSpecialities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinarian that = (Veterinarian) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(listOfSpecialities, that.listOfSpecialities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, listOfSpecialities);
    }




}
