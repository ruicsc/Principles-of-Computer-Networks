
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui
 */
public class Driver {
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame a = new JFrame();
                MainJPanel temp = new MainJPanel();
                a.setVisible(true);
                a.add(temp);
                a.setSize(995, 600);
                
            }
        });
    }
}
