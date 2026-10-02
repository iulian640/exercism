class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    protected int distanceTravelled;

    protected int numberOfVictories;

    public void drive() {
        distanceTravelled += 10;
    }

    public int getDistanceTravelled() {

        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {

        return other.numberOfVictories - this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
}
