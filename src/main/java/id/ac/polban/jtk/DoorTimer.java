package id.ac.polban.jtk;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author RomaUlina
 */
public class DoorTimer extends TimerTask {
    private int i;
    Timer timer;
    
    /**
     * contributor: Roma Ulina P
     */
    void StartTimer(){
        timer = new Timer();
        long delay = 1000; //milisecond
        long period = 3000;

        System.out.println("[start timer.");
        timer.schedule(this, delay, period);
    }
    
    /**
     * contributor: Zara Veda
     */
    void StopTimer(){
        timer.cancel();
        timer.purge();
    }
    
    void reset(){
        
    }
    
    //void notify(){}
    
    @Override
    public void run() { 
        System.out.println("Timer: " + ++i);
    }
}
