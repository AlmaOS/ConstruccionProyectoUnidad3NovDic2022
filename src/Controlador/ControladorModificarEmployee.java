package Controlador;

import Modelo.Employee;
import Modelo.EmployeeManager;
import Vista.vistaModificarEmployee;
import Vista.vistaPrincipal;

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

        view.setVisible(true);
        view.getInicioButton().addActionListener(this);
        view.getModificarButton().addActionListener(this);
        view.getTextFieldFN().setText("");
        view.getTextFieldLN().setText("");
        view.getTextFieldPhoto().setText("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getModificarButton() == e.getSource()){
            int id = Integer.parseInt(view.getTextFieldID().getText());
            int textEmpty = 0;
            String firstN = listaEmployee.get(id-1).getFirstName();
            String lastN = listaEmployee.get(id-1).getLastName();
            String photo = listaEmployee.get(id-1).getPhotoLink();

            if(!view.getTextFieldFN().getText().equals("")){
                firstN = view.getTextFieldFN().getText();
            }else {
                textEmpty++;
            }
            if(!view.getTextFieldLN().getText().equals("")){
                lastN = view.getTextFieldLN().getText();
            }else {
                textEmpty++;
            }
            if(!view.getTextFieldPhoto().getText().equals("")){
                photo = view.getTextFieldPhoto().getText();
            }else {
                textEmpty++;
            }

            if(textEmpty==3){
                System.out.println("El empleado no se ha modificado");
            }else {
                model.modificarEmployee(new Employee(id, firstN, lastN, photo));
                System.out.println("Empleado modificado");
            }
        }

        if(view.getInicioButton()==e.getSource()){
            vistaPrincipal viewPrincipal = new vistaPrincipal();
            ControladorVistaPrincipal controladorPrincipal = new ControladorVistaPrincipal();
            view.dispose();
        }
    }

}
