package Vista;

import Modelo.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class vistaEliminarEmployee extends JFrame{
    private JTable table1;
    private JButton eliminarButton;
    private JButton inicioButton;
    private JPanel panelEliminar;
    private JComboBox comboID;

    public vistaEliminarEmployee() {
        setContentPane(panelEliminar);
        setTitle("Eliminar Empleado");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));
    }

    public void iniciarComboID(ArrayList<Employee> empleados){
        for(int i=0;i<empleados.size();i++){
            comboID.addItem(empleados.get(i).getID());
        }
    }

    public JComboBox getComboID() {
        return comboID;
    }

    public JTable getTable1() {
        return table1;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public JButton getInicioButton() {
        return inicioButton;
    }
}
