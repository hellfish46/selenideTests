package com.petclinic.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.petclinic.object.Specialty;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SpecialtiesPage {
    Specialty specialty = new Specialty();

    public SpecialtiesPage clickAddBtn(){
        $(By.xpath("//button[normalize-space(text()) = 'Add']")).shouldBe(Condition.visible).click();
        return this;
    }

    public SpecialtiesPage fillSpecialtyField (String specialtyName){
        specialty.setSpecialty(specialtyName);
        $("#name").setValue(specialtyName);
        return this;
    }

    public SpecialtiesPage clickSaveBtn(){
        $("form button[type='submit']").click();
        return this;
    }

    public Specialty getSpecialty(){
        return specialty;
    }

    public void clickDeleteBtn(){

    }

    public List<Specialty> getAllSpecialties(){
        List<Specialty> specialtiesList = new ArrayList<>();

        List<SelenideElement> allInputs = $$(By.xpath("//tbody//input"));

        for(SelenideElement input : allInputs){
            specialtiesList.add(specFromInput(input));
        }
        return specialtiesList;
    }

    private Specialty specFromInput(SelenideElement input){
        Specialty specialty = new Specialty();
        specialty.setSpecialty(input.getAttribute("value"));
        return specialty;
    }


}
