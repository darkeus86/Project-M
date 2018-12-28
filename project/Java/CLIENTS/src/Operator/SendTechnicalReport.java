package Operator;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebTextField;

import java.awt.*;

public class SendTechnicalReport extends WebFrame {

    WebButton send = new WebButton("Send");
    WebButton cancel = new WebButton("Cancel");
    WebButton reset = new WebButton("Reset");

    WebLabel version = new WebLabel("Project M version:");
    WebLabel license = new WebLabel("License number:");
    WebLabel name = new WebLabel("Your name:");
    WebLabel email = new WebLabel("Your e-mail:");
    WebLabel subject = new WebLabel("Subject:");
    WebLabel attachedFiles = new WebLabel("Attached files:");
    WebLabel head = new WebLabel("Fill the form to send us a report");

    WebTextField versionT = new WebTextField("Project M v1.0(Beta)");
    WebTextField licenseT = new WebTextField("O00-00-01-A-K");
    WebTextField nameT = new WebTextField();
    WebTextField emailT = new WebTextField();
    WebTextField subjectT = new WebTextField();
    WebTextField attachedFilesT = new WebTextField();

    protected static GridBagConstraints c = new GridBagConstraints();
    GridBagLayout gridBagLayout = new GridBagLayout();

    SendTechnicalReport(){

        setSize(700,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(gridBagLayout);

        versionT.setEnabled(false);
        licenseT.setEnabled(false);

       // c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipady = 0;
        c.ipadx = 0;
        c.weighty = 1.0;
        c.weightx = 1.0;

        //send.setPreferredSize(100, 50);
        //cancel.setPreferredSize(100, 50);
        //reset.setPreferredSize(100, 50);

        add(head, c);
        add(version, c);
        add(versionT, c);
        add(license, c);
        add(licenseT, c);
        add(name, c);
        add(nameT, c);
        add(email, c);
        add(emailT, c);
        add(subject, c);
        add(subjectT, c);
        add(attachedFiles, c);
        add(attachedFilesT, c);

        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 13;
        c.insets = new Insets(0, 10, 0, 10);

        add(send, c);
        c.gridx = 2;
        add(cancel, c);
        c.gridx = 3;
        add(reset, c);
    }

    public static void launch()
    {
        SendTechnicalReport sendTechnicalReport = new SendTechnicalReport();
        sendTechnicalReport.setVisible(true);
    }

}
