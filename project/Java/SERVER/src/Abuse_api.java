import com.caucho.hessian.server.HessianServlet;
import Api_Project_M.Request_manager_API;

import java.sql.*;


public  class Abuse_api extends HessianServlet implements Request_manager_API {
   
    public boolean insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
//          statement.executeUpdate("INSERT INTO public.\"Orders\""+
//                  "(id, date, city, street, house, housing, room, \"time\", \"rationTitle\", price, \"personName\", \"personSecondName\")
//                  VALUES (1, \'" +date+",\'"+city+"\', '"+street+"\', house, housing, room, \'"+time+"\', \'"+rationTitle+"',"+price+", \'"+personName+"\',\'"+personSecondName+"\')"  );
                 statement.executeUpdate(
                         "INSERT INTO public.\"Orders\""+
                         "VALUES ("+id+",\'" +date+"\',\'"+city + "\',\'"+ street+"\',"+ house+","+ housing+","+ room+",\'"+time+"\',\'"+rationTitle+"\',"+ price+",\'"+personName+"\',\'" +personSecondName+"\',\'"+phone+"\')"
                 );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean insertSimpleUser(String loginFromUser, String passwordFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO public.\"SimpleUsers\""+
                    "VALUES (\'"+loginFromUser+"\',\'" +passwordFromUser+"\');");
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
                    "WHERE EXISTS ( SELECT \"Login\" FROM public.\"SimpleUsers\" WHERE \"Login\" = "+ "\'"+loginFromUser+"\')"
            );

            rs.next();
            if (rs.getRow()==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean selectValidationAutorisation(String loginFromUser, String passwordFromUser) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Orders";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT 'Login' FROM public.\"SimpleUsers\" \n" +
//                    "WHERE EXISTS ( SELECT \"Login\" FROM public.\"SimpleUsers\" WHERE \"Login\" = "+ "\'"+loginFromUser+"\')"
//            );
            ResultSet rs = statement.executeQuery("SELECT \"Login\",\"Password\" FROM public.\"SimpleUsers\" \n" +
                    "WHERE  \"Login\" = "+ "\'"+loginFromUser+"\' and "+"\"Password\" ="+"\'"+passwordFromUser+"\';"
            );
            rs.next();
            if (rs.getRow()==0)
            {
                return true;
            }
            else
            {
                return false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
