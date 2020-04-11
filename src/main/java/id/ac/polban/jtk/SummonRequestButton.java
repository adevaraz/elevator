/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

/**
 *
 * @author RomaUlina
 */
public class SummonRequestButton {
    boolean status = true; //true = pressed/turnlight summon button & false = released/turnoff summon button
 
    void TurnLightOff(){
    }
    
    void Released( int floorNumber, boolean direction){
        //CabNavigator
        if(true/*a cab was already stopped at the floor that the summon button was 
        released from AND the doors of the cab are open [floorNumber==floor that cab Is On]*/){
            //TurnLightOff()
            //start timer in Door Timer 3 second;
            //DoorOpeningDevice.CloseDoors()
        }
    }
}
