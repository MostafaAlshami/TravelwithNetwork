/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import java.io.Serializable;
import static travel.tourism.TravelTourism.hash;

/**
 *
 * @author Mostafa
 */
public class User implements Serializable {
    
    
    
    protected String username;
    protected String password;
    protected Boolean priveliage;
    //protected String nationality;
    protected int ID;
    
    private static int count = 2 ;

    public User ()
    {
        
        priveliage=false;
        this.ID=count;
        count++;
    }
    
   public void givePriv()
   {    
    priveliage=true;
   }
    
   public Boolean getPriv()
   {    
       return priveliage;
   }

    /*public String getNationality() {
        return nationality;
    }
    public boolean setNationality(String nationality) {
        if (username.length()>1 && username.length()<100)
        {
        this.nationality = nationality;
        return true;
        }
        else
        {
        return false;
        }
        
    }*/
   
   public String getUsername() {
        return username;
    }

    public boolean setUsername(String username)
    {
        if (username.length()>1 && username.length()<100)
        {
        this.username = username;
        return true;
        }
        else
        {
        return false;
        }
    }
    public String getPassword()
    {
        return password;
    }

    public boolean setPassword(String password)
    {
        if (password.length()>1 && password.length()<100)
        {
        this.password = password;
        return true;
        }
        else
        {
        return false;
        }
    }
    
    
        public boolean Login(String username,String password){
//        
//        for(String x: hash.keySet()){
//            if(username.equals(x)&&password.equals(hash.get(x)))
//            return true;
//            
//        }
        
        
if (hash.get(username).password.equals(password))
        {
            return true;
        }
        return false;
        
        
    }

    public void givePower() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
    