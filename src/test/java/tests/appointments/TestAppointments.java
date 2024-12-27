package tests.appointments;

import appointments.AppointmentPage;
import cura_app.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.login.TestLogin;

public class TestAppointments extends BaseTest {

    @Test
    public void testAppointments() throws InterruptedException {
        String year = "2024";
        String yearInputted = "2030";
        String month = "Mar";
        String monthNumber = "03";
        String day = "19";
        String comment = "Testing Hansen";
        String dropDownFacility = "Hongkong CURA Healthcare Center";

        var appointmentsPage = landingPage.goToLoginPage();

        appointmentsPage.selectDropDownFacility(dropDownFacility);
        Thread.sleep(3000);
        appointmentsPage.selectCheckBoxAppy();
        Thread.sleep(3000);
        appointmentsPage.selectMedicaidRadioButton();
        Thread.sleep(3000);
        appointmentsPage.selectVisitDateField();
        Thread.sleep(3000);
        appointmentsPage.clickCalendarMonthAndYear();
        Thread.sleep(3000);
        int currentSelectedYear = appointmentsPage.getCurrentSelectedYearAsInt(year);
        int inputtedYearAsInt = Integer.parseInt(yearInputted);
        if(currentSelectedYear >= inputtedYearAsInt){
            for(int i=currentSelectedYear;i>=inputtedYearAsInt;i--){
                appointmentsPage.clickCalendarBackwardButton();
                Thread.sleep(500);
            }
        }else{
            for(int i=currentSelectedYear;i<=inputtedYearAsInt;i++){
                appointmentsPage.clickCalendarForwardButton();
                Thread.sleep(500);
            }
        }
        appointmentsPage.selectCalendarMonth(month);
        Thread.sleep(3000);
        appointmentsPage.selectCalendarDay(day);
        Thread.sleep(3000);
        appointmentsPage.clickAppointmentFooter();
        Thread.sleep(3000);
        appointmentsPage.clickCommentField();
        Thread.sleep(3000);
        appointmentsPage.setCommentField(comment);
        Thread.sleep(3000);
        appointmentsPage.clickAppointmentButton();
        String actualDate = appointmentsPage.getFinalDate();
        String expectedDate = day + "/" + monthNumber + "/" + yearInputted;
        Assert.assertEquals(actualDate, expectedDate, "\n Actual Date and Expected Date do not match!" +
                "\n Actual Date:   " + actualDate +
                "\n Expected Date: " + expectedDate);
    }
}
