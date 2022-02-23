package g52977.atl.jeu2048.viewFx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Rectangle that represents a board square of the fx view.
 * 
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Square extends Rectangle {

    private final int value;

    /**
     * Constructor of Square.
     * 
     * @param value The value of the square.
     */
    public Square(int value) {
        this.value = value;        
        this.setHeight(110);
        this.setWidth(110);
        this.setArcHeight(20);
        this.setArcWidth(20);
        this.setColor();
    }

    /**
     * Set a color to the square according to the value.
     */
    private void setColor() {

        switch (value) {
            case 2:
                this.setFill(Color.web("#eee4da"));
                break;
            case 4:
                this.setFill(Color.web("#ede0c8"));
                break;
            case 8:
                this.setFill(Color.web("#f2b179"));
                break;
            case 16:
                this.setFill(Color.web("#f59563"));
                break;
            case 32:
                this.setFill(Color.web("#f67c5f"));
                break;
            case 64:
                this.setFill(Color.web("#f65e3b"));
                break;
            case 128:
                this.setFill(Color.web("#edcf72"));
                break;
            case 256:
                this.setFill(Color.web("#edcc61"));
                break;
            case 512:
                this.setFill(Color.web("#edc850"));
                break;
            case 1024:
                this.setFill(Color.web("#edc53f"));
                break;
            case 2048:
                this.setFill(Color.web("#edc22e"));
                break;
            default:
                this.setFill(Color.web("#eee4da59"));
        }
    }
}
