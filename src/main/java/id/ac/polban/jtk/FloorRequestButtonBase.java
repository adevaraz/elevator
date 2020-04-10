/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

public abstract class FloorRequestButtonBase extends SignalModule {
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
    public FloorRequestButtonBase() {
        status = Status.OFF;
    }
    
    /**
     * 
     */
    protected void turnLightOn() {
        this.status = Status.OFF;
    }

    /**
     * 
     */
    protected void turnLightOff() {
        this.status = Status.OFF;
    }
}