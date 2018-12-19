package User.Pop_up_windows;

import com.alee.laf.button.WebButton;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Payment_Pop_Up {
    WebFrame paymentFrame = new WebFrame();
    WebPasswordField pfCVC = new WebPasswordField();
    WebTextField tfCardNumber = new WebTextField();
    WebTextField tfFirstName = new WebTextField();
    WebTextField tfSecondName = new WebTextField();
    WebButton bPay = new WebButton("Pay!");
    WebButton bCancel = new WebButton("Cancel");
    GridBagLayout gbL = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    boolean confirmSuccess = false;
    public WebPasswordField getPfCVC() {
        return pfCVC;
    }

    public WebTextField getTfCardNumber() {
        return tfCardNumber;
    }

    public WebTextField getTfFirstName() {
        return tfFirstName;
    }

    public WebTextField getTfSecondName() {
        return tfSecondName;
    }

    public WebButton getbPay() {
        return bPay;
    }

    public WebButton getbCancel() {
        return bCancel;
    }

    public boolean fieldValidation()
    {
        if (tfFirstName.getText().trim().length() != 0 && tfSecondName.getText().trim().length()!=0 && pfCVC.getPassword().toString().trim().length()!= 0 && tfCardNumber.getText().trim().length()!=0)
            return true;
        else return false;
    }

    public Payment_Pop_Up()
    {
        bCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentFrame.dispose();
            }
        });



        pfCVC.setBorder(BorderFactory.createTitledBorder("CVC"));
        tfCardNumber.setBorder(BorderFactory.createTitledBorder("Card number"));
        tfFirstName.setBorder(BorderFactory.createTitledBorder("First name"));
        tfSecondName.setBorder(BorderFactory.createTitledBorder("Second name"));

        paymentFrame.setLayout(gbL);
        paymentFrame.setTitle("Payment");
        constraints.fill=GridBagConstraints.BOTH;
        constraints.ipadx = 100;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        paymentFrame.add(tfCardNumber,constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        paymentFrame.add(pfCVC,constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        paymentFrame.add(tfFirstName,constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        paymentFrame.add(tfSecondName,constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        paymentFrame.add(bPay,constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        paymentFrame.add(bCancel,constraints);
        paymentFrame.setVisible(true);
        paymentFrame.pack();
    }

    public WebFrame getPaymentFrame() {
        return paymentFrame;
    }
}
