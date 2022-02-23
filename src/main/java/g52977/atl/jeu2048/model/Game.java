package g52977.atl.jeu2048.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 * Represents the different metohds to play the game.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Game implements Model {

    private final Board board;
    private static final Random r = new Random();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Constructor of Game. Creates the board.
     */
    public Game() {
        this.board = new Board(4);
    }

    /**
     * Getter of board.
     *
     * @return the board.
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * Initialize the board by placing 2 random numbers.
     */
    @Override
    public void initBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.setSquareValue(i, j, 0);
            }
        }
        board.placeNumber(squareNumber());
        board.placeNumber(squareNumber());
        pcs.firePropertyChange("INIT_BOARD", null, board);
    }

    /**
     * Plays a turn : makes the move and places a random number if the move has
     * been executed.
     *
     * @param direction The direction of the move.
     */
    @Override
    public void playTurn(String direction) {
        if (move(direction)) {
            board.placeNumber(squareNumber());
            pcs.firePropertyChange("MOVE_OK", null, board);
        } else {
            pcs.firePropertyChange("MOVE_FAILED", null, board);
        }
    }

    /**
     * Checks if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    @Override
    public boolean isOver() {
        if (board.find2048()) {
            pcs.firePropertyChange("GAME_WON", null, board);
            return true;
        } else if (board.find0()) {
            return false;
        } else if (!board.possibleMoves()) {
            pcs.firePropertyChange("GAME_LOSE", null, board);
            return true;
        }

        return false;
    }

    /**
     * Checks if the game is win or loose.
     *
     * @return True if the user won, false if he lost.
     */
    @Override
    public boolean isWin() {
        return board.find2048();
    }

    /**
     * Makes a move according to the direction.
     *
     * @param direction The direction of the move.
     * @return A boolean at true if the move has been executed, false otherwise.
     */
    private boolean move(String direction) {
        switch (direction) {
            case "h":
                return board.move(Direction.UP);
            case "b":
                return board.move(Direction.DOWN);
            case "g":
                return board.move(Direction.LEFT);
            case "d":
                return board.move(Direction.RIGHT);
            default:
                return false;
        }
    }

    /**
     * Takes a random number between 2 and 4.
     *
     * @return The random number.
     */
    private int squareNumber() {
        int random = r.nextInt(10);

        if (random < 1) {
            return 4;
        }

        return 2;
    }

    /**
     * Add a listener to the game.
     * 
     * @param listener A new listener.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

}
