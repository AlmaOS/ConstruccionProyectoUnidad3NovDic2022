package Modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LecturaJSON {
    private String[][] employeeInfo;
    private JSONObject objetosDeJSON;
    private int numEmployee;


    public  void readFile(String archivo){
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader readFile = new FileReader(archivo);
            Object objJSON = jsonParser.parse(readFile);

            JSONObject auxObjetosDeJSON = new JSONObject((Map) objJSON);
            System.out.println("Json del archivo:");
            objetosDeJSON = (JSONObject) auxObjetosDeJSON.get("employees");
            System.out.println(objetosDeJSON);
            numEmployee = numEmployeeCount();
            employeeInfo = new String[numEmployee][4];
            String[][] auxInfoEmployee = new String[numEmployee][4];
            employeeInfo = guardarInfoJSON(auxInfoEmployee);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error detectado: "+ e.getMessage());
        } catch (ParseException e) {
            System.out.println("Estructura del JSON incorrecta");
        }
    }

    private int numEmployeeCount(){
        int numberEmployees = 0;
        JSONArray listEmployee =(JSONArray) objetosDeJSON.get("employee");
        for (Object a: listEmployee) {
            numberEmployees++;
        }
        return numberEmployees;
    }

    private String[][] guardarInfoJSON(String[][] registroDatos){
        JSONArray listEmployee =(JSONArray) objetosDeJSON.get("employee");
        for (Object a: listEmployee) {
            JSONObject auxEmployee = (JSONObject) a;
            String id = (String) auxEmployee.get("id");
            registroDatos[(Integer.parseInt(id))-1][0] = id;
            registroDatos[(Integer.parseInt(id))-1][1] = (String) auxEmployee.get("firstName");
            registroDatos[(Integer.parseInt(id))-1][2] = (String) auxEmployee.get("lastName");
            registroDatos[(Integer.parseInt(id))-1][3] = (String) auxEmployee.get("photo");
        }
        return registroDatos;
    }

    public void imprimir(){
        for(String[] a: employeeInfo){
            for (String b: a){
                System.out.println(b);
            }
        }
    }

    public String[][] getEmployeeInfo() {
        return employeeInfo;
    }

    public int getNumEmployee(){return numEmployee;}
}