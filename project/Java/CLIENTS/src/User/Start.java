package User;

import ApiProjectM.OrderInfoOperator;
import ApiProjectM.Ration;
import AuthorizationAndRegistration.Authorization.Authorization;
import User.Cart.CartMarkup;
import User.Cart.IntermediatePicture;
import User.PopUpWindows.PaymentPopUp;
import User.RationMurkup.Rations;
import AuthorizationAndRegistration.Registration.Registration;
import User.profileMarkup.profileMarkup;
import com.alee.extended.image.WebImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import ApiProjectM.RequestManagerApi;
import com.caucho.hessian.client.HessianProxyFactory;

// баг. Чтобы оформить заказ необходимо сначала нажать на кнопку mainPage в меню слева, иначе главное окно не будет активно.
public class Start {
    public static String loginId1;

    public static void main(String args[]) throws ParseException, MalformedURLException, SQLException, ClassNotFoundException {
        // ТЕСТ СЕРВЛЕТОВ
        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        RequestManagerApi apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");


        // создаем лист, делаем запрос, запрос заполняет лист, пользуемся листом.
        ArrayList<OrderInfoOperator> test = new ArrayList<OrderInfoOperator>();
        test = apiTest.selectInformationOrder();
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).getOrderFirstName() + " " + test.get(i).getOrderSecondName());
        }


        Authorization authorizationWindow = new Authorization();
        CartMarkup cartMarkup = new CartMarkup();
        MainFormMarkup mainFrameUser = new MainFormMarkup();
        MainPageContentMarkup mainPageContent = new MainPageContentMarkup();


        authorizationWindow.getbLogButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String serverAddress = "http://localhost:8080/";
                HessianProxyFactory factory = new HessianProxyFactory();
                RequestManagerApi apiTest = null;

                boolean validation = false;

                try {
                    apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }

                String pass = new String(authorizationWindow.getPassword().getPassword());
                validation = apiTest.selectValidationAuthorization(authorizationWindow.getLogin().getText(), pass);

                if (!validation) {
                    try {
                        mainFrameUser.setContent(mainPageContent.getPanel());
                        mainFrameUser.setNavigation();
                        loginId1 = authorizationWindow.getLogin().getText();

                        authorizationWindow.dispose();

                        MainPageContentMarkup mainPageContent = new MainPageContentMarkup();
                        MainPageContentMarkup mainPageUserTest = new MainPageContentMarkup();

                        WebImage img = new WebImage(".idea/resource/images/cart.png");
//#################################################################################################################################################
//                      первый рацион на главной

                        Ration ration;

                        WebImage imgForDaily = new WebImage(".idea/resource/images/vegetables.png");
                        ration = apiTest.selectInformationRation("Daily");

                        Rations daily = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForDaily);

//#################################################################################################################################################

//                     второй рацион на главной
                        WebImage imgForFit = new WebImage(".idea/resource/images/diet.png");
                        ration = apiTest.selectInformationRation("Fit");

                        Rations fit = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForFit);

//#################################################################################################################################################
//                    третий рацион на главной
                        WebImage imgForPower = new WebImage(".idea/resource/images/steak.png");
                        ration = apiTest.selectInformationRation("Power");
                        Rations power = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForPower);

