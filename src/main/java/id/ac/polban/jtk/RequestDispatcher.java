/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorController.Request;

class RequestDispatcher implements Runnable {
    /**
	 *
	 */
	private final ElevatorController elevatorController;

    /**
     * 
     */
    private boolean isActive = false;

	/**
	 * @param elevatorController
	 */
	RequestDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
	}

    /**
     * listen to the queue
     * 
     * @throws InterruptedException
     */
    synchronized void listen() throws InterruptedException {
        if (!this.isActive) {
            new Thread(this)
                .start();
        }
    }

    /**
     * terminate listener
     */
    synchronized void terminate() {
        this.isActive = false;        
    }

    /**
     * 
     */
    @Override
    public void run() {
        try {
            this.isActive = true;

            while (this.isActive) {
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
                                .processRequest(request.getCabID(), request.getFloorNumber());

                            // remove request from the queue
                            elevatorController.getRequestQueue().remove(request);
                        }).start();

                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}