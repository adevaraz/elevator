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
      
    }