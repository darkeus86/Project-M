package AddingOperators;

import ApiProjectM.RequestManagerApi;
import com.caucho.hessian.client.HessianProxyFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;

class Operator {
 public static void main(String[] args) throws ParseException {
     WindowAddingOperator windowAddingOperator = new WindowAddingOperator();
     windowAddingOperator.init();

     windowAddingOperator.getbAdd().addActionListener(new ActionListener() {
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
                 apiTest.insertOperator(
                             id+1,
                             windowAddingOperator.getTfPersonFirstName().getText(),
                             windowAddingOperator.getTfPersonSecondName().getText(),
                             windowAddingOperator.getTfPhone().getText()
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
