import Modelo.LecturaJSON;

public class Main {
    public static void main(String[] args) {
        LecturaJSON fileJSON = new LecturaJSON();
        fileJSON.readFile();
        fileJSON.imprimir();
    }
}
