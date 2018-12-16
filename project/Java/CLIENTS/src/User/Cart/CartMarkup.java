package User.Cart;

import com.alee.laf.button.WebButton;
import com.alee.laf.combobox.WebComboBox;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.spinner.WebSpinner;
import com.alee.laf.text.WebTextField;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;

/*###########################################
    CartMurkup включает в себя разметку данных корзины на главной странице пользователя.
    Создается по конструктору. Если нужны изменения данных, то после нажатия to order сеттером задаются
    информационные лабелы.
    Геттеры тож присутсвуют.
###########################################*/

public class CartMarkup {
    WebPanel mainPanel = new WebPanel();
    GridBagLayout gbL = new GridBagLayout();

    private GridBagConstraints constraintsCart = new GridBagConstraints();

    WebButton bCancel = new WebButton("Cancel");
    WebButton bConfirm = new WebButton("Confirm");

    WebLabel lDeliveryAdress = new WebLabel("Delivery address");
    WebLabel lTitle = new WebLabel();
    WebLabel lPrice = new WebLabel();


    WebTextField tfHouse = new WebTextField();
    WebTextField tfHousing = new WebTextField();
    WebTextField tfRoom = new WebTextField();
    WebTextField tfFirstName = new WebTextField();
    WebTextField tfSecondName = new WebTextField();

    String[] cities = {"St. Petersburg"};
    String[] streets = {"Nevsky avenue","Ligovsky Avenue","Pervomaisky Avenue", "Aptekarsky Avenue","text_field+combobox plagin"};

    WebComboBox cbCities = new WebComboBox(cities);
    WebComboBox cbStreets = new WebComboBox(streets);

    Date date = new Date(12);
    JDateChooser calendar = new JDateChooser(date);

    SpinnerModel hours = new SpinnerNumberModel(0, 0, 24, 1);
    SpinnerModel minutes = new SpinnerNumberModel(0, 0, 60, 1);

    WebSpinner wbHour = new WebSpinner(hours);
    WebSpinner wbMin = new WebSpinner(minutes);

    MaskFormatter maskTelephone = new MaskFormatter("+7-(###)-###-##-##");
    JFormattedTextField tfPhoneNum = new JFormattedTextField(maskTelephone);


    public WebButton getbCancel() {
        return bCancel;
    }

    public WebButton getbConfirm() {
        return bConfirm;
    }

