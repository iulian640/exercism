public class JedliksToyCar {

    int BATTERY = 100;
    int METERS;

    public static JedliksToyCar buy() {

        return new JedliksToyCar();

    }

    public String distanceDisplay() {

        StringBuilder display = new StringBuilder();
        display.append("Driven ");
        display.append(METERS);
        display.append(" meters");

        return display.toString();
    }

    public String batteryDisplay() {

        StringBuilder display = new StringBuilder();
        display.append("Battery at ");
        display.append(BATTERY);
        display.append("%");

        if (BATTERY == 0) {
            return "Battery empty";
        }
        return display.toString();
    }

    public void drive() {

        if (BATTERY > 0) {
            METERS += 20;
            BATTERY -= 1;
        }
    }
}
