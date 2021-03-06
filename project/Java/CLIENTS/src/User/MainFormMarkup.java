package User;
import com.alee.laf.button.WebButton;
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

class MainFormMarkup {


    int NAV_HEIGHT = 500;

    private final WebButton mainPageBut = new WebButton("Main page");
    private final WebButton myOrders = new WebButton("My orders");
    private final WebButton profile = new WebButton("Profile");
    private final WebButton ownRation = new WebButton("Own ration");
    private final WebButton logout = new WebButton("Logout");

    private final WebFrame mainFrame;
    private final WebPanel navPanel = new WebPanel();
    private final WebPanel contentPanel = new WebPanel();

    private final GridBagConstraints constraints = new GridBagConstraints();

    public MainFormMarkup() {
        mainFrame = new WebFrame();
        int MAIN_FRAME_HEIGHT = 700;
        int MAIN_FRAME_WEIGHT = 1250;
        mainFrame.setSize(MAIN_FRAME_WEIGHT, MAIN_FRAME_HEIGHT);
        mainFrame.add(navPanel);

        logout.setHorizontalAlignment(SwingConstants.CENTER);//

        GridLayout gLayout = new GridLayout(5, 0);
        GridBagLayout gbL = new GridBagLayout();


      //  navPanel.setPreferredSize(150, 550);

        navPanel.setLayout(gLayout);
        navPanel.add(mainPageBut);
        navPanel.add(myOrders);
        navPanel.add(profile);
        navPanel.add(ownRation);
        navPanel.add(logout);


       mainFrame.setLayout(gbL);
    }

    public void init() {
        mainFrame.setTitle("User.Project M");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);


    }

    public void exit()
    {
        this.mainFrame.dispose();
    }


    public void setContent(WebPanel panel)  //Вставка панели контента(контент =
    {
        //содержимогу раздела[main page , my orders etc]) в nav


        contentPanel.removeAll();
        contentPanel.setLayout(new GridLayout());
        contentPanel.add(panel);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
//        constraints.insets = new Insets(0,0,0,0);
        mainFrame.add(contentPanel, constraints);
        contentPanel.repaint();



        //mainFrame.setVisible(true);
    }

    public void setNavigation() { //тут мы вставляем нашу панель навигации в mainFrame
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        int NAV_WEIGHT = 75;
        constraints.ipadx = NAV_WEIGHT;
        constraints.ipady = 50;
        constraints.anchor = GridBagConstraints.EAST;
//        constraints.insets = new Insets(0,0,0,0);
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
