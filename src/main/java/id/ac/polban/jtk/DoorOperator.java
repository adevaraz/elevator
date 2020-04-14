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
enum DoorStatus {
    OPEN, CLOSE;
}
public class DoorOperator {
    OpenDoorButton openDoorButton = new OpenDoorButton(this);
    DoorStatus doorStatus;
    
    void setDoorStatus(DoorStatus status) {
        this.doorStatus = status;
    }
    
    DoorStatus getDoorStatus() {
        return doorStatus;
    }
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
