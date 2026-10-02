public class ExperimentalRemoteControlCar implements RemoteControlCar {

    protected int distanceTravelled;

    public void drive() {
        distanceTravelled += 20;
    }

    public int getDistanceTravelled() {

        return distanceTravelled;
    }
}
