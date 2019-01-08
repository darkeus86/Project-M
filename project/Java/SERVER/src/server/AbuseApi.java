package server;

import ApiProjectM.*;
import com.caucho.hessian.server.HessianServlet;

import java.sql.*;
import java.util.ArrayList;




public  class AbuseApi extends HessianServlet implements RequestManagerApi {
    @Override
    public void insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone, String UserLogin) throws ClassNotFoundException {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void insertSimpleUser(String loginFromUser, String passwordFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/SimpleUsers";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"SimpleUsers\"" +
                    "VALUES (\'" + loginFromUser + "\',\'" + passwordFromUser + "\');");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertCourier(int id, String firstName, String secondName, String phone) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Couriers";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"Couriers\"" +
                    "VALUES (" + id+ ",\'" + firstName + "\',\'" + secondName+ "\', \'" +phone+"\');");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertProfileInformation(String loginId, String firstName, String secondName, String gender, String email) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/ProfileInformation";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"ProfileInformation\"" +
                    "VALUES (" + loginId+ ",\'" + firstName + "\',\'" + secondName+ "\', \'" +gender+"\',\'"+email+"\');");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void updateAccountInformation(String oldLogin, String newLogin, String newPassword) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/SimpleUsers";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("UPDATE public.\"SimpleUsers\""+
            "SET \"Login\"=\'"+newLogin+"\',\"Password\"=\'"+newPassword+"\'"+
            "WHERE \"Login\"=\'"+oldLogin+"\';");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insertOperator(int id, String firstName, String secondName, String phone) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Operators";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"Operators\"" +
                    "VALUES (" + id+ ",\'" + firstName + "\',\'" + secondName+ "\', \'" +phone+"\');");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean selectValidationRegistration(String loginFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/SimpleUsers";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT 'Login' FROM public.\"SimpleUsers\" \n" +
                    "WHERE EXISTS ( SELECT \"Login\" FROM public.\"SimpleUsers\" WHERE \"Login\" = " + "\'" + loginFromUser + "\')"
            );

            rs.next();
            return rs.getRow() == 0;
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
            String url = "jdbc:postgresql://localhost:5432/SimpleUsers";
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


    @Override
    public String[] selectInfoForRationPopUpLeft(String title) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/RationsInformation";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT \"RationTitle\", \"Breakfast\", \"BProteins\", \"BFats\", \"BCarbohydrates\", \"BKkl\", \"SecondBreakfast\", \"SBProteins\", \"SBFats\", \"SBCarbohydrates\", \"SBKkl\", \"Dinner\", \"DProteins\", \"DFats\", \"DCarbohydrates\", \"DKkl\", \"AfternoonSnack\", \"ASProteins\", \"ASFats\", \"ASCarbohydrates\", \"ASKkl\", \"EveningMeal\", \"EMProteins\", \"EMFats\", \"EMCarbohydrates\", \"EMKkl\""
                +    " FROM public.\"RationsInformation\" where \"RationTitle\" ="+"\'"+title+"\';");

        String[] treeBranch = new String[6];
        while (rs.next()){
          treeBranch[0] = rs.getString("RationTitle");
          treeBranch[1] = rs.getString("Breakfast");
          treeBranch[2] = rs.getString("SecondBreakfast");
          treeBranch[3] = rs.getString("Dinner");
          treeBranch[4] = rs.getString("AfternoonSnack");
          treeBranch[5] = rs.getString("EveningMeal");
        }
        rs.close();
        con.close();

        return treeBranch;
    }

    @Override
    public float[] selectInfoForRationPopRight(String title) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/RationsInformation";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT \"RationTitle\", \"Breakfast\", \"BProteins\", \"BFats\", \"BCarbohydrates\", \"BKkl\", \"SecondBreakfast\", \"SBProteins\", \"SBFats\", \"SBCarbohydrates\", \"SBKkl\", \"Dinner\", \"DProteins\", \"DFats\", \"DCarbohydrates\", \"DKkl\", \"AfternoonSnack\", \"ASProteins\", \"ASFats\", \"ASCarbohydrates\", \"ASKkl\", \"EveningMeal\", \"EMProteins\", \"EMFats\", \"EMCarbohydrates\", \"EMKkl\""
                +    " FROM public.\"RationsInformation\" where \"RationTitle\" ="+"\'"+title+"\';");

        float[] protFatCar= new float[20];


        while (rs.next()){
                    protFatCar[0] = rs.getFloat("BProteins");
                    protFatCar[1] =        rs.getFloat("BFats");
                    protFatCar[2] = rs.getFloat("BCarbohydrates");
                    protFatCar[3] =rs.getFloat("BKkl");
                    protFatCar[4] = rs.getFloat("SBProteins");
                    protFatCar[5] =rs.getFloat("SBFats");
                    protFatCar[6] = rs.getFloat("SBCarbohydrates");
                    protFatCar[7] = rs.getFloat("SBKkl");
                    protFatCar[8] = rs.getFloat("DProteins");
                    protFatCar[9] =  rs.getFloat("DFats");
                    protFatCar[10] =  rs.getFloat("DCarbohydrates");
                    protFatCar[11] =   rs.getFloat("DKkl");
                    protFatCar[12] = rs.getFloat("ASProteins");
                    protFatCar[13] =  rs.getFloat("ASFats");
                    protFatCar[14] = rs.getFloat("ASCarbohydrates");
                    protFatCar[15] = rs.getFloat("ASKkl");
                    protFatCar[16] =  rs.getFloat("EMProteins");
                    protFatCar[17] =  rs.getFloat("EMFats");
                    protFatCar[18] =  rs.getFloat("EMCarbohydrates");
                    protFatCar[19] =    rs.getFloat("EMKkl");

        }
        rs.close();
        con.close();

        return protFatCar;
    }

    @Override
    public boolean updateStatus(int orderId, int status) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Couriers";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("UPDATE public.\"Orders\" SET status=" + status + "WHERE id=" +
                orderId + ";");
        return false;
    }

    @Override
    public boolean insertReports(int id, String reporter, String subject, String date) throws ClassNotFoundException,
            SQLException {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/Reports";
                String login = "postgres";
                String password = "postgres";
                Connection con = DriverManager.getConnection(url, login, password);
                Statement statement = con.createStatement();
                statement.executeUpdate("INSERT INTO public.\"Reports\"" +
                        "VALUES (" + id+ ",\'" + reporter + "\',\'" + subject + "\', \'" +date+"\');");
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }

    @Override
    public ArrayList<Reports> selectReportsOperator() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Reports";
        String login = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, login, password);
        Statement statement = con.createStatement();

        ArrayList<Reports> ordersList = new ArrayList<Reports>();

        ResultSet rs = statement.executeQuery("SELECT *FROM public.\"Reports\";");


        while (rs.next()){
            Reports reports = new Reports();
            reports.setId(Integer.parseInt(rs.getString("id")));
            reports.setReporter(rs.getString("reporter"));
            reports.setSubject(rs.getString("subject"));
            reports.setDate(rs.getString("date"));
            ordersList.add(reports);
        }
        rs.close();
        con.close();
        return ordersList;
    }


}



