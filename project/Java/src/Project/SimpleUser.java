package Project;

import com.alee.extended.checkbox.CheckState;
import com.alee.extended.checkbox.WebTristateCheckBox;
import com.alee.laf.checkbox.WebCheckBox;

import java.awt.*;

class UserLogin extends Login
{
    private WebCheckBox rememberPassword;
    private WebCheckBox autologin;

    UserLogin()
    {
        rememberPassword = new WebCheckBox("Remember password");

        autologin = new WebCheckBox("Autologin");

        mainPanel.add(autologin, BorderLayout.NORTH);
        mainPanel.add(rememberPassword, BorderLayout.NORTH);

        add(mainPanel, BorderLayout.NORTH);

    }

    public static void launch()
    {
        UserLogin login = new UserLogin();
        login.setVisible(true);
    }

}

public class SimpleUser {

    public static void main(String[] args) {
        UserLogin.launch();
    }
}
