package User;

import Api_Project_M.OrderInfoOperator;
import Api_Project_M.Ration;
import User.Autorisation.Autorisation;
import User.Cart.CartMarkup;
import User.Cart.Intermediate_Picture;
import User.Pop_up_windows.Payment_Pop_Up;
import User.RationMurkup.RationDataFromDatabase;
import User.RationMurkup.Rations;
import User.Registration.Registration;
import com.alee.extended.image.WebImage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import Api_Project_M.Request_manager_API;
import com.caucho.hessian.client.HessianProxyFactory;

public class Start {
    public static String loginId1;
    public static void main(String args[]) throws ParseException, MalformedURLException, SQLException, ClassNotFoundException {
        // ТЕСТ СЕРВЛЕТОВ
        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        Request_manager_API apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");

        
        // создаем лист, делаем запрос, запрос заполняет лист, пользуемся листом.
        ArrayList <OrderInfoOperator> test = new ArrayList<OrderInfoOperator>();
        test = apiTest.selectInformationOrder();
        for (int i =0; i < test.size();i++)
        {
            System.out.println( test.get(i).getOrderFirstName() +" "+ test.get(i).getOrderSecondName());
        }





        Autorisation autorisationWindow = new Autorisation();
        CartMarkup cartMarkup = new CartMarkup();
        MainFormMarkup mainFrameUser = new MainFormMarkup();

        autorisationWindow.getbLogButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String serverAddress = "http://localhost:8080/";
                HessianProxyFactory factory = new HessianProxyFactory();
                Request_manager_API apiTest = null;

                boolean validation = false;


                try {
                    apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
                String pass = new String(autorisationWindow.getPassword().getPassword());
                validation = apiTest.selectValidationAutorisation(autorisationWindow.getLogin().getText(), pass);
                System.out.print("validation from autor:" + validation);

                if (!validation) {


                    loginId1 = autorisationWindow.getLogin().getText();

                    autorisationWindow.dispose();


                    MainPageContentMarkup mainPageUser = new MainPageContentMarkup();
                    MainPageContentMarkup mainPageUserTest = new MainPageContentMarkup();


                    mainFrameUser.setContent(mainPageUser);
                    mainFrameUser.setNavigation();
                    mainFrameUser.init();

                    mainFrameUser.setContent(mainPageUserTest);
                    mainFrameUser.setNavigation();
                    mainFrameUser.init();


                    WebImage img = new WebImage("C:\\Users\\shut\\Desktop\\cart.png");


                    try {
                        // первый рацион на главной
                        Ration ration;
                        WebImage imgForDaily = new WebImage(".idea/resource/images/vegetables.png");
                        ration = apiTest.selectInformationRation("Daily");
                        Rations daily = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForDaily);

                        // второй рацион на главной
                        WebImage imgForFit = new WebImage(".idea/resource/images/diet.png");
                        ration = apiTest.selectInformationRation("Fit");
                        Rations fit = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForFit);

                        // третий рацион на главной
                        WebImage imgForPower = new WebImage(".idea/resource/images/steak.png");
                        ration = apiTest.selectInformationRation("Power");
                        Rations power = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForPower);


                        // тест работы кнопки mainPage
                        Intermediate_Picture picture = new Intermediate_Picture();

                        mainPageUser.setRation(daily.getPanel(), 0);
                        mainPageUser.setRation(fit.getPanel(), 1);
                        mainPageUser.setRation(power.getPanel(), 2);
                        mainPageUser.setCart(picture.getIntermediatePanel());

                        mainFrameUser.getButton(1).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainPageUser.getPanel().setVisible(true);
                                daily.getbToOrder().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        System.out.print("to order");
                                        cartMarkup.setlPrice(daily.getlPrice().getText());
                                        cartMarkup.setlTitle(daily.getlTitle().getText());
                                        mainPageUser.setCart(cartMarkup.getPanel());
                                        picture.getIntermediatePanel().setVisible(false);
                                        cartMarkup.getPanel().setVisible(true);
                                        mainPageUser.getPanel().setVisible(true);
                                    }
                                });

                                fit.getbToOrder().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        cartMarkup.setlPrice(fit.getlPrice().getText());
                                        cartMarkup.setlTitle(fit.getlTitle().getText());
                                        mainPageUser.setCart(cartMarkup.getPanel());
                                        picture.getIntermediatePanel().setVisible(false);
                                        cartMarkup.getPanel().setVisible(true);
                                        mainPageUser.getPanel().setVisible(true);
                                    }
                                });

                                power.getbToOrder().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        cartMarkup.setlPrice(power.getlPrice().getText());
                                        cartMarkup.setlTitle(power.getlTitle().getText());
                                        mainPageUser.setCart(cartMarkup.getPanel());
                                        picture.getIntermediatePanel().setVisible(false);
                                        cartMarkup.getPanel().setVisible(true);
                                        mainPageUser.getPanel().setVisible(true);
                                    }
                                });
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
                        //ЛОГАУТ (5 кнопка навигации mainFrameUser),
                        // они сами по себе друг за другом идут, тут такой же принцип индексации

                        mainFrameUser.getButton(5).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainFrameUser.exit();
                                autorisationWindow.setVisible(true); // по идее должно быть обнуление
                                // всего и скачок на новое состояние приложения, для нового юзера,
                                // тут же не создается MainFrameUser User = new MainFrameUser
                            }
                        });

                        cartMarkup.getbCancel().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainPageUser.setCart(picture.getIntermediatePanel());
                                cartMarkup.getPanel().setVisible(false);
                                picture.getIntermediatePanel().setVisible(true);
                                mainPageUser.getPanel().setVisible(true);
                            }
                        });

                        cartMarkup.getbConfirm().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Payment_Pop_Up popUp = new Payment_Pop_Up();
                                popUp.getbPay().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (popUp.fieldValidation()) {
                                            //ЗАКАЗ ОПЛАЧЕН! булеан переменная, инифиатор запроса
                                            String serverAddress = "http://localhost:8080/";
                                            HessianProxyFactory factory = new HessianProxyFactory();
                                            Request_manager_API apiTest = null;
                                            try {
                                                apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");
                                            } catch (MalformedURLException e1) {
                                                e1.printStackTrace();
                                            }


                                            try {
                                                System.out.print(apiTest.insertOrderRequest(
                                                        0,
                                                        cartMarkup.getCalendar().getDate().toString(),
                                                        cartMarkup.getCbCities().toString(),
                                                        cartMarkup.getCbStreets().toString(),
                                                        Integer.parseInt(cartMarkup.getTfHouse().getText()),
                                                        Integer.parseInt(cartMarkup.getTfHousing().getText()),
                                                        Integer.parseInt(cartMarkup.getTfRoom().getText()),
                                                        cartMarkup.getWbHour().getValue().toString() + ':' + cartMarkup.getWbMin().getValue().toString(),
                                                        cartMarkup.getlTitle().getText(),
                                                        Integer.parseInt(cartMarkup.getlPrice().getText().replace("$","").trim()),
                                                        cartMarkup.getTfFirstName().getText(),
                                                        cartMarkup.getTfSecondName().getText(),
                                                        cartMarkup.getTfPhoneNum().getText(),
                                                        loginId1));
                                            } catch (ClassNotFoundException e1) {
                                                e1.printStackTrace();
                                            } catch (SQLException e1) {
                                                e1.printStackTrace();
                                            }

//

                                        }
                                    }

                                });
                            }
                        });
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    // повторная попытка валидации, пока не имеет смысла, обычный попап
                }
            }
        });



        autorisationWindow.getbRegistration().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autorisationWindow.dispose();
                Registration registration = new Registration();

                registration.getbCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration.dispose();
                        autorisationWindow.setVisible(true);
                    }
                });

                registration.getbRegistration().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String serverAddress = "http://localhost:8080/";
                        HessianProxyFactory factory = new HessianProxyFactory();
                        Request_manager_API apiTest = null;
                        try {
                            apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        System.out.print(apiTest.selectValidationRegistration(registration.getLogin().getText()));
                        String pass = new String(registration.getPfPassword().getPassword());
                        String repeatPass = new String(registration.getPfRepeatPassword().getPassword());
                        boolean validation = (apiTest.selectValidationRegistration(registration.getLogin().getText()));

                        if ((validation) && (pass.equals(repeatPass))) {
                            System.out.print("registration test");
                            System.out.print(registration.getPfPassword().getText());

                            try {
                                System.out.print(apiTest.insertSimpleUser(registration.getLogin().getText(), pass));
                            } catch (ClassNotFoundException | SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }
}

