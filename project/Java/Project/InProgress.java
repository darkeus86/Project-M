package Project;

import com.alee.laf.optionpane.WebOptionPane;
import com.alee.laf.rootpane.WebFrame;

import java.awt.*;

public class InProgress extends WebFrame {
    InProgress()
    {
    }

    public void showMessage(Component parent){
        WebOptionPane.showMessageDialog(parent, "Sorry, page unavailable. It will be added soon.",
                "Page in work", WebOptionPane.INFORMATION_MESSAGE);
    }
}
