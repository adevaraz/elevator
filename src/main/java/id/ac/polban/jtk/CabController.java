/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

class CabController {
    private final CabNavigator[] cabNavigators;
    
    private final DoorOperator[] doorOperators;

    private final FloorRequestButton[][] floorRequestButtons;

    private boolean[] isAvailable;

    CabController (final FloorRequestButton[][] floorRequestButtons,
                   final ElevatorEngine elevatorEngine,
                   final DirectionDisplay directionDisplay,
                   final FloorNumberDisplay floorNumberDisplay) {
        this.cabNavigators = new CabNavigator[floorRequestButtons.length];

        this.doorOperators = new DoorOperator[floorRequestButtons.length];

        this.floorRequestButtons = floorRequestButtons;

        this.isAvailable = new boolean[floorRequestButtons.length];

        for (int i = 0; i < floorRequestButtons.length; ++i) {
            this.cabNavigators[i] = new CabNavigator(elevatorEngine,
                                                     directionDisplay,
                                                     floorNumberDisplay);

            this.doorOperators[i] = new DoorOperator();

            this.isAvailable[i] = true;
        }
    }
    
    public CabNavigator getCabNavigator(int cabID) {
        return this.cabNavigators[cabID];
    }

    /**
     * penanggung jawab : ALvira PD
     */
    public synchronized DoorOperator getDoorOperator(int cabID) {
    	return doorOperators[cabID];
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
        public void onFloorChanged(CabNavigatorResponse cabNavigator, int floorNumber);
    }

    public void processRequest(final int cabID, final int floorNumber, ProcessRequestCallback processRequestCallback) {
        synchronized (this) {
            if (!this.isAvailable(cabID)) {
                return;
            }
    
            new Thread(() -> {
                this.setAvailable(cabID, false);

                this.getCabNavigator(cabID)
                    .moveTo(floorNumber, new CabNavigator.MoveToCallback() {
                        @Override
                        public void onFloorChanged(CabNavigatorResponse response, int changedTo) {
                            processRequestCallback.onFloorChanged(CabController.this.getCabNavigator(cabID), changedTo);
                        }

                        @Override
                        public void onFinished() {
                            CabController.this.setAvailable(cabID, true);
                        }
                    });
            }).start();
        }
    }
}