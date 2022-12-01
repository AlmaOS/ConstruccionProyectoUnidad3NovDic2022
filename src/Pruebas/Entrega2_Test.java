package Pruebas;

import Modelo.EmployeeManager;
import Modelo.LecturaJSON;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Entrega2_Test {

    @Test
    @DisplayName("Debe crear un arraylist de Employee con el JSON")
    public void shouldCreateArrayOfEmployees(){
        EmployeeManager manager = new EmployeeManager();
        assertFalse(manager.getListEmployees()==null);
        assertEquals(3, manager.getListEmployees().size());    }
}
