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

import java.util.Timer;
import java.util.TimerTask;
        
public class OpenDoorButton {
    boolean status; //pressed = true, released = false
    
    void setStatus(boolean status) {
        status = this.status;
    }
    
    boolean getStatus() {
        return status;
    }
    
    void pressed() {
        setStatus(true);
    }
    
    void released() {
        setStatus(false);
        
        //Timer for hold opened door
        Timer timer = new Timer();
        TimerTask task = new DoorHolder();
        long delay = 1000; //milisecond
        long period = 10000;
        timer.schedule(task, delay, period);
        
        //Close the door
    }
}
