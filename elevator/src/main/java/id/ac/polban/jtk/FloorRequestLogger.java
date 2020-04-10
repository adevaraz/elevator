package id.ac.polban.jtk;

import java.util.concurrent.LinkedBlockingQueue;

class FloorRequestLogger implements Runnable {
    /**
     *
     */
    private final ElevatorController elevatorController;

    /**
     * 
     */
    private final LinkedBlockingQueue<FloorRequestSignal> signals;

    /**
     * @param elevatorController
     */
    FloorRequestLogger(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;

        this.signals = new LinkedBlockingQueue<FloorRequestSignal>();
    }

    /**
     * 
     */
    public void sendSignal(int cabID, int floorNumber, FloorRequestSignal.Response response) {
        signals.add(new FloorRequestSignal(cabID, floorNumber, response));
    }

    @Override
    public void run() {
        try {
            while (true) {
                // get signal from queue
                FloorRequestSignal signal = this.signals.take();

                // process the signal
                signal.process();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public class FloorRequest extends ElevatorController.Request {
        int cabID;
        int floorNumber;
    
        public FloorRequest (int cabID, int floorNumber) {
            super();
        }
    }
}