package g52977.atl.jeu2048.view;

import g52977.atl.jeu2048.model.Board;

/**
 * Interface of the view.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public interface InterfaceView {

    /**
     * Asks the direction to the user.
     *
     * @return The user's choice.
     */
    String askDirection();

    /**
     * Displays the board.
     *
     * @param board The game board.
     */
    void displayBoard(Board board);

    /**
     * Displays the end game message to the user based on his results.
     *
     * @param win A boolean at true if the user won and at false if the user
     * lost.
     */
    void endGameMessage(Boolean win);

}
