package Operator;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Test {
    private static int rowCount = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Table");

        ArrayList<File> data = new ArrayList<>();

        JTable table = new JTable();
        AbstractTableModel dataModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public String getColumnName(int columnIndex) {
                if (columnIndex==0)
                    return "Путь";
                if (columnIndex==1)
                    return "Размер";
                if (columnIndex==2)
                    return "Имя";
                else{
                    return "Error";
                }

            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex==0)
                    return String.class;
                if (columnIndex==1)
                    return Long.class;
                if (columnIndex==2)
                    return String.class;
                else {
                    return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                File file = data.get(rowIndex);
                if (columnIndex==0)
                    return file.getParent();
                if (columnIndex==1)
                    return file.length();
                if (columnIndex==2)
                    return file.getName();
                else {
                    return 0;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }
        };
        table.setModel(dataModel);




        table.setDefaultRenderer(Long.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                this.setText("" + table.getValueAt(row, column));
                if (row == 0 && column == 0) {
                    this.setForeground(Color.RED);
                } else {
                    this.setForeground(Color.BLUE);
                }
                return this;
            }
        });

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
