import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class provides various methods for managing sports game tickets.
 *
 * @author Nehal Singhal
 * @version 1.0
 */
public class Ticket {

    /**
     * Retrieves a list of all sports games from the specified file.
     *
     * @param filePath the path to the file containing the sports games
     * @return an ArrayList of SportsGame objects
     * @throws FileNotFoundException if the file is not found
     * @throws InvalidTicketException if the file contains invalid game types
     */
    public static ArrayList<SportsGame> retrieveGames(String filePath)
            throws FileNotFoundException, InvalidTicketException {

        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        ArrayList<SportsGame> games = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                try {
                    SportsGame game = processInfo(line);
                    games.add(game);
                } catch (InvalidTicketException e) {
                    System.out.println("Invalid game type in file: " + line);
                }
            }
        }

        scanner.close();
        return games;
    }

    /**
     * Processes a line of game data and returns the corresponding SportsGame object.
     *
     * @param info the line containing game data
     * @return a SportsGame object representing the game data
     * @throws InvalidTicketException if the game type is unrecognized
     */
    private static SportsGame processInfo(String info) throws InvalidTicketException {
        String[] vals = info.split(",");
        if (vals[0].equals("BasketballGame")) {
            return new BasketballGame(vals[1], vals[2], vals[3], Integer.parseInt(vals[4]),
                    Integer.parseInt(vals[5]), Integer.parseInt(vals[6]), vals[7]);
        } else if (vals[0].equals("FootballGame")) {
            return new FootballGame(vals[1], vals[2], vals[3], Integer.parseInt(vals[4]),
                    Integer.parseInt(vals[5]), Integer.parseInt(vals[6]), vals[7]);
        } else {
            throw new InvalidTicketException("Couldn't Recognise game: " + vals[0]);
        }
    }

    /**
     * Purchases tickets for all the games that have seats available and writes them to the file.
     *
     * @param filePath the path to the file to write to
     * @param games the list of games to check and write
     * @throws IOException if there is an error writing to the file
     */
    public static void purchaseTickets(String filePath, ArrayList<SportsGame> games) throws IOException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        File file = new File(filePath);

        PrintWriter writer = new PrintWriter(file);

        for (SportsGame game : games) {
            if (game.getSeatsLeft() > 0) {
                writer.println(game.toString());
            }
        }

        writer.close();
    }

    /**
     * Finds the line numbers of all occurrences of a specific sports game in the file.
     *
     * @param filePath the path to the file to search
     * @param game the sports game to find
     * @return a list of line numbers where the game is found
     * @throws FileNotFoundException if the file is not found
     * @throws InvalidTicketException if the game is not found in the file
     */
    public static ArrayList<Integer> findTickets(String filePath, SportsGame game)
            throws FileNotFoundException, InvalidTicketException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        ArrayList<Integer> lineNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                SportsGame fileGame = processInfo(line);
                if (fileGame.equals(game)) {
                    lineNumbers.add(lineNumber);
                }
            }
            lineNumber++;
        }

        scanner.close();

        if (lineNumbers.isEmpty()) {
            throw new InvalidTicketException("Game wasn't found in the file");
        }

        return lineNumbers;
    }

    /**
     * Removes a specific sports game from the file.
     *
     * @param filePath the path to the file to modify
     * @param gameToRemove the game to remove from the file
     * @throws FileNotFoundException if the file is not found
     * @throws InvalidTicketException if the game is not found in the file
     */
    public static void attendGame(String filePath, SportsGame gameToRemove)
            throws FileNotFoundException, InvalidTicketException {
        if (filePath == null || filePath.isEmpty()) {
            throw new FileNotFoundException("File path cannot be null or empty.");
        }

        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at the specified path.");
        }

        Scanner scanner = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        boolean find = false;
        ArrayList<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            String[] tokens = line.split(",");
            if (tokens[0].equals(gameToRemove.getClass().getSimpleName())
                && tokens[1].equals(gameToRemove.getVenue())
                && tokens[2].equals(gameToRemove.getStartTime())
                && tokens[3].equals(gameToRemove.getStartDate())
                && Integer.parseInt(tokens[4]) == gameToRemove.getScore1()
                && Integer.parseInt(tokens[5]) == gameToRemove.getScore2()
                && Integer.parseInt(tokens[6]) == gameToRemove.getSeatsLeft()) {
                find = true;
            } else {
                updatedLines.add(line);
            }
        }

        if (!find) {
            throw new InvalidTicketException("The specified SportsGame was not found.");
        }

        PrintWriter writer = new PrintWriter(file);
        for (String updatedLine : updatedLines) {
            writer.println(updatedLine);
        }
        writer.close();
    }

}