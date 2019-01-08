package User.Cart;

import com.alee.extended.image.WebImage;
import com.alee.laf.panel.WebPanel;

import java.awt.*;

public class IntermediatePicture {
    private final WebPanel intermediatePanel;

    public WebPanel getIntermediatePanel() {
        return intermediatePanel;
    }

    public IntermediatePicture()
    {
        WebImage img = new WebImage(".idea/resource/images/cart.png");
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
