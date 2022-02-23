package g52977.atl.jeu2048.viewFx;

import g52977.atl.jeu2048.controller.ControllerFx;
import g52977.atl.jeu2048.model.Board;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Fx view of the 2048 game.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class ViewFx implements ViewFxInterface {

    private final int STAGE_HEIGHT = 640;
    private final int STAGE_WIDTH = 940;
    private ControllerFx controller;
    private final Stage stage;
    private GameBoard gameBoard;
    private MessagesList messagesBoard;
    Boolean gameOver = false;

    /**
     * Constructor of ViewFx.
     * 
     * @param aStage The view stage.
     */
    public ViewFx(Stage aStage) {
        VBox root = new VBox(10);        
        initialize(root);

        // Scene        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/ViewFx.css");
        scene.addEventFilter(KeyEvent.KEY_PRESSED, KeyEvent -> {
            if (KeyEvent.getCode() != null && !gameOver) {
                playTurn(KeyEvent.getCode());            
            }
        });        

        // Stage
        stage = aStage;
        stage.setTitle("HEB ESI - 2048");
        stage.setMinWidth(STAGE_WIDTH);
        stage.setMinHeight(STAGE_HEIGHT);
        stage.setMaxWidth(STAGE_WIDTH);
        stage.setMaxHeight(STAGE_HEIGHT);
        stage.setScene(scene);
    }

    /**
     * Setter of ViewFx to set a controller. And add the view as a listener of 
     * the model.
     * 
     * @param controller A controller.
     */
    @Override
    public void setController(ControllerFx controller) {
        this.controller = controller;
        controller.addModelListener(this);
    }

    /**
     * Show the stage of the fx view.
     */
    @Override
    public void showStage() {
        controller.initBoard();
        stage.show();
    }

    /**
     * Initializes all the elements of the fx view.
     * 
     * @param root The root of the fx view.
     */
    private void initialize(VBox root) {        
        HBox content = new HBox(10);                             

        HBox buttons = new HBox(150);
        buttons.setPadding(new Insets(10, 0, 0, 0));
        buttons.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(content, buttons);
        
        VBox game = new VBox(0);        
        VBox messages = new VBox(0);  
        content.getChildren().addAll(game, messages);

        gameBoard = new GameBoard();        
        game.getChildren().add(gameBoard);                      

        messagesBoard = new MessagesList();
        messagesBoard.displayMessage("Bienvenue au 2048");
        messages.getChildren().add(messagesBoard);

        Button retryBtn = new Button("RECOMMENCER");                       
        retryBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                retryAction();
            }
        });        

        Button leaveBtn = new Button("QUITTER");
        leaveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        buttons.getChildren().addAll(retryBtn, leaveBtn);
    }

    /**
     * Play a turn according to the key entered by the user.
     * 
     * @param code The key entered by the user.
     */
    private void playTurn(KeyCode code) {

        switch (code) {
            case UP:
                controller.playTurn("h");
                break;
            case Z:
                controller.playTurn("h");
                break;
            case DOWN:
                controller.playTurn("b");
                break;
            case S:
                controller.playTurn("b");
                break;
            case LEFT:
                controller.playTurn("g");
                break;
            case Q:
                controller.playTurn("g");
                break;
            case RIGHT:
                controller.playTurn("d");
                break;
            case D:
                controller.playTurn("d");
                break;
        }

    }

    /**
     * Resets the board when a user clicks on the retry button.
     */
    private void retryAction() {
        controller.initBoard();
        messagesBoard.displayMessage("Partie recommencée");
        gameOver = false;
    }

    /**
     * Makes an action according to the event sent by the model.
     * 
     * @param pce The event sent by the model. 
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        String event = pce.getPropertyName();

        if (event.equalsIgnoreCase("init_board")) {
            gameBoard.createBoard((Board) pce.getNewValue());
        } else if (event.equalsIgnoreCase("move_ok")) {
            gameBoard.updateBoard((Board) pce.getNewValue());
        } else if (event.equalsIgnoreCase("move_failed")) {
            messagesBoard.displayMessage("Mouvement impossible");
        } else if (event.equalsIgnoreCase("game_won")) {
            messagesBoard.displayMessage("Partie terminée");
            messagesBoard.displayMessage("Vous avez gagné");
            gameOver = true;
        } else {
            messagesBoard.displayMessage("Partie terminée");
            messagesBoard.displayMessage("Vous avez perdu");
            gameOver = true;
        }
    }

}
