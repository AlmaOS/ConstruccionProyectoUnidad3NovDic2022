package Vista;

import Modelo.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class vistaModificarEmployee extends JFrame{
    private JTextField textFieldFN;
    private JTextField textFieldLN;
    private JTextField textFieldPhoto;
    private JPanel panelModificar;
    private JButton modificarButton;
    private JButton inicioButton;
    private JComboBox comboID;

    public vistaModificarEmployee() {
        setContentPane(panelModificar);
        setTitle("Modificar Empleado");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));
    }

    public void iniciarComboID(ArrayList<Employee> empleados){
        for(int i=0;i<empleados.size();i++){
            comboID.addItem(empleados.get(i).getID());
        }
    }

    public JComboBox getComboID(){return comboID;}

    public JTextField getTextFieldFN() {
        return textFieldFN;
    }

    public void setTextFieldFN(JTextField textFieldFN) {
        this.textFieldFN = textFieldFN;
    }

    public JTextField getTextFieldLN() {
        return textFieldLN;
    }

    public void setTextFieldLN(JTextField textFieldLN) {
        this.textFieldLN = textFieldLN;
    }

    public JTextField getTextFieldPhoto() {
        return textFieldPhoto;
    }

    public void setTextFieldPhoto(JTextField textFieldPhoto) {
        this.textFieldPhoto = textFieldPhoto;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public JButton getInicioButton() {
        return inicioButton;
    }
}
