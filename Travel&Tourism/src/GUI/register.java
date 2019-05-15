/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Homepage;
import GUI.Login;
import People.Saving_User_Data;
import People.User;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import sun.util.calendar.JulianCalendar;
import static travel.tourism.TravelTourism.UserLib;
import static travel.tourism.TravelTourism.hash;
import static travel.tourism.TravelTourism.savehash;

/**
 *
 * @author rock it
 */
public class register extends JFrame {

    JComboBox box = new JComboBox(getAllCountries());
    JButton btn = new JButton("Sign Up");
    JButton btn2 = new JButton("Back");
    //---------------------------------------------------
    JTextField txt = new JTextField();
    JTextField txt3 = new JTextField();
    JTextField txt4 = new JTextField();
//-----------------------------------------------------
    JLabel lbl = new JLabel("Username");
    JLabel lbl2 = new JLabel("Password");
    JLabel lbl3 = new JLabel("Repassword");
    JLabel lbl4 = new JLabel("Email");
    JLabel lbl5 = new JLabel("Nationality");
    JLabel lbl6 = new JLabel("Gender");
JPasswordField pfPassword;
JPasswordField repfPassword ;

    register() {
        JRadioButton m = new JRadioButton("Male", true);
        JRadioButton f = new JRadioButton("Female");
  pfPassword = new JPasswordField(20);
 lbl2.setLabelFor(pfPassword);
   repfPassword = new JPasswordField(20);
 lbl3.setLabelFor(repfPassword);
 
        setLayout(null);
        setSize(1000, 1000);
        setTitle("Registaration");
        txt.setBounds(350, 150, 200, 40);
        lbl.setBounds(250, 150, 200, 40);
        pfPassword.setBounds(txt.getX(), txt.getY() + 60, 200, 40);
        lbl2.setBounds(lbl.getX(), pfPassword.getY(), 200, 40);
        repfPassword.setBounds(pfPassword.getX(), pfPassword.getY() + 60, 200, 40);
        lbl3.setBounds(lbl2.getX(), repfPassword.getY(), 200, 40);
        txt4.setBounds(repfPassword.getX(), repfPassword.getY() + 60, 200, 40);
        lbl4.setBounds(lbl3.getX(), txt4.getY(), 200, 40);
        box.setBounds(400, 20, 109, 30);
        lbl5.setBounds(320, 20, 70, 30);
        ButtonGroup gender = new ButtonGroup();
        gender.add(m);
        gender.add(f);
        // JOptionPane.showMessageDialog(null, "hello world");
        m.setBounds(400, txt4.getY() + 90, 100, 30);
        f.setBounds(510, txt4.getY() + 90, 100, 30);
        lbl6.setBounds(300, f.getY(), 150, 40);
        btn.setBounds(350, 650, 150, 30);
        btn2.setBounds(700, box.getY(), btn.getWidth(), btn.getHeight());

        add(txt);
        add(lbl);
        add(pfPassword);
        add(lbl2);
        add(repfPassword);
        add(lbl3);
        add(txt4);
        add(lbl4);
        add(m);
        add(f);
        add(box);
        add(lbl5);
        add(lbl6);
        add(btn);
        add(btn2);
        btn2.addActionListener(new action());
        btn.addActionListener(new signin()); 
        btn2.addActionListener(new action());
//    btn.addActionListener(new myHolder());
        
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    /*public void paint(Graphics g){
     
     
       super.paint(g);
         BufferedImage img,img2;
    try {
        img = ImageIO.read(new File("E:\\oop\\project\\Travel Tourism\\dowenload.jpg"));
    //    img2 = ImageIO.read(new File("C:\\Users\\Mostafa\\Desktop\\'9aya3 '9ameer\\51cdca02c3d8392ae1b3ebb3de4b70de.jpg"));
         g.drawImage(img,700,700,null);
      //   g.drawImage(img2,800,100,null);

    } catch (IOException ex) {
        Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
    }
    }*/

    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Homepage home = new Homepage();
            home.setVisible(true);
            setVisible(false);
        }
    }
     private class signin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(txt.getText().length()==0 || txt4.getText().length()==0 || pfPassword.getPassword().length==0 || repfPassword.getPassword().length==0 ){
            
                 JOptionPane.showMessageDialog(null, "fill all data :","lost", JOptionPane.INFORMATION_MESSAGE);

            }//pfPassword.getText()!=repfPassword.getText()
           else if(!pfPassword.getText().equals(repfPassword.getText()) ){
               
              
                             JOptionPane.showMessageDialog(null, "password error :","lost", JOptionPane.ERROR_MESSAGE);

            
            
            }
           else{
User u=new User();
Login log=new Login();
boolean istaken =false;

             for(User i:UserLib){
                // System.out.println("testing");
                 if (i.getUsername().equals(txt.getText())){
                   JOptionPane.showMessageDialog(null, "Username already taken");
                   istaken=true;
                   break;
                    }}
             if(istaken){}
             else{
                     u.setUsername(txt.getText());
              //   u.setPassword(new String(p1.getPassword()));
             //   if(txt.getText().equals("admin"))
               //     u.givePower();
                 UserLib.add(u);
                 hash.put(txt.getText(),u);
                 savehash();
                 Saving_User_Data x=new Saving_User_Data();
                 x.save();
                 JOptionPane.showMessageDialog(null,"User Created Successfully");
                
        
             }
       
       setVisible(false);
        log.setVisible(true);
        }
       
        }
     
           
           }
            
     
        
     
     
     
     
     
     
