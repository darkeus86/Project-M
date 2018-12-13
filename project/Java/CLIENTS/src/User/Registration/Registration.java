package User.Registration;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import java.awt.*;

public class Registration extends WebFrame {

    public WebLabel welcome = new WebLabel("Registration");

    public WebLabel loginLabel = new WebLabel("Create login");
    public WebLabel lPassword= new WebLabel("Create password");
    public WebLabel lRepeatPassword= new WebLabel("Repeat password");
    public WebTextField login = new WebTextField();
    public WebPasswordField pfPassword = new WebPasswordField();
    public WebPasswordField pfRepeatPassword = new WebPasswordField();
    public WebPanel mainPanel;
    public WebButton bRegistration = new WebButton("Go to use!");

    public WebButton getbCancel() {
        return bCancel;
    }

    public WebButton bCancel = new WebButton("<- Go back <-");
    public Registration()
    {
        super("User.Project-M");

        setSize(700,500);

        bRegistration.setPreferredSize(147, 40);



        mainPanel = new WebPanel();
        mainPanel.setLayout(null);

//      ###WELCOME LABEL###
        welcome.setVerticalAlignment(WebLabel.CENTER);
        welcome.setHorizontalAlignment(WebLabel.CENTER);
        welcome.setFontSize(30);



//      ###COMPOSITION###
        WebPanel additionalPanel = new WebPanel();

        additionalPanel.setBounds(150,50,375,300);
        mainPanel.add(additionalPanel);

        additionalPanel.setLayout(new GridLayout(9, 0, 5, 12));
        additionalPanel.add(welcome);
        additionalPanel.add(loginLabel);
        additionalPanel.add(login);
        additionalPanel.add(lPassword);
        additionalPanel.add(pfPassword);
        additionalPanel.add(lRepeatPassword);
        additionalPanel.add(pfRepeatPassword);
        additionalPanel.add(bRegistration);
        additionalPanel.add(bCancel);

        getContentPane().add(mainPanel); //   метод отрисовки
        getContentPane().add(mainPanel); //   метод отрисовки

        this.setVisible(true);
    }


    public WebTextField getLogin() {
        return login;
    }

    public WebPasswordField getPfPassword() {
        return pfPassword;
    }

    public WebPasswordField getPfRepeatPassword() {
        return pfRepeatPassword;
    }

    public WebButton getbRegistration() {
        return bRegistration;
    }
}
