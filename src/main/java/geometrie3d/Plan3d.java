package geometrie3d;

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

    private Boolean invariant() {
        return unitaire.normeCarree() == 1 ;
    }

}
