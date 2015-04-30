
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class MainJPanel extends javax.swing.JPanel implements ActionListener{

    // timer for animation
    final Timer t = new Timer(40, this);
    
    boolean correctMessage = true;
    
    // start position of balls, and default speed
    double x1 = 100, y1 = 40, x2 = 100, y2 = 60, x3 = 820, y3 = 530, r = 10, velX1 = 0, velY1 = 0, velX2 = 0, velY2 = 0;
    
    // input messages for black and blue balls
    String message = "", binaryMessage = "", checksum = "", incorrectMessage = "";
    
    /**
     * Creates new form MainJPanel
     */
    public MainJPanel() {
        initComponents();
        t.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    /**
     * Convert string to binary number.
     * @param s input string.
     * @return a string of binary number.
     */
    public String stringToBinary(String s){
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        
        for (byte b : bytes){
            int val = b;
            
            for (int i = 0; i < 8; i++){
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        
        return binary.toString();
    }
    
    public String computeChecksum(String s){
        byte[] bytes = s.getBytes();
        Checksum checksumTarget = new CRC32();
        checksumTarget.update(bytes, 0, bytes.length);
        long checksumValue = checksumTarget.getValue();
        return Long.toBinaryString(checksumValue);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // draw lines
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin1 = new Line2D.Float(220, 425, 220, 498);
        g2.draw(lin1);
        Line2D lin2 = new Line2D.Float(266, 520, 317, 520);
        g2.draw(lin2);
        Line2D lin3 = new Line2D.Float(398, 520, 800, 520);
        g2.draw(lin3);
        Line2D lin4 = new Line2D.Float(882, 520, 937, 520);
        g2.draw(lin4);
        Line2D lin5 = new Line2D.Float(972, 425, 972, 498);
        g2.draw(lin5);
        Line2D lin6 = new Line2D.Float(350, 498, 505, 380);
        g2.draw(lin6);
        Line2D lin7 = new Line2D.Float(587, 380, 640, 380);
        g2.draw(lin7);
        Line2D lin8 = new Line2D.Float(680, 321, 680, 352);
        g2.draw(lin8);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // black ball
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x1, y1, 20, 20));
        g2.setColor(Color.blue);
        
        // blue ball
        Graphics2D g3 = (Graphics2D) g;
        g3.fill(new Ellipse2D.Double(x2, y2, 20, 20));
        g3.setColor(Color.red);
        
        // red ball
        Graphics2D g4 = (Graphics2D) g;
        g4.fill(new Ellipse2D.Double(x3, y3, 10, 10));
        g4.setColor(Color.yellow);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        // black ball route
        if (correctMessage){
            if (x1 == 100 && y1 < 529){
                y1 += velY1;
                repaint();
            }
            if (y1 == 530 && x1 < 1069){
                x1 += velX1;
                repaint();
            }
            if (x1 == 1070 && y1 > 150){
                y1 -= velY1;
                repaint();
            }
        }else{
            if (x1 == 100 && y1 < 529){
                y1 += velY1;
                repaint();
            }
            if (y1 == 530 && x1 < 819){
                x1 += velX1;
                repaint();
            }
            if (x1 == 820){
                x1 = 370;
                repaint();
            }
        }        
        
        // blue ball route
        if (x2 == 100 && y2 < 529){
            y2 += velY2;
            repaint();
        }
        if (y2 == 530 && x2 < 309){
            x2 += velX2;
            repaint();
        }
        if (y2 > 389 && x2 > 309 && x2 < 493){
            x2 += velX2 * 1.3;
            y2 -= velY2;
            repaint();
        }
        if (y2 == 388 && x2 > 493 && x2 < 739){
            x2 += velX2;
            repaint();
        }
        if (x2 > 739 && y2 > 49){
            y2 -= velY2;
            repaint();
        }
        
        // red ball route
        if (x1 > 810 && x3 > 380){
            x3 -= velX1;
            repaint();
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

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

        jButton1.setText("Start");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BlackButtonMouseClicked(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetButtonMouseClicked(evt);
            }
        });

        jButton4.setText("Black Msg");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BlackMsgMouseClicked(evt);
            }
        });

        jButton5.setText("Blue Msg");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BlueMsgMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/router.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jButton5)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(jLabel14)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel15)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(123, 123, 123)))))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel5)
                .addGap(289, 289, 289)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, jButton5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                    .addComponent(jLabel6))
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(139, 139, 139)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel2))
                        .addGap(108, 108, 108)
                        .addComponent(jLabel5)))
                .addGap(307, 307, 307))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, jButton5});

    }// </editor-fold>//GEN-END:initComponents

    private void BlackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlackButtonMouseClicked
        // TODO add your handling code here:
        if (jTextField2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No message!");
        }else if (x1 == 100 && y1 == 40){
            velX1 = 2;
            velY1 = 2;
            velX2 = 2;
            velY2 = 2;
            message = jTextField2.getText();
            jTextField2.setEditable(false);
            binaryMessage = stringToBinary(message);
            checksum = computeChecksum(message);
        }else if(correctMessage){
            velX1 = 2;
            velY1 = 2;
            velX2 = 2;
            velY2 = 2;
        }
    }//GEN-LAST:event_BlackButtonMouseClicked

    private void BlackMsgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlackMsgMouseClicked
        // TODO add your handling code here:
        if (correctMessage){
            velX1 = velY1 = 0;
            
            if (x1 == 100 && y1 < 335){
                JOptionPane.showMessageDialog(null, message);
            }
            if (y1 > 335 && x1 < 320){
                JOptionPane.showMessageDialog(null, "Preamble(7 bytes): 10100011101010101010101111110000000111111111111100110101\n" + 
                        "SFD(1 bytes): 10101011\n" + "Destination address(6 bytes): 101011111010101111101010111010101010101000110011\n" + 
                        "Source address(6 bytes): 101011111010101100101010111110101010101000110011\n" + 
                        "Type(2 bytes): 1110010110111000\n" + "Data and padding: " + binaryMessage + "\n" + 
                        "CRC(4 bytes): " + checksum);
            }
            if (x1 > 320 && x1 < 810){
                final ImageIcon icon = new ImageIcon("C:\\Users\\Rui\\Documents\\NetBeansProjects\\Assignment2\\src\\sine.png");
                JOptionPane.showMessageDialog(null, icon);
            }
            if (x1 > 810 && y1 > 335){
                JOptionPane.showMessageDialog(null, "Preamble(7 bytes): 10100011101010101010101111110000000111111111111100110101\n" + 
                        "SFD(1 bytes): 10101011\n" + "Destination address(6 bytes): 101011111010101111101010111010101010101000110011\n" + 
                        "Source address(6 bytes): 101011111010101100101010111110101010101000110011\n" + 
                        "Type(2 bytes): 1110010110111000\n" + "Data and padding: " + binaryMessage + "\n" + 
                        "CRC(4 bytes): " + checksum);
            }
            if (x1 == 972 && y1 < 335){
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }//GEN-LAST:event_BlackMsgMouseClicked

    private void BlueMsgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlueMsgMouseClicked
        // TODO add your handling code here:
        velX2 = velY2 = 0;

        if (x2 == 100 && y2 < 335){
            JOptionPane.showMessageDialog(null, message);
        }
        if (y2 > 335 && x2 < 320){
            JOptionPane.showMessageDialog(null, "Preamble(7 bytes): 10100011101010101010101111110000000111111111111100110101\n" +
                "SFD(1 bytes): 10101011\n" + "Destination address(6 bytes): 101011111010101111101010111010101010101000110011\n" +
                "Source address(6 bytes): 101011111010101100101010111110101010101000110011\n" +
                "Type(2 bytes): 1110010110111000\n" + "Data and padding: " + message + "\n" +
                "CRC(4 bytes): " + checksum);
        }
        if (x2 > 320 && x2 < 520){
            final ImageIcon icon = new ImageIcon("C:\\Users\\Rui\\Documents\\NetBeansProjects\\Assignment2\\src\\sine.png");
            JOptionPane.showMessageDialog(null, icon);
        }
        if (x2 > 520 && y2 > 226){
            JOptionPane.showMessageDialog(null, "Preamble(7 bytes): 10100011101010101010101111110000000111111111111100110101\n" +
                "SFD(1 bytes): 10101011\n" + "Destination address(6 bytes): 101011111010101111101010111010101010101000110011\n" +
                "Source address(6 bytes): 101011111010101100101010111110101010101000110011\n" +
                "Type(2 bytes): 1110010110111000\n" + "Data and padding: " + binaryMessage + "\n" +
                "CRC(4 bytes): " + checksum);
        }
        if (x2 >740 && y2 < 226){
            JOptionPane.showMessageDialog(null, message);
        }
    }//GEN-LAST:event_BlueMsgMouseClicked

    private void ResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseClicked
        // reset the positions of three balls
        x1 = 100;
        y1 = 40;
        x2 = 100;
        y2 = 60;
        x3 = 820;
        y3 = 530;
        velX1 = 0;
        velY1 = 0;
        velX2 = 0;
        velY2 = 0;
        correctMessage = true;
        message = "";
        binaryMessage = "";
        checksum = "";
        incorrectMessage = "";
        jTextField2.setEditable(true);
    }//GEN-LAST:event_ResetButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
