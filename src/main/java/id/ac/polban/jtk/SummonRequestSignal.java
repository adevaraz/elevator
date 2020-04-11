/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

/**
 *
 * @author Asus
 */
public class SummonRequestSignal {
     /**
     * 
     */
    interface Response {
        void onComplete();
    }    

    /**
     * 
     */
    private int cabID;

    /**
     * 
     */
    private int floorNumber;

    /**
     * 
     */
    private  Response response;

    public SummonRequestSignal(int cabID, int floorNumber, Response response) {
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
