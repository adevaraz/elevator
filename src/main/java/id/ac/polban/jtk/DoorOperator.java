package id.ac.polban.jtk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara Veda
 */
public class DoorOperator {
    OpenDoorButton openDoorButton = new OpenDoorButton(this);
    
    void startOperation() {
        
    }
    
    void doorOpened() {
        
    }
    
    void doorClosed() {
        
    }
    
    void suspend() {
        
    }
    
    void resume() {
        
    }
    
    void suspendFromLoad() {
        
    }
    
    void resumeFromLoad() {
        
    }
    
    void openDoorButtonPressed(int cabID) {
        openDoorButton.pressed();
    }
    
    void summonButtonPressed(int floorNumber, boolean direction) {
        
    }
}
