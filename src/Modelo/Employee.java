package Modelo;

public class Employee {
    private int ID;
    private String firstName;
    private String lastName;
    private String photoLink;

    public Employee(int ID, String firstName, String lastName, String photoLink) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoLink = photoLink;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    @Override
    public String toString(){
        return "id: "+ID+ ", firstName: " +firstName+ ", lastName: "+lastName+ ", photo: "+photoLink;
    }
}
