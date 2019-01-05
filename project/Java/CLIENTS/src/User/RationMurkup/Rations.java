package User.RationMurkup;

import com.alee.extended.image.WebImage;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.text.WebTextArea;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import java.awt.*;


public class Rations {

    WebPanel mainPanel = new WebPanel();
    WebLabel lTitle;

   WebTextField tfDescription;

    WebImage img;
    WebButton bToOrder = new WebButton("To order");
    WebLabel lPrice;

    GridBagLayout gbL = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    public Rations(String title, String description, String price, WebImage picture) {
        lTitle = new WebLabel(title);
        lTitle.setBackground(new Color(75,75,75));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        tfDescription = new WebTextField(description);


        tfDescription.setBackground(new Color(150,150,150));
        tfDescription.setHorizontalAlignment(SwingConstants.CENTER);


        img = picture;
        lPrice = new WebLabel(price);

        mainPanel.setLayout(gbL);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 100;
        constraints.ipady = 100;
        constraints.gridheight = 2;
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(img, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.ipadx = 100;
        constraints.gridheight = 1;
        constraints.ipady = 10;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 0, 0);
        mainPanel.add(bToOrder, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.ipadx = 400;
        constraints.gridheight = 1;
        constraints.ipady = 10;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 0, 5);
        mainPanel.add(lTitle, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipadx = 400;
        constraints.ipady = 75;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 0, 5);
        mainPanel.add(tfDescription, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.ipadx = 400;
        constraints.ipady = 10;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 0, 0);
        mainPanel.add(lPrice, constraints);

    }


    public WebPanel getPanel() {
        return mainPanel;
    }

    public WebImage getImg() {
        return img;
    }

    public WebLabel getlTitle() {
        return lTitle;
    }

    public WebButton getbToOrder() {
        return bToOrder;
    }

    public WebLabel getlPrice() {
        return lPrice;
    }

    public void setlTitle(WebLabel lTitle) {
        this.lTitle = lTitle;
    }

    public void setTfDescription(WebTextField tfDescription) {
        this.tfDescription = tfDescription;
}


    public void setImg(WebImage img) {
        this.img = img;
    }

    public void setlPrice(WebLabel lPrice) {
        this.lPrice = lPrice;
    }
}
