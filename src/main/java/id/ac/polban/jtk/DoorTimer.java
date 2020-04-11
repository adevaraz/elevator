/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.polban.jtk;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author RomaUlina
 */
public class DoorTimer {
    
    void StartTimer(){
        Timer timer = new Timer();
        TimerTask task = new DoorHolder();
        long delay = 1000; //milisecond
        long period = 10000;
        timer.schedule(task, delay, period);
    }
    void StopTimer(){
        
    }
    void reset(){
        
    }
    
    //void notify(){}
}
