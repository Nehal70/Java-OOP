/**
 * Represents a football game, extending the SportsGame class.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class FootballGame extends SportsGame {
    private String performer;

    /**
     * Creates a FootballGame object with the given details.
     *
     * @param venue       the venue
     * @param startTime   the time
     * @param startDate   the date
     * @param score1      the first score
     * @param score2      the second score
     * @param seatsLeft   the seats
     * @param performer   the performer
     * @throws IllegalArgumentException if null or empty
     */
    public FootballGame(String venue, String startTime, String startDate,
                        int score1, int score2, int seatsLeft, String performer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (performer == null || performer.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.performer = performer.trim();
    }

    /**
     * Overrides toString.
     *
     * @return string
     */
    @Override
    public String toString() {
        return String.format("FootballGame,%s,%s,%s,%d,%d,%d,%s", getVenue(), getStartTime(),
                                getStartDate(), getScore1(), getScore2(), getSeatsLeft(), performer);
    }

    /**
     * Compares.
     *
     * @param obj the object being compared with
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FootballGame)) {
            return false;
        }
        FootballGame other = (FootballGame) obj;
        return super.equals(other) && performer.equals(other.performer);
    }
}

