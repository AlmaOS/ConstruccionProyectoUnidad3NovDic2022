package Pruebas;

import Modelo.Employee;
import Modelo.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega4_Test {

    @Test
    @DisplayName("Debe eliminar employee")
    public void shouldEraseEmployee(){
        EmployeeManager employeeManager=new EmployeeManager();
        int size = employeeManager.getListEmployees().size();
        employeeManager.eliminarEmployee(3);
        assertEquals(size-1,employeeManager.getListEmployees().size());
    }
}
