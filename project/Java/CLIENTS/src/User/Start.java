package User;

import User.Cart.CartMarkup;
import User.Cart.Intermediate_Picture;
import User.Pop_up_windows.Payment_Pop_Up;
import User.RationMurkup.Rations;
import com.alee.extended.image.WebImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.ParseException;

import Api_Project_M.Request_manager_API;
import com.caucho.hessian.client.HessianProxyFactory;

public class Start {
    public static void main(String args[]) throws ParseException, MalformedURLException {
        // ТЕСТ СЕРВЛЕТОВ
//        String serverAddress = "http://localhost:8080/";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        Request_manager_API apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");
        //$$$$$$$$$$$$$$$$$$$$$$$$

        //тест базы данных

        //########################

        MainFormMarkup mainFrameUser = new MainFormMarkup();

        MainPageContentMarkup mainPageUser = new MainPageContentMarkup();
        MainPageContentMarkup mainPageUserTest = new MainPageContentMarkup();


        mainFrameUser.setContent(mainPageUser);
        mainFrameUser.setNavigation();
        mainFrameUser.init();

        mainFrameUser.setContent(mainPageUserTest);
        mainFrameUser.setNavigation();
        mainFrameUser.init();





        CartMarkup cartMarkup = new CartMarkup();
//       CartMarkup cartMarkupTest = new CartMarkup("Daily","123");

        WebImage img = new WebImage("C:\\Users\\shut\\Desktop\\s.png");
        Rations Daily = new Rations("Daily food","lorusimpson1","20$", img);
        Rations Daily1 = new Rations("Daily food","lorusimpson2","20$", new WebImage());
        Rations Daily2 = new Rations("Daily food","lorusimpson3","20$", new WebImage());


        Rations Daily11 = new Rations("123","123","123$", new WebImage());
        Rations Daily22 = new Rations("123","123","123$", new WebImage());
        Rations Daily33 = new Rations("123","123","123$", new WebImage());

        Intermediate_Picture picture = new Intermediate_Picture();
        // тест работы кнопки mainPage
        mainPageUser.setRation(Daily.getPanel(),0);
        mainPageUser.setRation(Daily1.getPanel(),1);
        mainPageUser.setRation(Daily2.getPanel(),2);
        mainPageUser.setCart(picture.getIntermediatePanel());

        // тест работы кнопки myorders
        mainPageUserTest.setRation(Daily11.getPanel(),0);
        mainPageUserTest.setRation(Daily22.getPanel(),1);
        mainPageUserTest.setRation(Daily33.getPanel(),2);
        //mainPageUserTest.setCart(cartMarkupTest.getPanel());

        mainFrameUser.getButton(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPageUser.getPanel().setVisible(true);
                Daily.getbToOrder().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        String buff = String.valueOf(apiTest.multiplicate(3,4));
//                        cartMarkup.setlPrice(buff);
                        cartMarkup.setlPrice("20");
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
                        if(popUp.fieldValidation())
                        {
                            //ЗАКАЗ ОПЛАЧЕН! булеан переменная, инифиатор запроса
                            String serverAddress = "http://localhost:8080/";
                            HessianProxyFactory factory = new HessianProxyFactory();
                            try {
                                Request_manager_API apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");


                                System.out.print(apiTest.insertOrderRequest(
                                        0,cartMarkup.getCalendar().getDate().toString(),
                                        cartMarkup.getCbCities().toString(),
                                        cartMarkup.getCbStreets().toString(),
                                        Integer.parseInt(cartMarkup.getTfHouse().getText()),
                                        Integer.parseInt(cartMarkup.getTfHousing().getText()),
                                        Integer.parseInt(cartMarkup.getTfRoom().getText()),
                                        cartMarkup.getWbHour().getValue().toString()+':'+cartMarkup.getWbMin().getValue().toString(),
                                        cartMarkup.getlTitle().getText(),
                                        Integer.parseInt(cartMarkup.getlPrice().getText()),
                                        cartMarkup.getTfFirstName().getText(),
                                        cartMarkup.getTfSecondName().getText(),
                                        cartMarkup.getTfPhoneNum().getText()));
//                                System.out.print(apiTest.insertOrderRequest(
//                                        23,
//                                        "12:12:2012",
//                                        "spb",
//                                        "nevsky",
//                                        23,23,23,"23:23","daily",12,"artem","shutemov"
//                                ));

                            } catch (MalformedURLException e1) {
                                e1.printStackTrace();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            } catch (ClassNotFoundException e1) {
                                e1.printStackTrace();
                            }


                        }
                    }
                });
//                if(popUp.fieldValidation())
//                {
//                    //ЗАКАЗ ОПЛАЧЕН! булеан переменная, инифиатор запроса
//                    String serverAddress = "http://localhost:8080/";
//                    HessianProxyFactory factory = new HessianProxyFactory();
//                    try {
//                        Request_manager_API apiTest = (Request_manager_API) factory.create(Request_manager_API.class, serverAddress + "DataService");
//
////                        apiTest.insertOrderRequest(
////                                0,cartMarkup.getCalendar().getDate().toString(),
////                                cartMarkup.getCbCities().toString(),
////                                cartMarkup.getCbStreets().toString(),
////                                Integer.parseInt(cartMarkup.getTfHouse().getText()),
////                                Integer.parseInt(cartMarkup.getTfHousing().getText()),
////                                Integer.parseInt(cartMarkup.getTfRoom().getText()),
////                                 cartMarkup.getWbHour().getValue().toString()+':'+cartMarkup.getWbMin().getValue().toString(),
////                                cartMarkup.getlTitle().getText(),
////                                Integer.parseInt(cartMarkup.getlPrice().getText()),
////                                cartMarkup.getTfFirstName().getText(),
////                                cartMarkup.getTfSecondName().getText());
//                        apiTest.insertOrderRequest(
//                                0,
//                                "12:12:2012",
//                                "spb",
//                                "nevsky",
//                                23,23,23,"23:23","daily",12,"artem","shutemov"
//                        );
//
//                    } catch (MalformedURLException e1) {
//                        e1.printStackTrace();
//                    } catch (SQLException e1) {
//                        e1.printStackTrace();
//                    } catch (ClassNotFoundException e1) {
//                        e1.printStackTrace();
//                    }
//
//
//                }
            }
        });


    }
}
