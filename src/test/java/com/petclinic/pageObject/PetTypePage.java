package com.petclinic.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.petclinic.object.PetType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PetTypePage {
    PetType petType = new PetType();

    public PetType returnPetType(){
        return petType;
    }
    public PetTypePage clickAddBtn(){
        $(By.xpath("//button[normalize-space(text()) = 'Add']")).click();
        return this;
    }

    public PetTypePage fillNewType(String type){
        $("#name").setValue(type);
        petType.setType(type);
        return this;
    }

    public PetTypePage clickSaveBtn(){
        $(By.xpath("//button[@type='submit']")).click();
        return this;
    }

    public List<PetType> getAllPetTypes(){
        List<PetType> petTypeList = new ArrayList<>();

        List<SelenideElement> allInputes = $(By.xpath("//tbody")).findAll(By.xpath(".//input"));
        for(SelenideElement input: allInputes){
            petTypeList.add(inputInObj(input));
        }
        return petTypeList;
        // List<SelenideElement> allOwnersTr = $(By.xpath("//tbody")).findAll(By.xpath("./tr"));
    }

    private PetType inputInObj (SelenideElement input){
        PetType petType = new PetType();
        petType.setType(input.getAttribute("value"));
        return petType;
    }
}
