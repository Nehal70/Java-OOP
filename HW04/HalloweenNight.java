/**
 * This class defines a Halloween Night event.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class HalloweenNight {

    private TrickOrTreater[] cryptKickerFive;
    private TrickOrTreater[] ghoulGang;

    /**
     * This constructor creates a Halloween Night object.
     *
     * @param cryptKickerFive array of trickOrTreaters
     * @param ghoulGang array of trickOrTreaters
     */
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = new TrickOrTreater[cryptKickerFive.length];
        this.ghoulGang = new TrickOrTreater[ghoulGang.length];
        for (int i = 0; i < cryptKickerFive.length; i++) {
            this.cryptKickerFive[i] = cryptKickerFive[i];
        }
        for (int i = 0; i < ghoulGang.length; i++) {
            this.ghoulGang[i] = ghoulGang[i];
        }
    }

    /**
     * Overrides the toString method of the Object class.
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cryptKickerFive: ");
        for (int i = 0; i < cryptKickerFive.length; i++) {
            sb.append(cryptKickerFive[i].toString());
            if (i < cryptKickerFive.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("\nversus ghoulGang: ");
        for (int i = 0; i < ghoulGang.length; i++) {
            sb.append(ghoulGang[i].toString());
            if (i < ghoulGang.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Compares the 2 arrays which act as 'teams'.
     *
     */
    public void compareTeams() {
        int cryptKickerWins = 0;
        int ghoulGangWins = 0;

        for (int i = 0; i < cryptKickerFive.length; i++) {
            if (cryptKickerFive[i].compareTo(ghoulGang[i]) > 0) {
                cryptKickerWins++;
            } else if (cryptKickerFive[i].compareTo(ghoulGang[i]) < 0) {
                ghoulGangWins++;
            }
        }

        if (cryptKickerWins > ghoulGangWins) {
            System.out.println("cryptKickerFive is favored.");
        } else if (ghoulGangWins > cryptKickerWins) {
            System.out.println("ghoulGang is favored.");
        } else {
            System.out.println("Neither team is favored.");
        }
    }

    /**
     * A method that simulates a battle between teams.
     *
     * @param winningCandyThreshold sets the threshold to win the battle
     */
    public void battle(int winningCandyThreshold) {
        if (winningCandyThreshold <= 0) {
            winningCandyThreshold = 60;
        }

        boolean cryptKickerWon = false;
        boolean ghoulGangWon = false;

        while (!cryptKickerWon && !ghoulGangWon) {
            for (int i = 0; i < cryptKickerFive.length; i++) {
                cryptKickerFive[i].trickOrTreat();
                if (cryptKickerFive[i] instanceof Ghost) {
                    ((Ghost) cryptKickerFive[i]).rob(ghoulGang[i]);
                }
            }

            for (int i = 0; i < ghoulGang.length; i++) {
                ghoulGang[i].trickOrTreat();
                if (ghoulGang[i] instanceof Ghost) {
                    ((Ghost) ghoulGang[i]).rob(cryptKickerFive[i]);
                }
            }

            int cryptKickerTotalCandy = 0;
            int ghoulGangTotalCandy = 0;

            for (TrickOrTreater trickOrTreater : cryptKickerFive) {
                cryptKickerTotalCandy += trickOrTreater.getNumCandy();
            }

            for (TrickOrTreater trickOrTreater : ghoulGang) {
                ghoulGangTotalCandy += trickOrTreater.getNumCandy();
            }

            if (cryptKickerTotalCandy >= winningCandyThreshold) {
                cryptKickerWon = true;
            }

            if (ghoulGangTotalCandy >= winningCandyThreshold) {
                ghoulGangWon = true;
            }
        }

        if (cryptKickerWon && ghoulGangWon) {
            System.out.println("It is a tie!");
        } else if (cryptKickerWon) {
            System.out.println("cryptKickerFive won!");
        } else {
            System.out.println("ghoulGang won!");
        }
    }
}
