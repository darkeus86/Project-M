package AddingOperators;

import com.alee.laf.button.WebButton;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class WindowAddingOperator {
    WebFrame mainFrame;

    public WebButton getbAdd() {
        return bAdd;
    }

    WebPanel mainPanel;
    WebTextField tfId;
    WebTextField tfPersonFirstName;
    WebTextField tfPersonSecondName;

    MaskFormatter maskTelephone = new MaskFormatter("+7-(###)-###-##-##");
    JFormattedTextField tfPhone;
    public WebButton bAdd = new WebButton("Add operator!");

    WindowAddingOperator() throws ParseException {
        tfPhone = new JFormattedTextField(maskTelephone);
        mainFrame = new WebFrame();
        mainPanel = new WebPanel();

        tfPersonFirstName = new WebTextField();
        tfPersonSecondName = new WebTextField();

        tfPersonFirstName.setBorder(BorderFactory.createTitledBorder("Input first name operator"));
        tfPersonSecondName.setBorder(BorderFactory.createTitledBorder("Input second name operator"));
        tfPhone.setBorder(BorderFactory.createTitledBorder("Input phone operator"));

        GridBagLayout gbL = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        mainPanel.setLayout(gbL);



        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 100;
        constraints.ipady = 20;
        constraints.insets = new Insets(5,0,0,0);
        mainPanel.add(tfPersonFirstName,constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(tfPersonSecondName,constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(tfPhone,constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(bAdd,constraints);


        mainFrame.add(mainPanel);
    }

    public void init()
    {
        mainPanel.setPreferredSize(400,300);
        mainFrame.pack();
        mainFrame.setTitle("Operator manager");
        mainFrame.setVisible(true);
    }


    public WebTextField getTfPersonFirstName() {
        return tfPersonFirstName;
    }



    public WebTextField getTfPersonSecondName() {
        return tfPersonSecondName;
    }



    public JFormattedTextField getTfPhone() {
        return tfPhone;
    }

}
