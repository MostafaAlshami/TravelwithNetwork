/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.tourism;

import GUI.Homepage;
import travel.tourism.*;
import People.Saving_User_Data;
import People.User;
import Service.Accommodation;
import Service.Transportation;
import java.awt.Menu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Mostafa
 */

public class TravelTourism {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<User> UserLib = new ArrayList<User>();
    public static HashMap<String, User> hash = new HashMap<String, User>();
    public static HashMap<String, Transportation> T = new HashMap<String, Transportation>();
    public static HashMap<String, Accommodation> A = new HashMap<String, Accommodation>();

    public static void savehash() {
        try{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\oopproject\\Travel&tourism\\HashMap.bin"));
        oos.writeObject(hash);
        oos.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found exc");
        }
        catch(IOException e)
        {
            System.out.println("IOException found");
        }
    }

    public static void loadhash() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\oopproject\\Travel&tourism\\HashMap.bin"));
        hash = (HashMap<String, User>) ois.readObject();
        ois.close();
    }

    boolean Exit = false;
    Scanner read = new Scanner(System.in);

    public int getinput(int NumChoices) { 
        int choice = -1;
        while (choice < 0 || choice > NumChoices) {
            try {
                // System.out.print("please enter your \n");
                System.out.print("enter your choice: ");
                choice = Integer.parseInt(read.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("invalid selection please enter a valid one");
            }

        }
        return choice;
    }

    public void PrintHeaderLine() {

        System.out.println("|--------------------------------------------|");
        System.out.println("|---------------Welcome to ------------------|");
        System.out.println("|-----------our Travel Agency----------------|");
        System.out.println("|------------------^_^-----------------------|");
    } //welcome hehe5 ;)

    public static void main(String[] args) throws IOException {
         Homepage z= new Homepage();
         
         
         
         JFrame J =new JFrame();
          // Login Ox=new Login();
         //register BC =new register();
        z.setVisible(true);
       
       // Ox.setVisible(true);
        //BC.setVisible(true);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Ox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       //BC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // TODO code application logic here
        
        //---------> SERVER OLD ONE 
//        Server s=new Server();
//        s.setVisible(true);
//        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Thread l=new Thread(s);
//        l.start();
//        Client p1=new Client("Player1");
//        p1.setVisible(true);
//        p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        Client p2=new Client("Player2");
//        p2.setVisible(true);
//        p2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //s.start();
        
        //------------------------------------------------------->SERVERRRR222
        
        ClientGUI clientGUI = new ClientGUI("127.0.0.1", 3000);
        ServerGUI serverGUI = new ServerGUI(3000);
        clientGUI.setVisible(true);
        serverGUI.setVisible(true); 
        ClientGUI clientGUI1 = new ClientGUI("127.0.0.1", 3000);
        clientGUI1.setVisible(true);
        
        
        
        Server server2 = new Server(3000);
//        
//        
        
        
        
        
        
        
        
        
        
        
        Transportation TR = new Transportation();
        Accommodation AC = new Accommodation();
        Saving_User_Data test = new Saving_User_Data();
        test.load();
        //System.out.println("Users Data loaded Successfully");
         Thread t=new Thread(z);
         t.start();
        try {
          //  User testt=new User();   
            //hash.put("test", testt);
            //savehash();
            
            loadhash();
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Error While Loading Data");
        }
//        Reservation_Data test1=new Reservation_Data();
//        test1.load();
//        System.out.println("Reservation Data loaded Successfully");
        TravelTourism ezMenu = new TravelTourism();
        ezMenu.PrintHeaderLine();

        String ID;
        int X1;
        String X2;
        String X3;
        Boolean X4;
        
        int choice = -1;
        int choice2=-1;
        int choice1=-1;
        while (choice!= 0) {
            System.out.println("1) Login ");
            System.out.println("2) Register ");
            System.out.println("0) Exit");
            choice = ezMenu.getinput(2);
            switch (choice) {
                case 0:
                    ezMenu.Exit = true;
                    System.out.println("Thanks for using our System");
                    break;
                case 1: //NE3MEL LOGINNNN HENAAA BEYTA2KED MEN 2L DATA 2L 3ANDO
  
                    System.out.println("Username: ");
                    Scanner read = new Scanner(System.in);
                    String Take_Username = read.next();
                    System.out.println("Password: ");
                    String Take_Password = read.next();
                    User temp = new User();
                     {
                        try {
                            if (!temp.Login(Take_Username, Take_Password)) {
                                //------------------------------------------------
                                System.out.println("incorrect username or password");
                                break;
                            }
                        } catch (Exception ex) {
                            System.out.println("Account doesn't exist");

                        }
                        finally{
                             while(choice1!=0)
                            {   
                                System.out.println("1)Tranportation Services");
                                System.out.println("2)Accommodation Services");
                                System.out.println("0)Exit");
                                choice1=ezMenu.getinput(2);
                            
                                
                            while(choice2!=0 && choice1 == 1)
                            {
                                System.out.println("1)Add Transport reservation");
                                System.out.println("2)View reservation");
                                System.out.println("3)Edit reservation");
                                System.out.println("4)Cancel reservation");
                                System.out.println("0)Logout");
                                choice2=ezMenu.getinput(4);
                                switch(choice2)
                                {
                                    case 1:
                                        System.out.println("Enter ID");
                                        ID = read.next();
                                        System.out.println("Enter Desired Vehicle Type (BUS OR PLANE OR TAXI OR RENTAL)");
                                        X2 = read.next();
                                        System.out.println("Enter Preferred Capcity");
                                        X1 = read.nextInt();
                                        TR.reserve();
                                        TR.add(ID, X1, X2, X2, true);
                                        T.put(TR.trans_ID, TR);
                                        System.out.println("Added Reservation successfully");
                                       
                                    break;
                                    
                                    case 2:
                                        System.out.println("Enter ID");
                                         ID=read.next();
                                        // T.get(ID);
                                         TR=T.get(ID);
                                        System.out.println("Type Of vechicle: "+TR.getType());
                                        TR.getCapacity();
                                        System.out.println("Capacity chosen: "+TR.getCapacity());
                                        System.out.println("Reservation Status: "+TR.isStatus());
                                        
                                        System.out.println("Reservaton Data Retrieved Successfully");
                                        break;
                                    
                                    case 3:
                                        System.out.println("Enter ID");
                                        ID = read.next();
                                        TR=T.get(ID);
                                        System.out.println("Enter Desired Vehicle Type (BUS OR PLANE OR TAXI OR RENTAL)");
                                        X2 = read.next();
                                        System.out.println("Enter Preferred Capcity");
                                        X1 = read.nextInt();
                                        TR.reserve();
                                        TR.modify(ID, X1, X2, X2, true);
                                        T.replace(TR.trans_ID, TR);
                                        System.out.println("Edited Reservation successfully");
                                    break;
                                    
                                    case 4:
                                        System.out.println("Enter ID");
                                        ID = read.next();
                                        TR=T.get(ID);
                                        //TR = T.get(read.nextLine());
                                        TR.delete();
                                        System.out.println("Reservation Cancelled");
                                        
                                    case 0:
                                        System.out.println("Logout Successfull");
                                    break;
                                }
                            }
                            while(choice2!=0 && choice1 == 2)
                            {
                                System.out.println("1)Add Accommodation reservation");
                                System.out.println("2)View reservation");
                                System.out.println("3)Edit reservation");
                                System.out.println("4)Cancel reservation");
                                System.out.println("0)Logout");
                                choice2=ezMenu.getinput(4);
                                switch(choice2)
                                {
                                    case 1:
                                        System.out.println("Enter ID");
                                        AC.setPlace_ID(read.nextLine());
                                        System.out.println("Enter Desired Accommodation Type (HOTEL OR RESORT OR CAMP)");
                                        AC.setType(read.nextLine());
                                        System.out.println("Enter Description");
                                        AC.setDescription(read.nextLine());
                                        System.out.println("Enter Location");
                                        AC.setLocation(read.nextLine());
                                        AC.reserve();
                                        A.put(AC.place_ID, AC);
                                        System.out.println("Added Reservation successfully");
                                       
                                    break;
                                    
                                    case 2:
                                        System.out.println("Enter ID");
                                        AC = A.get(read.nextLine());
                                        AC.getType();
                                        AC.getDescription();
                                        AC.getLocation();
                                        AC.isBooked();
                                        System.out.println("Reservaton Data Retrieved");
                                        break;
                                    
                                    case 3:
                                        System.out.println("Enter ID");
                                        TR = T.get(read.nextLine());
                                        System.out.println("Enter Desired Accommodation Type (HOTEL OR RESORT OR CAMP)");
                                        TR.setType(read.nextLine());
                                        System.out.println("Enter Description");
                                        AC.setDescription(read.nextLine());
                                        System.out.println("Enter Location");
                                        AC.setLocation(read.nextLine());
                                        A.put(AC.place_ID, AC);
                                        System.out.println("Edited Reservation successfully");
                                    break;
                                    
                                    case 4:
                                        System.out.println("Enter ID");
                                        AC = A.get(read.nextLine());
                                        AC.delete();
                                        System.out.println("Reservation Cancelled");
                                        
                                    case 0:
                                           System.out.println("Logout Successfull");
                                    break;
                                }
                            }
                        }
                        } 
                        
                        
                    }
                    if ("admin".equals(Take_Username) && "password".equals(Take_Password)) {     //  manager---------------------------------------------------------

                        System.out.println("1)Set schedule");
                        System.out.println("2)Give priveliage to PR");
                        System.out.println("0)Exit");
                        choice = ezMenu.getinput(11);               //CHOICES 2L 7ATEB2A GOWA MENU 2L ADMIN WA MOMKEN KMAN NEDY PERMISSION LEL PR YE3MEL ADD
                        switch (choice) {
                            case 0:
                                ezMenu.Exit = true;
                                System.out.println("0 sha8al");
                                break;
                        }

                    }
                   
                    
                    break;
                case 2:    //NE3MEL REGISTARTION HENAAAA
                    Scanner reads = new Scanner(System.in);
                    System.out.println("New Username: ");
                    String NUsername = reads.next();
                    System.out.println("New Password: ");
                    String NPassword = reads.next();
                    Saving_User_Data x = new Saving_User_Data(); 
                    Boolean taken = false;
                    if (hash.get(NUsername) != null)
                    {
                        System.out.println("Username already taken");
                            taken = true;
                    }
//                    for (User i : UserLib) {
//                        if (i.getUsername() == NUsername) {
//                            System.out.println("Username already taken");
//                            taken = true;
//                        }
//                    }
                    if (taken) {
                        break;
                    }
                    temp = new User();
                    temp.setUsername(NUsername);
                    temp.setPassword(NPassword);
                    //UserLib.add(temp);
                    hash.put(NUsername, temp);
                    x.save();
                    savehash();
                    //x.save();
                    //System.out.println("Username registration successfull");

                    break;

                //---------------------------------------------------------------------------------
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

}
    
    

