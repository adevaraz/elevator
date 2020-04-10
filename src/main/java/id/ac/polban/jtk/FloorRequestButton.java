/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

public class FloorRequestButton extends FloorRequestButtonBase {
    @Override
    public void turnLightOn() {
        this.getSignals().add(() -> {
            super.turnLightOn();

            return null;
        });
    }

    @Override
    public void turnLightOff() {
        this.getSignals().add(() -> {
            super.turnLightOff();

            return null;
        });
    }
}