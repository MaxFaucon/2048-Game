package g52977.atl.jeu2048.model;

import java.beans.PropertyChangeListener;

/**
 * Interface that represents the Model of the game.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public interface Model {

    /**
     * Getter of board.
     *
     * @return the board.
     */
    Board getBoard();

    /**
     * Initialize the board by placing 2 random numbers.
     */
    void initBoard();

    /**
     * Plays a turn : places a random number and makes the move in a certain
     * direction.
     *
     * @param direction The direction of the move.
     */
    void playTurn(String direction);

    /**
     * Checks if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    boolean isOver();

    /**
     * Checks if the game is win or loose.
     *
     * @return True if the user won, false if he lost.
     */
    boolean isWin();
    
    public void addPropertyChangeListener(PropertyChangeListener listener);

}
