package User.Cart;

import com.alee.laf.panel.WebPanel;

import javax.swing.*;
import java.awt.*;

public class Intermediate_Picture {
    WebPanel intermediatePanel;
    WebPanel picturePanel;
    public WebPanel getIntermediatePanel() {
        return intermediatePanel;
    }

    public Intermediate_Picture()
    {
        picturePanel = new WebPanel();
        intermediatePanel = new WebPanel();
        intermediatePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        picturePanel.setBackground(new Color(32,123,223));
        picturePanel.setBorder(BorderFactory.createTitledBorder("13"));
//

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx =0;
        constraints.gridy =0;
        constraints.ipadx = 300;
        constraints.ipady = 495;
        intermediatePanel.add(picturePanel,constraints);
    }
}
