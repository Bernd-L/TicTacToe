package tk.bernd.logic;


import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.stream.IntStream;

public class BL {

    //Players
    public static final int CROSS = -1;
    public static final int DEFAULT = 0;
    public static final int CIRCLE = 1;

    //Status
    public static final int RUNNING_GAME = 4;
    public static final int DRAW = 5;

    //Win sums
    public static final int CROSS_WIN = -3;
    public static final int CIRCLE_WIN = 3;

    //Text
    public static final String CROSS_TEXT = "X";
    public static final String CIRCLE_TEXT = "O";

    private final Frame frame;

    Random r = new Random();

    private int turn = DEFAULT;

    private int[][] currentSet = new int[3][3]; //[LEFT/RIGHT] [UP/DOWN]

    public BL(Frame frame) {
        this(frame, DEFAULT);
    }

    public BL(Frame frame, int beginner) {
        this.frame = frame;
        switch (beginner) {
            case CROSS:
                turn = CROSS;
                break;
            case DEFAULT:
                turn = r.nextBoolean() ? CROSS : CIRCLE;
                break;
            case CIRCLE:
                turn = CIRCLE;
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public int checkWin() {
        boolean nothingIsEmpty = true;
        //Check for y axis wins
        for (int i = 0; i < 3; i++) {
            switch (IntStream.of(currentSet[i]).sum()) {
                case CROSS_WIN:
                    return CROSS_WIN;
                case DEFAULT:
                    break;
                case CIRCLE_WIN:
                    return CIRCLE_WIN;
                default:
            }
        }

        //Check for x axis wins
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += currentSet[j][i];
                if (currentSet[j][i] == DEFAULT)
                    nothingIsEmpty = false;
            }
            switch (sum) {
                case CROSS_WIN:
                    return CROSS_WIN;
                case CIRCLE_WIN:
                    return CIRCLE_WIN;
                case DEFAULT:
                    break;
                default:
            }
        }

        //Check diagonal from low to high y axis
        switch (currentSet[0][0] + currentSet[1][1] + currentSet[2][2]) {
            case CIRCLE_WIN:
                return CIRCLE_WIN;
            case CROSS_WIN:
                return CROSS_WIN;
            case DEFAULT:
                break;
            default:
        }

        //Check diagonal from high to low y axis
        switch (currentSet[0][2] + currentSet[1][1] + currentSet[2][0]) {
            case CIRCLE_WIN:
                return CIRCLE_WIN;
            case CROSS_WIN:
                return CROSS_WIN;
            case DEFAULT:
                break;
        }

        if (nothingIsEmpty)
            return DRAW;

        return RUNNING_GAME;
    }

    public void setSign(int x, int y, int sign) {
        if (sign != CIRCLE | sign != CROSS) {
            throw new IndexOutOfBoundsException();
        }
        currentSet[x][y] = sign;
    }

    public int handlePress(int x, int y, JButton btn) {
        if (currentSet[x][y] != DEFAULT)
            return RUNNING_GAME;
        currentSet[x][y] = turn;
        btn.setText(turn == CIRCLE ? CIRCLE_TEXT : CROSS_TEXT);
        btn.setBackground(turn == CROSS ? Color.red : Color.blue);

        int cw = checkWin();
        if (cw == RUNNING_GAME)
        turn = turn == CIRCLE ? CROSS : CIRCLE;
            return cw;

    }

    public void restart(int beginner) {
        if (beginner == DEFAULT){
            turn = turn == CIRCLE ? CROSS : CIRCLE;
        }else{
            turn = beginner;
        }
        currentSet = new int[3][3];
    }
}
