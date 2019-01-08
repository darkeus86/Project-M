package Operator;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.text.WebTextField;

import java.awt.*;

class SendTechnicalReport extends WebFrame {

    private static final GridBagConstraints c = new GridBagConstraints();

    private SendTechnicalReport(){

        setSize(700,700);
        setLocationRelativeTo(null);
        setResizable(false);
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        WebTextField versionT = new WebTextField("Project M v1.0(Beta)");
        versionT.setEnabled(false);
        WebTextField licenseT = new WebTextField("O00-00-01-A-K");
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

        WebButton cancel = new WebButton("Cancel");
        WebButton reset = new WebButton("Reset");
        WebButton send = new WebButton("Send");

        send.setPreferredSize(100, 50);
        cancel.setPreferredSize(100, 50);
        reset.setPreferredSize(100, 50);

        WebLabel head = new WebLabel("Fill the form to send us a report");
        add(head, c);
        WebLabel version = new WebLabel("Project M version:");
        add(version, c);
        add(versionT, c);
        WebLabel license = new WebLabel("License number:");
        add(license, c);
        add(licenseT, c);
        WebLabel name = new WebLabel("Your name:");
        add(name, c);
        WebTextField nameT = new WebTextField();
        add(nameT, c);
        WebLabel email = new WebLabel("Your e-mail:");
        add(email, c);
        WebTextField emailT = new WebTextField();
        add(emailT, c);
        WebLabel subject = new WebLabel("Subject:");
        add(subject, c);
        WebTextField subjectT = new WebTextField();
        add(subjectT, c);
        WebLabel attachedFiles = new WebLabel("Attached files:");
        add(attachedFiles, c);
        WebTextField attachedFilesT = new WebTextField();
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
