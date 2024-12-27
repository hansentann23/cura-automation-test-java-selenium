package tests.login;

import cura_app.base.BaseTest;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void testLogin(){
        String username = "John Doe";
        String password = "ThisIsNotAPassword";
        var loginPage = landingPage.goToLoginPage();
        loginPage.clickLoginButton();
        loginPage.fillUserNameField(username);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
    }
}
