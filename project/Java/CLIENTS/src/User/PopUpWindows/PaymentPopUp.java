package User.PopUpWindows;

import com.alee.laf.button.WebButton;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PaymentPopUp {
    private final WebFrame paymentFrame = new WebFrame();
    private final WebPasswordField pfCVC = new WebPasswordField();
    private final WebTextField tfCardNumber = new WebTextField();
    private final WebTextField tfFirstName = new WebTextField();
    private final WebTextField tfSecondName = new WebTextField();
    private final WebButton bPay = new WebButton("Pay!");
    private final WebButton bCancel = new WebButton("Cancel");
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
        return tfFirstName.getText().trim().length() != 0 && tfSecondName.getText().trim().length() != 0 && pfCVC.getPassword().toString().trim().length() != 0 && tfCardNumber.getText().trim().length() != 0;
    }

    public PaymentPopUp()
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

        GridBagLayout gbL = new GridBagLayout();
        paymentFrame.setLayout(gbL);
        paymentFrame.setTitle("Payment");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill=GridBagConstraints.BOTH;
        constraints.ipadx = 100;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        paymentFrame.add(tfCardNumber, constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        paymentFrame.add(pfCVC, constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        paymentFrame.add(tfFirstName, constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        paymentFrame.add(tfSecondName, constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        paymentFrame.add(bPay, constraints);

        constraints.fill=GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        paymentFrame.add(bCancel, constraints);


        paymentFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        paymentFrame.pack();
        paymentFrame.setLocationRelativeTo(null);
        paymentFrame.setVisible(true);
    }

    public WebFrame getPaymentFrame() {
        return paymentFrame;
    }
}