//      class myHolder implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//User u=new User();
//Login log=new Login();
//boolean istaken =false;
//
//             for(User i:UserLib){
//                // System.out.println("testing");
//                 if (i.getUsername().equals(txt.getText())){
//                   JOptionPane.showMessageDialog(null, "Username already taken");
//                   istaken=true;
//                   break;
//                    }}
//             if(istaken){}
//             else{
//                     u.setUsername(txt.getText());
//              //   u.setPassword(new String(p1.getPassword()));
//             //   if(txt.getText().equals("admin"))
//               //     u.givePower();
//                 UserLib.add(u);
//                 hash.put(txt.getText(),u);
//                 savehash();
//                 Saving_User_Data x=new Saving_User_Data();
//                 x.save();
//                 JOptionPane.showMessageDialog(null,"User Created Successfully");
//                
//        
//             }
//       
//       setVisible(false);
//        log.setVisible(true);
//        }
//       
//        }
//     
//
//    
   
     private void txt2KeyPressed(java.awt.event.KeyEvent evt){
    
 int key=evt.getKeyCode();
     if(key==10){
         txt3.requestFocus();
     }
     
    
    }
          private void txt3KeyPressed(java.awt.event.KeyEvent evt){
    
 int key=evt.getKeyCode();
     if(key==10){
         txt4.requestFocus();
     }
     
    
    }
           private void txt4KeyPressed(java.awt.event.KeyEvent evt){
    
 int key=evt.getKeyCode();
     if(key==10){
         txt.requestFocus();
     }
     
    
    }
    
    /*  private class foucs implements FocusListener{

        @Override
        public void focusGained(FocusEvent fe) {
                if(txt  instanceof JTextField)
                txt.setText(null);  
                if(txt2  instanceof JTextField)
                txt2.setText(null);      
                 if(txt3  instanceof JTextField)
                                     txt3.setText(null);  

                      if(txt4  instanceof JTextField)
                                          txt4.setText(null);  

        
        
        }

        @Override
        public void focusLost(FocusEvent fe) {
            System.out.println("write some thing");        
        }
    
    
               }*/






    public String[] getAllCountries() {
        String[] countries = new String[Locale.getISOCountries().length];
        String[] countryCodes = Locale.getISOCountries();
        for (int i = 0; i < countryCodes.length; i++) {
            Locale obj = new Locale("", countryCodes[i]);
            countries[i] = obj.getDisplayCountry();
        }
        return countries;
    }
   

}