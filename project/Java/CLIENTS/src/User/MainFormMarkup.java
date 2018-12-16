package User;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;

import javax.swing.*;
import java.awt.*;

/*###########################################
    Разметка мета окна юзера. Содержит гридбеглайот таблицу на 1 строку и 2 столбца.
    первый (левый) столбец содержит nav панель
    правый содержит панель контента, обновляется в зависимости от перехода по nav.

    сама nav панель это оыбчный гридлайот, на 5 элементов.
###########################################*/

public class MainFormMarkup {

    int MAIN_FRAME_WEIGHT = 1250;
    int MAIN_FRAME_HEIGHT = 700;


    int NAV_WEIGHT = 75;
    int NAV_HEIGHT = 500;

    WebButton mainPageBut = new WebButton("Main page");
    WebButton myOrders = new WebButton("My orders");
    WebButton profile = new WebButton("Profile");
    WebButton ownRation = new WebButton("Own ration");
    WebButton logout = new WebButton("Logout");

    WebFrame mainFrame;
    public WebPanel navPanel = new WebPanel();
    WebPanel contentPanel = new WebPanel();

    public GridBagConstraints constraints = new GridBagConstraints();

    public MainFormMarkup() {
        mainFrame = new WebFrame();
        mainFrame.setSize(MAIN_FRAME_WEIGHT, MAIN_FRAME_HEIGHT);
        mainFrame.add(navPanel);

        logout.setHorizontalAlignment(SwingConstants.CENTER);//

        GridLayout gLayout = new GridLayout(5, 0);
        GridBagLayout gbL = new GridBagLayout();


        navPanel.setPreferredSize(150, 550);

        //navPanel.setBorder(BorderFactory.createTitledBorder("nav"));
        navPanel.setLayout(gLayout);
        navPanel.add(mainPageBut);
        navPanel.add(myOrders);
        navPanel.add(profile);
        navPanel.add(ownRation);
        navPanel.add(logout);

        contentPanel.setBorder(BorderFactory.createTitledBorder("content"));
        mainFrame.setLayout(gbL);
    }

    public void init() {
        mainFrame.setTitle("User.Project M");
        mainFrame.setVisible(true);
    }

    public void exit()
    {
        this.mainFrame.dispose();
    }


    public void setContent(MainPageContentMarkup object)  //Вставка панели контента(контент =
    {                                                     //содержимогу раздела[main page , my orders etc]) в nav
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,0,0,0);
        mainFrame.add(object.getPanel(), constraints);
    }

    public void setNavigation() { //тут мы вставляем нашу панель навигации в mainFrame
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = NAV_WEIGHT;
        constraints.ipady = NAV_HEIGHT;
        constraints.insets = new Insets(0,0,0,100);
        mainFrame.add(navPanel, constraints);
    }

    public WebButton getButton(int id) { //вся логика переключений кнопок должна быть в start, обычный геттер
        switch (id) {
            case 1: {
                return mainPageBut;
            }
            case 2: {
                return myOrders;
            }
            case 3: {
                return profile;
            }
            case 4: {
                return ownRation;
            }
            case 5:
            {
                return logout;
            }
        }
        return null;
    }

}
