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
            objetosDeJSON = (JSONObject) auxObjetosDeJSON.get("employees");
            numEmployee = numEmployeeCount();
            employeeInfo=guardarInfoJSON(new String[numEmployee][4]);

        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch (IOException e){
            System.out.println("Error detectado: "+ e.getMessage());
        } catch (ParseException e){
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
        for (int i=0;i<listEmployee.size();i++) {
            Object a= listEmployee.get(i);
            JSONObject auxEmployee = (JSONObject) a;
            int id = Integer.parseInt((String) auxEmployee.get("id"));
            registroDatos[i][0] = String.valueOf(id);
            registroDatos[i][1] = (String) auxEmployee.get("firstName");
            registroDatos[i][2] = (String) auxEmployee.get("lastName");
            registroDatos[i][3] = (String) auxEmployee.get("photo");
        }
        return registroDatos;
    }

    public String[][] getEmployeeInfo() {return employeeInfo;}

    public int getNumEmployee(){return numEmployee;}
}