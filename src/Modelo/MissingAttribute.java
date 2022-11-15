package Modelo;

public class MissingAttribute extends Exception{
    public MissingAttribute(){
        super("La estructura del employee en el archivo es incorrecta.");
    }
}
