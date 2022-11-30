package Pruebas;

import Modelo.LecturaJSON;
import Vista.vistaPrincipal;
import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;

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
    public void shouldThrowStopWhenFilenameWrong() {
        jsonReader.readFile("empleado.txt");
        assertEquals(0,jsonReader.getNumEmployee());
        assertNull(jsonReader.getEmployeeInfo());
    }

    @Test
    @DisplayName("El archivo a leer debe tener la estructura adecuada")
    public void shouldStopWhenJsonStructureWrong() {
        jsonReader.readFile("employ.txt");
        assertEquals(0,jsonReader.getNumEmployee());
        assertNull(jsonReader.getEmployeeInfo());
    }
}
