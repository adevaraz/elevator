/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

/**
 *
 * @author Andhika
 */
public class SummonRequestSignal {

    SummonRequestSignal(int cabID, int floorNumber, FloorRequestSignal.Response response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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
    private final boolean direction;

    /**
     * 
     */
    private final int floorNumber;

    /**
     * 
     */
    private  Response response;

    public SummonRequestSignal(int cabID,boolean direction, int floorNumber, Response response) {
        this.cabID = cabID;
        
        this.direction= direction;       
        this.floorNumber = floorNumber;

        this.response = response;
    }

    public void process () {
        // if (this.elevatorController.cabController.cabs[cabID].cabNavigator.floorNumber == floorNumber) {
        //     // Send a signal to the cab’s door opening device to
        //     // open the doors
        // }
        // else {
        //     this.elevatorController.cabController.cabs[cabID].summonRequestButton[floorNumber].turnLightOn();
         //    requests.add(this.elevatorController.new SummonRequest(direction, floorNumber));

        //     // Add summon request to queue
        //     requests.drainTo(this.elevatorController.queue);
        // }

        response.onComplete();
    }
    
}
