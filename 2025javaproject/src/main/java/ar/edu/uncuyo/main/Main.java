package ar.edu.uncuyo.main;
import ar.edu.uncuyo.view.*;

//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;


public class Main {
//private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args) {

        LoginPanel empview = new LoginPanel();
        //centrar la ventana
        empview.setLocationRelativeTo(null);
        empview.setVisible(true);
        System.out.println("Sistema corriendo");    
    }
}
