package User;

import Cart.CartMarkup;
import RationMurkup.Rations;
import com.alee.extended.image.WebImage;
import com.alee.laf.label.WebLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    public static void main(String args[]) {
        MainFormMarkup asd = new MainFormMarkup();
        asd.init();

        MainPageContentMarkup testMurkup = new MainPageContentMarkup();
        asd.setContent(testMurkup);

        CartMarkup cartMarkup = new CartMarkup(new WebLabel("Daily"));

        Rations Daily = new Rations("DAily food","lorusimpson1","20$", new WebImage());
        Rations Daily1 = new Rations("DAily food","lorusimpson2","20$", new WebImage());
        Rations Daily2 = new Rations("DAily food","lorusimpson3","20$", new WebImage());


        testMurkup.setContent1(Daily.getPanel(),0);
        testMurkup.setContent2(Daily1.getPanel(),1);
        testMurkup.setContent3(Daily2.getPanel(),2);
        testMurkup.setCart(cartMarkup.getPanel());

        asd.getButton(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testMurkup.getPanel().setVisible(true);
            }
        });


        asd.getButton(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testMurkup.getPanel().setVisible(false);
            }
        });

    }
}
