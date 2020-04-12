/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

/**
 *
 * @author Andhika
 * @author RomaUlina
 */
public class SummonRequestButton {
      enum LightStatus {
          ON,OF;
    }
      
     private LightStatus statuslight;
       public void turnLightOn() {
        this.statuslight = LightStatus.ON;
    }
    /**
     * 
     */
    public void turnLightOff() {
        this.statuslight = LightStatus.ON;.OFF;
    }
      
      
    static void Pressed(enum direction, int floorNumber) {
        // ElevatorController.getInstance().getSummonRequestLogger().sendSignal(cabID, floorNumber, new ISignalResponse(){
        //     @Override
        //     public void onComplete() {
        //         // TODO Auto-generated method stub
        //     }
        // } );
        // released(direction,floorNumber);
    }
    
    static void Released(enum direction, int floorNumber) {
                    //CabNavigator
        //if(true a cab was already stopped at the floor that the summon button was 
        //released from AND the doors of the cab are open [floorNumber==floor that cab Is On]){
            //TurnLightOff()
            //start timer in Door Timer 3 second;
            //DoorOpeningDevice.CloseDoors()
        //}
        // ElevatorController.getInstance().getSummonRequestLogger().sendSignal(cabID, floorNumber, new ISignalResponse(){
        //     @Override
        //     public void onComplete() {
        //         // TODO Auto-generated method stub
        //     }
        // } );
    }
}