package User.Cart;

import com.alee.extended.image.WebImage;
import com.alee.laf.panel.WebPanel;

import javax.swing.*;
import java.awt.*;

public class Intermediate_Picture {
    WebPanel intermediatePanel;
    WebImage img;
    public WebPanel getIntermediatePanel() {
        return intermediatePanel;
    }

    public Intermediate_Picture()
    {
        img = new WebImage("C:\\Users\\shut\\Desktop\\cart.png");
        intermediatePanel = new WebPanel();
        intermediatePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        intermediatePanel.setBackground(new Color(80,80,80));

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx =0;
        constraints.gridy =0;
        constraints.ipadx = 300;
        constraints.ipady = 495;
        intermediatePanel.add(img,constraints);
    }
}
