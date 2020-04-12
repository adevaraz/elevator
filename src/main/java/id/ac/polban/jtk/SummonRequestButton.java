/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

/**
 *
<<<<<<< HEAD
 * @author RomaUlina
=======
 * @author Andhika
>>>>>>> author
 */
public class SummonRequestButton {
<<<<<<< HEAD
    boolean status = true; //true = pressed/turnlight summon button & false = released/turnoff summon button
 
    void TurnLightOff(){
=======
      void turnLightOn() {

    }

    void turnLightOff() {
        
    }

    static void Pressed(boolean direction, int floorNumber) {
        // ElevatorController.getInstance().getFloorRequestLogger().sendSignal(cabID, floorNumber, new ISignalResponse(){
        //     @Override
        //     public void onComplete() {
        //         // TODO Auto-generated method stub
        //     }
        // } );
        // released(direction,floorNumber);
>>>>>>> update
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
