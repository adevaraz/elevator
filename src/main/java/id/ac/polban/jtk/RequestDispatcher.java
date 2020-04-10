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
	 * @param elevatorController
	 */
	RequestDispatcher(ElevatorController elevatorController) {
		this.elevatorController = elevatorController;
	}

    @Override
    public void run() {
        try {
            while (true) {
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
}