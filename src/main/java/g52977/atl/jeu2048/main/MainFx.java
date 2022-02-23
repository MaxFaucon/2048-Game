package g52977.atl.jeu2048.main;

import g52977.atl.jeu2048.controller.ControllerFx;
import g52977.atl.jeu2048.model.Game;
import g52977.atl.jeu2048.model.Model;
import g52977.atl.jeu2048.viewFx.ViewFx;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * Fx main class of the 2048 game.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class MainFx extends Application {        
    
    /**
     * Launches the application.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Starts the application.
     * 
     * @param stage The stage of the application.
     * @throws Exception An exception if the start fail.
     */
    @Override
    public void start(Stage stage) throws Exception {           
        Model model = new Game();
        ViewFx view = new ViewFx(stage);
        ControllerFx controller = new ControllerFx(model, view);
        view.setController(controller);
        view.showStage();
    }
    
}
