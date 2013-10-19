package br.com.cadoresistemas.williamcadore.trucks_system;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.DAO.UtilDAO;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String Nimbus = "Nimbus";
        String Windows = "Windows";
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if (Windows.equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());

                            break;
                        }
             }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
    }
                //PlasticLookAndFeel.setPlasticTheme(new com.jgoodies.looks.plastic.theme.ExperienceRoyale());

                //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run(){
                    ConnectionFactory.getConnection(-1);
                    System.out.println(new UtilDAO().getSizeDB());
                    try {
                        new Util().getVersionSystem();
                    } catch (IOException e) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
                   }
            }
        });
    }
}