package Modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class LecturaJSON {
    private String[][] employeeInfo;
    private JSONObject objetosDeJSON;
    private int numEmployee;
    private ArrayList<Employee> listEmployees = new ArrayList<>();


    public  void readFile(String archivo){
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader readFile = new FileReader(archivo);
            Object objJSON = jsonParser.parse(readFile);

            JSONObject auxObjetosDeJSON = new JSONObject((Map) objJSON);
            objetosDeJSON = (JSONObject) auxObjetosDeJSON.get("employees");
            leerAtributos();
            //System.out.println(objetosDeJSON);
            numEmployee = numEmployeeCount();
            listEmployees = new ArrayList<>();
            guardarEmployees();

        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch (IOException e){
            System.out.println("Error detectado: "+ e.getMessage());
        } catch (ParseException e){
            System.out.println("Estructura del JSON incorrecta");
        }catch(MissingAttribute e){
            System.out.println("El archivo JSON no cuenta con los atributos completos del empleado o están mal escritos");
        }
    }

    private void leerAtributos() throws MissingAttribute {
        JSONArray listEmployee =(JSONArray) objetosDeJSON.get("employee");
        for(Object emp : listEmployee){
            JSONObject auxEmp = (JSONObject) emp;
            Set<String> atributos = auxEmp.keySet();
                verificarAtributos(atributos);
        }
    }

    public void verificarAtributos(Set<String> atributosEmp) throws MissingAttribute {
        String[] defaultAtributos ={"id","firstName","lastName","photo"};
        int atributosVerificados = 0;
        for ( String atributo : atributosEmp) {
            for(String defAtrib : defaultAtributos) {
                if(defAtrib.equals(atributo)){
                    atributosVerificados++;
                }
            }
        }

        if(atributosVerificados!=4){
            throw new MissingAttribute();
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
            int id = Integer.parseInt((String) auxEmployee.get("id"));
            registroDatos[id-1][0] = String.valueOf(id);
            registroDatos[id-1][1] = (String) auxEmployee.get("firstName");
            registroDatos[id-1][2] = (String) auxEmployee.get("lastName");
            registroDatos[id-1][3] = (String) auxEmployee.get("photo");
            //crearEmployee(id,registroDatos[id-1][1],registroDatos[id-1][2],registroDatos[id-1][3]);
        }
        return registroDatos;
    }

    public void guardarEmployees(){
        JSONArray listEmployee = (JSONArray) objetosDeJSON.get("employee");
        for(Object a:listEmployee){
            JSONObject employeeJSON = (JSONObject) a;
            int ID = Integer.parseInt((String) employeeJSON.get("id"));
            String firstName = (String) employeeJSON.get("firstName");
            String lastName = (String) employeeJSON.get("lastName");
            String photoLink = (String) employeeJSON.get("photo");

            listEmployees.add(new Employee(ID, firstName, lastName, photoLink));
        }

    }

    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    public void imprimir(){
        if(numEmployee!=0){
            for(String[] a: employeeInfo){
                for (String b: a){
                    System.out.println(b);
                }
            }
        }
    }

    public String[][] getEmployeeInfo() {
        return employeeInfo;
    }

    public int getNumEmployee(){return numEmployee;}
}