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
    private final LinkedBlockingQueue<Signal> signals;

    /**
     * @param elevatorController
     */
    FloorRequestLogger(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;

        this.signals = new LinkedBlockingQueue<Signal>();
    }

    public void sendSignal(int cabID, int floorNumber, ISignalResponse response) {
        signals.add(new Signal(cabID, floorNumber, response));
    }

    @Override
    public void run() {
        try {
            while (true) {
                // get signal from queue
                Signal signal = this.signals.take();

                // process the signal
                signal.process();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    interface ISignalResponse {
        void onComplete();
    }    

    protected class Signal {
        /**
         * 
         */
        private final int cabID;

        /**
         * 
         */
        private final int floorNumber;

        /**
         * 
         */
        private final ISignalResponse response;

        protected Signal(int cabID, int floorNumber, ISignalResponse response) {
            this.cabID = cabID;
            
            this.floorNumber = floorNumber;

            this.response = response;
        }

        protected void process () {
            // if (this.elevatorController.cabController.cabs[cabID].cabNavigator.floorNumber == floorNumber) {
            //     // Send a signal to the cab’s door opening device to
            //     // open the doors 
            // }
            // else {
            //     this.elevatorController.cabController.cabs[cabID].floorRequestButton[floorNumber].turnLightOn();
            //     requests.add(this.elevatorController.new FloorRequest(cabID, floorNumber));
    
            //     // Add floor request to queue
            //     requests.drainTo(this.elevatorController.queue);
            // }
    
            response.onComplete();
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