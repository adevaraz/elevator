package id.ac.polban.jtk;

class CabController {
    /**
     *
     */
    private final ElevatorController elevatorController;

    Cab[] cabs;
    Thread[] cabProcess;
    RequestProcessor[] cabRequest;

    public CabController (ElevatorController elevatorController) {
        this.elevatorController = elevatorController;

        this.cabs = new Cab[2];

        this.cabs[0] = new Cab();
        this.cabs[1] = new Cab();

        this.cabProcess = new Thread[2];
        this.cabRequest = new RequestProcessor[2];
    }


    void ProcessRequest(final int cabID, final int floorNumber) {
        cabProcess[cabID] = new Thread(this.cabRequest[cabID]);
        cabProcess[cabID].start();
    }

    class RequestProcessor implements Runnable {
        int cabID;
        int floorNumber; 

        public RequestProcessor (final int cabID, final int floorNumber) {
            this.cabID = cabID;
            this.floorNumber = floorNumber;
        }

        @Override
        public void run() {
//            cabs[cabID].cabNavigator.MoveToFloor(this.floorNumber);
        }
    }
}