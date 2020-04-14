/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

class CabController {
    static public final int FLOOR_COUNT = 6;

    static public final int CAB_COUNT = 2;

    private final CabNavigator[] cabNavigators;
    
    private final DoorOperator[] doorOperators;

    private final FloorRequestButton[][] floorRequestButtons;

    private boolean[] isAvailable;

    public CabController () {
        this.cabNavigators = new CabNavigator[CAB_COUNT];

        this.doorOperators = new DoorOperator[CAB_COUNT];

        this.floorRequestButtons = new FloorRequestButton[CAB_COUNT][FLOOR_COUNT];

        this.isAvailable = new boolean[CAB_COUNT];

        for (int i = 0; i < CAB_COUNT; ++i) {
            this.cabNavigators[i] = new CabNavigator(new ElevatorEngine(), DirectionDisplayImpl.createInstance(), FloorNumberDisplayImpl.createInstance());

            this.isAvailable[i] = true;

            for (int j = 0; j < FLOOR_COUNT; ++j) {
                this.floorRequestButtons[i][j] = FloorRequestButtonImpl.createInstance();
            }
        }
    }
    
    /**
     * penanggung jawab : ALvira PD
     */
    public synchronized DoorOperator getDoorOperator(int cabID) {
    	return doorOperators[cabID];
    }

    public CabNavigator getCabNavigator(int cabID) {
        return this.cabNavigators[cabID];
    }

    public FloorRequestButton getFloorRequestButton(int cabID, int floorNumber) {
        return this.floorRequestButtons[cabID][floorNumber];
    }

    private void setAvailable(final int cabID, boolean isAvailable) {
        synchronized (this) {
            this.isAvailable[cabID] = isAvailable;
        }
    }

    public boolean isAvailable(final int cabID) {
        synchronized (this) {
            return this.isAvailable[cabID];
        }
    }

    public interface ProcessRequestCallback {
        public void onFloorChanged(CabNavigator cabNavigator, int floorNumber);
    }

    public void processRequest(final int cabID, final int floorNumber, ProcessRequestCallback processRequestCallback) {
        setAvailable(cabID, false);

        this.getCabNavigator(cabID)
            .moveTo(floorNumber, new CabNavigator.MoveToCallback() {
                @Override
                public void onFloorChanged(int changedTo) {
                    processRequestCallback.onFloorChanged(CabController.this.getCabNavigator(cabID), changedTo);
                }
            });

        setAvailable(cabID, true);
    }
}