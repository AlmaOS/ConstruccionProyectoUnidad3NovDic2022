package Modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscritorJSON {
    JSONObject employees;

    public void actualizarJSON(ArrayList<Employee> list){
        convertirAJSON(list);
        try {
            PrintWriter file = new PrintWriter(new FileWriter("employees.txt"));
            file.write(employees.toString());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void convertirAJSON(ArrayList<Employee> list){
        JSONArray lista = new JSONArray();
        for(Employee emp:list){
            JSONObject employee= new JSONObject();
            employee.put("id", String.valueOf(emp.getID()));
            employee.put("firstName", emp.getFirstName());
            employee.put("lastName", emp.getLastName());
            employee.put("photo", emp.getPhotoLink());

            lista.add(employee);
        }
        JSONObject employeeB = new JSONObject();
        employeeB.put("employee",lista);
        employees=new JSONObject();
        employees.put("employees",employeeB);
    }


}
