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
public class Transportation implements Requests{
    public String trans_ID;
    String type;
    enum type
    {
        BUS,
        PLANE, 
        TAXI,
        RENTAL;
    }
    String loc;
    int capacity;
    boolean status;
   
    
    
    /*Constructor*/

    public Transportation() {
        this.trans_ID = "";
        this.type = "";
        this.capacity = -1;
        this.status = false;
    }
    
    
    
    
    /*Setters & Getters*/
    public String getTrans_ID() {
        return trans_ID;
    }

    public void setTrans_ID(String trans_ID) {
        this.trans_ID = trans_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    /*Methods*/

  @Override public void add(String id, int Capacity, String type, String loc , boolean state)
  {
      setTrans_ID(id);
      setType(type);
      setCapacity(Capacity);
      setStatus(state);
  }
   @Override public void delete()
  {
      setTrans_ID(null);
      setType(null);
      setCapacity(-1);
      setStatus(false);
  }
    @Override public void reserve()
  {
       if(trans_ID != null)
      {
      this.status = true;
      }
  }
    @Override public void modify(String id, int x1, String x2, String x3, boolean state)
  {
      setTrans_ID(id);
      setType(x2);
      setCapacity(x1);
      setStatus(state);
  }
}