//#################################################################################################################################################

                        IntermediatePicture picture = new IntermediatePicture();

                        mainPageContent.setRation(daily.getPanel(), 0);
                        mainPageContent.setRation(fit.getPanel(), 1);
                        mainPageContent.setRation(power.getPanel(), 2);
                        mainPageContent.setCart(picture.getIntermediatePanel());
                        mainFrameUser.setContent(mainPageContent.getPanel());
                        mainFrameUser.setNavigation();
                        mainFrameUser.init();
                        profileMarkup profile = new profileMarkup();

                        daily.getbToOrder().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.print("to order");
                                cartMarkup.setlPrice(daily.getlPrice().getText());
                                cartMarkup.setlTitle(daily.getlTitle().getText());
                                mainPageContent.setCart(cartMarkup.getPanel());
                                picture.getIntermediatePanel().setVisible(false);
                                cartMarkup.getPanel().setVisible(true);
                                mainPageContent.getPanel().setVisible(true);
                            }
                        });

                        fit.getbToOrder().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cartMarkup.setlPrice(fit.getlPrice().getText());
                                cartMarkup.setlTitle(fit.getlTitle().getText());
                                mainPageContent.setCart(cartMarkup.getPanel());
                                picture.getIntermediatePanel().setVisible(false);
                                cartMarkup.getPanel().setVisible(true);
                                mainPageContent.getPanel().setVisible(true);
                            }
                        });

                        power.getbToOrder().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cartMarkup.setlPrice(power.getlPrice().getText());
                                cartMarkup.setlTitle(power.getlTitle().getText());
                                mainPageContent.setCart(cartMarkup.getPanel());
                                picture.getIntermediatePanel().setVisible(false);
                                cartMarkup.getPanel().setVisible(true);
                                mainPageContent.getPanel().setVisible(true);
                            }
                        });

                        mainFrameUser.getButton(1).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                mainFrameUser.setContent(mainPageContent.getPanel());

                                daily.getbToOrder().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        System.out.print("to order");
                                        cartMarkup.setlPrice(daily.getlPrice().getText());
                                        cartMarkup.setlTitle(daily.getlTitle().getText());
                                        mainPageContent.setCart(cartMarkup.getPanel());
                                        picture.getIntermediatePanel().setVisible(false);
                                        cartMarkup.getPanel().setVisible(true);
                                        mainPageContent.getPanel().setVisible(true);
                                    }
                                });

                                fit.getbToOrder().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        cartMarkup.setlPrice(fit.getlPrice().getText());
                                        cartMarkup.setlTitle(fit.getlTitle().getText());
                                        mainPageContent.setCart(cartMarkup.getPanel());
                                        picture.getIntermediatePanel().setVisible(false);
                                        cartMarkup.getPanel().setVisible(true);
                                        mainPageContent.getPanel().setVisible(true);
                                    }
                                });

                                power.getbToOrder().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        cartMarkup.setlPrice(power.getlPrice().getText());
                                        cartMarkup.setlTitle(power.getlTitle().getText());
                                        mainPageContent.setCart(cartMarkup.getPanel());
                                        picture.getIntermediatePanel().setVisible(false);
                                        cartMarkup.getPanel().setVisible(true);
                                        mainPageContent.getPanel().setVisible(true);
                                    }
                                });
                            }
                        });


                        mainFrameUser.getButton(2).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainFrameUser.setContent(mainPageContent.getPanel());
                            }
                        });


                        mainFrameUser.getButton(3).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainFrameUser.setContent(profile.getContainerPanel());
                                mainFrameUser.init();

                                profile.getbSaveProfileInfo().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String serverAddress = "http://localhost:8080/";
                                        HessianProxyFactory factory = new HessianProxyFactory();
                                        RequestManagerApi apiTest = null;
                                        try {
                                            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                                        } catch (MalformedURLException e2) {
                                            e2.printStackTrace();
                                        }
                                        System.out.print(apiTest.insertProfileInformation(
                                                loginId1,
                                                profile.getTfFirstName().getText(),
                                                profile.getTfSecongName().getText(),
                                                profile.getGroup().getSelection().getActionCommand(),
                                                profile.getTfEmail().getText()));

                                    }
                                });
                                profile.getbSaveAccoundChangeInfo().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (profile.getTfLogin().getText().isEmpty() && profile.getTfPassword().getText().isEmpty())
                                        {
                                            profile.setTfLogin("Input new login");
                                            profile.setTfPassword("Input new password");
                                        }
                                        else if(!profile.getTfLogin().getText().isEmpty() && profile.getTfPassword().getText().isEmpty())
                                        {
                                            profile.setTfPassword("Input new password");
                                        }
                                        else if(profile.getTfLogin().getText().isEmpty() && !profile.getTfPassword().getText().isEmpty())
                                        {
                                            profile.setTfLogin("Input new login");
                                        }
                                        else
                                        {
                                            String serverAddress = "http://localhost:8080/";
                                            HessianProxyFactory factory = new HessianProxyFactory();
                                            RequestManagerApi apiTest = null;
                                            try {
                                                apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                                            } catch (MalformedURLException e2) {
                                                e2.printStackTrace();
                                            }
                                            apiTest.updateAccountInformation(loginId1,profile.getTfLogin().getText(),profile.getTfPassword().getText());
                                        }
                                    }
                                });
                            }
                        });
                        //ЛОГАУТ (5 кнопка навигации mainFrameUser),
                        // они сами по себе  идут друг за другом.
                        mainFrameUser.getButton(5).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainFrameUser.exit();
                                authorizationWindow.setVisible(true); // по идее должно быть обнуление
                                // всего и скачок на новое состояние приложения, для нового юзера,
                                // тут же не создается MainFrameUser User = new MainFrameUser
                            }
                        });

                        cartMarkup.getbCancel().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainPageContent.setCart(picture.getIntermediatePanel());
                                cartMarkup.getPanel().setVisible(false);
                                picture.getIntermediatePanel().setVisible(true);
                                mainPageContent.getPanel().setVisible(true);
                            }
                        });

                        cartMarkup.getbConfirm().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PaymentPopUp popUp = new PaymentPopUp();
                                popUp.getbPay().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (popUp.fieldValidation()) {
                                            //ЗАКАЗ ОПЛАЧЕН! булеан переменная, инифиатор запроса
                                            popUp.getPaymentFrame().dispose();
                                            String serverAddress = "http://localhost:8080/";
                                            HessianProxyFactory factory = new HessianProxyFactory();
                                            RequestManagerApi apiTest = null;
                                            try {
                                                apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                                            } catch (MalformedURLException e1) {
                                                e1.printStackTrace();
                                            }

                                            try {
                                                int id = apiTest.selectIdPositionForOrders();

                                                apiTest.insertOrderRequest(
                                                        id + 1,
                                                        cartMarkup.getCalendar().getDate().toString(),
                                                        cartMarkup.getCbCities().getSelectedItem().toString(),
                                                        cartMarkup.getCbStreets().getSelectedItem().toString(),
                                                        Integer.parseInt(cartMarkup.getTfHouse().getText()),
                                                        Integer.parseInt(cartMarkup.getTfHousing().getText()),
                                                        Integer.parseInt(cartMarkup.getTfRoom().getText()),
                                                        cartMarkup.getWbHour().getValue().toString() + ':' + cartMarkup.getWbMin().getValue().toString(),
                                                        cartMarkup.getlTitle().getText(),
                                                        Integer.parseInt(cartMarkup.getlPrice().getText().replace("$", "").trim()),
                                                        cartMarkup.getTfFirstName().getText(),
                                                        cartMarkup.getTfSecondName().getText(),
                                                        cartMarkup.getTfPhoneNum().getText(),
                                                        loginId1);
                                            } catch (ClassNotFoundException e1) {
                                                e1.printStackTrace();
                                            } catch (SQLException e1) {
                                                e1.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                        });
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    // повторная попытка валидации, пока не имеет смысла, обычный попап
                }
            }
        });


        authorizationWindow.getbRegistration().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorizationWindow.dispose();
                Registration registration = new Registration();

                registration.getbCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration.dispose();
                        authorizationWindow.setVisible(true);
                    }
                });

                registration.getbRegistration().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String serverAddress = "http://localhost:8080/";
                        HessianProxyFactory factory = new HessianProxyFactory();
                        RequestManagerApi apiTest = null;
                        try {
                            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        String pass = new String(registration.getPfPassword().getPassword());
                        String repeatPass = new String(registration.getPfRepeatPassword().getPassword());
                        boolean validation = (apiTest.selectValidationRegistration(registration.getLogin().getText()));

                        if ((validation) && (pass.equals(repeatPass))) {
                            registration.dispose();
                            authorizationWindow.setVisible(true);

                            try {
                                apiTest.insertSimpleUser(registration.getLogin().getText(), pass);
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


