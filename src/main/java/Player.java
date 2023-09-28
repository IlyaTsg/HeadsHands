public class Player extends Entity{
    private String name;
    private int level=1;
    public Player(String name, int level, int armor, int attack, int maxHeadpoints, int lowerDamage, int upperDamage) {
        super(armor, attack, maxHeadpoints, lowerDamage, upperDamage);
        if(level<1){
            throw new IllegalArgumentException("Level must be bigger than 1");
        }
        this.name = name;
        this.level = level;
    }

    public void getInfo(){
        System.out.println("Player " + name + ":" +
                "\n    lvl: " + level +
                "\n    armor: " + getArmor() +
                "\n    attack: " + getArmor() +
                "\n    hp: " + getHeadpoints() +
                "\n    dmg: " + getDamage()[0] + "-" + getDamage()[1] +
                "\n    lifeStatus: " + getLifeStatus());
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
