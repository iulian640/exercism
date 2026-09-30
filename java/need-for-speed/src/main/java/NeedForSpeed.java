class NeedForSpeed {

    public int battery = 100;
    int speed;
    int batteryDrain;
    int metersDriven;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {

        if (battery - batteryDrain >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public int distanceDriven() {

        return metersDriven;
    }

    public void drive() {

        if (battery > 0) {
            metersDriven += speed;
            battery -= batteryDrain;
        } else {
        }
    }

    public static NeedForSpeed nitro() {
        NeedForSpeed nitro = new NeedForSpeed(50, 4);

        return nitro;
    }
}

class RaceTrack {

    int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {

        if ((Math.ceil(distance) / Math.ceil(car.speed)) * car.batteryDrain <= 100) {
            return true;
        } else {
            return false;
        }
    }
}
