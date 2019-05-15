/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Mostafa
 */
public class Hotel extends Accommodation implements Requests{
     int star;
    
    /*Constructor*/

    public Hotel(int star, String place_ID, int stars, int capacity, String description, boolean booked) {
        super();
        this.star = 0;
        this.type = "HOTEL";
    }

       


    @Override  public void add(String id, int star, String description, String location, boolean state)
    {
        this.place_ID = id;
        this.star = star;
        this.description = description;
        this.booked = state;
        this.location = location;
        this.type = "HOTEL";
          
    }
     @Override  public void delete()
  {
        this.place_ID = null;
        this.description = null;
        this.location = null;
        this.booked = false;
        this.star = -1;
        this.type = null;
  }
   @Override public void reserve()
  {
      if(place_ID != null)
      {
      this.booked = true;
      }
  }
 
 
  }