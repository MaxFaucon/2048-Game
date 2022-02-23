package g52977.atl.jeu2048.model;

/**
 * A square on the board. A square has an integer value.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Square {

    private int value;

    /**
     * Constructor of Square.
     *
     * @param value The square's value.
     */
    public Square(int value) {
        this.value = value;
    }

    /**
     * Getter of value.
     *
     * @return The square's value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter of value.
     *
     * @param value The square's value.
     */
    public void setValue(int value) {
        this.value = value;
    }

}
