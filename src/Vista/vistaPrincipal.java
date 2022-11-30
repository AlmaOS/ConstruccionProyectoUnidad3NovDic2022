package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class vistaPrincipal extends JFrame {

    private JButton bAgregar;
    private JButton bEliminar;
    private JButton bCambiar;
    private JTable table;
    private JPanel panelPrincipal;

    public vistaPrincipal() {
        setContentPane(panelPrincipal);
        setTitle("Inicio");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        crearTabla();
    }

    public JTable getTable(){ return table;}

    public JButton getbCambiar() {
        return bCambiar;
    }
}
