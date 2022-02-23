package g52977.atl.jeu2048.controller;

import g52977.atl.jeu2048.model.Model;
import g52977.atl.jeu2048.view.View;

/**
 * Controller of the game.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Controller {

    private final Model model;
    private final View view;

    /**
     * Constructor of Controller.
     *
     * @param model The model of the game.
     * @param view The view of the game.
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Starts the game by calling the methods needed to start the game.
     */
    public void start() {          
        System.out.println("Bienvenue dans le jeu 2048 !");
        System.out.println("");
        model.initBoard();        
        view.displayBoard(model.getBoard());

        while (!model.isOver()) {
            String direction = view.askDirection();
            model.playTurn(direction);
            view.displayBoard(model.getBoard());
        }

        boolean win = model.isWin();
        view.endGameMessage(win);
    }

}
