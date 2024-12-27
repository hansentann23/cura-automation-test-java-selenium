package appointments;

import base.BasePage;
import base.LandingPage;
import login.LoginPage;
import org.openqa.selenium.By;

import static utilities.DropDownUtility.selectByValue;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class AppointmentPage extends LandingPage {

    private By userNameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public void fillUserNameField(String userName) {
        scrollToElementJS(userNameField);
        click(userNameField);
        set(userNameField, userName);
    }

    public void fillPasswordField(String password){
        scrollToElementJS(passwordField);
        click(passwordField);
        set(passwordField, password);
    }

    public AppointmentPage clickLoginButton(){
        scrollToElementJS(loginButton);
        click(loginButton);
        return new AppointmentPage();
    }

    private By dropDownFacility = By.id("combo_facility");
    private By checkBoxApply = By.id("chk_hospotal_readmission");
    private By radioButtonMedicaid = By.id("radio_program_medicaid");
    private By visitDateField = By.id("txt_visit_date");
    private By calendarMonthAndYear = By.xpath("//th[normalize-space()='November 2024']");
//    private By calendarMonthAndYearDetail = By.xpath("//th[normalize-space()='2024']");
    private By calendarBackwardButton = By.xpath("//div[@class='datepicker-months']//th[@class='prev'][normalize-space()='«']");
    private By calendarForwardButton = By.xpath("//div[@class='datepicker-months']//th[@class='next'][normalize-space()='»']");
    private By commentField = By.id("txt_comment");
    private By bookAppointmentButton = By.id("btn-book-appointment");
    private By appointmentFooter = By.xpath("//strong[normalize-space()='CURA Healthcare Service']");

    private By calendarMonthAndYearDetail (String year){
        return By.xpath("//th[normalize-space()='"+ year +"']");
    }

    private By calendarYearSelect (String year){
        return By.xpath("//span[contains(@class,'year')][text()='"+ year +"']");
    }

    private By calendarMonthSelect (String month){
        return By.xpath("//span[contains(@class,'month')][text()='"+ month +"']");
    }

    private By calendarDaySelect (String day){
        return By.xpath("//td[contains(@class,'day')][text()='"+day+"']");
    }

    public void selectDropDownFacility (String value){
        scrollToElementJS(dropDownFacility);
        selectByValue(dropDownFacility, value);
    }

    public void selectCheckBoxAppy (){
        scrollToElementJS(checkBoxApply);
        click(checkBoxApply);
    }

    public void selectMedicaidRadioButton (){
        scrollToElementJS(radioButtonMedicaid);
        click(radioButtonMedicaid);
    }

    public void selectVisitDateField(){
        scrollToElementJS(visitDateField);
        click(visitDateField);
    }

    public void clickCalendarMonthAndYear(){
        click(calendarMonthAndYear);
    }

//    public void clickCalendarMonthAndYearDetail(String year){
//        click(calendarMonthAndYearDetail(year));
//    }

    public void selectCalendarYear(String year){
        click(calendarYearSelect(year));
    }

    public void selectCalendarMonth(String month){
        click(calendarMonthSelect(month));
    }

    public void selectCalendarDay(String day){
        click(calendarDaySelect(day));
    }

    public String getFinalDate(){
        return find(visitDateField).getAttribute("value");
    }

    public String getCurrentSelectedDate(String year){
        return find(calendarMonthAndYearDetail(year)).getText();
    }

    public int getCurrentSelectedYearAsInt(String year){
        String currentYear = getCurrentSelectedDate(year);
        return Integer.parseInt(currentYear);
    }

    public void clickCalendarForwardButton(){
        scrollToElementJS(calendarForwardButton);
        click(calendarForwardButton);
    }

    public void clickCalendarBackwardButton(){
        scrollToElementJS(calendarBackwardButton);
        click(calendarBackwardButton);
    }

    public void clickCommentField(){
        scrollToElementJS(commentField);
        click(commentField);
    }

    public void setCommentField(String comment){
        set(commentField, comment);
    }

    public AppointmentConfirmationPage clickAppointmentButton(){
        scrollToElementJS(bookAppointmentButton);
        click(bookAppointmentButton);
        return new AppointmentConfirmationPage();
    }

    public void clickAppointmentFooter(){
        click(appointmentFooter);
    }


}
