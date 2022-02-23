package g52977.atl.jeu2048.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 52977
 */
public class BoardTest {

    /**
     * Test of rightFlip method, of class Board.
     */
    @Test
    public void testRightFlip_1() {
        System.out.println("rightFlip 1");
        Square[][] squares = {
            {new Square(1), new Square(5), new Square(9), new Square(13)},
            {new Square(2), new Square(6), new Square(10), new Square(14)},
            {new Square(3), new Square(7), new Square(11), new Square(15)},
            {new Square(4), new Square(8), new Square(12), new Square(16)}
        };
        Board instance = new Board(squares);
        instance.rightFlip();

        int[][] expResult = {
            {4, 3, 2, 1},
            {8, 7, 6, 5},
            {12, 11, 10, 9},
            {16, 15, 14, 13}
        };

        int[][] result = instance.getSquaresValues();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of leftFlip method, of class Board.
     */
    @Test
    public void testLeftFlip_1() {
        System.out.println("leftFlip 1");
        Square[][] squares = {
            {new Square(1), new Square(5), new Square(9), new Square(13)},
            {new Square(2), new Square(6), new Square(10), new Square(14)},
            {new Square(3), new Square(7), new Square(11), new Square(15)},
            {new Square(4), new Square(8), new Square(12), new Square(16)}
        };
        Board instance = new Board(squares);
        instance.leftFlip();

        int[][] expResult = {
            {13, 14, 15, 16},
            {9, 10, 11, 12},
            {5, 6, 7, 8},
            {1, 2, 3, 4}
        };

        int[][] result = instance.getSquaresValues();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of reverseFlip method, of class Board.
     */
    @Test
    public void testReverseFlip_1() {
        System.out.println("reverseFlip 1");
        Square[][] squares = {
            {new Square(1), new Square(5), new Square(9), new Square(13)},
            {new Square(2), new Square(6), new Square(10), new Square(14)},
            {new Square(3), new Square(7), new Square(11), new Square(15)},
            {new Square(4), new Square(8), new Square(12), new Square(16)}
        };
        Board instance = new Board(squares);
        instance.reverseFlip();

        int[][] expResult = {
            {4, 8, 12, 16},
            {3, 7, 11, 15},
            {2, 6, 10, 14},
            {1, 5, 9, 13}
        };

        int[][] result = instance.getSquaresValues();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of swipeUp method, of class Board.
     */
    @Test
    public void testSwipeUp_1() {
        System.out.println("swipeUp 1");
        Square[][] squares = {
            {new Square(0), new Square(0), new Square(0), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.swipeUp(0, 0);

        int[][] expResult = {
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of swipeUp method, of class Board.
     */
    @Test
    public void testSwipeUp_2() {
        System.out.println("swipeUp 2");
        Square[][] squares = {
            {new Square(2), new Square(0), new Square(0), new Square(0)},
            {new Square(0), new Square(0), new Square(0), new Square(0)},
            {new Square(0), new Square(0), new Square(0), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.swipeUp(0, 1);

        int[][] expResult = {
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of swipeUp method, of class Board.
     */
    @Test
    public void testSwipeUp_3() {
        System.out.println("swipeUp 3");
        Square[][] squares = {
            {new Square(0), new Square(0), new Square(0), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(0), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.swipeUp(2, 0);

        int[][] expResult = {
            {0, 0, 2, 0},
            {0, 0, 2, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_1() {
        System.out.println("move not executed");
        Square[][] squares = {
            {new Square(4), new Square(16), new Square(4), new Square(2)},
            {new Square(2), new Square(8), new Square(2), new Square(0)},
            {new Square(4), new Square(0), new Square(64), new Square(0)},
            {new Square(0), new Square(0), new Square(128), new Square(0)}
        };
        Board instance = new Board(squares);

        boolean expResult = false;
        boolean result = instance.move(Direction.UP);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_2() {
        System.out.println("move up");
        Square[][] squares = {
            {new Square(0), new Square(0), new Square(0), new Square(2)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(0), new Square(2), new Square(0), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.UP);

        int[][] expResult = {
            {2, 2, 2, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_3() {
        System.out.println("move down");
        Square[][] squares = {
            {new Square(2), new Square(0), new Square(0), new Square(0)},
            {new Square(0), new Square(2), new Square(0), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(0), new Square(2)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.DOWN);

        int[][] expResult = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {2, 2, 2, 2}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_4() {
        System.out.println("move right");
        Square[][] squares = {
            {new Square(2), new Square(0), new Square(0), new Square(0)},
            {new Square(0), new Square(2), new Square(0), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(0), new Square(2)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.RIGHT);

        int[][] expResult = {
            {0, 0, 0, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 2}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_5() {
        System.out.println("move left");
        Square[][] squares = {
            {new Square(0), new Square(0), new Square(0), new Square(2)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(0), new Square(2), new Square(0), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.LEFT);

        int[][] expResult = {
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {2, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_6() {
        System.out.println("move 6");
        Square[][] squares = {
            {new Square(2), new Square(2), new Square(2), new Square(2)},
            {new Square(0), new Square(2), new Square(2), new Square(4)},
            {new Square(2), new Square(2), new Square(4), new Square(2)},
            {new Square(2), new Square(2), new Square(4), new Square(4)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.UP);

        int[][] expResult = {
            {4, 4, 4, 2},
            {2, 4, 8, 4},
            {0, 0, 0, 2},
            {0, 0, 0, 4}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_7() {
        System.out.println("move 7");
        Square[][] squares = {
            {new Square(2), new Square(2), new Square(1024), new Square(0)},
            {new Square(4), new Square(4), new Square(1024), new Square(0)},
            {new Square(0), new Square(4), new Square(256), new Square(0)},
            {new Square(8), new Square(2), new Square(256), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.UP);

        int[][] expResult = {
            {2, 2, 2048, 0},
            {4, 8, 512, 0},
            {8, 2, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMove_8() {
        System.out.println("move 8");
        Square[][] squares = {
            {new Square(0), new Square(0), new Square(1024), new Square(0)},
            {new Square(0), new Square(0), new Square(1024), new Square(0)},
            {new Square(4), new Square(2), new Square(256), new Square(0)},
            {new Square(4), new Square(2), new Square(256), new Square(0)}
        };
        Board instance = new Board(squares);
        instance.move(Direction.UP);

        int[][] expResult = {
            {8, 4, 2048, 0},
            {0, 0, 512, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] result = instance.getSquaresValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testFind2048_1() {
        System.out.println("find2048 1");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(0)},
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)}
        };
        Board instance = new Board(squares);
        Boolean expResult = false;
        Boolean result = instance.find2048();
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testFind2048_2() {
        System.out.println("find2048 2");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(0)},
            {new Square(2), new Square(2048), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)}
        };
        Board instance = new Board(squares);
        Boolean expResult = true;
        Boolean result = instance.find2048();
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testFind0_1() {
        System.out.println("find0 1");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)},
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)}
        };
        Board instance = new Board(squares);
        Boolean expResult = false;
        Boolean result = instance.find0();
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testFind0_2() {
        System.out.println("find0 2");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)},
            {new Square(2), new Square(0), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)}
        };
        Board instance = new Board(squares);
        Boolean expResult = true;
        Boolean result = instance.find0();
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testPossibleMoves_1() {
        System.out.println("possibleMoves 1");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(0)},
            {new Square(2), new Square(4), new Square(2), new Square(2)},
            {new Square(4), new Square(2), new Square(4), new Square(4)}
        };
        Board instance = new Board(squares);
        Boolean expResult = true;
        Boolean result = instance.possibleMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testPossibleMoves_2() {
        System.out.println("possibleMoves 2");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(4)},
            {new Square(4), new Square(16), new Square(2), new Square(128)},
            {new Square(2), new Square(2), new Square(32), new Square(64)},
            {new Square(2), new Square(8), new Square(8), new Square(2)}
        };
        Board instance = new Board(squares);
        Boolean expResult = true;
        Boolean result = instance.possibleMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoves method, of class Board.
     */
    @Test
    public void testPossibleMoves_3() {
        System.out.println("possibleMoves 3");
        Square[][] squares = {
            {new Square(2), new Square(4), new Square(2), new Square(4)},
            {new Square(4), new Square(2), new Square(4), new Square(2)},
            {new Square(2), new Square(4), new Square(2), new Square(4)},
            {new Square(4), new Square(2), new Square(4), new Square(2)}
        };
        Board instance = new Board(squares);
        Boolean expResult = false;
        Boolean result = instance.possibleMoves();
        assertEquals(expResult, result);
    }

}
