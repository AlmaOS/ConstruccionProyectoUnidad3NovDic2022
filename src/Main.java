import Modelo.LecturaJSON;
import Vista.vistaPrincipal;

public class Main {
    public static void main(String[] args) {
        LecturaJSON fileJSON = new LecturaJSON();
        fileJSON.readFile();
        fileJSON.imprimir();
        vistaPrincipal vista = new vistaPrincipal();
        vista.setVisible(true);
    }
}
