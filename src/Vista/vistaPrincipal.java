package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vistaPrincipal extends JFrame {

    private JButton bAgregar;
    private JButton bEliminar;
    private JButton bCambiar;
    private JTable table;
    private JPanel panelPrincipal;

    public vistaPrincipal() {
        setContentPane(panelPrincipal);
        setTitle("Inicio");
        setSize(800,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,500));
    }

    public JTable getTable(){ return table;}

    public JButton getbCambiar() {
        return bCambiar;
    }
}
