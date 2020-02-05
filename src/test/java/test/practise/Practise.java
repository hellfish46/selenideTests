package test.practise;

import com.codeborne.selenide.Condition;
import com.petclinic.pageObject.NewOwnerPage;
import com.petclinic.pageObject.ValidationMessage;
import com.petclinic.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Practise extends TestBase {

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
}
