package test.programmers.kakao2017;

import org.junit.Test;
import programmers.kakao2017.DartGame;

import static org.junit.Assert.*;

public class DartGameTest {

    /**
     * 예제	dartResult	answer	설명
     * 1	1S2D*3T	    37	    11 * 2 + 22 * 2 + 33
     * 2	1D2S#10S	9	    12 + 21 * (-1) + 101
     * 3	1D2S0T	    3	    12 + 21 + 03
     * 4	1S*2T*3S	23	    11 * 2 * 2 + 23 * 2 + 31
     * 5	1D#2S*3S	5	    12 * (-1) * 2 + 21 * 2 + 31
     * 6	1T2D3D#	    -4	    13 + 22 + 32 * (-1)
     * 7	1D2S3T*	    59	    12 + 21 * 2 + 33 * 2
     */
    @Test
    public void solution() {

        DartGame dartGame = new DartGame();

        assertEquals(dartGame.solution("1S2D*3T"), 37);
        assertEquals(dartGame.solution("1D2S#10S"), 9);
        assertEquals(dartGame.solution("1D2S0T"), 3);
        assertEquals(dartGame.solution("1S*2T*3S"), 23);
        assertEquals(dartGame.solution("1D#2S*3S"), 5);
        assertEquals(dartGame.solution("1T2D3D#"), -4);
        assertEquals(dartGame.solution("1D2S3T*"), 59);
    }
}