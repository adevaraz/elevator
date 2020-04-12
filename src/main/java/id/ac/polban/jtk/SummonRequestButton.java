/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;
import id.ac.polban.jtk.ElevatorEngine.Direction;
/**
 *
 * @author Andhika
 * @author RomaUlina
 */
enum LightStatus {
    OFF, ON;
}
public class SummonRequestButton {
      
    private LightStatus statuslight;
    boolean status; //true = pressed/turnlight summon button & false = released/turnoff summon button
    LightStatus DirectionUp, DirectionDown;
    Cab cab;
    
       public void turnLightOn() {
        this.statuslight = LightStatus.ON;
    }
    /**
     * 
     */
    public void turnLightOff() {
        this.statuslight = LightStatus.ON;
    }
    
    
    void TurnLightOff(ElevatorEngine.Direction direction){
        if(direction == ElevatorEngine.Direction.UP){
            DirectionUp = LightStatus.OFF;
            System.out.println("The summon button light is " + DirectionUp);
        }else if(direction == ElevatorEngine.Direction.DOWN){
            DirectionDown = LightStatus.OFF;
            System.out.println("The summon button light is " + DirectionDown);
        }
    }
    
    //static void Pressed(enum direction, int floorNumber) {
        // ElevatorController.getInstance().getSummonRequestLogger().sendSignal(cabID, floorNumber, new ISignalResponse(){
        //     @Override
        //     public void onComplete() {
        //         // TODO Auto-generated method stub
        //     }
        // } );
        // released(direction,floorNumber);
    //}

    void Released(int floorNumber, ElevatorEngine.Direction direction){
        int floorNumberCab = cab.getCabNavigator().getFloorNumber();
        if(floorNumber==floorNumberCab /*&& the door cab is open*/){
            TurnLightOff(direction);
            DoorTimer doorTimer = new DoorTimer();
            doorTimer.StartTimer();
            //DoorOpeningDevice.CloseDoors()
        }
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
