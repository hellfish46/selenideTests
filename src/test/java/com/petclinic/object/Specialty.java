package com.petclinic.object;

import java.util.Objects;

public class Specialty {

    private String specialty;

    public String getSpeciality() {
        return specialty;
    }

    public void setSpecialty(String speciality) {
        this.specialty = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty that = (Specialty) o;
        return Objects.equals(specialty, that.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialty);
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "speciality='" + specialty + '\'' +
                '}';
    }
}
