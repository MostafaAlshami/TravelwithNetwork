/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Login;
import GUI.register;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author rock it
 */
public class Homepage extends JFrame implements Runnable {

    private Graphics myg;
    private Boolean paintme = true;

    JButton btn = new JButton("log in");
    JButton btn2 = new JButton("register");

    //JLabel Time = new JLabel();
    JLabel ex= new JLabel();
    
    JFrame frame = new JFrame();

    public Homepage() {

        JLabel background;
        add(btn);
        add(btn2);
       // add(Time);
        add(ex);
        //Time.setText("menna");
        this.setLayout(null);

       // ex.setBounds(200, 100, 200, 70);
        btn.setBounds(300, 200, 200, 70);
        btn2.setBounds(300, 300, 200, 70);
        ex.setBounds(500, 60, 200, 70);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss ");

        LocalDateTime local = LocalDateTime.now();
        

        //frame.add(Time);
        btn.addActionListener(new action());
        btn.addMouseListener(new mouse());
        btn2.addActionListener(new action());
        btn2.addMouseListener(new mouse());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("safarny");
        setSize(600, 600);
    }

    @Override
    public void run() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss ");
        while (true) {
            LocalDateTime local = LocalDateTime.now();
            ex.setText(dtf.format(local));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void paint(Graphics g) {

        myg = g;

        super.paint(g);
        BufferedImage img;
        try {
            img = ImageIO.read(new File("C:\\Users\\Mostafa\\Desktop\\'9aya3 '9ameer\\shanks.jpg"));
            g.drawImage(img, 600, 300, null);
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Login L = new Login();
            register A = new register();

        }
    }

    private class mouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

        }

        @Override
        public void mousePressed(MouseEvent me) {
            Login L = new Login();
            register A = new register();

            Object buttonpressed = me.getSource();
            if (buttonpressed.equals(btn)) {
                L.setVisible(true);
                setVisible(false);

            } else if (buttonpressed.equals(btn2)) {
                A.setVisible(true);
                setVisible(false);

            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }

}
