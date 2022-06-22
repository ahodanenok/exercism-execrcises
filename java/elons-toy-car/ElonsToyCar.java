/**
 * Elon's Toy Car
 * https://exercism.org/tracks/java/exercises/elons-toy-car
 */
public class ElonsToyCar {
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    private int mileageInMeters = 0;
    private int remainingBatteryPercentage = 100;

    public String distanceDisplay() {
        return String.format("Driven %d meters", mileageInMeters);
    }

    public String batteryDisplay() {
        if (remainingBatteryPercentage > 0) {
            return String.format("Battery at %d%%", remainingBatteryPercentage);
        } else if (remainingBatteryPercentage == 0) {
            return "Battery empty";
        } else {
            throw new IllegalStateException("Battery has negative charge!");
        }
    }

    public void drive() {
        if (remainingBatteryPercentage == 0) {
            return;
        }

        mileageInMeters += 20;
        remainingBatteryPercentage--;
    }
}
