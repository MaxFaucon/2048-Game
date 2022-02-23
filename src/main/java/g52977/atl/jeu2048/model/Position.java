package g52977.atl.jeu2048.model;

/**
 * The position on the board. A position is represented by an integer for the x
 * & column axis.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Constructor of Position
     *
     * @param row The position on the row-axis.
     * @param column The position on the column-axis.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter of row.
     *
     * @return The position on the row-axis.
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter of column.
     *
     * @return The position on the column-axis.
     */
    public int getColumn() {
        return column;
    }

}
