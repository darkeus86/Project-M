package Project;

import com.alee.laf.button.WebButton;
import com.alee.laf.rootpane.WebFrame;

public class SendReport extends WebFrame {

    WebButton send = new WebButton("Send");
    WebButton cancel = new WebButton("Cancel");
    WebButton reset = new WebButton("Reset");

    SendReport(){
        add(send);
        add(cancel);
        add(reset);
    }

    public static void launch()
    {
        SendReport sendReport = new SendReport();
        sendReport.setVisible(true);
    }

}
