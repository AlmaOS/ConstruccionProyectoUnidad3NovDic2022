package Pruebas;

import Modelo.Employee;
import Modelo.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega5_Test {

    @Test
    @DisplayName("Debe agregar un employee")
    public void shouldAddEmployee(){
        EmployeeManager employeeManager = new EmployeeManager();
        int size = employeeManager.getListEmployees().size();
        employeeManager.agregarEmpleado(5,"Abril","Garza","https://abril-garza");
        assertEquals(size+1,employeeManager.getListEmployees().size());
    }
}
