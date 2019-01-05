package Operator;

import ApiProjectM.CourierInfoOperator;
import ApiProjectM.OrderInfoOperator;
import ApiProjectM.RequestManagerApi;
import AuthorizationAndRegistration.Authorization.Authorization;
import AuthorizationAndRegistration.Registration.Registration;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.table.WebTable;
import com.caucho.hessian.client.HessianProxyFactory;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Operator extends WebFrame {


    WebTabbedPane tabbedPane = new WebTabbedPane();
    MenuBar menuBar = new MenuBar();
    WebTable newOrdersTable;
    WebScrollPane newOrdersScroll;
    WebTable myOrdersTable;
    WebScrollPane myOrdersScroll;
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

    private String firstnames = Content.getFirstName();
    private String secondnames = Content.getSecondName();
    private String addresstr = Content.getAddress();
    private String desiredtimes = Content.getDesiredTime();
    private String phones = Content.getPhone();
    private String titles = Content.getTitle();
    private String firstcours = Content.getFirstName();
    private String secondcours = Content.getSecondName();
    private String phonecours = Content.getPhone();
    private String statustr = Content.getStatus();

    protected static GridBagConstraints c = new GridBagConstraints();
    protected static GridBagConstraints cRight = new GridBagConstraints();
    static Operator operator = new Operator();
    static Login login = new Login();
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagLayout gridBagLayoutRight = new GridBagLayout();

    Operator() {

        setSize(1250, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Operator.EXIT_ON_CLOSE);

        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        RequestManagerApi apiTest = null;

        try {
            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }

        //Заполняем таблицу
        String[] str = new String[3];
        ArrayList<OrderInfoOperator> orderInfo = new ArrayList<OrderInfoOperator>();
        try {
            orderInfo = apiTest.selectInformationOrder();
            String[][] str1 = new String[orderInfo.size()][3];
            String[][] str3 = new String[orderInfo.size()][3];
            for (int i = 0; i < orderInfo.size(); i++) {

                if(orderInfo.get(i).getStatus() == 0){
                    str1[i][0] = Integer.toString(orderInfo.get(i).getOrderId());
                    str1[i][1] = orderInfo.get(i).getOrderTitle();
                    str1[i][2] = orderInfo.get(i).getOrderDate() + " " + orderInfo.get(i).getOrderTime();}
                else{
                    str3[i][0] = Integer.toString(orderInfo.get(i).getOrderId());
                    str3[i][1] = orderInfo.get(i).getOrderTitle();
                    str3[i][2] = orderInfo.get(i).getOrderDate() + " " + orderInfo.get(i).getOrderTime();
                }
            }
            String[] str2 = new String[3];
            str2[0] = "Id";
            str2[1] = "Title";
            str2[2] = "Time";
            myOrdersTable = new WebTable(str3, str2);
            myOrdersTable.setEditable(false);
            newOrdersTable = new WebTable(str1, str2);
            newOrdersTable.setEditable(false);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        myOrdersScroll = new WebScrollPane(myOrdersTable);
        newOrdersScroll = new WebScrollPane(newOrdersTable);
        System.out.println(myOrdersTable.getValueAt(1,0));
        int row = myOrdersTable.getSelectedRow();
        if (row == -1) {

        } else {
            desiredtimes = (String) myOrdersTable.getValueAt(row, 3);
        }

        //Слушаем нажатия мыши по таблице
        newOrdersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = newOrdersTable.getSelectedRow();
                    //Проверяем попал ли пользователь по строке
                    if (row == -1) {

                    } else {
                        String serverAddress = "http://localhost:8080/";
                        HessianProxyFactory factory = new HessianProxyFactory();
                        RequestManagerApi apiTest = null;

                        try {
                            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }

                        ArrayList<OrderInfoOperator> orderInfo = new ArrayList<OrderInfoOperator>();
                        try {
                            orderInfo = apiTest.selectInformationOrder();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        ArrayList<CourierInfoOperator> courierInfo = new ArrayList<>();
                        try {
                            courierInfo = apiTest.selectInformationCourier();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        //Получаем данные из БД
                        int orderId = Integer.valueOf(myOrdersTable.getValueAt(row, 0).toString())-1;
                        firstnames = orderInfo.get(orderId).getOrderFirstName();
                        secondnames = orderInfo.get(orderId).getOrderSecondName();
                        desiredtimes = orderInfo.get(orderId).getOrderDate() + " " + orderInfo.get(orderId).getOrderTime();
                        addresstr = orderInfo.get(orderId).getOrderCity() + ", " + orderInfo.get(orderId).getOrderStreet()
                                + ", " + orderInfo.get(orderId).getOrderHouse() + ", " +
                                orderInfo.get(orderId).getOrderHousing() + ", " + orderInfo.get(orderId).getOrderRoom();
                        phones = orderInfo.get(orderId).getOrderPhone();
                        titles = orderInfo.get(orderId).getOrderTitle();
                        firstcours = courierInfo.get(1).getOperatorFirstName();
                        secondcours = courierInfo.get(1).getOperatorSecondName();
                        phonecours = courierInfo.get(1).getOperatorPhone();
                        if(orderInfo.get(orderId).getStatus()==0)
                            statustr = "Free";
                        else statustr = "Cooking";
                        RequestManagerApi finalApiTest = apiTest;
                        takeorder.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    finalApiTest.updateStatus(orderId, 1);
                                } catch (ClassNotFoundException e1) {
                                    e1.printStackTrace();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                                status.setText("Cooking");
                                panelRight.remove(takeorder);
                            }
                        });
                    }

                    //Заполняем данные правой панели
                    desiredtime.setText("Desired delivery time: " + desiredtimes);
                    firstname.setText("First name: " + firstnames);
                    secondname.setText("Second name: " + secondnames);
                    adress.setText("Address: " + addresstr);
                    desiredtime.setText("Desired delivery time: " + desiredtimes);
                    phone.setText("Phone:" + phones);
                    title.setText("Title: " + titles);
                    firstcour.setText("First name: " + firstcours);
                    secondcour.setText("Second name: " + secondcours);
                    phonecour.setText("Phone: " + phonecours);

                    takeorder = new WebButton("Take order");

                    panelRight.add(takeorder, cRight);


                }
            }
        });
        System.out.print(desiredtimes);

        //Создаем констреинтс
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
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

        //Формуируем щаблон правой панели
        firstname.setText("First name: ");
        secondname.setText("Second name: ");
        adress.setText("Address: ");
        desiredtime.setText("Desired delivery time: ");
        phone.setText("Phone: ");
        title.setText("Title: ");
        commentary.setText("Commentary: ");
        firstcour.setText("First name: ");
        secondcour.setText("Second name: ");
        phonecour.setText("Phone: ");
        status.setText("Free");


        //Форматирование текста
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

        //Заполняем панель
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
        panelRight.add(firstcour, cRight);
        panelRight.add(secondcour, cRight);
        panelRight.add(phonecour, cRight);
        panelRight.add(current, cRight);
        panelRight.add(status, cRight);

        tabbedPane.setTabPlacement(WebTabbedPane.LEFT);
        tabbedPane.addTab("New orders", newOrdersScroll);
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
                try {
                    main(null);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        MenuBar.makeReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendTechnicalReport.launch();
            }
        });

        MenuBar.documentation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InProgress inProgress = new InProgress();
                inProgress.showMessage(operator);
            }
        });

        MenuBar.myReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportsWindow reportsWindow = new ReportsWindow();
                reportsWindow.launch();
            }
        });
    }


    public void launch(Login login) {
        Operator operator = new Operator();
        operator.setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, MalformedURLException {

        Authorization authorizationWindow = new Authorization();


        authorizationWindow.getbLogButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverAddress = "http://localhost:8080/";
                HessianProxyFactory factory = new HessianProxyFactory();
                RequestManagerApi apiTest = null;

                boolean validation = false;


                try {
                    apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
                String pass = new String(authorizationWindow.getPassword().getPassword());
                validation = apiTest.selectValidationAuthorization(authorizationWindow.getLogin().getText(), pass);
                System.out.print("validation from autor:" + validation);

                if (!validation) {
                    authorizationWindow.dispose();
                    operator.launch(login);
                }
            }
        });


        authorizationWindow.getbRegistration().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorizationWindow.dispose();
                Registration registration = new Registration();

                registration.getbCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration.dispose();
                        authorizationWindow.setVisible(true);
                    }
                });
                registration.getbRegistration().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String serverAddress = "http://localhost:8080/";
                        HessianProxyFactory factory = new HessianProxyFactory();
                        RequestManagerApi apiTest = null;
                        try {
                            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        System.out.print(apiTest.selectValidationRegistration(registration.getLogin().getText()));
                        String pass = new String(registration.getPfPassword().getPassword());
                        String repeatPass = new String(registration.getPfRepeatPassword().getPassword());
                        boolean validation = (apiTest.selectValidationRegistration(registration.getLogin().getText()));

                        if ((validation) && (pass.equals(repeatPass))) {
                            System.out.print("registration test");
                            System.out.print(registration.getPfPassword().getText());
                            registration.dispose();
                            authorizationWindow.setVisible(true);
                            try {
                                System.out.print(apiTest.insertSimpleUser(registration.getLogin().getText(), pass));
                            } catch (ClassNotFoundException | SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
            }
        });

    }
}



