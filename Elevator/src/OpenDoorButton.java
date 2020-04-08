/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara Veda
 */
public class OpenDoorButton {
    boolean status; //pressed = true, released = false
    
    void setStatus(boolean status) {
        status = this.status;
    }
    
    boolean getStatus() {
        return status;
    }
    
    void pressed() {
        setStatus(true);
    }
    
    void released() {
        setStatus(false);
    }
}
