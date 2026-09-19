
class BirdWatcher {
    private final int[] birdsPerDay;

    private final static int[] BIRDSWATCHEDLASTWEEK = { 0, 2, 5, 3, 7, 8, 4 };

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {

        return BIRDSWATCHEDLASTWEEK;
    }

    public int getToday() {

        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {

        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {

        for (int birds : birdsPerDay) {
            if (birds == 0)
                return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {

        int total = 0;

        for (int i = 0; i < Math.min(numberOfDays, 7); i++) {
            total += birdsPerDay[i];
        }
        return total;
    }

    public int getBusyDays() {
        int busydays = 0;

        for (int birds : birdsPerDay) {
            if (birds >= 5) {
                busydays++;
            }
        }
        return busydays;

    }
}
