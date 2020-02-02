package com.petclinic.pageObject;

import com.petclinic.object.Veterinarian;
import org.openqa.selenium.Keys;

import java.security.Key;

import static com.codeborne.selenide.Selenide.$;

public class AddNewVeterinarianPage {
    private String firstNameCss = "#firstName";
    private String lastNameCss = "#lastName";

    Veterinarian veterinarian = new Veterinarian();

    public AddNewVeterinarianPage setFirstName(String firstName){
        $(firstNameCss).setValue(firstName);
        veterinarian.setFirstName(firstName);
        return this;
    }

    public AddNewVeterinarianPage clearFirstName(){
        $(firstNameCss).sendKeys(Keys.CONTROL + "a");
        $(firstNameCss).sendKeys(Keys.DELETE);
        return this;
    }

    public AddNewVeterinarianPage clearLastName(){
        $(lastNameCss).sendKeys(Keys.CONTROL + "a");
        $(lastNameCss).sendKeys(Keys.DELETE);
        return this;
    }

    public AddNewVeterinarianPage setLastName(String lastName){
        $(lastNameCss).setValue(lastName);
        veterinarian.setLastName(lastName);
        return this;
    }
    public AddNewVeterinarianPage setSpecialty(String specialtyValue){
        veterinarian.setType(specialtyValue);
        $("#specialties").selectOptionContainingText(specialtyValue);
        return this;
    }

    public AddNewVeterinarianPage clickSaveBtn(){
        $("button[type='submit']").click();
        return this;
    }

    public AddNewVeterinarianPage clickSpecialtySelect(){
        $("#specialties").click();
        return this;
    }

    public Veterinarian returnVeterinarianObj(){
        return veterinarian;
    }


}
