package User.profileMarkup;

import com.alee.extended.image.WebImage;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import java.awt.*;

public class profileMarkup {
    private WebPanel pProfile;
    private WebLabel lUserName = new WebLabel("Username");
    private WebLabel lAccountManagment = new WebLabel("Account managment");
    private final WebTextField tfFirstName= new WebTextField();
    private final WebTextField tfSecongName = new WebTextField();
    private WebTextField tfEmail = new WebTextField();
    private final WebTextField tfLogin = new WebTextField();
    private final WebTextField tfPassword = new WebTextField();
    private JRadioButton rbMale = new JRadioButton("Male");
    private JRadioButton rbFemale= new JRadioButton("Female");
    private WebImage iAvatar= new WebImage(".idea/resource/images/diet.png");
    private WebButton bSaveProfileInfo = new WebButton("Save");
    private WebButton bSaveAccoundChangeInfo = new WebButton("Save");
    private ButtonGroup group = new ButtonGroup();

    public ButtonGroup getGroup() {
        return group;
    }

    private GridBagLayout gbl = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private WebPanel containerPanel = new WebPanel();

    public WebButton getbSaveProfileInfo() {
        return bSaveProfileInfo;
    }

    public WebButton getbSaveAccoundChangeInfo() {
        return bSaveAccoundChangeInfo;
    }

    public void setpProfile(WebPanel pProfile) {
        this.pProfile = pProfile;
    }

    public void setlUserName(WebLabel lUserName) {
        this.lUserName = lUserName;
    }

    public void setlAccountManagment(WebLabel lAccountManagment) {
        this.lAccountManagment = lAccountManagment;
    }

    public void setTfFirstName(String firstName) {
        tfFirstName.setText(firstName);
    }

    public void setTfSecongName(String secondName) {
        tfSecongName.setText(secondName);
    }

    public void setTfEmail(WebTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    public void setTfLogin(String message) {
        tfLogin.setText(message);
    }

    public void setTfPassword(String message) {
        tfPassword.setText(message);
    }

    public void setRbMale(JRadioButton rbMale) {
        this.rbMale = rbMale;
    }

    public void setRbFemale(JRadioButton rbFemale) {
        this.rbFemale = rbFemale;
    }

    public void setiAvatar(WebImage iAvatar) {
        this.iAvatar = iAvatar;
    }

    public void setbSaveProfileInfo(WebButton bSaveProfileInfo) {
        this.bSaveProfileInfo = bSaveProfileInfo;
    }

    public void setbSaveAccoundChangeInfo(WebButton bSaveAccoundChangeInfo) {
        this.bSaveAccoundChangeInfo = bSaveAccoundChangeInfo;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }

    public void setGbl(GridBagLayout gbl) {
        this.gbl = gbl;
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public void setContainerPanel(WebPanel containerPanel) {
        this.containerPanel = containerPanel;
    }

    public profileMarkup()
    {
//        WebPanel containerPanel = new WebPanel();
        containerPanel.setLayout(new GridLayout());


        pProfile = new WebPanel();
        pProfile.setLayout(gbl);
        lUserName.setBorder(BorderFactory.createTitledBorder("Username"));
        lUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lAccountManagment.setHorizontalAlignment(SwingConstants.CENTER);
        tfFirstName.setBorder(BorderFactory.createTitledBorder("First name"));
        tfSecongName.setBorder(BorderFactory.createTitledBorder("Second name"));
        tfEmail.setBorder(BorderFactory.createTitledBorder("email"));
        tfLogin.setBorder(BorderFactory.createTitledBorder("Login"));
        tfPassword.setBorder(BorderFactory.createTitledBorder("Password"));
        iAvatar.setBorder(BorderFactory.createTitledBorder("Avatar"));

        rbMale.setActionCommand("Male");
        rbFemale.setActionCommand("Female");
        group.add(rbMale);
        group.add(rbFemale);

        constraints.gridx=0;
        constraints.gridy=0;
        constraints.ipadx = 150;
        constraints.ipady=15;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(0,0,0,0);
        constraints.anchor = GridBagConstraints.CENTER;
        pProfile.add(lUserName,constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.ipadx = 150;
        constraints.insets = new Insets(0,0,0,0);
        constraints.ipady=60;
        pProfile.add(iAvatar, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth= 2;
        constraints.gridheight = 1;
        constraints.ipadx = 150;
        constraints.ipady=15;
        pProfile.add(tfFirstName, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        pProfile.add(tfSecongName, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        pProfile.add(rbMale, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        pProfile.add(rbFemale, constraints);



        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        pProfile.add(tfEmail, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=5;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        pProfile.add(bSaveProfileInfo, constraints);


        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=6;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        pProfile.add(lAccountManagment, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=7;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        pProfile.add(tfLogin, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=8;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        pProfile.add(tfPassword, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx=0;
        constraints.gridy=9;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        pProfile.add(bSaveAccoundChangeInfo, constraints);

        containerPanel.add(pProfile);
    }

    public WebPanel getpProfile() {
        return pProfile;
    }

    public WebPanel getContainerPanel() {
        return containerPanel;
    }

    public WebLabel getlUserName() {
        return lUserName;
    }

    public WebLabel getlAccountManagment() {
        return lAccountManagment;
    }

    public WebTextField getTfFirstName() {
        return tfFirstName;
    }

    public WebTextField getTfSecongName() {
        return tfSecongName;
    }

    public WebTextField getTfEmail() {
        return tfEmail;
    }

    public WebTextField getTfLogin() {
        return tfLogin;
    }

    public WebTextField getTfPassword() {
        return tfPassword;
    }

    public JRadioButton getRbMale() {
        return rbMale;
    }

    public JRadioButton getRbFemale() {
        return rbFemale;
    }

    public WebImage getiAvatar() {
        return iAvatar;
    }



    public GridBagLayout getGbl() {
        return gbl;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }
}
