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
                elevatorController.getRequestQueue().take();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}