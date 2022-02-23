package g52977.atl.jeu2048.controller;

import g52977.atl.jeu2048.model.Model;
import g52977.atl.jeu2048.viewFx.ViewFxInterface;
import java.beans.PropertyChangeListener;

/**
 * Fx controller of the 2048 game.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class ControllerFx {

    private final Model model;
    private final ViewFxInterface view;

    /**
     * Constructor of ControllerFx;
     * 
     * @param model The model of the application.
     * @param view The view of the application.
     */
    public ControllerFx(Model model, ViewFxInterface view) {
        this.model = model;
        this.view = view;        
    }        
    
    /**
     * Plays a turn if the game isn't over.
     * 
     * @param direction The direction of the move.
     */
    public void playTurn(String direction) {
        if (!model.isOver()) {
            model.playTurn(direction);
        }
        model.isOver();
    }
    
    /**
     * Initialize the game board.
     */
    public void initBoard() {       
        model.initBoard();
    }
    
    /**
     * Add a listener to the game.
     * 
     * @param listener The new listener.
     */
    public void addModelListener(PropertyChangeListener listener) {
        model.addPropertyChangeListener(listener);
    }
    
}
