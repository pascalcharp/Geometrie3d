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

    public Point3d(Vecteur3d v) {
        x = v.getXi() ;
        y = v.getYj() ;
        z = v.getZk() ;
    }

    public double getX() {return x ; }
    public double getY() {return y ; }
    public double getZ() {return z ; }

    public Point3d translation(Vecteur3d v) {
        return new Point3d(x + v.getXi(), y + v.getYj(), z + v.getZk()) ;
    }

    @Override
    public boolean equals(Object p) {
        if (p == this) return true ;
        if (!(p instanceof Point3d)) return false ;
        Point3d u = (Point3d) p ;
        return x == u.x && y == u.y && z == u.z ;
    }
}
