package Pruebas;

import Modelo.Employee;
import Modelo.EmployeeManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Entrega3_Test {
    private static EmployeeManager employeeManager;
    private static Employee employee;

    @BeforeEach
    public void inicialize(){
        employeeManager = new EmployeeManager();
        employee = new Employee(3,"Conan","Gray","http://Conan.png");
        employeeManager.modificarEmployee(employee);
    }

    @Test
    @DisplayName("Probando modificar employee")
    public void shouldModifyEmployee(){
        assertFalse(employeeManager.getListEmployees()==null);
        assertEquals(3,employeeManager.getListEmployees().size());
    }

    @Test
    @DisplayName("Probando modificar JSON")
    public void shouldModifyJSON(){
        assertFalse(employeeManager.getEditor().getEmployees()==null);
        assertEquals(1,employeeManager.getEditor().getEmployees().size());
    }
}
