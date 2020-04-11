/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

class CabController {
    /**
     * 
     */
    static private final int FLOOR_COUNT = 6;

    /**
     * 
     */
    static private final int CAB_COUNT = 2;

    /**
     *
     */
    private final ElevatorController elevatorController;

    /**
     * 
     */
    private final Cab[] cabs;
    
    RequestProcessor[] cabsRequest;
    Thread[] cabsThread;

    public CabController (ElevatorController elevatorController) {
        this.elevatorController = elevatorController;

        this.cabs = new Cab[CAB_COUNT];

        for (int i = 0; i < CAB_COUNT; ++i) {
            this.cabs[i] = new Cab(FLOOR_COUNT);
        }

        this.cabsRequest = new RequestProcessor[2];
        this.cabsThread  = new Thread[2];
    }

    /**
     * @return the cabs
     */
    public Cab getCab(int cabID) {
        return cabs[cabID];
    }

    public void processRequest(final int cabID, final int floorNumber) {
        cabsRequest[cabID] = new RequestProcessor(cabID, floorNumber);
        
        this.cabsThread[cabID] = new Thread(cabsRequest[cabID]);

        this.cabsThread[cabID].start();
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
            cabs[cabID]
                .getCabNavigator()
                .moveTo(floorNumber);

            // reset the request
            cabsRequest[this.cabID] = null;
        }
    }
}