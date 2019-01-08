package AddingCouriers;

import ApiProjectM.RequestManagerApi;
import com.caucho.hessian.client.HessianProxyFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;

class Courier {
 public static void main(String[] args) throws ParseException {
     WindowAddingCourier windowAddingCourier = new WindowAddingCourier();
     windowAddingCourier.init();

     windowAddingCourier.getbAdd().addActionListener(new ActionListener() {
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

             try {
                 int id = apiTest.selectIdPositionCourier();
                 apiTest.insertCourier(
                             id+1,
                             windowAddingCourier.getTfPersonFirstName().getText(),
                             windowAddingCourier.getTfPersonSecondName().getText(),
                             windowAddingCourier.getTfPhone().getText()
                     );
             } catch (ClassNotFoundException e1) {
                 e1.printStackTrace();
             } catch (SQLException e1) {
                 e1.printStackTrace();
             }
         }
         });



 }
}
