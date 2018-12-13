package Project;

import com.alee.laf.menu.MenuBarStyle;
import com.alee.laf.menu.WebMenu;
import com.alee.laf.menu.WebMenuBar;
import com.alee.laf.menu.WebMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuBar extends WebMenuBar {

    public static WebMenuItem exit;
    public static WebMenuItem logout;
    public static WebMenuItem makeReport;
    public static WebMenuItem myReports;
    public static WebMenuItem documentation ;

    MenuBar()
    {
        setMenuBarStyle(MenuBarStyle.standalone);

        WebMenu reports= new WebMenu("Reports");
        WebMenu help= new WebMenu("Help");
        WebMenu menu= new WebMenu("Menu");

        documentation = new WebMenuItem("Documentation");
        myReports = new WebMenuItem("My reports");
        makeReport = new WebMenuItem("Make a report");
        exit = new WebMenuItem("Exit");
        logout = new WebMenuItem("Logout");


        reports.add(myReports);
        help.add(documentation);
        help.add(makeReport);
        menu.add(logout);
        menu.add(exit);

        add(reports);
        add(help);
        add(menu);
    }
}
