import java.util.Random;

public class Entity {
    private int armor = 15;
    private int attack = 15;
    private int headpoints = 100;
    private int maxHeadpoints = 100;
    private int lowerDamage = 1;
    private int upperDamage = 6;
    private int healCounter = 0;
    private boolean lifeStatus = true; // Статус жизни

    // Если защищающийся умер, то вернет true
    public void Punch(Entity defender){
        Random random = new Random();
        int attackModifier = this.attack - defender.armor + 1;
        if(attackModifier < 1){ // Если защита оказалась больше атаки, то нужно хоть раз кинуть кость
            attackModifier = 1;
        }
        for(int i=0; i<attackModifier; ++i){
            if(random.nextInt(1, 7) > 4){
                int currentDamage = random.nextInt(lowerDamage, upperDamage+1);
                defender.headpoints -= currentDamage;
                if(defender.headpoints < 1){
                    defender.headpoints = 0;
                    defender.lifeStatus = false;
                }
                break;
            }
        }
    }

    public boolean Heal(){
        if(healCounter > 4){
            return false;
        }
        ++healCounter;
        headpoints += (int)(maxHeadpoints*0.3);
        if(headpoints > maxHeadpoints) headpoints = maxHeadpoints;
        return true;
    }

    public Entity(int armor, int attack, int maxHeadpoints, int lowerDamage, int upperDamage) {
        if(armor<1 || armor>30){
            throw new IllegalArgumentException("Armor must be between 1 to 30");
        }
        if(attack<1 || attack>30){
            throw new IllegalArgumentException("Attack must be between 1 to 30");
        }
        if(maxHeadpoints<0){
            throw new IllegalArgumentException("Headpoints must be bigger than 0");
        }
        if(lowerDamage>upperDamage || lowerDamage<1){
            throw new IllegalArgumentException("Upper damage must be bigger than lower. Lower damage must be bigger than 0");
        }

        this.armor = armor;
        this.attack = attack;
        this.headpoints = maxHeadpoints;
        this.maxHeadpoints = maxHeadpoints;
        this.lowerDamage = lowerDamage;
        this.upperDamage = upperDamage;
    }

    public int getArmor() {
        return armor;
    }
    public int getAttack() {
        return attack;
    }
    public int getHeadpoints() {
        return headpoints;
    }
    public int[] getDamage(){
        return new int[]{this.lowerDamage, this.upperDamage};
    }
    public boolean getLifeStatus() {
        return lifeStatus;
    }
    public void setLifeStatus(boolean lifeStatus) {
        this.lifeStatus = lifeStatus;
    }
}
