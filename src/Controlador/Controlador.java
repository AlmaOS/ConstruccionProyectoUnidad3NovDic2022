package Controlador;

import Modelo.Employee;
import Modelo.LecturaJSON;
import Vista.vistaPrincipal;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;

public class Controlador {
    private LecturaJSON model;
    private vistaPrincipal view;
    private ArrayList<Employee> employees;

    public Controlador(){
        model = new LecturaJSON();
        view = new vistaPrincipal();
        model.readFile("employee.txt");
        employees = model.getListEmployees();
        llenarTabla();
        view.setVisible(true);
    }

    public void llenarTabla(){
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

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
    }
}
