package Cart;

import com.alee.extended.date.WebCalendar;
import com.alee.extended.date.WebDateField;
import com.alee.extended.time.WebClock;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.spinner.WebSpinner;
import com.alee.laf.text.WebTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javafx.scene.control.Spinner;
import sun.util.calendar.JulianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CartMarkup {
    WebPanel mainPanel = new WebPanel();
    GridBagLayout gbL = new GridBagLayout();

    private GridBagConstraints constraints = new GridBagConstraints();

    int CART_WEIGHT = 300;
    int CART_HEIGHT = 520;

    WebLabel lDeliveryAdress = new WebLabel("Delivery address");
    WebLabel lTitle ;
    WebTextField phoneNum = new WebTextField("Input your phone");
    WebTextField exeption = new WebTextField("Input your phone");

    Date date = new Date(12);
    JDateChooser c =new JDateChooser(date);

    SpinnerModel numbers = new SpinnerNumberModel(0, 0, 24, 1);

    WebSpinner hour = new WebSpinner(numbers);
    WebSpinner min = new WebSpinner(numbers);
    public  CartMarkup(WebLabel title)
    {
        lTitle = new WebLabel(title.getText());



        mainPanel.setPreferredSize(CART_WEIGHT,  CART_HEIGHT);
        mainPanel.setBorder(BorderFactory.createTitledBorder("cart"));
        mainPanel.setLayout(gbL);

        constraints.fill = GridBagConstraints.BOTH;


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 2;
        constraints.gridwidth =2;
        mainPanel.add(lTitle,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth =2;
        mainPanel.add(phoneNum,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth =2;
        mainPanel.add(lDeliveryAdress,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth =2;
        mainPanel.add(c,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth =1;
        mainPanel.add(hour,constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth =1;
        mainPanel.add(min,constraints);



    }

    public WebPanel getPanel()
    {
        return mainPanel;
    }
}
