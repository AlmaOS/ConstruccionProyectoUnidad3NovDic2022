package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableImage extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln , boolean b1n1, int i, int il){
        if(o instanceof JLabel){
            JLabel lbl = (JLabel) o;
            return lbl;
        }
        return super.getTableCellRendererComponent(jtable,o, bln,b1n1, i, il);
    }
}
