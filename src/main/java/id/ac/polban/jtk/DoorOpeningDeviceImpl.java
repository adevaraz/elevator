/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NAD
 */



public class DoorOpeningDeviceImpl implements DoorOpeningDevice {
    DoorOperator operator;
    
    public DoorOpeningDeviceImpl(DoorOperator operator) {
        this.operator = operator;
    }
    
    @Override
    public void openDoors() {
        try {        
            Thread.sleep(1);
            operator.doorOpened();
                    } catch (InterruptedException ex) {
            Logger.getLogger(DoorOpeningDeviceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void closeDoors() {
        try {
            Thread.sleep(1);
            operator.doorClosed();
                } catch (InterruptedException ex) {
            Logger.getLogger(DoorOpeningDeviceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
