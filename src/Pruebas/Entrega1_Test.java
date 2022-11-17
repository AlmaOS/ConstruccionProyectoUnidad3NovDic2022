package Pruebas;

import Modelo.LecturaJSON;
import Vista.vistaPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1_Test {
    private static LecturaJSON jsonReader;

    @Test
    @DisplayName("Probando crear vista")
    public void shouldCreatView() {
        vistaPrincipal view = new vistaPrincipal();
        view.setVisible(true);
        assertTrue(view.isVisible());
    }

    @BeforeEach
    public void inicialize(){
        System.out.println("Instanciando lector Json...");
        jsonReader = new LecturaJSON();
    }

    @Test
    @DisplayName("Probando crear lector")
    public void shouldCreatJsonFile() {
        jsonReader.readFile("employee.txt");
        assertFalse(jsonReader.getEmployeeInfo()==null);
        assertEquals(3, jsonReader.getNumEmployee());
    }

    @Test
    @DisplayName("El archivo a leer debe estar dentro del directorio")
    public void shouldStopWhenFilenameWrong() {
        jsonReader.readFile("empleado.txt");
        assertFalse(jsonReader.getEmployeeInfo()==null);
        assertEquals(3, jsonReader.getNumEmployee());
    }

    @Test
    @DisplayName("El archivo a leer debe tener la estructura adecuada")
    public void shouldStopWhenJsonStructureWrong() {
        jsonReader.readFile("employ.txt");
        assertFalse(jsonReader.getEmployeeInfo()==null);
        assertEquals(3, jsonReader.getNumEmployee());
    }

    @Test
    @DisplayName("El archivo a leer debe tener los atributos adecuados")
    public void shouldStopWhenAttributesWrong() {
        jsonReader.readFile("emp.txt");
        assertFalse(jsonReader.getEmployeeInfo()==null);
        assertEquals(3, jsonReader.getNumEmployee());
    }
}
