/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorController.Request;

class RequestDispatcher implements Runnable {
	private final ElevatorController elevatorController;

    private boolean isListening = false;

	RequestDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public boolean isListening() {
        synchronized (this) {
            return isListening;
        }
    }

    private void setListening(boolean isListening) {
        synchronized (this) {
            this.isListening = isListening;
        }
    }

    public void listen() throws InterruptedException {
        if (!this.isListening()) {
            // create new thread
            new Thread(this)
                .start();

            // Wait for the new thread to run
            while (!this.isListening()) {}
        }
    }

    public void terminate() {
        this.setListening(false);
    }

    @Override
    public void run() {
        this.setListening(true);

        while (this.isListening()) {
            for (int i = 0; i < CabController.CAB_COUNT; ++i) {
                if (!elevatorController.getCabController().isAvailable(i)) {
                    continue;
                }
                
                for (Request request : elevatorController.getRequestQueue()) {
                    if (request.getCabID() != i) {
                        continue;
                    }

                    // Process the request in distinct thread
                    new Thread(() -> {
                        elevatorController
                            .getCabController()
                            .processRequest(request.getCabID(), request.getFloorNumber(), new CabController.ProcessRequestCallback() {
                                @Override
                                public void onFloorChanged(CabNavigator cabNavigator, int floorNumber) {
                                    // Remove request here
                                }
                            });
                    }).start();

                    break;
                }
            }
        }
    }
}