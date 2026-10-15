public class GameMaster {

    public String describe(Character character) {

        int level = character.getLevel();
        String characterClass = character.getCharacterClass();
        int hitPoints = character.getHitPoints();

        return "You're a level " + level + " " + characterClass + " " + "with " + hitPoints + " hit points.";
    }

    public String describe(Destination destination) {

        String name = destination.getName();
        int inhabitants = destination.getInhabitants();

        return "You've arrived at " + name + ", which has " + inhabitants + " inhabitants.";
    }

    public String describe(TravelMethod travelMethod) {

        return travelMethod == travelMethod.WALKING ? "You're traveling to your destination by walking."
                : "You're traveling to your destination on horseback.";
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {

        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);

    }

    public String describe(Character character, Destination destination) {

        return describe(character) + " You're traveling to your destination by walking. " + describe(destination);
    }
}
