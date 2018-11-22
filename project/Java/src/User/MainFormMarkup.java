package User;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;

import javax.swing.*;
import java.awt.*;


public class MainFormMarkup {

    int MAIN_FRAME_WEIGHT = 1050;
    int MAIN_FRAME_HEIGHT = 650;


    double NAV_WEIGHT = 0.15;
    int NAV_HEIGHT = 590;

    double CONTENT_WEIGHT = 0.85;
    int CONTENT_HEIGHT = 590;


    int BUTTON_WEIGHT = 150;
    int BUTTON_HEIGHT = 60;


    WebButton mainPageBut = new WebButton("Main page");
    WebButton myOrders = new WebButton("My orders");
    WebButton profile = new WebButton("Profile");
    WebButton ownRation = new WebButton("Own ration");


    WebFrame mainFrame;
    WebPanel navPanel = new WebPanel();
    WebPanel contentPanel = new WebPanel();

    public GridBagConstraints constraints = new GridBagConstraints();



    public void setContent(WebPanel contentPanel)
    {
        constraints.gridx = 1;
        constraints.gridy = 0;
        mainFrame.add(contentPanel, constraints);
    }

    public MainFormMarkup() {
        mainFrame = new WebFrame();
        mainFrame.setSize(MAIN_FRAME_WEIGHT, MAIN_FRAME_HEIGHT);
        mainFrame.add(navPanel);

        GridLayout gLayout = new GridLayout(4,0);
        GridBagLayout gbL = new GridBagLayout();

       mainPageBut.setPreferredSize(new Dimension(BUTTON_WEIGHT,BUTTON_HEIGHT));
        navPanel.setBorder(BorderFactory.createTitledBorder("nav"));
        navPanel.setLayout(gLayout);
        navPanel.add(mainPageBut);
        navPanel.add(myOrders);
        navPanel.add(profile);
        navPanel.add(ownRation);

        contentPanel.setBorder(BorderFactory.createTitledBorder("content"));

        mainFrame.setLayout(gbL);
        //GridBagConstraints constraints = new GridBagConstraints();  //этот объект позволяет настроить конкретную ячейку
        mainFrame.add(navPanel);

        //тут мы вставляем нашу панель навигации в mainFrame
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = NAV_WEIGHT;
        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        mainFrame.add(navPanel, constraints);

//        тут мы вставляем нашу панель контента в mainFrame
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.weightx = CONTENT_WEIGHT;
//        constraints.ipady = CONTENT_HEIGHT;
//        constraints.gridx = 1;
//        constraints.gridy = 0;
//        constraints.gridheight = 2;
//        mainFrame.add(contentPanel, constraints);

        //Вставка logout
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = NAV_WEIGHT;
        constraints.ipady = 40;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        WebLabel logout = new WebLabel("Logout");
        logout.setHorizontalAlignment(SwingConstants.CENTER);//
        mainFrame.add(logout, constraints);

    }


    public void init()
    {
        mainFrame.setTitle("Project M");
        mainFrame.setVisible(true);
    }

    public void setContent(WebButton object)
    {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = CONTENT_WEIGHT;
        constraints.ipady = CONTENT_HEIGHT;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        mainFrame.add(object, constraints);
    }

    public void deleteContent()
    {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = CONTENT_WEIGHT;
        constraints.ipady = CONTENT_HEIGHT;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 2;

    }

    public static void main(String args[]) {
        MainFormMarkup asd = new MainFormMarkup();
        asd.init();






    }

}
