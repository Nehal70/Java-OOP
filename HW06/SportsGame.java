/**
 * Represents a generic sports game with details such as venue, time, score, and available seats.
 *
 * @author Nehal
 * @version 1.0
 */
public abstract class SportsGame {
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;

    /**
     * Constructs a new SportsGame object with the specified details.
     *
     * @param venue     the venue
     * @param startTime the time
     * @param startDate the date
     * @param score1    the first score
     * @param score2    the second score
     * @param seatsLeft the seats available
     * @throws IllegalArgumentException if any of the arguments are invalid (null, empty, or negative values)
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft) {
        if (venue == null || venue.trim().isEmpty() || startTime == null || startTime.trim().isEmpty()
            || startDate == null || startDate.trim().isEmpty() || score1 < 0 || score2 < 0 || seatsLeft < 0) {
            throw new IllegalArgumentException("Invalid Arguments");
        }
        this.venue = venue.trim();
        this.startTime = startTime.trim();
        this.startDate = startDate.trim();
        this.score1 = score1;
        this.score2 = score2;
        this.seatsLeft = seatsLeft;
    }

    /**
     * Returns the venue.
     *
     * @return String
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Returns the start time.
     *
     * @return string
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Returns the start date.
     *
     * @return string
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Returns the score of the first team.
     *
     * @return int
     */
    public int getScore1() {
        return score1;
    }

    /**
     * Returns the score of the second team.
     *
     * @return int
     */
    public int getScore2() {
        return score2;
    }

    /**
     * Returns the number of seats left.
     *
     * @return int
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }

    /**
     * Returns a string representation of the sports game.
     *
     * @return string
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %d, %d",
               this.venue, this.startTime, this.startDate, this.score1, this.score2, this.seatsLeft);
    }

    /**
     * Compares.
     *
     * @param obj the object being compared with
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SportsGame)) {
            return false;
        }
        SportsGame other = (SportsGame) obj;
        return venue.equals(other.venue) && startTime.equals(other.startTime)
                && startDate.equals(other.startDate) && score1 == other.score1
                && score2 == other.score2 && seatsLeft == other.seatsLeft;
    }
}

