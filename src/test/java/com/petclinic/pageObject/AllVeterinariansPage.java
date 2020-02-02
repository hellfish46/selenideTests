package com.petclinic.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.petclinic.object.Veterinarian;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class AllVeterinariansPage {


    public List<Veterinarian> getAllVeterinarians(){
        List<Veterinarian> allVetObj = new ArrayList<>();
        List<SelenideElement> allVetTrs = $$(By.xpath("//tbody/tr"));
        for (SelenideElement tr: allVetTrs) {
            allVetObj.add(createVetFromTr(tr));
        }
        return allVetObj;
    }

    private Veterinarian createVetFromTr(SelenideElement tr){
        Veterinarian vet = new Veterinarian();
        String fullName = tr.$(By.xpath("./td[1]")).getText().trim();
        String[] fullNameArr = fullName.split(" ");
        if(fullNameArr.length >1){
            vet.setFirstName(fullNameArr[0]);
            vet.setLastName(fullNameArr[1]);
        } else {
            vet.setFirstName(fullNameArr[0]);
        }
        //System.out.println(tr.findElements(By.xpath("./td[2]/div")).size() > 0);
        String tdDivs = "./td[2]/div";
        if(tr.$$(By.xpath(tdDivs)).size() > 0) {
            List<String> specialitiesList = new ArrayList<>();
            List<SelenideElement> listOfSpecialities = tr.$$(By.xpath(tdDivs));

            for (SelenideElement speciality : listOfSpecialities) {
                specialitiesList.add(speciality.getText());
            }
            vet.setListOfSpecialities(specialitiesList);
        }
        return vet;

    }


}
