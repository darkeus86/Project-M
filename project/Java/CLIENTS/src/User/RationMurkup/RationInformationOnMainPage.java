package User.RationMurkup;

import ApiProjectM.Ration;
import ApiProjectM.RequestManagerApi;
import com.alee.extended.image.WebImage;
import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;
import java.sql.SQLException;

class RationInformationOnMainPage {


    public RationInformationOnMainPage(String title) throws SQLException, ClassNotFoundException {
        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        RequestManagerApi apiTest = null;
        try {
            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        WebImage imgForDaily = new WebImage(".idea/resource/images/vegetables.png");
        Ration ration = apiTest.selectInformationRation(title);
        Rations daily = new Rations(ration.getTitle(), ration.getDescription(), ration.getPrice() + " $", imgForDaily);
    }
}
