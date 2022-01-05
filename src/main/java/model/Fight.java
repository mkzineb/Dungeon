package model;

public class Fight implements PlayerState {
    public Monster monster;
    public Player player;

    @Override
    public void handle() {
        MonsterEncounter monster = new MonsterEncounter();
        int playerVitality = player.character.vitality;
        int playerPower = player.character.power;
        int monsterVitality = this.monster.character.vitality;
        int monsterPower = this.monster.character.power;
        if (monster.interact(player)){
            while (player.character.isAlive() || this.monster.character.isAlive()) {
                monsterVitality = monsterVitality - playerPower;
                playerVitality = playerVitality - monsterPower;
            }

        }
    }
    public void damage() {
        monster.character.vitality--;
    }

}
