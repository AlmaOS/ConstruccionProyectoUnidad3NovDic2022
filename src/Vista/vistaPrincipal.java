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

    public void crearTabla(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Foto");
        model.addRow(new String[]{"11111", "Alma", "Ordoñez", "www.foto.com"});
    }
}
