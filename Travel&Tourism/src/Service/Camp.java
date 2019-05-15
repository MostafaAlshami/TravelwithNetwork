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
public class Camp extends Accommodation implements Requests{
     int no_of_nights;
    
    /*Constructor*/

    public Camp(int star, String place_ID, int stars, int capacity, String description, boolean booked) {
        super();
        this.no_of_nights = 0;
        this.type = "CAMP";
    }

       


    @Override  public void add(String id, int nights, String description, String location, boolean state)
    {
        this.place_ID = id;
        this.no_of_nights = nights;
        this.description = description;
        this.booked = state;
        this.location = location;
        this.type = "CAMP";
          
    }
     @Override  public void delete()
  {
        this.place_ID = null;
        this.description = null;
        this.location = null;
        this.booked = false;
        this.no_of_nights = -1;
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

