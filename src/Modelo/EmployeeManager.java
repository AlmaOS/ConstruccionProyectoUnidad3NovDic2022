package Modelo;

import java.util.ArrayList;

public class EmployeeManager {
    private LecturaJSON lector;
    private ArrayList<Employee> listEmployees;
    private EscritorJSON editor;

    public EmployeeManager() {
        lector = new LecturaJSON();
        lector.readFile("employees.txt");
        listEmployees= new ArrayList<>();
        cargarEmpleados(lector.getEmployeeInfo());
        editor = new EscritorJSON();
    }

    private void cargarEmpleados(String[][] info){
        for(int i=0;i<info.length;i++){
            int ID = Integer.parseInt( info[i][0]);
            String firstName = info[i][1];
            String lastName = info[i][2];
            String photoLink = info[i][3];

            listEmployees.add(new Employee(ID, firstName, lastName, photoLink));
        }
    }

    public void imprimirEmpleados(){
        if(listEmployees.size()!=0){
            for(Employee a: listEmployees){
                System.out.println(a.toString());
            }
        }
    }

    public ArrayList getListEmployees(){return listEmployees;}

    public void modificarEmployee(Employee emp){
        int id = emp.getID();
        Employee oldEmp=buscar(id);
        if(oldEmp!=null) {
            listEmployees.remove(id - 1);
            listEmployees.add(id - 1, emp);
            editor.actualizarJSON(listEmployees);
        }else{
            System.out.println("ID no encontrado");
        }
    }

    private Employee buscar(int id){
        for(Employee e:listEmployees){
            if(e.getID()==id){
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeManager emp = new EmployeeManager();
        emp.imprimirEmpleados();
        emp.modificarEmployee(new Employee(3,"Sabrina","Carpenter","https://"));
        emp.imprimirEmpleados();
    }
}
