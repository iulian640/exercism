class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

    Fighter warrior = new Fighter();

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter Warrior) {
        if (Warrior.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }

    @Override
    public String toString() {

        return "Fighter is a Warrior";
    }

}

class Wizard extends Fighter {

    boolean spellIsPrepared = false;

    void prepareSpell() {
        spellIsPrepared = true;
    }

    @Override
    boolean isVulnerable() {
        if (spellIsPrepared) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    int getDamagePoints(Fighter Wizard) {
        if (spellIsPrepared) {
            return 12;
        } else {
            return 3;
        }
    }

    @Override
    public String toString() {

        return "Fighter is a Wizard";
    }
}
