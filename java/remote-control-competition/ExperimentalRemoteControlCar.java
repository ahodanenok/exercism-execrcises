/**
 * Remote Control Competition
 * https://exercism.org/tracks/java/exercises/remote-control-competition
 */
public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled = 0;

    @Override
    public void drive() {
        distanceTravelled += 20;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
