import com.caucho.hessian.server.HessianServlet;
import Api_Project_M.Request_manager_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Abuse_api extends HessianServlet implements Request_manager_API {
    @Override
    public boolean insertOrderRequest(int id, String date, String city, String street, int house, int housing, int room, String time, String rationTitle, int price, String personName, String personSecondName, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Orders";
        String login = "postgres";
        String password = "postgres";
        try {
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
}
