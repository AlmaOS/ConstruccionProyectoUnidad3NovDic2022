import Modelo.LecturaJSON;
import Vista.vistaPrincipal;

public class Main {
    public static void main(String[] args) {
        LecturaJSON fileJSON = new LecturaJSON();
        fileJSON.readFile("employee.txt");
        fileJSON.imprimir();
        vistaPrincipal vista = new vistaPrincipal();
        vista.setVisible(true);
    }
}
