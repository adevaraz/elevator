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
 class SummonRequestLogger  {
 
    private final ElevatorController elevatorController;

    SummonRequestLogger(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }
     void Pressed(int floorNumber,ElevatorEngine.Direction direction) {
      // TODO: If door closed and elevator stopped at floor x
        if (false) {
            // TODO: Open the door
            return;
        }
        // Add request to queue
        elevatorController
            .getRequestQueue()
            .add(new SummonRequest(cabID,direction, floorNumber));

        // Turn the button light on
        elevatorController
           .getCabController()
            .getSummonRequestButton(cabID,direction, floorNumber)
           .turnLightOn();
    }
     
     public static SummonRequestLogger createInstance(ElevatorController elevatorController) {
        return (SummonRequestLogger) Proxy.newProxyInstance(SummonRequestLogger.class.getClassLoader(),
                                                           new Class[] {SummonRequestLogger.class},
                                                           new SignalModule(new SummonRequestLoggerImpl(elevatorController)));
    void Released(int floorNumber, ElevatorEngine.Direction direction){
        int floorNumberCab = cab.getCabNavigator().getFloorNumber();
        if(floorNumber==floorNumberCab /*&& the door cab is open*/){
            TurnLightOff(direction);
            DoorTimer doorTimer = new DoorTimer();
            doorTimer.StartTimer();
            //DoorOpeningDevice.CloseDoors()
            }
        }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    }

        public static class SummonRequest extends Request {
        /**
         * 
         */
        private int cabID;
        
        private enum direction;

        /**
         * 
         */
        private int floorNumber;

        public SummonRequest(int cabID,enum direction, int floorNumber) {
            super();
       
            this.cabID = cabID;
            this.direction=direction;
            this.floorNumber = floorNumber;
        }

        @Override
        public int getCabID() {
            return this.cabID;
        }

        @Override
        public int getFloorNumber() {
            return this.floorNumber;
        }
        
        @Override
        public int getDirection() {
            return this.direction;
        }
        
    }
}
