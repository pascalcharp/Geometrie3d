package geometrie3d;

public class Precision {
    public static final double EPSILON = 1.0E-8 ;

    public static boolean DoubleEquals(double x, double y) {
        return Math.abs(x - y) < EPSILON ;
    }
}
