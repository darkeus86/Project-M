package AuthorizationAndRegistration.Authorization;

import com.alee.laf.button.*;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;

import com.alee.laf.text.WebTextField;

import java.awt.*;

public class Authorization extends WebFrame {

    private final WebLabel welcome = new WebLabel("Welcome");
    private final WebButton logButton = new WebButton("Sign in");
    private final WebLabel loginLabel = new WebLabel("Login");
    private final WebLabel passwordLabel= new WebLabel("Password");
    private final WebTextField login = new WebTextField();
    private final WebPasswordField password = new WebPasswordField();
    private final WebPanel mainPanel = new WebPanel();
    private final WebButton bRegistration = new WebButton("Registration");
    private final WebButton bLogButton = new WebButton("Login");

    public Authorization()
    {
        super("User.Project-M");

        setSize(700,500);


        bLogButton.setPreferredSize(147, 40);
        mainPanel.setLayout(null);

//      ###WELCOME LABEL###
        welcome.setVerticalAlignment(WebLabel.CENTER);
        welcome.setHorizontalAlignment(WebLabel.CENTER);
        welcome.setFontSize(30);

//      ###COMPOSITION###
        WebPanel additionalPanel = new WebPanel();
        additionalPanel.setBounds(150,50,375,300);
        mainPanel.add(additionalPanel);

        additionalPanel.setLayout(new GridLayout(8, 0, 5, 12));
        additionalPanel.add(welcome);
        additionalPanel.add(loginLabel);
        additionalPanel.add(login);
        additionalPanel.add(passwordLabel);
        additionalPanel.add(password);
        additionalPanel.add(bLogButton);
        additionalPanel.add(bRegistration);

        getContentPane().add(mainPanel); //   метод отрисовки
        getContentPane().add(mainPanel); //   метод отрисовки
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



    public WebButton getLogButton() {
        return logButton;
    }

    public WebTextField getLogin() {
        return login;
    }

    public WebPasswordField getPassword() {
        return password;
    }

    public WebButton getbRegistration() {
        return bRegistration;
    }

    public WebButton getbLogButton() {
        return bLogButton;
    }
}
