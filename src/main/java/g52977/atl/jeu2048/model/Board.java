package g52977.atl.jeu2048.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the game board and the possible actions on this board. A board is
 * build with squares.
 *
 * @author Maximilien Faucon 52977 <52977@etu.he2b.be>
 */
public class Board {

    private Square[][] squares;
    private static Random r = new Random();

    /**
     * Constructor of Board.
     *
     * @param size The size of the board.
     */
    public Board(int size) {
        this.squares = new Square[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                squares[row][column] = new Square(0);
            }
        }
    }

    /**
     * Constructor of Board for the tests.
     *
     * @param squares An array of squares.
     */
    Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Getter of squares.
     *
     * @return A defensive copy of the board squares.
     */
    public Square[][] getSquares() {
        Square[][] defCopySquares = new Square[squares.length][squares[0].length];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                defCopySquares[i][j] = squares[i][j];
            }
        }
        
        return defCopySquares;
    }

    /**
     * Getter of squares for the tests.
     *
     * @return The square of the board.
     */
    int[][] getSquaresValues() {
        int[][] squaresValues = new int[squares.length][squares.length];

        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                squaresValues[row][column] = squares[row][column].getValue();
            }
        }

        return squaresValues;
    }

    /**
     * Gives the value of a square on the board.
     *
     * @param row The position of the square on the x-axis.
     * @param column The position of the square on the y-axis.
     * @return The value of the square.
     */
    public int getSquareValue(int row, int column) {
        return squares[row][column].getValue();
    }

    /**
     * Set a new value in a square.
     *
     * @param row The position of the square on the x-axis.
     * @param column The position of the square on the y-axis.
     * @param value The new value for the square.
     */
    public void setSquareValue(int row, int column, int value) {
        squares[row][column].setValue(value);
    }

    /**
     * Gives the size of the board.
     *
     * @return The size of the board.
     */
    public int getSize() {
        return squares.length;
    }

    /**
     * Changes the squares of the board with new squares.
     *
     * @param newSquares A new array of squares.
     */
    private void changeSquaresValues(int[][] newSquares) {
        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                squares[row][column].setValue(newSquares[row][column]);
            }
        }
    }

    /**
     * Places a random number on a random free place on the board.
     *
     * @param randomNumber The random number to place.
     */
    public void placeNumber(int randomNumber) {
        List<Position> emptySquaresList = new ArrayList();

        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                if (this.getSquareValue(row, column) == 0) {
                    emptySquaresList.add(new Position(row, column));
                }
            }
        }

        int randomPosition = r.nextInt(emptySquaresList.size());
        int row = emptySquaresList.get(randomPosition).getRow();
        int column = emptySquaresList.get(randomPosition).getColumn();

        this.setSquareValue(row, column, randomNumber);
    }

    /**
     * Calls a move according to the direction entered.
     *
     * @param direction The move's direction.
     * @return A boolean at true if the move has been executed, false otherwise.
     */
    public boolean move(Direction direction) {
        switch (direction) {
            case UP:
                return this.moveUp();
            case DOWN:
                return this.moveDown();
            case RIGHT:
                return this.moveRight();
            case LEFT:
                return this.moveLeft();
            default:
                return false;
        }
    }

    /**
     * Flip the board to the right.
     */
    void rightFlip() {
        int[][] flippedSquares = new int[squares.length][squares.length];

        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                flippedSquares[row][column] = 
                        squares[squares.length - 1 - column][row].getValue();
            }
        }

        changeSquaresValues(flippedSquares);
    }

    /**
     * Flip the board to the left.
     */
    void leftFlip() {
        int[][] flippedSquares = new int[squares.length][squares.length];

        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                flippedSquares[row][column] = 
                        squares[column][squares.length - 1 - row].getValue();
            }
        }

        changeSquaresValues(flippedSquares);
    }

    /**
     * Reverse the board.
     */
    void reverseFlip() {
        int[][] flippedSquares = new int[squares.length][squares.length];

        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                flippedSquares[row][column] = 
                        squares[squares.length - 1 - row][column].getValue();
            }
        }

        changeSquaresValues(flippedSquares);
    }

    /**
     * Swipes all the values of a given column to the top and return a boolean.
     *
     * @param column The column of the array.
     * @param row The line where to start.
     * @return If at least 1 value is swipped, return true. Return false
     * otherwise.
     */
    boolean swipeUp(int column, int row) {
        int save = row;
        boolean swipe = false;

        while (row < squares.length) {
            if (squares[row][column].getValue() != 0) {
                squares[save][column].setValue(squares[row][column].getValue());
                squares[row][column].setValue(0);
                save++;
                swipe = true;
            } else {
                row++;
            }
        }

        return swipe;
    }

    /**
     * Makes the move up. Also checks if the move has been executed.
     *
     * @return True if the move has been executed, false otherwise.
     */
    private boolean moveUp() {
        boolean moveExecuted = false;

        for (int column = 0; column < squares.length; column++) {
            int row = 0;
            boolean swipe;

            while (row < squares.length - 1) {
                if (squares[row][column].getValue() == 0) {
                    swipe = swipeUp(column, row);
                    // If at least 1 value swipped, a move has been done. Otherwise,
                    // no values can move in the column and we go in the next column.
                    if (swipe) {
                        moveExecuted = true;
                    } else {
                        break;
                    }
                } else if (squares[row + 1][column].getValue() == 0) {
                    swipe = swipeUp(column, row + 1);
                    if (swipe) {
                        moveExecuted = true;
                    } else {
                        break;
                    }
                }

                if (squares[row][column].getValue() != 0
                        && squares[row][column].getValue() == squares[row + 1][column].getValue()) {
                    squares[row][column].setValue(squares[row + 1][column].getValue() * 2);
                    squares[row + 1][column].setValue(0);
                    moveExecuted = true;
                }

                row++;
            }
        }

        return moveExecuted;

    }

    /**
     * Makes the move right by flipping the board to the left and making a move
     * up.
     *
     * @return True if the move has been executed, false otherwise.
     */
    private boolean moveRight() {
        this.leftFlip();
        boolean moveExecuted = this.moveUp();
        this.rightFlip();
        return moveExecuted;
    }

    /**
     * Makes the move down by reversing the board and making a move up.
     *
     * @return True if the move has been executed, false otherwise.
     */
    private boolean moveDown() {
        this.reverseFlip();
        boolean moveExecuted = this.moveUp();
        this.reverseFlip();
        return moveExecuted;
    }

    /**
     * Makes the move left by flipping the board to the right and making a move
     * up.
     *
     * @return True if the move has been executed, false otherwise.
     */
    private boolean moveLeft() {
        this.rightFlip();
        boolean moveExecuted = this.moveUp();
        this.leftFlip();
        return moveExecuted;
    }

    /**
     * Checks if the value 2048 is in the board.
     *
     * @return True if 2048 is in the board, false otherwise.
     */
    public boolean find2048() {
        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                if (squares[row][column].getValue() == 2048) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if the value 0 is in the board.
     *
     * @return True if 0 is in the board, false otherwise.
     */
    public boolean find0() {
        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                if (squares[row][column].getValue() == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if there are still possible moves.
     *
     * @return True if there is a possible move, false otherwise.
     */
    public boolean possibleMoves() {
        for (int row = 0; row < squares.length; row++) {
            for (int column = 0; column < squares.length; column++) {
                int squareValue = squares[row][column].getValue();

                if (row + 1 < squares.length 
                        && squares[row + 1][column].getValue() == squareValue
                        || row - 1 >= 0 
                        && squares[row - 1][column].getValue() == squareValue
                        || column + 1 < squares.length 
                        && squares[row][column + 1].getValue() == squareValue
                        || column - 1 >= 0 
                        && squares[row][column - 1].getValue() == squareValue) {
                    return true;
                }
            }
        }

        return false;
    }

}
