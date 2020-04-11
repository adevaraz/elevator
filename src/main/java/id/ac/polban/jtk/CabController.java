/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

class CabController {
    /**
     * 
     */
    static public final int FLOOR_COUNT = 6;

    /**
     * 
     */
    static public final int CAB_COUNT = 2;

    /**
     *
     */
    private final ElevatorController elevatorController;

    /**
     * 
     */
    private final CabNavigator[] cabNavigators;
    
    /**
     * 
     */
    private final DoorOperator[2] doorOperator;

    /**
     * 
     */
    private final DoorOperator[] doorOperators;
    
    /**
     * 
     */
    private final FloorRequestButton[][] floorRequestButtons;

    /**
     * 
     */
    private boolean[] isAvailable;

    public CabController (ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
  
        this.cabNavigators = new CabNavigator[CAB_COUNT];
        
        this.doorOperators = new DoorOperator[CAB_COUNT];

        this.floorRequestButtons = new FloorRequestButton[CAB_COUNT][FLOOR_COUNT];

        this.isAvailable = new boolean[CAB_COUNT];

        for (int i = 0; i < CAB_COUNT; ++i) {
            this.cabNavigators[i] = new CabNavigator(new ElevatorEngine());

            this.isAvailable[i] = true;

            for (int j = 0; j < FLOOR_COUNT; ++j) {
                this.floorRequestButtons[i][j] = (FloorRequestButton)Proxy.newProxyInstance(FloorRequestButton.class.getClassLoader(), new Class[] {FloorRequestButton.class}, new SignalModule(new FloorRequestButtonImpl()));
            }
        }
    }
    
    /**
     * penanggung jawab : ALvira PD
     */
    public synchronized DoorOperator getDoorOperator(int cabID) {
    	return doorOperators[cabID];
    }

    public synchronized CabNavigator getCabNavigator(int cabID) {
        return this.cabNavigators[cabID];
    }

    public synchronized FloorRequestButton getFloorRequestButton(int cabID, int floorNumber) {
        return this.floorRequestButtons[cabID][floorNumber];
    }

    public synchronized void processRequest(final int cabID, final int floorNumber) {
        this.isAvailable[cabID] = false;

        this.getCabNavigator(cabID).moveTo(floorNumber);

        this.isAvailable[cabID] = true;
    }

    public synchronized boolean isAvailable(final int cabID) {
        return this.isAvailable[cabID];
    }
    
    public DoorOperator getDoorOperator(int cabID) {
        return doorOperator[cabID];
    }
 }
