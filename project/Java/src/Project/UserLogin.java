package Project;

import com.alee.laf.button.WebButton;
import com.alee.laf.checkbox.WebCheckBox;

import java.awt.*;

class UserLogin extends Login
{
    private WebCheckBox rememberPassword;
    private WebCheckBox autologin;
    private WebButton newLogButton = new WebButton("Login");

    UserLogin()
    {
        remove(logButton);

        rememberPassword = new WebCheckBox("Remember password");
        autologin = new WebCheckBox("Autologin");
        rememberPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        autologin.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        GridBagConstraints c = Login.getc();
        c.anchor = GridBagConstraints.NORTH;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;

        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;

        c.insets = new Insets(5, 0, 0, 90);
        gridBagLayout.setConstraints(autologin, c);

        c.insets = new Insets(5, 0, 0, 20);
        gridBagLayout.setConstraints(rememberPassword, c);

        c.insets = new Insets(50, 0, 0, 0);
        c.ipadx = 100;
        c.ipady = 30;
        gridBagLayout.setConstraints(newLogButton, c);

        add(autologin);
        add(rememberPassword);
        add(newLogButton);



    }

    public static void launch()
    {
        UserLogin login = new UserLogin();
        login.setVisible(true);
    }

}
