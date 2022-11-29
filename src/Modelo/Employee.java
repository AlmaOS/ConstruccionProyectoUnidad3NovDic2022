package Modelo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

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

    public Object[] toTableFormat(){
        JLabel JImg = new JLabel();
        try {
            JImg.setIcon(createImage(this.photoLink));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Object[] {ID, firstName, lastName, JImg};
    }

    public ImageIcon createImage(String urlLocation) {
        Image image = null;

        try {
            URL urlImg = new URL(urlLocation);
            image = ImageIO.read(urlImg);
            Image icon = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (Exception e) {
            ImageIcon img = new ImageIcon("user.png");
            Image icon = img.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        }
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setPhotoLink(String photoLink) {this.photoLink = photoLink;}
}
