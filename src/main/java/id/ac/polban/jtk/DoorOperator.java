package id.ac.polban.jtk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara Veda
 */
enum DoorStatus {
    OPEN, CLOSE;
}
public class DoorOperator {
    
    OpenDoorButtonImpl openDoorButton = new OpenDoorButtonImpl(this);
    DoorStatus doorStatus;
    
    void setDoorStatus(DoorStatus status) {
        this.doorStatus = status;
    }
    
    DoorStatus getDoorStatus() {
        return doorStatus;
    }
    DoorOperator operator = new DoorOperator();
    SummonRequestButton summonButton = new SummonRequestButton();
    DoorTimer timer = new DoorTimer();
    
    enum Status {
        OPENED, CLOSED;
    }
    
    private Status status;
    
    void startOperation() {
        operator.doorOpened();
        operator.doorClosed();

    }
    
    void doorOpened() {
        this.status = Status.OPENED;
    }
    
    void doorClosed() {
        this.status = Status.OPENED;
    }
    
    void suspend() {
        timer.StopTimer();
    }
    
    void resume() {
        timer.StartTimer();
    }
    
    void suspendFromLoad() {
        timer.StopTimer();
    }
    
    void resumeFromLoad() {
        timer.StartTimer();
    }
    
    void openDoorButtonPressed(int cabID) {
    	ElevatorController
    	.getInstance()
    	.getCabController()
    	.getDoorOperator(cabID)
        .openDoorButton.pressed();
    }
    
    void summonButtonPressed(int floorNumber, boolean direction) {
        timer.StartTimer();     
    }    
}
