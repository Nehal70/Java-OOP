public class Driver {
    public static void main(String[] args) {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        cryptKickerFive[0] = new Ghost("Ghostly Gus", 10, 5);
        cryptKickerFive[1] = new Witch("Wicked Wanda", 9, 3, "Bwahaha");
        cryptKickerFive[2] = new Ghost("Spooky Sam", 11, 2);
        cryptKickerFive[3] = new Witch("Enchanting Eliza", 7, 4, "Hehehe");
        cryptKickerFive[4] = new Ghost("Mysterious Mike", 8, 6);

        ghoulGang[0] = new Witch("Malicious Molly", 12, 2, "Bwahaha");
        ghoulGang[1] = new Ghost("Frightening Fred", 6, 1);
        ghoulGang[2] = new Witch("Cackling Clara", 5, 3, "Cackle!");
        ghoulGang[3] = new Ghost("Terrifying Tom", 10, 0);
        ghoulGang[4] = new Witch("Screaming Sarah", 8, 7, "Hahaha");

        HalloweenNight halloweenNight = new HalloweenNight(cryptKickerFive, ghoulGang);
        System.out.println(halloweenNight);
        halloweenNight.compareTeams();
        halloweenNight.battle(60);
    }
}


