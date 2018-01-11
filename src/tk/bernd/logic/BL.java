package tk.bernd.logic;

import java.awt.*;
import java.util.stream.IntStream;

public class BL {

    public BL(Frame frame){
        this.frame = frame;
    }
    private final Frame frame;
    public static final int CROSS_WIN = -3;
    public static final int DEFAULT = 0;
    public static final int CIRCLE_WIN = 3;
    public static final int CROSS = -1;
    public static final int CIRCLE = 1;

    private int[][] currentSet = new int[3][3]; //[LEFT/RIGHT] [UP/DOWN]

    public int checkWin(){
        //Check for y axis wins
        for (int i = 0; i < 3; i++) {
            switch (IntStream.of(currentSet[i]).sum()){
                case CROSS:
                    return CROSS;
                case DEFAULT:
                    break;
                case CIRCLE:
                    return CIRCLE;
                default:
                    throw new AssertionError();
            }
        }


        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += currentSet[]
            }
        }


        return 10;
    }

    public void setSign(int x, int y)
}
