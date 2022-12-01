package Pruebas;

import Modelo.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega4_Test {
    private static EmployeeManager employeeManager;

    @BeforeEach
    public void inicialize(){
        employeeManager=new EmployeeManager();
        employeeManager.eliminarEmployee(3);
    }

    @Test
    @DisplayName("Debe eliminar employee")
    public void shouldEraseEmployee(){
        assertEquals(4,employeeManager.getListEmployees().size());
    }

    @Test
    @DisplayName("Debe eliminar del JSON")
    public void shouldEraseFromJSON(){
        assertFalse(employeeManager.getEditor().getEmployees()==null);
        assertEquals(1,employeeManager.getEditor().getEmployees().size());
    }
}
