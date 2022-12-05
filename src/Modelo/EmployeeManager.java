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

    public ArrayList<Employee> getListEmployees(){return listEmployees;}

    public void modificarEmployee(Employee emp){
        int id = emp.getID();
        int index=buscar(id);
        if(index>=0) {
            listEmployees.remove(index);
            listEmployees.add(index, emp);
            editor.actualizarJSON(listEmployees);
        }else{
            System.out.println("ID no encontrado");
        }
    }

    public void eliminarEmployee(int id){
        int index = buscar(id);
        listEmployees.remove(index);
        editor.actualizarJSON(listEmployees);
    }

    public void agregarEmpleado(int id, String fName, String LName, String link){
        Employee emp = new Employee(id,fName,LName,link);
        if(!existeID(id)){
            listEmployees.add(emp);
            editor.actualizarJSON(listEmployees);
        }
    }

    private boolean existeID(int ID){
        boolean exist = false;
        for(int i=0;i<listEmployees.size();i++){
           if(listEmployees.get(i).getID() == ID){
               exist = true;
               break;
           }
        }
        return exist;
    }

    private int buscar(int id){
        for(int i=0;i<listEmployees.size();i++){
            Employee e = listEmployees.get(i);
            if(e.getID()==id){
                return i;
            }
        }
        return -1;
    }

    public EscritorJSON getEditor() {
        return editor;
    }

    public static void main(String[] args) {
        EmployeeManager emp = new EmployeeManager();
        emp.agregarEmpleado(3,"Conan","Gray","https://conan.png");
    }
}
