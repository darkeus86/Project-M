package Project;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.tabbedpane.WebTabbedPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operator extends WebFrame {


    WebTabbedPane tabbedPane = new WebTabbedPane();
    MenuBar menuBar = new MenuBar();
    WebScrollPane newOrdersTable = (WebScrollPane) TableExample.getPreview();
    WebScrollPane myOrdersTable = (WebScrollPane) TableExample1.getPreview();
    WebScrollPane infromation;
    WebPanel panel = new WebPanel();
    WebPanel panelRight = new WebPanel();

    WebButton takeorder = new WebButton("Take the order");
    WebButton cancelorder = new WebButton("Cancel the order");
    WebButton confirmorder = new WebButton("Confirm implemetation");

    WebLabel customer = new WebLabel("Customer infromation");
    WebLabel firstname = new WebLabel();
    WebLabel secondname = new WebLabel();
    WebLabel adress = new WebLabel();
    WebLabel commentary = new WebLabel();
    WebLabel desiredtime = new WebLabel();
    WebLabel phone = new WebLabel();
    WebLabel ration = new WebLabel("Ration information");
    WebLabel title = new WebLabel();
    WebLabel courier = new WebLabel("Courier information");
    WebLabel firstcour = new WebLabel();
    WebLabel secondcour = new WebLabel();
    WebLabel phonecour = new WebLabel();
    WebLabel current = new WebLabel("Current status");
    WebLabel status = new WebLabel();

    String firstnames = new String(" Bob");
    String secondnames = new String(" Smit");
    String adresstr = new String(" ul. Professora Popova 5, 197376 St. Petersburg, Russian Federation");
    String desiredtimes = new String(" 10:00 27.11.2018");
    String phones = new String(" +7(900)000-00-00");
    String titles = new String(" Fit");
    String firstcours =  new String(" Alex");
    String secondcours = new String(" Smit");
    String phonecours = new String(" +7(900)000-00-01");
    String statustr = new String(" Free");

    protected static GridBagConstraints c = new GridBagConstraints();
    protected static GridBagConstraints cRight = new GridBagConstraints();
    static Operator operator = new Operator();
    static Login login = new Login();
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagLayout gridBagLayoutRight = new GridBagLayout();

    Operator()
    {

        setSize(1250,700);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Operator.EXIT_ON_CLOSE);

        c.anchor = GridBagConstraints.WEST;
        c.fill   = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth  = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.5;
        c.weighty = 1.0;
        add(menuBar, BorderLayout.NORTH);
        panel.setLayout(gridBagLayout);
        add(panel, BorderLayout.CENTER);

        cRight.anchor = GridBagConstraints.NORTHWEST;
        cRight.fill = GridBagConstraints.NONE;
        cRight.gridheight = 1;
        cRight.gridwidth = GridBagConstraints.REMAINDER;
        cRight.gridx = GridBagConstraints.RELATIVE;
        cRight.gridy = GridBagConstraints.RELATIVE;
        cRight.insets = new Insets(15, 25, 0, 0);
        cRight.ipadx = 0;
        cRight.ipady = 0;
        cRight.weightx = 1.0;
        cRight.weighty = 1.0;

        panelRight.setLayout(gridBagLayoutRight);

        firstname.setText("First name: " + firstnames);
        secondname.setText("Second name: " + secondnames);
        adress.setText("Address: " + adresstr);
        desiredtime.setText("Desired delivery time: " + desiredtimes);
        phone.setText("Phone: " + phones);
        title.setText("Title: " + titles);
        commentary.setText("Commentary: ");
        firstcour.setText("First name: " + firstcours);
        secondcour.setText("Second name: " + secondcours);
        phonecour.setText("Phone: " + phonecours);
        status.setText(statustr);

        customer.setFont(new Font("Times New Roman", Font.BOLD, 16));
        firstname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        secondname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        adress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        commentary.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        desiredtime.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        phone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        ration.setFont(new Font("Times New Roman", Font.BOLD, 16));
        title.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        courier.setFont(new Font("Times New Roman", Font.BOLD, 16));
        firstcour.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        secondcour.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        phonecour.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        current.setFont(new Font("Times New Roman", Font.BOLD, 16));
        status.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        status.setForeground(new java.awt.Color(31, 102, 13));

        gridBagLayoutRight.setConstraints(customer, cRight);
        panelRight.add(customer);
        gridBagLayoutRight.setConstraints(firstname, cRight);
        panelRight.add(firstname);
        gridBagLayoutRight.setConstraints(secondname, cRight);
        panelRight.add(secondname);
        gridBagLayoutRight.setConstraints(adress, cRight);
        panelRight.add(adress);
        gridBagLayoutRight.setConstraints(commentary, cRight);
        panelRight.add(commentary);
        gridBagLayoutRight.setConstraints(desiredtime, cRight);
        panelRight.add(desiredtime);
        gridBagLayoutRight.setConstraints(phone, cRight);
        panelRight.add(phone);
        gridBagLayoutRight.setConstraints(ration, cRight);
        panelRight.add(ration);
        gridBagLayoutRight.setConstraints(title, cRight);
        panelRight.add(title);
        gridBagLayoutRight.setConstraints(courier, cRight);
        panelRight.add(courier);
        gridBagLayoutRight.setConstraints(firstcour, cRight);
        panelRight.add(firstcour);
        gridBagLayoutRight.setConstraints(secondcour, cRight);
        panelRight.add(secondcour);
        gridBagLayoutRight.setConstraints(phonecour, cRight);
        panelRight.add(phonecour);
        gridBagLayoutRight.setConstraints(current, cRight);
        panelRight.add(current);
        gridBagLayoutRight.setConstraints(status, cRight);
        panelRight.add(status);

        tabbedPane.setTabPlacement(WebTabbedPane.LEFT);
        tabbedPane.addTab("New orders", newOrdersTable);
        tabbedPane.addTab("My orders", myOrdersTable);

        infromation = new WebScrollPane((Component) panelRight);
        infromation.createHorizontalScrollBar();

        gridBagLayout.setConstraints(tabbedPane, c);
        panel.add(tabbedPane);
        gridBagLayout.setConstraints(infromation, c);
        panel.add(infromation);

        MenuBar.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        MenuBar.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                main(null);
            }
        });

        MenuBar.makeReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendReport.launch();
            }
        });

        MenuBar.documentation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InProgress inProgress = new InProgress();
                inProgress.showMessage(operator);
            }
        });
    }


    public void launch(Login login)
    {
        Operator operator = new Operator();
        operator.setVisible(true);
    }

    public static void main(String[] args)
    {
        login.launch();
        login.logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator.launch(login);
            }
        });
    }
}
