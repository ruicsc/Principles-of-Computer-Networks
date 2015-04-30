
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui Da
 */
public class MainJPanel extends javax.swing.JPanel implements ActionListener, KeyListener{

    final Timer t = new Timer(40, this);
    int x = 100, y = 40, r = 10, velX = 0, velY = 0;
    
    /**
     * Creates new form MainJPanel
     */
    public MainJPanel() {
        initComponents();
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin1 = new Line2D.Float(220, 320, 220, 395);
        g2.draw(lin1);
        Line2D lin2 = new Line2D.Float(255, 425, 357, 425);
        g2.draw(lin2);
        Line2D lin3 = new Line2D.Float(439, 425, 523, 425);
        g2.draw(lin3);
        Line2D lin4 = new Line2D.Float(604, 425, 723, 425);
        g2.draw(lin4);
        Line2D lin5 = new Line2D.Float(755, 320, 755, 395);
        g2.draw(lin5);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x, y, 20, 20));
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        x += velX;
        y += velY;
        repaint();
    }
    
    public void up() {
        velX = 0;
        velY = -2;
    }
    
    public void down() {
        velX = 0;
        velY = 2;
    }
    
    public void left() {
        velX = -2;
        velY = 0;
    }
    
    public void right() {
        velX = 2;
        velY = 0;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_RIGHT) {
            if (x == 100 && y < 480) {
                down();
            } else if (x == 860 && y <= 480 && y > 40) {
                up();
            } else if (x < 860 && y == 480) {
                right();
            } else {
                velX = 0;
                velY = 0;
            }
        }
        if (code == KeyEvent.VK_LEFT) {
            if (x == 100 && y <= 480 && y > 40) {
                up();
            } else if (x == 860 && y < 480) {
                down();
            } else if (x > 100 && y == 480) {
                left();
            } else {
                velX = 0;
                velY = 0;
            }
        }
        if (code == KeyEvent.VK_SPACE) {
            if (x == 100 && y >= 40 && y <= 60) {
                JOptionPane.showMessageDialog(null,"Name: Application Layer\n" + 
                    "Fuctionality: Network process to application\n" + 
                    "Data Unit: Data\n" + "Message Example: \"AH\" + \"Hello\"");
            }
            if (x == 100 && y > 60 && y <= 100) {
                JOptionPane.showMessageDialog(null,"Name: Presentation Layer\n" + 
                    "Fuctionality: Data presentation and encryption\n" + 
                    "Data Unit: Data\n" + "Message Example: \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 100 && y > 100 && y <= 140) {
                JOptionPane.showMessageDialog(null,"Name: Session Layer\n" + 
                    "Fuctionality: Managing communication sessions\n" + 
                    "Data Unit: Data\n" + "Message Example: \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 100 && y > 140 && y <= 180) {
                JOptionPane.showMessageDialog(null,"Name: Transport Layer\n" + 
                    "Fuctionality: Reliable transmission of data from point to network\n" + 
                    "Data Unit: Segment\n" + "Message Example: \"TH\" + \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 100 && y > 180 && y <= 220) {
                JOptionPane.showMessageDialog(null,"Name: Network Layer\n" + 
                    "Fuctionality: Structuring and managing a multi-node network, including addressing, routing and traffic control\n" + 
                    "Data Unit: Packet, Datagram\n" + "Message Example: \"NH\" + \"TH\" + \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 100 && y > 220 && y <= 260) {
                JOptionPane.showMessageDialog(null,"Name: Data-Link Layer\n" + 
                    "Fuctionality: Sending data to receiving node by a physical layer\n" + 
                    "Data Unit: Frame, Bit\n" + "Message Example: \"DLH\" + \"NH\" + \"TH\" + \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 100 && y > 260 && y <= 300) {
                JOptionPane.showMessageDialog(null,"Name: Physical Layer\n" + 
                    "Fuctionality: Sending raw bit streams over a physical medium\n" + 
                    "Data Unit: Bit\n" + "Message Example: \"010000001001010100010101010......\"");
            }
            if (x == 100 && y > 300 && y <= 480) {
                JOptionPane.showMessageDialog(null,"Data Transmitting: \"010000001001010100010101010......\"");
            }
            if (y == 480 && x > 100 && y < 860) {
                JOptionPane.showMessageDialog(null,"Data Transmitting: \"010000001001010100010101010......\"");
            }
            if (x == 860 && y > 300 && y <= 480) {
                JOptionPane.showMessageDialog(null,"Data Transmitting: \"010000001001010100010101010......\"");
            }
            if (x == 860 && y >= 40 && y <= 60) {
                JOptionPane.showMessageDialog(null,"Name: Application Layer\n" + 
                    "Fuctionality: Network process to application\n" + 
                    "Data Unit: Data\n" + "Message Example: \"AH\" + \"Hello\"");
            }
            if (x == 860 && y > 60 && y <= 100) {
                JOptionPane.showMessageDialog(null,"Name: Presentation Layer\n" + 
                    "Fuctionality: Data presentation and decryption\n" + 
                    "Data Unit: Data\n" + "Message Example: \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 860 && y > 100 && y <= 140) {
                JOptionPane.showMessageDialog(null,"Name: Session Layer\n" + 
                    "Fuctionality: Managing communication sessions\n" + 
                    "Data Unit: Data\n" + "Message Example: \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 860 && y > 140 && y <= 180) {
                JOptionPane.showMessageDialog(null,"Name: Transport Layer\n" + 
                    "Fuctionality: Reliable transmission of data from network to point\n" + 
                    "Data Unit: Segment\n" + "Message Example: \"TH\" + \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 860 && y > 180 && y <= 220) {
                JOptionPane.showMessageDialog(null,"Name: Network Layer\n" + 
                    "Fuctionality: Structuring and managing a multi-node network, including addressing, routing and traffic control\n" + 
                    "Data Unit: Packet, Datagram\n" + "Message Example: \"NH\" + \"TH\" + \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 860 && y > 220 && y <= 260) {
                JOptionPane.showMessageDialog(null,"Name: Data-Link Layer\n" + 
                    "Fuctionality: Receiving data to receiving node by a physical layer\n" + 
                    "Data Unit: Frame, Bit\n" + "Message Example: \"DLH\" + \"NH\" + \"TH\" + \"SH\" + \"PH\" + \"AH\" + \"Hello\"");
            }
            if (x == 860 && y > 260 && y <= 300) {
                JOptionPane.showMessageDialog(null,"Name: Physical Layer\n" + 
                    "Fuctionality: Receiving raw bit streams over a physical medium\n" + 
                    "Data Unit: Bit\n" + "Message Example: \"010000001001010100010101010......\"");
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
            velX = 0;
            velY = 0;
        }        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jTextField1.setEditable(false);
        jTextField1.setText("Application Layer");

        jTextField3.setEditable(false);
        jTextField3.setText("Presentation Layer");

        jTextField4.setEditable(false);
        jTextField4.setText("Session Layer");

        jTextField5.setEditable(false);
        jTextField5.setText("Transport Layer");

        jTextField6.setEditable(false);
        jTextField6.setText("Network Layer");

        jTextField7.setEditable(false);
        jTextField7.setText("Data-Link Layer");

        jTextField10.setEditable(false);
        jTextField10.setText("Physical Layer");

        jTextField11.setEditable(false);
        jTextField11.setText("Data-Link Layer");

        jTextField12.setEditable(false);
        jTextField12.setText("Physical Layer");

        jTextField13.setEditable(false);
        jTextField13.setText("Network Layer");

        jTextField14.setEditable(false);
        jTextField14.setText("Application Layer");

        jTextField15.setEditable(false);
        jTextField15.setText("Presentation Layer");

        jTextField16.setEditable(false);
        jTextField16.setText("Session Layer");

        jTextField17.setEditable(false);
        jTextField17.setText("Transport Layer");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel5.setText("CSC 567 - Assignment 1");

        jLabel6.setText("Rui Da");

        jLabel7.setText("Keyboard \"Right\":");

        jLabel8.setText("Keyboard \"Left\":");

        jLabel9.setText("Keyboard \"Space\":");

        jLabel10.setText("move bubble forwards");

        jLabel11.setText("move bubble backwards");

        jLabel12.setText("show transmitting message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))))
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4))
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
