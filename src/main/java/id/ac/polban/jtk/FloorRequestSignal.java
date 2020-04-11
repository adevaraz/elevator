package id.ac.polban.jtk;

public class FloorRequestSignal {
    /**
 *
 */
    interface Response {
        void onComplete();
    }    

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
    private final Response response;

    public FloorRequestSignal(int cabID, int floorNumber, Response response) {
        this.cabID = cabID;
        
        this.floorNumber = floorNumber;

        this.response = response;
    }

    public void process () {
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