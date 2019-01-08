package Operator;

import com.alee.laf.menu.MenuBarStyle;
import com.alee.laf.menu.WebMenu;
import com.alee.laf.menu.WebMenuBar;
import com.alee.laf.menu.WebMenuItem;


class MenuBar extends WebMenuBar {

    static WebMenuItem documentation = new WebMenuItem("Documentation");
    static WebMenuItem myReports = new WebMenuItem("My reports");
    static WebMenuItem makeReport = new WebMenuItem("Make a report");
    static WebMenuItem exit = new WebMenuItem("Exit");
    static WebMenuItem logout = new WebMenuItem("Logout");

    MenuBar()
    {
        setMenuBarStyle(MenuBarStyle.standalone);

        WebMenu reports= new WebMenu("Reports");
        WebMenu help= new WebMenu("Help");
        WebMenu menu= new WebMenu("Menu");




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
