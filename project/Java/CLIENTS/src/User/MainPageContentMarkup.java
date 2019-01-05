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


/*###########################################
    Разметка main page юзера. Содержит рационы и корзину.
    все держится на гридбеглайот. Пока что количество рационов 3, но по идее можно безнаказанно добавлять
    n рационов, просто надо прикрутить полосу прокрутки и псевдорастягивать корзину через
    constraints.gridheight = n ;

    Сама структура выглядит так:
    ------------
    #  1 #  c  #
    ------  a  #
    #  2 #  r  #
    ------  t  #
    #  3 #     #
    ------------

###########################################*/

public class MainPageContentMarkup {

    WebPanel mainPanel = new WebPanel();

    GridBagLayout gbL = new GridBagLayout();
    private static GridBagConstraints constraints = new GridBagConstraints();

    public MainPageContentMarkup() {
        mainPanel.setLayout(gbL);
      //  mainPanel.setPreferredSize(1000, 1000);
        //mainPanel.setBorder(BorderFactory.createTitledBorder("MainPAgeContentMark"));
    }

//вставка рациона непосредственно в раздел main page (user)
    public void setRation(WebPanel object, int id)
    {
        object.setBackground(new Color (120,120,120));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = id;
        constraints.insets = new Insets(15,0,0,50);
        constraints.anchor = GridBagConstraints.NORTH;
        mainPanel.add(object, constraints);
    }

    public void setCart(WebPanel object) {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 3;
        constraints.insets = new Insets(15,30,0,30);
        mainPanel.add(object, constraints);
    }

    public WebPanel getPanel() {
        return mainPanel;
    }

}

