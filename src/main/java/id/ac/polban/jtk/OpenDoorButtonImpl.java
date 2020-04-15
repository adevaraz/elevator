package id.ac.polban.jtk;

import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara Veda
 */

public class OpenDoorButtonImpl {
    enum Status {
        PRESSED, RELEASED;
    }
    
    private Status status;
    DoorOperator operator;
    
    /**
     * Constructor
     * @param operator
     * @param cab
     */
    public OpenDoorButtonImpl(DoorOperator operator) {
        this.operator = operator;
    }
    
    void setStatus(Status status) {
        this.status = status;
    }
    
    Status getStatus() {
        return status;
    }
    
    /**
     * penanggung jawab : ALvira PD
     */
    void pressed() {
    	//Open the door
        operator.doorOpened();
    }
    
    /**
     * penanggung jawab: Zara Veda
     */
    void released() throws InterruptedException {
        // TODO: If elevator stopped at floor x and the cab doors opened
        //isAvailable(cabID) ---> get the cabID
        
        if(ElevatorController.getInstance().getCabController().isAvailable(0) &&
                (operator.getDoorStatus() == DoorOperator.DoorStatus.OPENED)){
            
            Status status = Status.RELEASED;
            setStatus(status);
            
            // Start Timer
            DoorTimer timer = new DoorTimer();
            timer.StartTimer();
            TimeUnit.SECONDS.sleep(1);
            timer.StopTimer();
        }
        
        //Close the door
        operator.doorClosed();
    }
}