    public CartMarkup() throws ParseException {
        mainPanel.setLayout(gbL);

        tfPhoneNum.setBorder(BorderFactory.createTitledBorder("Phone"));

       // mainPanel.setBorder(BorderFactory.createTitledBorder("cart"));
        mainPanel.setBackground(new Color(123, 123, 123));

        wbHour.setBorder(BorderFactory.createTitledBorder("Hour"));
        wbMin.setBorder(BorderFactory.createTitledBorder("Minutes"));

        cbCities.setBorder(BorderFactory.createTitledBorder("Choose your city"));
        cbStreets.setBorder(BorderFactory.createTitledBorder("Choose your street"));

        tfHouse.setBorder(BorderFactory.createTitledBorder("House"));
        tfHousing.setBorder(BorderFactory.createTitledBorder("Housing"));
        tfRoom.setBorder(BorderFactory.createTitledBorder("Room"));
        tfFirstName.setBorder(BorderFactory.createTitledBorder("First Name"));
        tfSecondName.setBorder(BorderFactory.createTitledBorder("Second Name"));

        lTitle.setVerticalAlignment(SwingConstants.CENTER);
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setFontName("Times new Roman");
        lTitle.setFontSize(25);

        lPrice.setVerticalAlignment(SwingConstants.CENTER);
        lPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lPrice.setFontName("Times new Roman");
        lPrice.setFontSize(25);

        lDeliveryAdress.setVerticalAlignment(SwingConstants.CENTER);
        lDeliveryAdress.setHorizontalAlignment(SwingConstants.CENTER);
        lDeliveryAdress.setFontName("Times new Roman");
        lDeliveryAdress.setFontSize(25);

        constraintsCart.fill = GridBagConstraints.BOTH;
        constraintsCart.gridx = 0;
        constraintsCart.gridy = 0;
        constraintsCart.gridwidth = 3;
        constraintsCart.ipadx = 20; // это чудо магически вляет на размер cart (вероятно, задается размер для минимальной ячейки)
        constraintsCart.insets = new Insets(0, 3, 15, 3);
        mainPanel.add(lTitle, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 2;
        constraintsCart.weightx = 0.5;
        constraintsCart.gridwidth = 1;
        constraintsCart.insets = new Insets(7, 0, 0, 0);
        mainPanel.add(tfFirstName, constraintsCart);

        constraintsCart.gridx = 2;
        constraintsCart.gridy = 2;
        constraintsCart.weightx = 0.5;
        constraintsCart.gridwidth = 1;
        constraintsCart.insets = new Insets(7, 0, 0, 0);
        mainPanel.add(tfSecondName, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 1;
        constraintsCart.gridwidth = 3;
        constraintsCart.insets = new Insets(0, 0, 0, 0);
        mainPanel.add(tfPhoneNum, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 3;
        constraintsCart.gridwidth = 3;
        constraintsCart.insets = new Insets(10, 0, 25, 0);
        mainPanel.add(lDeliveryAdress, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 4;
        constraintsCart.gridwidth = 3;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(calendar, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 5;
        constraintsCart.gridwidth = 1;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(wbHour, constraintsCart);

        constraintsCart.gridx = 1;
        constraintsCart.gridy = 5;
        constraintsCart.gridwidth = 1;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(wbMin, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 6;
        constraintsCart.gridwidth = 3;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(cbCities, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 7;
        constraintsCart.gridwidth = 3;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(cbStreets, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 8;
        constraintsCart.gridwidth = 1;
        constraintsCart.weightx = 0.3;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(tfHouse, constraintsCart);

        constraintsCart.gridx = 1;
        constraintsCart.gridy = 8;
        constraintsCart.weightx = 0.3;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(tfHousing, constraintsCart);

        constraintsCart.gridx = 2;
        constraintsCart.gridy = 8;
        constraintsCart.weightx = 0.3;
        constraintsCart.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(tfRoom, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 9;
        constraintsCart.gridwidth = 3;
        constraintsCart.insets = new Insets(15, 3, 15, 3);
        mainPanel.add(lPrice, constraintsCart);

        constraintsCart.gridx = 0;
        constraintsCart.gridy = 10;
        constraintsCart.gridwidth = 1;
        constraintsCart.insets = new Insets(0, 30, 0, 0);
        mainPanel.add(bCancel, constraintsCart);

        constraintsCart.gridx = 2;
        constraintsCart.gridy = 10;
        constraintsCart.gridwidth = 1;
        constraintsCart.insets = new Insets(0, 0, 0, 30);
        mainPanel.add(bConfirm, constraintsCart);

    }

    public WebPanel getPanel() {
        return mainPanel;
    }

    public void setlDeliveryAdress(WebLabel lDeliveryAdress) {
        this.lDeliveryAdress = lDeliveryAdress;
    }

    public void setlTitle(String lTitle) {
        this.lTitle.setText(lTitle);
    }

    public void setlPrice(String price) {
        this.lPrice.setText(price);
    }

    public WebTextField getTfHouse() {
        return tfHouse;
    }

    public WebTextField getTfHousing() {
        return tfHousing;
    }

    public WebTextField getTfRoom() {
        return tfRoom;
    }

    public WebComboBox getCbCities() {
        return cbCities;
    }

    public WebComboBox getCbStreets() {
        return cbStreets;
    }

    public JDateChooser getCalendar() {
        return calendar;
    }

    public WebSpinner getWbHour() {
        return wbHour;
    }

    public WebSpinner getWbMin() {
        return wbMin;
    }

    public JFormattedTextField getTfPhoneNum() {
        return tfPhoneNum;
    }

    public WebTextField getTfFirstName() {
        return tfFirstName;
    }

    public void setTfFirstName(WebTextField tfFirstName) {
        this.tfFirstName = tfFirstName;
    }

    public WebTextField getTfSecondName() {
        return tfSecondName;
    }

    public void setTfSecondName(WebTextField tfSecondName) {
        this.tfSecondName = tfSecondName;
    }

    public WebLabel getlTitle() {
        return lTitle;
    }

    public WebLabel getlPrice() {
        return lPrice;
    }
}
