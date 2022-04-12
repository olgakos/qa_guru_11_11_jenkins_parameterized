package mycompany.olga.tests.demoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@DisplayName("Это страница Practice Form (v.3)")
public class RegistrationFormTests extends TestBase {

    @Test
    void studentRegistrationFormTests() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[id=firstName]").setValue("Olga");
        $("#lastName").setValue("Kos"); //вниамние на разницу с #
        $("#userEmail").setValue("ok@yandex.ru");
        //$(byText("Female")).click(); //Gender
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8125560781"); //Mobile(10 Digits)
        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3"); //it's April
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $$(".react-datepicker__day").find(text("23")).click();

        //Subjects (мульти-список)
        //$("#subjectsInput").scrollTo().setValue("English"); // не сработал если >1
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();

        //Hobbies (check-boxes)
        $("#hobbies-checkbox-1").scrollTo().parent().click();
        $(byText("Reading")).click();
        $("#hobbies-checkbox-3").parent().click(); // todo возможны вараинты, подумать

        //Picture Select picture
        //NB! to Jenkins
       // $("#uploadPicture").uploadFromClasspath("img/selenide.png");
        $("#currentAddress").setValue("Moskovskoe 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        //button // todo возможны вараинты, подумать
        $("#submit").click();
        //$("#submit").scrollTo().click(); //скролл на случай если кнопка загородена баннером

        //Checking
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Olga Kos"),
                text("ok@yandex.ru")
                /*
                ,
                text("Female"),
                text("8125560781"),
                text("23 April,2000"),
                text("English, History"),
                text("Sports, Reading, Music"),
                //text("selenide.png"),
                text("Moskovskoe 1"),
                text("NCR Delhi")

                 */
        );

        $("#closeLargeModal").click(); //button
    }
}