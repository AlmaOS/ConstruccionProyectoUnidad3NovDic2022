package Vista;

import javax.swing.*;
import java.awt.*;

public class vistaAgregarEmployee extends JFrame {
    private JPanel panelAgregar;
    private JTextField textFieldID;
    private JTextField textFieldFN;
    private JTextField textFieldLN;
    private JTextField textFieldPhoto;
    private JButton agregarButton;
    private JButton inicioButton;
    private JLabel Alerta;

    public vistaAgregarEmployee() {
        setContentPane(panelAgregar);
        setTitle("Agregar Empleado");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public JTextField getTextFieldFN() {
        return textFieldFN;
    }

    public JTextField getTextFieldLN() {
        return textFieldLN;
    }

    public JTextField getTextFieldPhoto() {
        return textFieldPhoto;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JButton getInicioButton() {
        return inicioButton;
    }

    public JLabel getAlerta() {
        return Alerta;
    }
}
