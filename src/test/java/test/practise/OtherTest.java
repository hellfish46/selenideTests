package test.practise;

import com.codeborne.selenide.Condition;
import com.petclinic.pageObject.AddNewVeterinarianPage;
import com.petclinic.pageObject.ValidationMessage;
import com.petclinic.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OtherTest extends TestBase {
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
