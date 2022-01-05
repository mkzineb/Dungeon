package model;

public class MonsterEncounter implements Encounter {
    Monster monster;

    @Override
    public boolean interact(Player player) {
        return false;
    }
}
