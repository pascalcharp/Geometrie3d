package geometrie3d;

public class Point3d {
    private double x ;
    private double y ;
    private double z ;

    public Point3d(double xinit, double yinit, double zinit) {
        x = xinit ;
        y = yinit ;
        z = zinit ;
    }

    public double getX() {return x ; }
    public double getY() {return y ; }
    public double getZ() {return z ; }

    public Point3d translation(Vecteur3d v) {
        return new Point3d(x + v.getXi(), y + v.getYj(), z + v.getZk()) ;
    }
}
