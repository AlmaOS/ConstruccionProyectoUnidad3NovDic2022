package Controlador;

import Modelo.Employee;
import Modelo.EmployeeManager;
import Vista.vistaModificarEmployee;
import Vista.vistaPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorVistaPrincipal implements ActionListener {
    private EmployeeManager model;
    private vistaPrincipal view;

    public ControladorVistaPrincipal(){
        model = new EmployeeManager();
        view = new vistaPrincipal();
        llenarTabla(model.getListEmployees());
        view.setVisible(true);

        view.getbCambiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getbCambiar()==e.getSource()){
            vistaModificarEmployee viewModify = new vistaModificarEmployee();
            ControladorModificarEmployee controladorModificarEmployee = new ControladorModificarEmployee();
            view.dispose();
        }
    }

    public void llenarTabla(ArrayList<Employee> employees){
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Foto");
        setDesignTable();
        for(Employee emp:employees){
            model.addRow(emp.toTableFormat());
        }
    }

    private void setDesignTable(){
        TableColumn column = view.getTable().getColumn("ID");
        column.setMinWidth(20);
        column.setPreferredWidth(20);
        column.setMaxWidth(20);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        column.setCellRenderer(tcr);
        column = view.getTable().getColumn("Nombre");
        column.setMinWidth(70);
        column.setPreferredWidth(100);
        column.setMaxWidth(150);
        column = view.getTable().getColumn("Apellido");
        column.setMinWidth(70);
        column.setPreferredWidth(100);
        column.setMaxWidth(150);
        column = view.getTable().getColumn("Foto");
        column.setMinWidth(150);
        column.setPreferredWidth(150);
    }

}
