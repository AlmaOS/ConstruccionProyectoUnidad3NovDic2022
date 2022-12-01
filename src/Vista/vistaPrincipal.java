package Vista;

import javax.swing.*;
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
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JTable getTable(){ return table;}

    public JButton getbCambiar() {
        return bCambiar;
    }

    public JButton getbAgregar() {
        return bAgregar;
    }

    public JButton getbEliminar() {
        return bEliminar;
    }
}
