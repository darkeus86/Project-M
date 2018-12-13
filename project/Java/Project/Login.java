package Project;

import com.alee.laf.button.*;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;

import com.alee.laf.text.WebTextField;

import java.awt.*;

public class Login extends WebFrame {

    public WebLabel welcome = new WebLabel("Welcome");
    public WebButton logButton;
    public WebLabel loginLabel = new WebLabel("Login");
    public WebLabel passwordLabel= new WebLabel("Password");
    public WebTextField login = new WebTextField();
    public WebPasswordField password = new WebPasswordField();
    public WebPanel mainPanel;

    public Login()
    {
        super("User.Project-M");

        setSize(700,500);

        logButton = new WebButton("Login");
        logButton.setPreferredSize(147, 40);



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

        additionalPanel.setLayout(new GridLayout(7, 0, 5, 12));
        additionalPanel.add(welcome);
        additionalPanel.add(loginLabel);
        additionalPanel.add(login);
        additionalPanel.add(passwordLabel);
        additionalPanel.add(password);
        additionalPanel.add(logButton);


        getContentPane().add(mainPanel); //   метод отрисовки
        getContentPane().add(mainPanel); //   метод отрисовки
    }

    public static void launch()
    {
        Login login = new Login();
        login.setVisible(true);
    }


}
