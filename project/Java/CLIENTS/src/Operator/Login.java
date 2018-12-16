package Operator;

import com.alee.laf.button.*;
import com.alee.laf.label.WebLabel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Login extends WebFrame {

    protected WebLabel welcome = new WebLabel("Welcome");
    protected static WebButton logButton;
    protected WebLabel loginLabel = new WebLabel("Login");
    protected WebLabel passwordLabel= new WebLabel("Password");
    protected WebTextField login = new WebTextField();
    protected WebPasswordField password = new WebPasswordField();
    protected GridBagLayout gridBagLayout = new GridBagLayout();
    protected static GridBagConstraints c = new GridBagConstraints();

    public Login()
    {
        super("Project-M");

        setSize(600,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLocale(new Locale("en"));
        setLayout(gridBagLayout);

        logButton = new WebButton("Login");

        welcome.setFont(new Font("Times New Roman", Font.BOLD, 42));
        loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        login.setFontSize(15);
        password.setFontSize(15);


        c.anchor = GridBagConstraints.NORTH;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(25, 0, 50, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;

        gridBagLayout.setConstraints(welcome, c);

        c.insets = new Insets(5, 0, 5, 110);
        gridBagLayout.setConstraints(loginLabel, c);

        c.insets = new Insets(5, 0, 5, 0);
        c.ipadx = 150;
        c.ipady = 0;
        gridBagLayout.setConstraints(login, c);

        c.insets = new Insets(5, 0, 5, 75);
        c.ipadx = 0;
        c.ipady = 0;
        gridBagLayout.setConstraints(passwordLabel, c);

        c.insets = new Insets(5, 0, 5, 0);
        c.ipadx = 150;
        c.ipady = 0;
        gridBagLayout.setConstraints(password, c);

        c.insets = new Insets(90, 0, 35, 0);
        c.ipadx = 100;
        c.ipady = 30;
        gridBagLayout.setConstraints(logButton, c);

        add(welcome);
        add(loginLabel);
        add(login);
        add(passwordLabel);
        add(password);
        add(logButton);

        setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
                dispose();
                setVisible(false);
            }
        });

    }

    protected static GridBagConstraints getc()
    {
        return c;
    }
    public static void launch()
    {
        Login login = new Login();
        login.setVisible(true);
    }


}
