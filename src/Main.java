import Modelo.Employee;
import Modelo.LecturaJSON;
import Vista.vistaPrincipal;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LecturaJSON fileJSON = new LecturaJSON();
        fileJSON.readFile("employee.txt");
        ArrayList<Employee> listEmployees = fileJSON.getListEmployees();
        System.out.println(listEmployees.get(1));
        vistaPrincipal vista = new vistaPrincipal();
        vista.setVisible(true);
    }
}
