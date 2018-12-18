package Operator;

import Operator.MyRenderer;
import com.alee.laf.label.WebLabel;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.alee.laf.table.renderers.WebTableCellRenderer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

/**
 * User: mgarin Date: 30.01.12 Time: 16:14
 */

public class MyOrdersTable extends AbstractTableModel
{
    private int columnCount = 3;
    private ArrayList<String []> dataArrayList;

    public MyOrdersTable(){
        dataArrayList = new ArrayList<String[]>();
        for(int i = 0; i < dataArrayList.size(); i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            //Названия столбцов
            case 0: return "Id of order";
            case 1: return "Title";
            case 2: return "Order time";
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }

    public void addData(String[] row){
        //Добавление данных в таблицу
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }

}
