package Vista;

import javax.swing.*;
import java.awt.*;

public class vistaModificarEmployee extends JFrame{
    private JTextField textFieldID;
    private JTextField textFieldFN;
    private JTextField textFieldLN;
    private JTextField textFieldPhoto;
    private JPanel panelModificar;
    private JButton modificarButton;
    private JButton inicioButton;

    public vistaModificarEmployee() {
        setContentPane(panelModificar);
        setTitle("Modificar Empleado");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public void setTextFieldID(JTextField textFieldID) {
        this.textFieldID = textFieldID;
    }

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
