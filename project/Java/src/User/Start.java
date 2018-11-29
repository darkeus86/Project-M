package User;

import Cart.CartMarkup;
import RationMurkup.Rations;
import com.alee.extended.image.WebImage;
import com.alee.laf.label.WebLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Start {
    public static void main(String args[]) throws ParseException {
        MainFormMarkup mainFrameUser = new MainFormMarkup();

        MainPageContentMarkup mainPageUser = new MainPageContentMarkup();
        MainPageContentMarkup mainPageUserTest = new MainPageContentMarkup();


        mainFrameUser.setContent(mainPageUser);
        mainFrameUser.setNavigation();
        mainFrameUser.init();

        mainFrameUser.setContent(mainPageUserTest);
        mainFrameUser.setNavigation();
        mainFrameUser.init();





        CartMarkup cartMarkup = new CartMarkup("Daily","123");
        CartMarkup cartMarkupTest = new CartMarkup("Daily","123");

        WebImage img = new WebImage("C:\\Users\\shut\\Desktop\\s.png");
        Rations Daily = new Rations("Daily food","lorusimpson1","20$", img);
        Rations Daily1 = new Rations("Daily food","lorusimpson2","20$", new WebImage());
        Rations Daily2 = new Rations("Daily food","lorusimpson3","20$", new WebImage());


        Rations Daily11 = new Rations("123","123","123$", new WebImage());
        Rations Daily22 = new Rations("123","123","123$", new WebImage());
        Rations Daily33 = new Rations("123","123","123$", new WebImage());

        // тест работы кнопки mainPage
        mainPageUser.setRation(Daily.getPanel(),0);
        mainPageUser.setRation(Daily1.getPanel(),1);
        mainPageUser.setRation(Daily2.getPanel(),2);
        mainPageUser.setCart(cartMarkup.getPanel());

        // тест работы кнопки myorders
        mainPageUserTest.setRation(Daily11.getPanel(),0);
        mainPageUserTest.setRation(Daily22.getPanel(),1);
        mainPageUserTest.setRation(Daily33.getPanel(),2);
        mainPageUserTest.setCart(cartMarkupTest.getPanel());

        mainFrameUser.getButton(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPageUser.getPanel().setVisible(true);
                mainPageUserTest.getPanel().setVisible(false);

            }
        });


        mainFrameUser.getButton(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPageUser.getPanel().setVisible(false);
                mainPageUserTest.getPanel().setVisible(true);
            }
        });

    }
}
