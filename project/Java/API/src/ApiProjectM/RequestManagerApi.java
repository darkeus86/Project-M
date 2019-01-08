package ApiProjectM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RequestManagerApi {
   // boolean insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone, String UserLogin) throws ClassNotFoundException, SQLException;
    void insertSimpleUser (String login, String password) throws ClassNotFoundException, SQLException;
    void insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone, String UserLogin) throws ClassNotFoundException, SQLException;
    void insertOperator(int id, String firstName, String secondName, String phone) throws ClassNotFoundException, SQLException;
    void insertCourier(int id , String firstName, String secondName, String phone) throws ClassNotFoundException, SQLException;
    boolean insertProfileInformation(String loginId, String firstName, String SecondName,String gender,String email);
    void updateAccountInformation(String oldLogin, String newLogin , String newPassword);
    boolean selectValidationRegistration(String login);
    boolean selectValidationAuthorization(String login, String password);
    int selectIdPositionForOrders() throws SQLException, ClassNotFoundException;
    int selectIdPositionCourier() throws SQLException, ClassNotFoundException;
    Ration selectInformationRation(String title) throws ClassNotFoundException, SQLException;
    ArrayList<OrderInfoOperator> selectInformationOrder() throws ClassNotFoundException, SQLException;
    ArrayList<CourierInfoOperator> selectInformationCourier() throws ClassNotFoundException, SQLException;

    String[] selectInfoForRationPopUpLeft(String title) throws ClassNotFoundException, SQLException;
    float[] selectInfoForRationPopRight(String title) throws ClassNotFoundException, SQLException;


    boolean updateStatus(int orderId, int status)throws ClassNotFoundException, SQLException;

    boolean insertReports(int i, String alexey_kravchenko, String s, String toString)throws ClassNotFoundException, SQLException;

    ArrayList<Reports> selectReportsOperator() throws ClassNotFoundException, SQLException;
}
