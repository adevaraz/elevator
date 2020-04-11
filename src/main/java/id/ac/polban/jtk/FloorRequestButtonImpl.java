/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

public class FloorRequestButtonImpl implements FloorRequestButton {
    /**
     * 
     */
    public enum Status {
        ON,
        OFF
    }

    /**
     * 
     */
    private Status status;

    /**
     * 
     */
    public FloorRequestButtonImpl() {
        this.status = Status.OFF;
    }
    
    /**
     * 
     */
    public void turnLightOn() {
        this.status = Status.ON;
    }

    /**
     * 
     */
    public void turnLightOff() {
        this.status = Status.OFF;
    }
}