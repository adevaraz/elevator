package id.ac.polban.jtk;

import java.lang.reflect.Proxy;
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
    
    /**
     * contributor: Zara Veda
     */
    void setStatus(Status status) {
        this.status = status;
    }
    
    /**
     * contributor: Alvir
     */
    Status getStatus() {
        return status;
    }
    
    /**
     * contributor: Alvira PD
     */
     void pressed(int cabID) {
    	
    	if (ElevatorController.getInstance().getCabController().isAvailable(cabID) &&
                (ElevatorController.getInstance().getCabController().getDoorOperator(cabID).getDoorStatus()
                    == DoorOperator.DoorStatus.OPENED))	{
    		Status status = Status.PRESSED;
            setStatus(status);
            
          //Open the door
          ElevatorController.getInstance().getCabController().getDoorOperator(cabID).doorOpened();
    	}
    }
    
    /**
     * contributor: Zara Veda
     * 
     * @throws InterruptedException
     */
    void released(int cabID) throws InterruptedException {
        
        if(ElevatorController.getInstance().getCabController().isAvailable(cabID) &&
                (ElevatorController.getInstance().getCabController().getDoorOperator(cabID).getDoorStatus()
                    == DoorOperator.DoorStatus.OPENED)){
            
            Status status = Status.RELEASED;
            setStatus(status);
            
            // Start Timer
            DoorTimer timer = new DoorTimer();
            timer.StartTimer();
            Thread.sleep(1);
            timer.StopTimer();
        }
        
        //Close the door
        ElevatorController.getInstance().getCabController().getDoorOperator(cabID).doorClosed();
    }
    
    public static OpenDoorButton createInstance() {
        return (OpenDoorButton)Proxy.newProxyInstance(OpenDoorButton.class.getClassLoader(),
                                                          new Class[] {OpenDoorButton.class},
                                                          new SignalModule(new OpenDoorButtonImpl()));
    }
}
