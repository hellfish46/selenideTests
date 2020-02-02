package com.petclinic.tests;

import com.codeborne.selenide.Condition;
import com.petclinic.object.Owner;
import com.petclinic.object.PetType;
import com.petclinic.object.Specialty;
import com.petclinic.object.Veterinarian;
import com.petclinic.pageObject.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertFalse;

public class Tests extends TestBase {


    //Owner tests
    @Test
    public void createNewOwnerValidData(){
        open("/owners/add");
        $("[type=submit]").shouldBe(Condition.disabled);
        //open("/owners");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        Owner owner = newOwnerPage
                .setFirstName("Denis1")
                .setLastName("KrasaveTs")
                .setAddress("England, 49000")
                .setCity("London")
                .setTelephone("123456789")
                .clickAddNewOwnerBtn()
                .returnOwnerObj();
        $(By.xpath("//tbody/tr")).shouldBe(Condition.visible);
        AllOwnersPage allOwnersPage = new AllOwnersPage();
        List<Owner> allOwnersObj = allOwnersPage.getAllOwners();
        assertThat(allOwnersObj).contains(owner);
    }


    @Test
    public void firstNameLessTwoSymbols(){
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setFirstName("D")
                .setLastName("KrasaveTs")
                .setAddress("England, 49000")
                .setCity("London")
                .setTelephone("123456789");
        $(By.xpath("//input[@id='firstName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.FIRSTNAMELESSTWOSYMBOLS.getMessage()));

    }

    @Test
    public void lastNameLessTwoSymbols(){
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setFirstName("Dima")
                .setLastName("K")
                .setAddress("England, 49000")
                .setCity("London")
                .setTelephone("123456789");
        $(By.xpath("//input[@id='lastName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.LASTNAMELESSTWOSYMBOLS.getMessage()));
    }
    @Test
    public void telephoneMustContainOnlyDigits(){
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setFirstName("Dima")
                .setLastName("Danilec")
                .setAddress("England, 49000")
                .setCity("London")
                .setTelephone("1234f");
        $(By.xpath("//input[@id='telephone']/following-sibling::span[@class='help-block']")).shouldHave(Condition.text(
                ValidationMessage.PHONEMUSTBEDIGITS.getMessage()));
    }

    @Test
    public void ownerAllFieldsRequiredMessages(){
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setFirstName("Dima")
                .setLastName("Danilec")
                .setAddress("England, 49000")
                .setCity("London")
                .setTelephone("1234f");

        newOwnerPage.clearFirstName();
        $(By.xpath("//input[@id='firstName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.FIRSTNAMEISREQUIRED.getMessage()));

        newOwnerPage.clearLastName();
        $(By.xpath("//input[@id='lastName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.LASTNAMEISREQUIRED.getMessage()));

        newOwnerPage.clearAddress();
        $(By.xpath("//input[@id='address']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.ADDRESSISREQUIRED.getMessage()));

        newOwnerPage.clearCity();
        $(By.xpath("//input[@id='city']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.CITYISREQUIRED.getMessage()));

        newOwnerPage.clearTelephone();
        $(By.xpath("//input[@id='telephone']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.PHONEISREQUIRED.getMessage()));


    }

//    @Test
//    public void ocam(){
//        open("http://arlp.lancertool.com/login");
//        $("#__BVID__16__BV_button_").click();
//        $(By.xpath("//a[@role='menuitem']/img[@src='/images/england.png']")).click();
//        $("#inputEmail").setValue("qwer@qwer.qwer");
//        $("#inputPassword").setValue("secret");
//        $("[type=submit]").click();
//        $(".notification-content").shouldBe(Condition.visible).shouldHave(Condition.text(
//                "Email or password is incorrect"
//        ));
//    }

// Pet type
    @Test
    public void newPetTypeCreation(){
        open("/pettypes");
        $(By.xpath("//tbody/tr")).shouldBe(Condition.visible);
        PetTypePage petTypePage = new PetTypePage();
        PetType petType = petTypePage.clickAddBtn().fillNewType("dino12").clickSaveBtn().returnPetType();
        assertThat(petTypePage.getAllPetTypes()).contains(petType);

    }

    @Test
    public void newPetTypeEmptyField(){
        open("/pettypes");
        $(By.xpath("//tbody/tr")).shouldBe(Condition.visible);

        PetTypePage petTypePage = new PetTypePage();
        Integer sizeBefore = petTypePage.getAllPetTypes().size();
        petTypePage.clickAddBtn().clickSaveBtn();
        refresh();

        Integer sizeAfter = petTypePage.getAllPetTypes().size();
        assertThat(sizeBefore).isEqualTo(sizeAfter);

    }

    //specialty test
    @Test
    public void createNewSpecialty(){
        open("/specialties");
        SpecialtiesPage specialtiesPage = new SpecialtiesPage();
        Specialty specialty = specialtiesPage.clickAddBtn().fillSpecialtyField("brain").clickSaveBtn().getSpecialty();
        refresh();
        List<Specialty> allSpecialties = specialtiesPage.getAllSpecialties();
        assertThat(allSpecialties).contains(specialty);
    }

    @Test
    public void createEmptySpecialty(){
        open("/specialties");
        SpecialtiesPage specialtiesPage = new SpecialtiesPage();
        List<Specialty> allSpecialtiesBefore = specialtiesPage.getAllSpecialties();
        specialtiesPage.clickAddBtn().clickSaveBtn();
        refresh();
        List<Specialty> allSpecialtiesAfter = specialtiesPage.getAllSpecialties();
        assertThat(allSpecialtiesBefore).isEqualTo(allSpecialtiesAfter);
        System.out.println(allSpecialtiesAfter.toString());
    }

    @Test
    public void createNewVet(){
        open("/vets/add");
        AddNewVeterinarianPage addNewVeterinarianPage = new AddNewVeterinarianPage();
        Veterinarian veterinarian = addNewVeterinarianPage
                .setFirstName("Andrew")
                .setLastName("Sega")
                .clickSpecialtySelect()
                .setSpecialty("brain")
                .clickSpecialtySelect()
                .clickSaveBtn()
                .returnVeterinarianObj();

        //sleep(2000);
        $(By.xpath("//tbody/tr")).shouldBe(Condition.visible);
        AllVeterinariansPage allVeterinariansPage = new AllVeterinariansPage();
        List<Veterinarian> allVeterinarians = allVeterinariansPage.getAllVeterinarians();

        assertThat(allVeterinarians).contains(veterinarian);
    }

    @Test
    public void vetHasFirstNameLessTwoSymbols(){
        open("/vets/add");
        AddNewVeterinarianPage addNewVeterinarianPage = new AddNewVeterinarianPage();
        addNewVeterinarianPage
                .setFirstName("A")
                .setLastName("Sega")
                .clickSpecialtySelect()
                .setSpecialty("brain")
                .clickSpecialtySelect();
        $(By.xpath("//input[@id='firstName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.FIRSTNAMELESSTWOSYMBOLS.getMessage()));
    }
    @Test
    public void vetHasLastNameLessTwoSymbols(){
        open("/vets/add");
        AddNewVeterinarianPage addNewVeterinarianPage = new AddNewVeterinarianPage();
        addNewVeterinarianPage
                .setFirstName("Andrew")
                .setLastName("S")
                .clickSpecialtySelect()
                .setSpecialty("brain")
                .clickSpecialtySelect();
        $(By.xpath("//input[@id='lastName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.LASTNAMELESSTWOSYMBOLS.getMessage()));
    }



    @Test
    public void vetFirstLastNamesRequiredMessages(){
        open("/vets/add");
        AddNewVeterinarianPage addNewVeterinarianPage = new AddNewVeterinarianPage();
        addNewVeterinarianPage
                .setFirstName("Andrew")
                .setLastName("Sega")
                .clickSpecialtySelect()
                .setSpecialty("brain")
                .clickSpecialtySelect();

        addNewVeterinarianPage.clearFirstName();
        $(By.xpath("//input[@id='firstName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.FIRSTNAMEISREQUIRED.getMessage()));

        addNewVeterinarianPage.clearLastName();
        $(By.xpath("//input[@id='lastName']/following-sibling::span[@class='help-block']"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(ValidationMessage.LASTNAMEISREQUIRED.getMessage()));
    }




}
