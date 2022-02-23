package g52977.atl.jeu2048.viewFx;

import g52977.atl.jeu2048.model.Board;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * GridPane that represents the game board of the fx view.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class GameBoard extends GridPane {

    Boolean boardCreated = false;

    /**
     * Constructor of GameBoard.
     */
    public GameBoard() {
        this.getStylesheets().add("css/ViewFx.css");        
    }

    /**
     * Creates the fx game board if he's not created yet  with the board values.
     * Each square of the Board is a Text with a Square.
     * 
     * @param board The board containing the values.
     */
    public void createBoard(Board board) {
        if (!boardCreated) {
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    Rectangle square = new Square(board.getSquareValue(i, j));
                    Text text = new Text();

                    if (board.getSquareValue(i, j) != 0) {
                        text = new Text(String.valueOf(board.getSquareValue(i, j)));
                        text.setFont(Font.font("System", FontWeight.BOLD, 40));
                    }
                    
                    this.add(new StackPane(square, text), j, i);
                }
            }
            boardCreated = true;
        } else {
            updateBoard(board);
        }
      
    }

    /**
     * Updates the fx game board with the board values.
     * 
     * @param board The board containing the values.
     */
    public void updateBoard(Board board) {
        int child = 0;
        StackPane pane;
        int value;
        Text text;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                pane = (StackPane) this.getChildren().get(child);
                value = board.getSquareValue(i, j);                                

                if (value != 0) {
                    text = new Text(String.valueOf(value));
                    text.setFont(Font.font("System", FontWeight.BOLD, 40));
                    pane.getChildren().set(0, new Square(value));
                    pane.getChildren().set(1, text);
                } else {
                    pane.getChildren().set(0, new Square(0));
                    pane.getChildren().set(1, new Text(""));
                }
                child++;
            }
        }
    }

}
