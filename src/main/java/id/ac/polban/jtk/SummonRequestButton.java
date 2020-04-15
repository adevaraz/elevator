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
    ElevatorEngine.Direction direction;  
    private DoorOperator doorOperator;
    private LightStatus statuslight;

    LightStatus DirectionUp, DirectionDown;
    Cab cab;
    
       public void turnLightOn() {
        this.statuslight = LightStatus.ON;
    }
    
    void TurnLightOff(Direction direction){
        if(direction.getValue() == Direction.UP.getValue()){
            DirectionUp = LightStatus.OFF;
            System.out.println("The summon button light is " + DirectionUp);
        }else if(direction.getValue() == Direction.UP.getValue()){
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

    void Released(int floorNumber, Direction direction){
        int floorNumberCab = cab.getCabNavigator().getFloorNumber();
        if(floorNumber==floorNumberCab && doorOperator.getDoorStatus()==doorOperator.doorStatus.OPENED){
            TurnLightOff(direction);
            DoorTimer doorTimer = new DoorTimer();
            doorTimer.StartTimer();
            doorOperator.doorClosed();
        }
    }
}
