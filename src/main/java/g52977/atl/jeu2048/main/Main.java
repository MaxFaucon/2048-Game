package g52977.atl.jeu2048.main;

import g52977.atl.jeu2048.controller.Controller;
import g52977.atl.jeu2048.model.Game;
import g52977.atl.jeu2048.model.Model;
import g52977.atl.jeu2048.view.View;

/**
 * Main class.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Main {
    
    public static void main(String[] args) {                       
        Model model = new Game();
        View view = new View();
        Controller controller = new Controller(model, view);                
                
        controller.start();        
    }
    
}
