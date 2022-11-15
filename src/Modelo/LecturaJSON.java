package Modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class LecturaJSON {
    private String[][] employeeInfo;
    private JSONObject objetosDeJSON;
    private String[] atributosGuardados;
    private int numEmployee;


    public  void readFile(String archivo){
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader readFile = new FileReader(archivo);
            Object objJSON = jsonParser.parse(readFile);

            JSONObject auxObjetosDeJSON = new JSONObject((Map) objJSON);
            System.out.println("Json del archivo:");
            objetosDeJSON = (JSONObject) auxObjetosDeJSON.get("employees");
            guardarAtributosEmployee();
            System.out.println(objetosDeJSON);
            numEmployee = numEmployeeCount();
            employeeInfo = new String[numEmployee][4];
            String[][] auxInfoEmployee = new String[numEmployee][4];
            employeeInfo = guardarInfoJSON(auxInfoEmployee);

        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch (IOException e){
            System.out.println("Error detectado: "+ e.getMessage());
        } catch (ParseException e){
            System.out.println("Estructura del JSON incorrecta");
        }
    }

    private void guardarAtributosEmployee(){
        JSONArray listEmployee =(JSONArray) objetosDeJSON.get("employee");
        for(Object emp : listEmployee){
            JSONObject auxEmp = (JSONObject) emp;
            Set<String> atributos = auxEmp.keySet();
            atributosGuardados = new String[atributos.size()];
            try {
                verificarAtributos(atributos);
            } catch (MissingAttribute e) {
                System.out.println("La estructura del employee en el archivo es incorrecta.");
                System.exit(1);
            }
        }


    }

    public void verificarAtributos(Set<String> atributosEmp) throws MissingAttribute {
        String[] defaultAtributos ={"firstName","lastName","photo","id"};
        int numAtributos = 0;
        int i = 0;
        for ( String key : atributosEmp) {
            atributosGuardados[i] = (String) key;
            numAtributos = 0;
            for(String atrib : defaultAtributos) {
                for (String llave : atributosGuardados) {
                    if(atrib.equals(llave)){
                        numAtributos++;
                        break;
                    }
                }
            }
            i++;
        }

        if(numAtributos!=4){
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
            String id = (String) auxEmployee.get("id");
            registroDatos[(Integer.parseInt(id))-1][0] = id;
            registroDatos[(Integer.parseInt(id))-1][1] = (String) auxEmployee.get("firstName");
            registroDatos[(Integer.parseInt(id))-1][2] = (String) auxEmployee.get("lastName");
            registroDatos[(Integer.parseInt(id))-1][3] = (String) auxEmployee.get("photo");
        }
        return registroDatos;
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