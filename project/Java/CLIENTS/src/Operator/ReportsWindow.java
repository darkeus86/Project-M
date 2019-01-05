package Operator;

import ApiProjectM.OrderInfoOperator;
import ApiProjectM.Reports;
import ApiProjectM.RequestManagerApi;
import com.alee.extended.panel.WebButtonGroup;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.radiobutton.WebRadioButton;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.caucho.hessian.client.HessianProxyFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReportsWindow extends WebFrame {

    WebTable reportsTable;
    WebButton cancelButton = new WebButton("Cancel");
    WebButton sendButton = new WebButton("Send");
    WebButton importTable = new WebButton("Import");
    ButtonGroup buttonGroup = new ButtonGroup();
    WebRadioButton daily = new WebRadioButton("Daily");
    WebRadioButton monthly = new WebRadioButton("Monthly");
    WebRadioButton annual = new WebRadioButton("Annual");
    WebRadioButton total = new WebRadioButton("Total");
    WebButton exit = new WebButton("Exit");
    WebLabel period = new WebLabel("Choose period");
    WebScrollPane scrollPane;


    ReportsWindow(){

        setSize(1000, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;
        c.gridwidth = GridBagConstraints.REMAINDER ;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(0, 0, 20, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1.0;
        c.weighty = 0.9;

        //Настройка группы кнопок
        buttonGroup.add(daily);
        buttonGroup.add(monthly);
        buttonGroup.add(annual);
        buttonGroup.add(total);
        daily.setSelected(true);

        cancelButton.setPreferredSize(110,35);
        sendButton.setPreferredSize(110,35);
        importTable.setPreferredSize(110,35);
        exit.setPreferredSize(110,35);

        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        RequestManagerApi apiTest = null;

        try {
            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }

        //Наполнение таблицы
        ArrayList<Reports> reports = new ArrayList<Reports>();
        try {
            reports = apiTest.selectReportsOperator();
            String[][] str1 = new String[reports.size()][4];
            for (int i = 0; i < reports.size(); i++) {
                str1[i][0] = Integer.toString(reports.get(i).getId());
                str1[i][1] = reports.get(i).getReporter();
                str1[i][2] = reports.get(i).getSubject();
                str1[i][3] = reports.get(i).getDate();
            }
            String[] str2 = new String[4];
            str2[0] = "Id";
            str2[1] = "Reporter";
            str2[2] = "Subject";
            str2[3] = "Date";
            reportsTable = new WebTable(str1, str2);
            reportsTable.setEditable(false);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        //Добавление таблицы на рабочую область
        scrollPane = new WebScrollPane(reportsTable);
        add(scrollPane, c);

        //Закрытие окна
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        //Отправка отчета
        sendButton.addActionListener(new ActionListener() {
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
                Date date = new Date();
                try {
                    String selectedButton;
                    if(daily.isSelected()){selectedButton = daily.getText();}
                    else if(monthly.isSelected()){selectedButton = monthly.getText();}
                    else if(annual.isSelected()){selectedButton = annual.getText();}
                    else selectedButton = total.getText();
                    apiTest.insertReports(1, "Alexey Kravchenko", selectedButton + "report", date.toString());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        //Располежение остальных элементов на рабочей области
        c.insets = new Insets(5, 0, 0, 0);
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.weighty = 0.01;
        add(period, c);

        c.insets = new Insets(0, 85, 15, 0);
        c.gridwidth = 3;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        add(daily, c);
        c.gridx = 3;
        add(monthly, c);
        c.gridx = 6;
        add(annual, c);
        c.gridx = 9;
        add(total, c);

        c.insets = new Insets(0, 85, 15, 55);
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 4;
        add(cancelButton, c);
        c.gridx = 4;
        add(sendButton, c);
        c.gridx = 8;
        add(importTable, c);

        c.gridy = 5;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(30,0,15, 30);
        add(exit, c);




    }

    public void launch()
    {
        setVisible(true);
    }

    public static void main(String[] args) {
        ReportsWindow reportsWindow = new ReportsWindow();
        reportsWindow.launch();
    }
}
