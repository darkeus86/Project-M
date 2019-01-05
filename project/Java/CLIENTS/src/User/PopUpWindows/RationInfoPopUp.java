package User.PopUpWindows;

import ApiProjectM.Ration;
import User.profileMarkup.profileMarkup;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.alee.laf.splitpane.WebSplitPane;
import com.alee.laf.text.WebTextField;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class RationInfoPopUp {

   WebFrame frame= new WebFrame();
   WebSplitPane splitPane ;
   WebPanel leftPanel = new WebPanel();
   WebPanel rightPanel = new WebPanel();
   WebTextField tfProteins = new WebTextField();
   WebTextField tfFats= new WebTextField();
   WebTextField tfCarbohydrates= new WebTextField();
   WebTextField tfKkl= new WebTextField();


   DefaultMutableTreeNode rationTitle =  new DefaultMutableTreeNode("DAily");

   DefaultMutableTreeNode breakfast = new DefaultMutableTreeNode("Breakfast");
   DefaultMutableTreeNode secondBreakfast = new DefaultMutableTreeNode("Second breakfast");
   DefaultMutableTreeNode dinner = new DefaultMutableTreeNode("Dinner");
   DefaultMutableTreeNode afternoonSnack =  new DefaultMutableTreeNode("Afternoon snack");
   DefaultMutableTreeNode eveningMeal = new DefaultMutableTreeNode("eveningMeal");

   DefaultMutableTreeNode  breakfastFood;
   DefaultMutableTreeNode  secondBreakfastFood;
   DefaultMutableTreeNode  dinnerFood ;
   DefaultMutableTreeNode  afternoonSnackFood;
   DefaultMutableTreeNode  eveningMealFood ;

    public void setBreakfastFood(String title) {
       breakfastFood = new DefaultMutableTreeNode(title);
    }

    public void setSecondBreakfastFood(String title) {
        secondBreakfastFood  = new DefaultMutableTreeNode(title);
    }

    public void setDinnerFood(String title) {
        dinnerFood  = new DefaultMutableTreeNode(title);;
    }

    public void setAfternoonSnackFood(String title) {
        afternoonSnackFood =new DefaultMutableTreeNode(title);
    }

    public void setEveningMealFood(String title) {
        eveningMealFood = new DefaultMutableTreeNode(title);;
    }

    public RationInfoPopUp()
   {
       frame.setTitle("Ration information");

       breakfast.add(breakfastFood);
       secondBreakfast.add(secondBreakfastFood);
       dinner.add(dinnerFood);
       afternoonSnack.add(afternoonSnackFood);
       eveningMeal.add(eveningMealFood);

       rationTitle.add(breakfast);
       rationTitle.add(secondBreakfast);
       rationTitle.add(dinner);
       rationTitle.add(afternoonSnack);
       rationTitle.add(eveningMeal);
       JTree jt = new JTree(rationTitle);

       leftPanel.add(jt);
       rightPanel.setLayout(new GridLayout(4,1));
       rightPanel.add(tfProteins);
       rightPanel.add(tfFats);
       rightPanel.add(tfCarbohydrates);
       rightPanel.add(tfKkl);

       splitPane = new WebSplitPane(SwingConstants.VERTICAL, leftPanel,rightPanel );
       frame.add(splitPane);

       tfProteins.setBorder(BorderFactory.createTitledBorder("Proteins"));
       tfFats.setBorder(BorderFactory.createTitledBorder("Fats"));
       tfCarbohydrates.setBorder(BorderFactory.createTitledBorder("Carbohydrates"));
       tfKkl.setBorder(BorderFactory.createTitledBorder("Kkl"));

       frame.pack();
       frame.setVisible(true);

   }

    public static void main(String[] args) {
        RationInfoPopUp pop = new RationInfoPopUp();

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
}
