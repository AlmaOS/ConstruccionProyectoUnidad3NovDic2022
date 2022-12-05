package Controlador;

import Modelo.Employee;
import Modelo.EmployeeManager;
import Vista.vistaAgregarEmployee;
import Vista.vistaModificarEmployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorAgregarEmployee implements ActionListener {
    private EmployeeManager model;
    private vistaAgregarEmployee view;
    private ArrayList<Employee> listaEmployee;

    public ControladorAgregarEmployee(){
        model = new EmployeeManager();
        view = new vistaAgregarEmployee();
        listaEmployee = model.getListEmployees();

        view.getAlerta().setText("");
        view.getInicioButton().addActionListener(this);
        view.getAgregarButton().addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getAgregarButton() == e.getSource()){
            if(validarEntrada()) {
                int id = Integer.parseInt(view.getTextFieldID().getText());
                if (model.existeID(id)) {
                    view.getAlerta().setText("El ID ya existe, ingrese uno diferente");
                } else {
                    String FN = view.getTextFieldFN().getText();
                    String LN = view.getTextFieldLN().getText();
                    String Photo = view.getTextFieldPhoto().getText();
                    model.agregarEmpleado(id, FN, LN, Photo);
                    System.out.println("Empleado agregado");
                    ControladorVistaPrincipal controladorVistaPrincipal = new ControladorVistaPrincipal();
                    view.dispose();
                }
            }else{
                view.getAlerta().setText("Uno o más espacios están en blanco");
            }
        }

        if (view.getInicioButton() == e.getSource()) {
            ControladorVistaPrincipal controladorPrincipal = new ControladorVistaPrincipal();
            view.dispose();
        }
    }

    private boolean validarEntrada(){
        if(view.getTextFieldID().getText().equals("")||view.getTextFieldFN().getText().equals("")||view.getTextFieldLN().equals("")||view.getTextFieldPhoto().getText().equals("")){
            return false;
        }else{
            return true;
        }
    }
}
