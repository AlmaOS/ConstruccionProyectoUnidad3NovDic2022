package Pruebas;

import Modelo.LecturaJSON;
import Vista.vistaPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

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
        System.out.println("Instanciando contact manager...");
        LecturaJSON jsonReader = new LecturaJSON();
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
    public void shouldThrowFileNotFoundExceptionWhenFilenameWrong() {
        assertThrows(FileNotFoundException.class, () -> {
            jsonReader.readFile("empleado.txt");
        });
    }

    @Test
    @DisplayName("El archivo a leer debe tener la estructura adecuada")
    public void shouldThrowParseExceptionWhenJsonStructureWrong() {
        assertThrows(ParseException.class, () -> {
            jsonReader.readFile("employ.txt");
        });
    }
}
