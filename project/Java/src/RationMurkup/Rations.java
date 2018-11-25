package RationMurkup;

import com.alee.extended.image.WebImage;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Rations {

    WebPanel mainPanel = new WebPanel();
    WebLabel lTitle;
    WebTextField tfDescription;
    WebImage img;
    WebButton bToOrder = new WebButton("To order");
    WebLabel lPrice;
    int WEIGHT_RATION_PANEL = 700;
    int HEIGHT_RATION_PANEL = 170;

    GridBagLayout gbL = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();







    public Rations(String title, String description,String price, WebImage picture)
    {
        lTitle = new WebLabel(title);


        tfDescription = new WebTextField(description);
        img = picture;
        lPrice = new WebLabel(price);
        mainPanel.setPreferredSize(WEIGHT_RATION_PANEL, HEIGHT_RATION_PANEL);
        mainPanel.setBorder(BorderFactory.createTitledBorder("ration"));

        mainPanel.setLayout(gbL);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(img, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(bToOrder, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(lTitle, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(tfDescription, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 2;
        mainPanel.add(lPrice, constraints);

    }


    public WebPanel getPanel()
    {
        return mainPanel;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public String getTitle() {
        return lTitle.getText();
    }

    public String getDescription() {
        return tfDescription.getText();
    }

    public WebImage getImg() {
        return img;
    }
}
