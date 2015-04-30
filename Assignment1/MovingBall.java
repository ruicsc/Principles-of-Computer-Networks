
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui
 */
public class MovingBall extends JPanel implements ActionListener {
        Timer t = new Timer(5, this);
        double x = 0, y = 0, velX = 2, velY = 2;
        
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
            g2.fill(circle);
            t.start();
            //g.setColor(Color.RED);
            //g.fillOval(r, r, 2*r, 2*r);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            x += velX;
            y += velY;
            repaint();
        }
    }
