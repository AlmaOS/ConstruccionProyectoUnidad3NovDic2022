package Controlador;

import Modelo.Employee;
import Modelo.EmployeeManager;
import Vista.vistaModificarEmployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorModificarEmployee implements ActionListener {
    private EmployeeManager model;
    private vistaModificarEmployee view;
    private ArrayList<Employee> listaEmployee;

    public ControladorModificarEmployee(){
        model = new EmployeeManager();
        view = new vistaModificarEmployee();
        listaEmployee = model.getListEmployees();

        view.iniciarComboID(listaEmployee);
        view.getInicioButton().addActionListener(this);
        view.getModificarButton().addActionListener(this);
        view.getComboID().addActionListener(this);
        CambiarEmpleado();
        view.setVisible(true);
    }

    private void CambiarEmpleado(){
        int id=view.getComboID().getSelectedIndex();
        view.getTextFieldFN().setText(listaEmployee.get(id).getFirstName());
        view.getTextFieldLN().setText(listaEmployee.get(id).getLastName());
        view.getTextFieldPhoto().setText(listaEmployee.get(id).getPhotoLink());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getComboID()==e.getSource()){
            CambiarEmpleado();
        }

        if(view.getModificarButton() == e.getSource()){
            String firstN=view.getTextFieldFN().getText();
            String lastN=view.getTextFieldLN().getText();
            String photo = view.getTextFieldPhoto().getText();

            model.modificarEmployee(new Employee(view.getComboID().getSelectedIndex()+1, firstN, lastN, photo));
            System.out.println("Empleado modificado");
        }

        if(view.getInicioButton()==e.getSource()){
            ControladorVistaPrincipal controladorPrincipal = new ControladorVistaPrincipal();
            view.dispose();
        }
    }

    public static void main(String[] args) {
        ControladorModificarEmployee controller = new ControladorModificarEmployee();
    }

}
