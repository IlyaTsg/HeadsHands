public class Monster extends Entity{
    private String name;
    public Monster(String name, int armor, int attack, int maxHeadpoints, int lowerDamage, int upperDamage) {
        super(armor, attack, maxHeadpoints, lowerDamage, upperDamage);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void getInfo(){
        System.out.println("Monster " + name + ":" +
                "\n    armor: " + getArmor() +
                "\n    attack: " + getArmor() +
                "\n    hp: " + getHeadpoints() +
                "\n    dmg: " + getDamage()[0] + "-" + getDamage()[1] +
                "\n    lifeStatus: " + getLifeStatus());
    }
}
