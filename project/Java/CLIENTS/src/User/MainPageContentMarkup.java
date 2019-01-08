package User;
import com.alee.laf.panel.WebPanel;

import java.awt.*;


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

class MainPageContentMarkup {

    private final WebPanel mainPanel = new WebPanel();

    private static final GridBagConstraints constraints = new GridBagConstraints();

    public MainPageContentMarkup() {
        GridBagLayout gbL = new GridBagLayout();
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

