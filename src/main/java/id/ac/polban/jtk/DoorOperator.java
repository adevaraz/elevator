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

enum DoorState {
    OPEN, CLOSE;
}

public class DoorOperator {
    OpenDoorButton button = new OpenDoorButton();
    
    void startOperation() {
        
    }
    
    /**
     * penanggung jawab: Nadhilah 
     */
    void doorOpened(int cabID) {
        
    }
    
    /**
     * penanggung jawab: Nadhilah 
     */
    void doorClosed(int cabID) {
        //set status doornya jadi tutup
    }
    
    void suspend() {
        
    }
    
    void resume() {
        
    }
    
    void suspendFromLoad() {
        
    }
    
    void resumeFromLoad() {
        
    }
    
    void openDoorButtonPressed(int cabId) {
        button.pressed();
    }
    
    void summonButtonPressed(int floorNumber, boolean direction) {
        //direction : true means up, false means down
    }
}
