/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

class RequestDispatcher implements Runnable {
    /**
	 *
	 */
	private final ElevatorController elevatorController;

    /**
     * 
     */
    private Data data;

	/**
	 * @param elevatorController
	 */
	RequestDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
        
        this.data = new Data();
	}

    /**
     * listen to the queue
     * 
     * @throws InterruptedException
     */
    synchronized void listen() throws InterruptedException {
        if (!this.data.isActive) {
            new Thread(this)
                .start();
        }
    }

    /**
     * terminate listener
     */
    synchronized void terminate() {
        this.data.isActive = false;        
    }

    /**
     * 
     */
    @Override
    public void run() {
        try {
            this.data.isActive = true;

            while (this.data.isActive) {
                // Process the request
                elevatorController
                    .getRequestQueue()
                    .take()
                    .call();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    private static class Data {
        private boolean isActive = false;
    }
}