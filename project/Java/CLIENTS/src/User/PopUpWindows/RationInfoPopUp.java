package User.PopUpWindows;

import ApiProjectM.RequestManagerApi;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.splitpane.WebSplitPane;
import com.alee.laf.text.WebTextField;
import com.caucho.hessian.client.HessianProxyFactory;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class RationInfoPopUp {

   private final WebFrame frame= new WebFrame();
    private final WebTextField tfProteins = new WebTextField();
   private final WebTextField tfFats= new WebTextField();
   private final WebTextField tfCarbohydrates= new WebTextField();
   private final WebTextField tfKkl= new WebTextField();


    private DefaultMutableTreeNode  breakfastFood;
   private DefaultMutableTreeNode  secondBreakfastFood;
   private DefaultMutableTreeNode  dinnerFood ;
   private DefaultMutableTreeNode  afternoonSnackFood;
   private DefaultMutableTreeNode  eveningMealFood ;
    private final JTree jt;

    public JTree getJt() {
        return jt;
    }

    public void setBreakfastFood(String title) {
       breakfastFood = new DefaultMutableTreeNode(title);
    }

    public void setSecondBreakfastFood(String title) {
        secondBreakfastFood  = new DefaultMutableTreeNode(title);
    }

    public void setDinnerFood(String title) {
        dinnerFood  = new DefaultMutableTreeNode(title);
    }

    public void setAfternoonSnackFood(String title) {
        afternoonSnackFood =new DefaultMutableTreeNode(title);
    }

    public void setEveningMealFood(String title) {
        eveningMealFood = new DefaultMutableTreeNode(title);
    }

    public RationInfoPopUp(String sBreakfast, String sSecondBreakfast,String sDinner, String sAftenoonSnack, String sEveningMeal)
   {
      breakfastFood = new DefaultMutableTreeNode(sBreakfast);
      secondBreakfastFood= new DefaultMutableTreeNode(sSecondBreakfast);
      dinnerFood= new DefaultMutableTreeNode(sDinner);
      afternoonSnackFood = new DefaultMutableTreeNode(sAftenoonSnack);
      eveningMealFood= new DefaultMutableTreeNode(sEveningMeal);


       frame.setTitle("Ration information");

       DefaultMutableTreeNode breakfast = new DefaultMutableTreeNode("Breakfast");
       breakfast.add(breakfastFood);
       DefaultMutableTreeNode secondBreakfast = new DefaultMutableTreeNode("Second breakfast");
       secondBreakfast.add(secondBreakfastFood);
       DefaultMutableTreeNode dinner = new DefaultMutableTreeNode("Dinner");
       dinner.add(dinnerFood);
       DefaultMutableTreeNode afternoonSnack = new DefaultMutableTreeNode("Afternoon snack");
       afternoonSnack.add(afternoonSnackFood);
       DefaultMutableTreeNode eveningMeal = new DefaultMutableTreeNode("eveningMeal");
       eveningMeal.add(eveningMealFood);

       DefaultMutableTreeNode rationTitle = new DefaultMutableTreeNode("Daily");
       rationTitle.add(breakfast);
       rationTitle.add(secondBreakfast);
       rationTitle.add(dinner);
       rationTitle.add(afternoonSnack);
       rationTitle.add(eveningMeal);
        jt = new JTree(rationTitle);

       WebPanel leftPanel = new WebPanel();
       leftPanel.add(jt);
       WebPanel rightPanel = new WebPanel();
       rightPanel.setLayout(new GridLayout(4,1));
       rightPanel.add(tfProteins);
       rightPanel.add(tfFats);
       rightPanel.add(tfCarbohydrates);
       rightPanel.add(tfKkl);

       WebSplitPane splitPane = new WebSplitPane(SwingConstants.VERTICAL, leftPanel, rightPanel);
       frame.add(splitPane);

       tfProteins.setBorder(BorderFactory.createTitledBorder("Proteins"));
       tfFats.setBorder(BorderFactory.createTitledBorder("Fats"));
       tfCarbohydrates.setBorder(BorderFactory.createTitledBorder("Carbohydrates"));
       tfKkl.setBorder(BorderFactory.createTitledBorder("Kkl"));

   }

        public void createTree() throws SQLException, ClassNotFoundException {
        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();

        RequestManagerApi apiTest = null;
        try {
            apiTest = (RequestManagerApi) factory.create(RequestManagerApi.class, serverAddress + "DataService");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }

        String[] rationInfo = apiTest.selectInfoForRationPopUpLeft("Daily");
        System.out.print(rationInfo[0]);
            RationInfoPopUp rationPopUp = new RationInfoPopUp(
                    rationInfo[1],rationInfo[2],rationInfo[3],rationInfo[4],rationInfo[5]
            );
            jt.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    TreePath path = jt.getSelectionPath();
                    String treeNodeValue = path.getPathComponent(path.getPathCount()-1).toString().trim();
                    System.out.println(path.getPathComponent(path.getPathCount()-1));
                    if(treeNodeValue.equals(rationInfo[1]))
                    {
                        tfProteins.setText(rationInfo[1]);
                    }
                }
            });

    }

        public void init()
        {
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.setSize(new Dimension(300,250));
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        }

    public void setTfProteins(String count) {
       tfProteins.setText(count);
    }

    public void setTfFats(String count) {
        tfFats.setText(count);
    }

    public void setTfCarbohydrates(String count) {
       tfCarbohydrates.setText(count);
    }

    public void setTfKkl(String count) {
        tfKkl.setText(count);
    }

    public DefaultMutableTreeNode getBreakfastFood() {
        return breakfastFood;
    }

    public DefaultMutableTreeNode getSecondBreakfastFood() {
        return secondBreakfastFood;
    }

    public DefaultMutableTreeNode getDinnerFood() {
        return dinnerFood;
    }

    public DefaultMutableTreeNode getAfternoonSnackFood() {
        return afternoonSnackFood;
    }

    public DefaultMutableTreeNode getEveningMealFood() {
        return eveningMealFood;
    }
}
