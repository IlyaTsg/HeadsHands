public class Main {
    public static void main(String[] args) {
        try {
            Player player = new Player("Jack", 5, 15, 15, 100, 1, 30);
            Monster monster = new Monster("Monster", 10, 10, 50, 1, 6);
            Monster monster2 = new Monster("Monster2", 10, 10, 50, 1, 6);

            player.getInfo();
            monster.getInfo();
            System.out.println("\n");

            while (monster.getLifeStatus()) {
                System.out.println("Player punches monster");
                player.Punch(monster);
                monster.getInfo();
                System.out.println("\n");
            }

            System.out.println("\n\n");
            monster2.getInfo();
            System.out.println("\n");
            System.out.println("Player punches monster2");
            player.Punch(monster2);
            monster2.getInfo();
            System.out.println("Monster heals");
            monster2.Heal();
            monster2.getInfo();
        }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
        }
    }
}
