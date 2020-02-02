package com.petclinic.pageObject;

import com.codeborne.selenide.Condition;
import com.petclinic.object.Owner;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class NewOwnerPage {
    private String firstNameCss = "#firstName";
    private String lastNameCss = "#lastName";
    private String address = "#address";
    private String city = "#city";
    private String telephone = "#telephone";

    Owner owner = new Owner();

    public NewOwnerPage clearFirstName(){
        $(firstNameCss).sendKeys(Keys.CONTROL + "a");
        $(firstNameCss).sendKeys(Keys.DELETE);
        return this;
    }

    public NewOwnerPage clearLastName(){
        $(lastNameCss).sendKeys(Keys.CONTROL + "a");
        $(lastNameCss).sendKeys(Keys.DELETE);
        return this;
    }
    public NewOwnerPage clearAddress(){
        $(address).sendKeys(Keys.CONTROL + "a");
        $(address).sendKeys(Keys.DELETE);
        return this;
    }

    public NewOwnerPage clearCity(){
        $(city).sendKeys(Keys.CONTROL + "a");
        $(city).sendKeys(Keys.DELETE);
        return this;
    }
    public NewOwnerPage clearTelephone(){
        $(telephone).sendKeys(Keys.CONTROL + "a");
        $(telephone).sendKeys(Keys.DELETE);
        return this;
    }



    public NewOwnerPage setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        owner.setFirstName(firstName);
        return this;
    }
    public NewOwnerPage setLastName(String lastName){
        $("#lastName").setValue(lastName);
        owner.setLastName(lastName);
        return this;
    }
    public NewOwnerPage setAddress(String address){
        $("#address").setValue(address);
        owner.setAddress(address);
        return this;
    }
    public NewOwnerPage setCity(String city){
        $("#city").setValue(city);
        owner.setCity(city);
        return this;
    }
    public NewOwnerPage setTelephone(String telephone){
        $("#telephone").setValue(telephone);
        owner.setTelephone(telephone);
        return this;
    }
    public NewOwnerPage clickAddNewOwnerBtn() {
        $("[type=submit]").shouldBe(Condition.enabled).click();
        return this;
    }

    public Owner returnOwnerObj(){
        return owner;
    }


}
