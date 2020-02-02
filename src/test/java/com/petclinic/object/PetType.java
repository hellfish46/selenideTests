package com.petclinic.object;

import java.util.Objects;

public class PetType {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetType petType = (PetType) o;
        return Objects.equals(type, petType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "PetType{" +
                "type='" + type + '\'' +
                '}';
    }


}
