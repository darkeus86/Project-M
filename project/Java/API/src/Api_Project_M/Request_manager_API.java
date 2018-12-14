package Api_Project_M;

import java.sql.SQLException;

public interface Request_manager_API {
    boolean insertOrderRequest (int id, String date, String city, String streer, int house,int housing,int room, String time,String rationTitle,int price,String personName, String personSecondName,String phone) throws ClassNotFoundException, SQLException;
    boolean insertSimpleUser (String login, String password) throws ClassNotFoundException, SQLException;
    boolean selectValidationRegistration(String login);
    boolean selectValidationAutorisation(String login, String password);
}
