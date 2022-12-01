package Controlador;

import Modelo.Employee;
import Modelo.EmployeeManager;
import Vista.TableImage;
import Vista.vistaEliminarEmployee;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorEliminarEmployee implements ActionListener {
    private EmployeeManager model;
    private vistaEliminarEmployee view;
    private ArrayList<Employee> listaEmployee;
    private int empMostrados =0;

    public ControladorEliminarEmployee() {
        model = new EmployeeManager();
        view = new vistaEliminarEmployee();
        listaEmployee = model.getListEmployees();

        view.iniciarComboID(listaEmployee);
        view.getInicioButton().addActionListener(this);
        view.getEliminarButton().addActionListener(this);
        view.getComboID().addActionListener(this);
        mostrarEncabezados();
        view.setVisible(true);
    }

    public void mostrarEncabezados(){
        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Foto");
        setDesignTable();
    }
    public void mostrarEmpleado(ArrayList<Employee> employees){
        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
        int id=view.getComboID().getSelectedIndex();
        model.addRow(employees.get(id).toTableFormat());
    }

    private void setDesignTable(){
        TableColumn column = view.getTable1().getColumn("ID");
        view.getTable1().setDefaultRenderer(Object.class,new TableImage());
        view.getTable1().setRowHeight(160);
        column.setMinWidth(20);
        column.setPreferredWidth(20);
        column.setMaxWidth(20);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        column.setCellRenderer(tcr);
        column = view.getTable1().getColumn("Nombre");
        column.setMinWidth(70);
        column.setPreferredWidth(100);
        column.setMaxWidth(150);
        column = view.getTable1().getColumn("Apellido");
        column.setMinWidth(70);
        column.setPreferredWidth(100);
        column.setMaxWidth(150);
        column = view.getTable1().getColumn("Foto");
        column.setMinWidth(150);
        column.setPreferredWidth(50);
    }

    public void limpiarTabla(){
        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
        for(int i=0; i<view.getTable1().getRowCount();i++){
            model.removeRow(i);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getComboID()==e.getSource()){
            empMostrados++;
            if (empMostrados >=1){
                limpiarTabla();
            }
            mostrarEmpleado(listaEmployee);
        }

        if (view.getEliminarButton()==e.getSource()){
            model.eliminarEmployee(view.getComboID().getSelectedIndex()+1);
            System.out.println("Empleado eliminado");
        }

        if (view.getInicioButton()==e.getSource()){
            ControladorVistaPrincipal controladorVistaPrincipal = new ControladorVistaPrincipal();
            view.dispose();
        }
    }

    public static void main(String[] args) {
        ControladorEliminarEmployee controladorEliminarEmployee = new ControladorEliminarEmployee();
    }
}
