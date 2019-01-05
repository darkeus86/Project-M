import User.profileMarkup.profileMarkup;
import com.alee.laf.rootpane.WebFrame;

import java.awt.*;

public class test {
    public static void main(String[] args) {
        WebFrame frame = new WebFrame();
        profileMarkup profile = new profileMarkup();

        frame.setLayout(new GridLayout());
        frame.add(profile.getpProfile());

        frame.pack();
        frame.setVisible(true);

    }
}
