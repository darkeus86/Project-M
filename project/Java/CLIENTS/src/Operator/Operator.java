package Operator;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.table.WebTable;

import java.awt.*;
import java.awt.event.*;

public class Operator extends WebFrame {


    WebTabbedPane tabbedPane = new WebTabbedPane();
    MenuBar menuBar = new MenuBar();
    WebScrollPane newOrdersTable = (WebScrollPane) NewOrdersTable.getPreview();
    MyOrdersTable myOrdersTableModel = new MyOrdersTable();
    WebTable myOrdersTable = new WebTable(myOrdersTableModel);
    WebScrollPane myOrdersScroll = new WebScrollPane(myOrdersTable);
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

    String firstnames = Content.getFirstName();
    String secondnames = Content.getSecondName();
    String addresstr = Content.getAddress();
    String desiredtimes = Content.getDesiredTime();
    String phones = Content.getPhone();
    String titles = Content.getTitle();
    String firstcours =  Content.getFirstName();
    String secondcours = Content.getSecondName();
    String phonecours = Content.getPhone();
    String statustr = Content.getStatus();

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
        String str = new String("");
        myOrdersTableModel.addData(str);
        int row = myOrdersTable.getSelectedRow();
        if(row == -1){

        }
        else
        {
            desiredtimes = (String)myOrdersTable.getValueAt(row, 3);
        }

        myOrdersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.print("test 1");
                if(e.getClickCount() == 2) {
                    System.out.print("test 2");
                    int row = myOrdersTable.getSelectedRow();
                    if(row == -1){

                    }
                    else
                    {
                        System.out.print("test 3");
                        desiredtimes = (String)myOrdersTable.getValueAt(row, 3);
                    }
                    desiredtime.setText("Desired delivery time: " + desiredtimes);
                }
            }
        });
        System.out.print(desiredtimes);

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
        adress.setText("Address: " + addresstr);
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

        status.setForeground(new Color(31, 102, 13));

        panelRight.add(customer, cRight);
        panelRight.add(firstname, cRight);
        panelRight.add(secondname, cRight);
        panelRight.add(adress, cRight);
        panelRight.add(commentary, cRight);
        panelRight.add(desiredtime, cRight);
        panelRight.add(phone, cRight);
        panelRight.add(ration, cRight);
        panelRight.add(title, cRight);
        panelRight.add(courier, cRight);
        panelRight.add(firstcour, cRight);;
        panelRight.add(secondcour, cRight);
        panelRight.add(phonecour, cRight);
        panelRight.add(current, cRight);
        panelRight.add(status, cRight);

        tabbedPane.setTabPlacement(WebTabbedPane.LEFT);
        tabbedPane.addTab("New orders", newOrdersTable);
        tabbedPane.addTab("My orders", myOrdersScroll);

        infromation = new WebScrollPane((Component) panelRight);
        infromation.createHorizontalScrollBar();

        panel.add(tabbedPane, c);
        panel.add(infromation, c);

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
