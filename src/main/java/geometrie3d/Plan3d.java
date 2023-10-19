package geometrie3d;

import static geometrie3d.Precision.DoubleEquals;

public class Plan3d {
    private Point3d point ;
    private Vecteur3d unitaire ;

    public Plan3d(Point3d pPoint, Vecteur3d pUnitaire) {
        point = pPoint ;
        unitaire = pUnitaire ;

        assert invariant() ;
    }

    public Plan3d(Point3d a, Point3d b, Point3d c) {
        Triangle3d t = new Triangle3d(a, b, c) ;
        point = a ;
        unitaire = t.lireNormale() ;

        assert invariant() ;

    }

    public Boolean contient(Point3d p) {
        Vecteur3d v = new Vecteur3d(point, p) ;
        return v.produitScalaire(unitaire) == 0 ;
    }

    public Point3d projectionOrthographique(Point3d p) {
        Vecteur3d ra = new Vecteur3d(point) ;
        Vecteur3d rp = new Vecteur3d(p) ;
        double lambda = unitaire.produitScalaire(ra.sub(rp)) ;
        Vecteur3d res = rp.add(unitaire.multiplier(lambda)) ;
        return new Point3d(res) ;
    }

    private Boolean invariant() {
        return DoubleEquals(unitaire.normeCarree(), 1.0)  && !unitaire.estNul() ;
    }

}
