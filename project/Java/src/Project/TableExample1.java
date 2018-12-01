package Project;



import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.alee.laf.table.renderers.WebTableCellRenderer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * User: mgarin Date: 30.01.12 Time: 16:14
 */

public class TableExample1
{



    public static Component getPreview()
    {
        // Table
        WebTable table = new WebTable ( new ExampleTableModel () );
        WebScrollPane scrollPane = new WebScrollPane ( table );

        // Custom column
        TableColumn column = table.getColumnModel ().getColumn ( 1 );

        // Custom renderer
        WebTableCellRenderer renderer = new WebTableCellRenderer ();
        column.setCellRenderer ( renderer );


        // Better column sizes
        initColumnSizes ( table );

        return scrollPane;
    }

    private static void initColumnSizes(JTable table)
    {
        ExampleTableModel model = ( ExampleTableModel ) table.getModel ();
        TableColumn column;
        Component comp;
        int headerWidth;
        int cellWidth;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer = table.getTableHeader ().getDefaultRenderer ();

        for ( int i = 0; i < model.getColumnCount (); i++ )
        {
            column = table.getColumnModel ().getColumn ( i );

            comp = headerRenderer.getTableCellRendererComponent ( null, column.getHeaderValue (), false, false, 0, 0 );
            headerWidth = comp.getPreferredSize ().width;

            comp = table.getDefaultRenderer ( model.getColumnClass ( i ) ).
                    getTableCellRendererComponent ( table, longValues[ i ], false, false, 0, i );
            cellWidth = comp.getPreferredSize ().width;

            column.setPreferredWidth ( Math.max ( headerWidth, cellWidth ) );
        }
    }

    public static class ExampleTableModel extends AbstractTableModel
    {
        private String[] columnNames = {"Id of order", "Title", "Order time", "Status"};
        private Object[][] data = {{"001", "Fit", "12.12.2012 09:00", "Cooking"},
                {"002", "Fit", "12.12.2012 09:00", "At the courier"}, {"003", "Balance", "12.12.2012 09:00", "Cooking"},
                {"004", "Fit", "12.12.2012 09:00", "Delivered"}, {"005", "Balance", "12.12.2012 09:00", "Delivered"}};

        public final Object[] longValues = {"000", "None", 0, "01.01.2000 00:00"};

        @Override
        public int getColumnCount ()
        {
            return columnNames.length;
        }

        @Override
        public int getRowCount ()
        {
            return data.length;
        }

        @Override
        public String getColumnName ( int col )
        {
            return columnNames[ col ];
        }

        @Override
        public Object getValueAt ( int row, int col )
        {
            return data[ row ][ col ];
        }

        @Override
        public Class getColumnClass ( int c )
        {
            return longValues[ c ].getClass ();
        }

        @Override
        public boolean isCellEditable ( int row, int col )
        {
            return col >= 1;
        }

        @Override
        public void setValueAt ( Object value, int row, int col )
        {
            data[ row ][ col ] = value;
            fireTableCellUpdated ( row, col );
        }
    }
}
