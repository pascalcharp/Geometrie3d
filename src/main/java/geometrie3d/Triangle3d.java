package geometrie3d ;

public class Triangle3d {
    private final Point3d ra ;
    private final Point3d rb ;
    private final Point3d rc ;

    private Vecteur3d normale ;

    public Triangle3d(Point3d rainit, Point3d rbinit, Point3d rcinit) {

        ra = rainit ;
        rb = rbinit ;
        rc = rcinit ;

        Vecteur3d v = new Vecteur3d(ra, rb) ;
        Vecteur3d w = new Vecteur3d(ra, rc) ;
        Vecteur3d temp = v.produitVectoriel(w) ;
        normale = temp.normaliser() ;


        assert invariant() ;
    }

    private Boolean invariant() {
        return ! normale.estNul() ;
    }

    public Vecteur3d lireNormale() { return normale ; }

    public Boolean estCoplanaire(Point3d p) {
        Vecteur3d ap = new Vecteur3d(ra, p) ;
        return normale.produitScalaire(ap) == 0 ;
    }

    public Boolean estInterieur(Point3d p) {
        if (estCoplanaire(p)) {
            Vecteur3d ap = new Vecteur3d(ra, p) ;
            Vecteur3d ab = new Vecteur3d(ra, rb) ;
            Vecteur3d ac = new Vecteur3d(ra, rc) ;

            if (ap.produitScalaire(ab) > 0 && ap.produitScalaire(ac) > 0) {
                Vecteur3d ba = new Vecteur3d(rb, ra) ;
                Vecteur3d bc = new Vecteur3d(rb, rc) ;
                Vecteur3d bp = new Vecteur3d(rb, p) ;

                return bp.produitScalaire(ba) > 0 && bp.produitScalaire(bc) > 0 ;
            }
        }
        return false ;
    }
}
