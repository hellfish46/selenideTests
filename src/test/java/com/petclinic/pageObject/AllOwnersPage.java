package com.petclinic.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.petclinic.object.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class AllOwnersPage {


    private Owner createOwnerFromTr(SelenideElement tr){

        Owner owner = new Owner();
        //tr.$(By.xpath("//tbody/tr"));
        String fullName = tr.$(By.xpath(".//td/a")).getText();////////////////////////////////////////////////////
       // String fullName = userRow.findElement(By.xpath(".//td/a")).getText();
        String[] fullNameArray = fullName.split(" ");
       // Owner owner = new Owner();
        owner.setFirstName(fullNameArray[0]);
        if(fullNameArray.length > 1) {
            owner.setLastName(fullNameArray[1]);
        }
        owner.setAddress(tr.$(By.xpath(".//td[2]")).getText());
        owner.setCity(tr.$(By.xpath(".//td[3]")).getText());
        owner.setTelephone(tr.$(By.xpath(".//td[4]")).getText());
        String pets = tr.$(By.xpath(".//td[5]")).getText();
        if(pets.isEmpty()){
            owner.setPets(null);
        }
        else {
            owner.setPets(pets);
        }
        return owner;

    }

    public List<Owner> getAllOwners(){

        List<Owner> allOwnersObj= new ArrayList<>();
        List<SelenideElement> allOwnersTr = $(By.xpath("//tbody")).findAll(By.xpath("./tr"));

        //List<WebElement> allOwnersTr = driver.findElements(By.xpath("//tbody/tr"));
        for (SelenideElement tr: allOwnersTr) {

            allOwnersObj.add(createOwnerFromTr(tr));
        }
        return allOwnersObj;
    }
}
