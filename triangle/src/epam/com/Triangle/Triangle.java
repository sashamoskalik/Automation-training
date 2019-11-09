package epam.com.Triangle;

public class Triangle {
    public static boolean triangle(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException();
        }
        return (a < b + c) && (b < a + c) && (c < a + b);
    }
}
