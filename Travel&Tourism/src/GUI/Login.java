/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Homepage;
import GUI.JUser;
import GUI.register;
import People.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static travel.tourism.TravelTourism.hash;

/**
 *
 * @author rock it
 */
public class Login extends JFrame  {
    JButton btn2=new JButton("Login");
    JTextField txt=new JTextField();
    JTextField txt2=new JTextField();
        JLabel label =new JLabel("User Name");
        JLabel label2 =new JLabel("password");
JCheckBox checkbox=new JCheckBox("do u want to save ");
        JLabel label3 =new JLabel("save user name "
                                   + " and"
                                  +" password");
        JButton btn=new JButton("i don't have account");
        

    
    Login(){
        setSize(600, 600);
        setTitle("Login");
        setLayout(null);
        txt.setBounds(200, 150, 200, 60);
        txt2.setBounds(txt.getX(), txt.getY()+70, 200, 60);
        label.setBounds(txt.getX()-100, txt.getY(), 150, 60);
                label2.setBounds(txt.getX()-100, txt2.getY(), 150, 60);
checkbox.setBounds(txt2.getX()+160, txt2.getY()+90, 20, 20);
label3.setBounds(txt.getX(), checkbox.getY()-10, 140, 40);
btn.setBounds(txt.getX(), label3.getY()+50, 150, 30);
btn2.setBounds(txt.getX(), btn.getY()+50, 150, 30);
        add(txt);
       add(txt2);
       add(label);
       add(label2);
       add(checkbox);
       add(btn);
    add(label3);
    add(btn2);
  btn.addActionListener(new action());
   btn.addMouseListener(new mouse());
    btn2.addActionListener(new act()); 
    
    
    }
       class myt implements ActionListener{
 
            @Override
            public void actionPerformed(ActionEvent ae) {
      User i=new User();
  //AdminMenu am=new AdminMenu();
  boolean d=false;
 for(String x:hash.keySet()){
     if(!(x.equals(txt.getText())&&(hash.get(x).getPassword().equals(txt2.getText()))))
     {
          JOptionPane.showMessageDialog(null,"Username or Password is incorrect");   
          d=true;
     }
 }
     if(d){}
     else{
              User x=hash.get(txt.getText());
              // am.setVisible(true);
              /*if(x.getPower()||txt.getText().equals("admin")){
      setVisible(false);
     
 }
      else{
          //e3ml menu el user
          
          
      }*/

    }}}
    
     
   private class mouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
          register R=new register();

   Object buttonpressed=me.getSource();
     if (buttonpressed.equals(btn)){
         R.setVisible(true);
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
    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
          Homepage home=new Homepage();
          register R=new register();
        }
    
    
    
    }
    private class act implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JUser t =new JUser();
            t.setVisible(true);
            setVisible(false);
        }
    
    
    }
   
}


            