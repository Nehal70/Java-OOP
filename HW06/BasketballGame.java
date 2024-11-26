/**
 * Represents a basketball game.
 *
 * @author Nehal
 * @version 1.0
 */
public class BasketballGame extends SportsGame {
    private String league;

    /**
     * Creates a BasketballGame object with the specified details.
     *
     * @param venue     the venue
     * @param startTime the time
     * @param startDate the date
     * @param score1    the first score
     * @param score2    the second score
     * @param seatsLeft the seats
     * @param league    the league
     * @throws IllegalArgumentException if null or empty
     */
    public BasketballGame(String venue, String startTime, String startDate,
                            int score1, int score2, int seatsLeft, String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (league == null || league.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Argument.");
        }
        this.league = league.trim();
    }

    /**
     * overrides toString.
     *
     * @return string
     */
    @Override
    public String toString() {
        return String.format("BasketballGame,%s,%s,%s,%d,%d,%d,%s", getVenue(), getStartTime(),
                                getStartDate(), getScore1(), getScore2(), getSeatsLeft(), league);
    }

    /**
     * compares basketball games.
     *
     * @param obj the object being compared with
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BasketballGame)) {
            return false;
        }
        BasketballGame other = (BasketballGame) obj;
        return super.equals(other) && league.equals(other.league);
    }
}

