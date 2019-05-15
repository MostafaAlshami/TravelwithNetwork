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
public class Accommodation implements Requests{
    public String place_ID;
    String description;
    String location;
    boolean booked;
    String type;
enum type
    {
        HOTEl,
        RESORT,
        CAMP;
    }
    int star;
    
    /*Constructor*/

    public Accommodation() {
        this.place_ID = null;
        this.star = -1;
        this.description = null;
        this.location = null;
        this.booked = false;
        this.type = null;
    }

    
    
    /*Getters and Setters*/
    public String getPlace_ID() {
        return place_ID;
    }

    public void setPlace_ID(String place_ID) {
        this.place_ID = place_ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
   @Override  public void add(String id, int star, String type, String location, boolean state)
    {
        this.place_ID = id;
        this.star = star;
        this.type = type;
        this.booked = state;
        this.location = location;
          
    }
     @Override  public void delete()
  {
        this.place_ID = null;
        this.description = null;
        this.location = null;
        this.booked = false;
        this.type = null;
  }
   @Override public void reserve()
  {
      if(place_ID != null)
      {
      this.booked = true;
      }
  } 
   @Override public void modify(String id, int x1, String x2, String x3, boolean state)
  {
      setPlace_ID(id);
      setType(x2);
      setLocation(x3);
      setBooked(state);
  }
}