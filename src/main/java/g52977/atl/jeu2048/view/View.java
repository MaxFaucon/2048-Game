package g52977.atl.jeu2048.view;

import g52977.atl.jeu2048.model.Board;
import java.util.Scanner;

/**
 * View of the game.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class View implements InterfaceView {

    /**
     * Displays the board.
     *
     * @param board The game board.
     */
    @Override
    public void displayBoard(Board board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board.getSquareValue(i, j) + "\t");
            }
            System.out.println("");
            System.out.println("");
        }

    }

    /**
     * Asks the direction to the user.
     *
     * @return The user's choice.
     */
    @Override
    public String askDirection() {
        showPossibleChoices();

        System.out.println("Entrez votre mouvement : ");
        String input = veryfiesInput();

        while (!input.matches("h|b|g|d")) {
            System.out.println("Le mouvement est incorect. Veuillez réessayer : ");
            input = veryfiesInput();
        }

        return input;
    }

    /**
     * Veryfies the user's input and wait for a valid input.
     *
     * @return The user's input.
     */
    private String veryfiesInput() {
        Scanner clavier = new Scanner(System.in);

        while (!clavier.hasNextLine()) {
            clavier.next();
            System.out.println("Entrée invalide. Veuillez entrer votre mouvement :");
        }

        return clavier.nextLine();
    }

    /**
     * Displays the possible choices to the user.
     */
    private void showPossibleChoices() {
        System.out.println("- Haut (h)");
        System.out.println("- Droite (d)");
        System.out.println("- Gauche (g)");
        System.out.println("- Bas (b)");
    }

    /**
     * Displays the end game message to the user based on his results.
     *
     * @param win A boolean at true if the user won and at false if the user
     * lost.
     */
    @Override
    public void endGameMessage(Boolean win) {
        if (win) {
            System.out.println("Félicitations ! Vous avez gagné !");
        } else {
            System.out.println("Dommage... Vous avez perdu...");
        }

    }

}
