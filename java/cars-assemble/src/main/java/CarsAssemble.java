public class CarsAssemble {

    private static final int CARSPERHOUR = 221;

    private static final int STOPPED = 0;

    private static final int TOPLOWSPEED = 4;

    private static final int TOPMEDIUMSPEED = 8;

    private static final int HIGHSPEED = 9;

    private static final int XHIGHSPEED = 10;

    private static final int NOPRODUCTION = 0;

    private static final double XHIGHSPEEDPRUCTION = 0.77;

    private static final double HIGHSPEEDPRODUCTION = 0.80;

    private static final double MEDIUMSPEEDPRODUCTION = 0.9;

    private static final int LOWSPEEDPRODUCTION = 1;

    public double productionRatePerHour(int speed) {

        if (speed == XHIGHSPEED) {
            return CARSPERHOUR * XHIGHSPEEDPRUCTION * speed;
        } else if (speed == HIGHSPEED) {
            return CARSPERHOUR * HIGHSPEEDPRODUCTION * speed;
        } else if (speed <= TOPLOWSPEED) {
            return CARSPERHOUR * LOWSPEEDPRODUCTION * speed;
        } else if (speed <= TOPMEDIUMSPEED) {
            return CARSPERHOUR * MEDIUMSPEEDPRODUCTION * speed;
        } else {
            return CARSPERHOUR * NOPRODUCTION;
        }
    }

    public int workingItemsPerMinute(int speed) {

        return (int) productionRatePerHour(speed) / 60;
    }
}
