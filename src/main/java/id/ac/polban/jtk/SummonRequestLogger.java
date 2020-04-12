/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;
import java.util.concurrent.LinkedBlockingQueue;
/**
 *
 * @author Andhika
 */
 class SummonRequestLogger implements Runnable {
    private int floorNumber;
    private boolean direction;
    
    private final ElevatorController elevatorController;
    
    private final LinkedBlockingQueue<SummonRequestSignal> signals;

    SummonRequestLogger(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;

        this.signals = new LinkedBlockingQueue<SummonRequestSignal>();
    }
    
       public void sendSignal(int cabID, int floorNumber, SummonRequestSignal.Response response) {
        signals.add(new SummonRequestSignal(cabID,direction, floorNumber, response));
    }
    
    @Override
    public void run() {
          try {
            while (true) {
                // get signal from queue
                SummonRequestSignal signal = this.signals.take();

                // process the signal
                signal.process();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }
        public class SummonRequest extends ElevatorController.Request {
        int cabID;
        int floorNumber;
    
        public SummonRequest (int cabID,boolean direction, int floorNumber) {
            super();
        }
    }
    
    
}
