/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

class CabController {
    private final int cabCount;

    private final CabNavigator[] cabNavigators;
    
    private final DoorOperator[] doorOperators;

    private final FloorRequestButton[][] floorRequestButtons;

    private boolean[] isAvailable;

    /**
     * contributor: Raefaldhi Amartya J
     */
    CabController (final FloorRequestButton[][] floorRequestButtons,
                   final ElevatorEngine[] elevatorEngines,
                   final DirectionDisplay[] directionDisplays,
                   final FloorNumberDisplay[] floorNumberDisplays,
                   final DoorOpeningDevice[] doorOpeningDevices,
                   final OpenDoorButton[] openDoorButtons) {
        this.cabCount = elevatorEngines.length;

        this.cabNavigators = new CabNavigator[this.getCabCount()];

        this.doorOperators = new DoorOperator[this.getCabCount()];

        this.floorRequestButtons = floorRequestButtons;

        this.isAvailable = new boolean[this.getCabCount()];

        for (int i = 0; i < this.getCabCount(); ++i) {
            this.cabNavigators[i] = new CabNavigator(elevatorEngines[i],
                                                     directionDisplays[i],
                                                     floorNumberDisplays[i]);

            this.doorOperators[i] = new DoorOperator(doorOpeningDevices[i], openDoorButtons[i]);

            this.isAvailable[i] = true;
        }
    }
    
    /**
     * contributor: Raefaldhi Amartya J
     */
    public int getCabCount() {
        return this.cabCount;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public CabNavigator getCabNavigator(int cabID) {
        return this.cabNavigators[cabID];
    }

    /**
     * contributor: Alvira PD
     */
    public synchronized DoorOperator getDoorOperator(int cabID) {
    	return doorOperators[cabID];
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public FloorRequestButton getFloorRequestButton(int cabID, int floorNumber) {
        return this.floorRequestButtons[cabID][floorNumber];
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    private void setAvailable(final int cabID, boolean isAvailable) {
        synchronized (this) {
            this.isAvailable[cabID] = isAvailable;
        }
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public boolean isAvailable(final int cabID) {
        synchronized (this) {
            return this.isAvailable[cabID];
        }
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public interface ProcessRequestCallback {
        public void onFloorChanged(CabNavigatorResponse cabNavigator, int floorNumber);
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public void processRequest(final int cabID, final int floorNumber, ProcessRequestCallback processRequestCallback) {
        synchronized (this) {
            if (!this.isAvailable(cabID)) {
                return;
            }
          
            this.setAvailable(cabID, false);

            System.out.println("ProcessRequest(cabID: " + cabID + ", floorNumber: " + floorNumber + ")");

            new Thread(() -> {
                this.getCabNavigator(cabID)
                    .moveTo(floorNumber, new CabNavigator.MoveToCallback() {
                        @Override
                        public void onFloorChanged(CabNavigatorResponse response, int changedTo) {
                            System.out.println("floorChanged cabID: " + cabID + ", floorNumber: " + changedTo + "");
                         
                            processRequestCallback.onFloorChanged(CabController.this.getCabNavigator(cabID), changedTo);
                        }

                        @Override
                        public void onFinished() {
                            System.out.println("finished cabID: " + cabID);
                         
                            CabController.this.setAvailable(cabID, true);
                        }
                    });
            }).start();
        }
    }
}