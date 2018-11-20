package Project;

import com.alee.laf.button.*;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import java.awt.*;

public class Login extends WebFrame {

    public   WebLabel welcome = new WebLabel("Welcome");
    public WebButton logButton;
    public WebLabel loginLabel = new WebLabel("Login");
    public WebLabel passwordLabel= new WebLabel("Password");
    public WebTextField login = new WebTextField();
    public WebPasswordField password = new WebPasswordField();
    public WebPanel mainPanel;

    public Login()
    {
        super("Project-M");

        setSize(200,200);

        logButton = new WebButton("Login");
        logButton.setPreferredSize(147, 40);

        mainPanel = new WebPanel(new GridLayout(7, 0, 5, 12));

        mainPanel.add(welcome);
        mainPanel.add(loginLabel);
        mainPanel.add(login);
        mainPanel.add(passwordLabel);
        mainPanel.add(password);

        add(mainPanel);
        add(logButton);

        setDefaultCloseOperation(WebFrame.EXIT_ON_CLOSE);
    }

    public static void launch()
    {
        Login login = new Login();
        login.setVisible(true);
    }


}
