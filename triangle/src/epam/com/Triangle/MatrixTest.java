package epam.com.Triangle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test(expected = IllegalArgumentException.class)
    public void negativeSide(){
        Triangle.triangle(10, -5, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void allSidesZero(){
        Triangle.triangle(0, 0, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void oneSideZero(){
        Triangle.triangle(7, 0, 2);
    }
    @Test
    public void oneSideGreaterSumOther(){
        assertFalse(Triangle.triangle(10, 1, 2));
    }
    @Test
    public void rightTriangle(){
        assertTrue(Triangle.triangle(3, 4, 5));
    }
    @Test
    public void isosceles(){
        assertTrue(Triangle.triangle(4, 4, 2));
    }
    @Test
    public void equilateral(){
        assertTrue(Triangle.triangle(8, 8, 8));
    }
    @Test
    public void oneSideEqualsSumOther(){
        assertFalse(Triangle.triangle(9, 6, 3));
    }
    @Test(expected = IllegalArgumentException.class)
    public void allSidesNegative(){
        Triangle.triangle(-5, -10, -2);
    }
    @Test
    public void normalTriangle(){
        assertTrue(Triangle.triangle(4, 5, 6));
    }
}