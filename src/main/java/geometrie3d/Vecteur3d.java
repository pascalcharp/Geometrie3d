package geometrie3d;

public class Vecteur3d {
    private double xi ;
    private double yj ;
    private double zk ;

    public Vecteur3d(double xiinit, double yjinit, double zkinit) {
        xi = xiinit ;
        yj = yjinit ;
        zk = zkinit ;
    }

    public Vecteur3d(Point3d source, Point3d dest) {
        xi = dest.getX() - source.getX() ;
        yj = dest.getY() - source.getY() ;
        zk = dest.getZ() - source.getZ() ;
    }

    public Vecteur3d(Point3d dest) {
        xi = dest.getX();
        yj = dest.getY();
        zk = dest.getZ();
    }

    public double getXi() {return xi ; }

    public double getYj() {return yj ; }

    public double getZk() {return zk ; }

    @Override
    public boolean equals(Object r) {
        if (r == this) return true ;
        if (!(r instanceof Vecteur3d)) return false ;
        Vecteur3d v = (Vecteur3d) r ;
        return xi == v.xi && yj == v.yj && zk ==  v.zk ;
    }

    public Boolean estNul() {
        return xi == 0 && yj == 0 && zk == 0 ;
    }

    public double normeCarree() {
        return xi * xi + yj * yj + zk * zk ;
    }

    public double norme() {
        return Math.sqrt(normeCarree()) ;
    }

    public double produitScalaire(Vecteur3d v) {
        return xi * v.xi + yj * v.yj + zk * v.zk ;
     }

     public Vecteur3d produitVectoriel(Vecteur3d v) {
        return new Vecteur3d(yj * v.zk - zk * v.yj, zk * v.xi - xi * v.zk, xi * v.yj - yj * v.xi) ;
     }

     public Vecteur3d multiplier(double d) {
        return new Vecteur3d(xi * d, yj * d, zk * d) ;
     }

     public Vecteur3d normaliser() {
        double invn = 1.0 / norme() ;
        return multiplier(invn) ;
     }

     public Vecteur3d add(Vecteur3d rhs) {
        return new Vecteur3d(xi + rhs.xi, yj + rhs.yj, zk + rhs.zk) ;
     }

     public Vecteur3d sub(Vecteur3d rhs) {
        return new Vecteur3d(xi - rhs.xi, yj - rhs.yj, zk - rhs.zk) ;
     }

     public Vecteur3d projeterSur(Vecteur3d v) {
        double scaleFact = 1.0 / v.norme() ;
        Vecteur3d unit = v.multiplier(scaleFact) ;
        double mag = produitScalaire(unit) ;
        return unit.multiplier(mag) ;
     }
}
