package ApiProjectM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RequestManagerApi {
    boolean insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone, String UserLogin) throws ClassNotFoundException, SQLException;
    int selectIdPositionForOrders() throws SQLException, ClassNotFoundException;
    int selectIdPositionCourier() throws SQLException, ClassNotFoundException;
    boolean insertSimpleUser (String login, String password) throws ClassNotFoundException, SQLException;
    boolean insertCourier(int id ,String firstName, String secondName, String phone) throws ClassNotFoundException, SQLException;
    boolean insertOperator(int id ,String firstName, String secondName, String phone) throws ClassNotFoundException, SQLException;
    boolean insertTechnicalReport(int version, String license, String eMail, String subject, String name) throws  ClassNotFoundException, SQLException;
    boolean selectValidationRegistration(String login);
    boolean selectValidationAuthorization(String login, String password);
    Ration selectInformationRation(String title) throws ClassNotFoundException, SQLException;
    ArrayList<OrderInfoOperator> selectInformationOrder() throws ClassNotFoundException, SQLException;
    ArrayList<CourierInfoOperator> selectInformationCourier() throws ClassNotFoundException, SQLException;
}
