package base;

import appointments.AppointmentPage;
import login.LoginPage;
import org.openqa.selenium.By;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class LandingPage extends BasePage{
    private By makeAppointmentButton = By.id("btn-make-appointment");

    public AppointmentPage goToLoginPage (){
        scrollToElementJS(makeAppointmentButton);
        click(makeAppointmentButton);
        return new AppointmentPage();
    }
}
