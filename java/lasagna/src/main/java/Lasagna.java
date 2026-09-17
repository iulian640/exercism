public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int actualMinutes) {

        return expectedMinutesInOven() - actualMinutes;
    }

    public int preparationTimeInMinutes(int lasgnaLayers) {

        return lasgnaLayers * 2;
    }

    public int totalTimeInMinutes(int lasagnaLayers, int actualMinutes) {

        return (lasagnaLayers * 2) + actualMinutes;
    }
}
