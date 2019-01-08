package AuthorizationAndRegistration.Registration;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import java.awt.*;

public class Registration extends WebFrame {

    private final WebTextField login = new WebTextField();
    private final WebPasswordField pfPassword = new WebPasswordField();
    private final WebPasswordField pfRepeatPassword = new WebPasswordField();
    private final WebButton bRegistration = new WebButton("Go to use!");

    public WebButton getbCancel() {
        return bCancel;
    }

    private final WebButton bCancel = new WebButton("<- Go back <-");
    public Registration()
    {
        super("User.Project-M");

        setSize(700,500);

        bRegistration.setPreferredSize(147, 40);


        WebPanel mainPanel = new WebPanel();
        mainPanel.setLayout(null);

//      ###WELCOME LABEL###
        WebLabel welcome = new WebLabel("Registration");
        welcome.setVerticalAlignment(WebLabel.CENTER);
        welcome.setHorizontalAlignment(WebLabel.CENTER);
        welcome.setFontSize(30);



//      ###COMPOSITION###
        WebPanel additionalPanel = new WebPanel();

        additionalPanel.setBounds(150,50,375,300);
        mainPanel.add(additionalPanel);

        additionalPanel.setLayout(new GridLayout(9, 0, 5, 12));
        additionalPanel.add(welcome);
        WebLabel loginLabel = new WebLabel("Create login");
        additionalPanel.add(loginLabel);
        additionalPanel.add(login);
        WebLabel lPassword = new WebLabel("Create password");
        additionalPanel.add(lPassword);
        additionalPanel.add(pfPassword);
        WebLabel lRepeatPassword = new WebLabel("Repeat password");
        additionalPanel.add(lRepeatPassword);
        additionalPanel.add(pfRepeatPassword);
        additionalPanel.add(bRegistration);
        additionalPanel.add(bCancel);

        getContentPane().add(mainPanel); //   метод отрисовки
        getContentPane().add(mainPanel); //   метод отрисовки
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
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
