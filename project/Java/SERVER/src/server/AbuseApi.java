package server;

import Api_Project_M.CourierInfoOperator;
import Api_Project_M.OrderInfoOperator;
import Api_Project_M.Ration;
import com.caucho.hessian.server.HessianServlet;
import Api_Project_M.RequestManagerApi;

import java.sql.*;
import java.util.ArrayList;


public  class AbuseApi extends HessianServlet implements RequestManagerApi {


    @Override
    public boolean insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone, String UserLogin) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate(
                    "INSERT INTO public.\"Orders\"" +
                            "VALUES (" + id + ",\'" + date + "\',\'" + city + "\',\'" + street + "\'," + house + "," + housing + "," + room + ",\'" + time + "\',\'" + rationTitle + "\'," + price + ",\'" + personName + "\',\'" + personSecondName + "\',\'" + phone + "\',\'" + UserLogin + "\')");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int selectIdPositionForOrders() throws SQLException, ClassNotFoundException {
        int id;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Orders";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT COUNT(1) FROM public.\"Orders\";");
        rs.next();
        id = Integer.parseInt(rs.getString("count"));
        rs.close();
        con.close();
        return id;
    }

    @Override
    public int selectIdPositionCourier() throws SQLException, ClassNotFoundException {

        int id;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Couriers";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT COUNT(1) FROM public.\"Couriers\";");
        rs.next();
        id = Integer.parseInt(rs.getString("count"));
        rs.close();
        con.close();
        return id;
    }

    public boolean insertSimpleUser(String loginFromUser, String passwordFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"SimpleUsers\"" +
                    "VALUES (\'" + loginFromUser + "\',\'" + passwordFromUser + "\');");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertCourier(int id,String firstName, String secondName, String phone) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Couriers";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"Couriers\"" +
                    "VALUES (" + id+ ",\'" + firstName + "\',\'" + secondName+ "\', \'" +phone+"\');");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean selectValidationRegistration(String loginFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT 'Login' FROM public.\"SimpleUsers\" \n" +
                    "WHERE EXISTS ( SELECT \"Login\" FROM public.\"SimpleUsers\" WHERE \"Login\" = " + "\'" + loginFromUser + "\')"
            );

            rs.next();
            if (rs.getRow() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean selectValidationAuthorization(String loginFromUser, String passwordFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT \"Login\",\"Password\" FROM public.\"SimpleUsers\" \n" +
                    "WHERE  \"Login\" = " + "\'" + loginFromUser + "\' and " + "\"Password\" =" + "\'" + passwordFromUser + "\';"
            );
            rs.next();
            if (rs.getRow() == 0) {
                rs.close();
                con.close();
                return true;
            } else {
                rs.close();
                con.close();
                return false;
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public Ration selectInformationRation(String title) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/Rations";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT \"Title\",\"Description\",\"Price\" FROM public.\"Rations\" \nWHERE  \"Title\" = '" + title + "\';");
        Ration ration = null;
        while (rs.next()) {
            ration = new Ration(rs.getString("Title"), rs.getString("Description"), rs.getInt("Price"));
        }
        rs.close();
        con.close();
        return ration;
    }

    @Override
    public ArrayList<OrderInfoOperator> selectInformationOrder() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Orders";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ArrayList<OrderInfoOperator> ordersList = new ArrayList<OrderInfoOperator>();

        ResultSet rs = statement.executeQuery("SELECT *FROM public.\"Orders\";");


        while (rs.next()){
                OrderInfoOperator order = new OrderInfoOperator();
                order.setOrderId(Integer.parseInt(rs.getString("id")));
                order.setOrderDate(rs.getString("date"));
                order.setOrderCity(rs.getString("city"));
                order.setOrderStreet(rs.getString("street"));
                order.setOrderHouse(Integer.parseInt(rs.getString("house")));
                order.setOrderHousing(Integer.parseInt(rs.getString("housing")));
                order.setOrderRoom(Integer.parseInt(rs.getString("room")));
                order.setOrderTime(rs.getString("time"));
                order.setOrderTitle(rs.getString("rationTitle"));
                order.setOrderPrice(Integer.parseInt(rs.getString("price")));
                order.setOrderFirstName(rs.getString("personFirstName"));
                order.setOrderSecondName(rs.getString("personSecondName"));
                order.setOrderPhone(rs.getString("phone"));
                order.setOrderLoginId(rs.getString("loginId"));
                ordersList.add(order);
        }
        rs.close();
        con.close();
        return ordersList;


    }


    @Override
    public ArrayList<CourierInfoOperator> selectInformationCourier() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Couriers";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ArrayList<CourierInfoOperator> ordersList = new ArrayList<CourierInfoOperator>();

        ResultSet rs = statement.executeQuery("SELECT *FROM public.\"Couriers\";");


        while (rs.next()){
            CourierInfoOperator courier = new CourierInfoOperator();
            courier.setOperatorId(Integer.parseInt(rs.getString("id")));
            courier.setOperatorFirstName(rs.getString("personFirstName"));
            courier.setOperatorSecondName(rs.getString("personSecondName"));
            courier.setOperatorPhone(rs.getString("phone"));
            ordersList.add(courier);
        }
        rs.close();
        con.close();
        return ordersList;

    }
}



