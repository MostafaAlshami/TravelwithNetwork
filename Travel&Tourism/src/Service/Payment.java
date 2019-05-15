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
public class Payment {
   
private int userchoice;
private int []binnumber;
private int [] card;
private boolean cash;



public void prices(int []cost){
 
    //method to show prices list 



}

    public int[] getBinnumber() {
        return binnumber;
    }

    public void setBinnumber(int[] binnumber) {
        if(binnumber.length>=1&&binnumber.length<=3){
        this.binnumber = binnumber;
        System.out.println("true");}
        else
            System.out.println("wrong "
                    + "try again ");
        setBinnumber(binnumber);
    }

    public int getUserchoice() {
        return userchoice;
    }

    public void setUserchoice(int userchoice) {
        this.userchoice = userchoice;
    }

    public int[] getCard() {
        return card;
    }

    public void setCard(int[] card) {
        if(card.length>=1 && card.length>=10){
        this.card = card;
            System.out.println("true");
        }else
            System.out.println("wrong  "
                    + "try again");
        setCard(card);

    }

}
