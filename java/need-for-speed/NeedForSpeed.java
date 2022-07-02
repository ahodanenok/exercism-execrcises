class NeedForSpeed {

    private final int speed;
    private int distanceDriven;

    private final int batteryDrain;
    private int batteryRemaining;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.batteryRemaining = 100;
    }

    public boolean batteryDrained() {
        return batteryRemaining < batteryDrain;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (batteryDrained()) {
            return;
        }

        distanceDriven += speed;
        batteryRemaining -= batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        int initialDistanceDriven = car.distanceDriven();
        while (true) {
            if (car.distanceDriven() - initialDistanceDriven >= distance) {
                return true;
            }

            if (car.batteryDrained()) {
                return false;
            }

            car.drive();
        }
    }
}
