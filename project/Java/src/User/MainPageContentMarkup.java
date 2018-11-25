package User;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageContentMarkup {

    WebPanel mainPanel = new WebPanel();

    GridBagLayout gbL = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();


    public MainPageContentMarkup() {

        mainPanel.setLayout(gbL);
        mainPanel.setPreferredSize(700, 150);
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 3;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weightx = 1;
        mainPanel.setBorder(BorderFactory.createTitledBorder("test"));
    }


    public void setContent1(WebPanel object, int id) {
        constraints.gridx = 0;
        constraints.gridy = id;
        constraints.anchor = GridBagConstraints.NORTH;
        mainPanel.add(object, constraints);
    }

    public void setContent2(WebPanel object, int id) {
        constraints.gridx = 0;
        constraints.gridy = id;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(object, constraints);
    }

    public void setContent3(WebPanel object, int id) {
        constraints.gridx = 0;
        constraints.gridy = id;
        constraints.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(object, constraints);
    }

    public void setCart(WebPanel object) {
        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(object, constraints);
    }

    public WebPanel getPanel() {
        return mainPanel;
    }

}

