package geometrie3d;

public class Droite3d {
    private Point3d point ;
    private Vecteur3d unitaire ;

    public Droite3d(Point3d pPoint, Vecteur3d pUnitaire) {
        point = pPoint ;
        unitaire = pUnitaire ;

        assert invariant() ;
    }

    public Boolean appartient(Point3d p) {
        Vecteur3d v = new Vecteur3d(point, p) ;
        return v.projeterSur(unitaire) == v ;
    }

    private Boolean invariant() {
        return unitaire.normeCarree() == 1 && !unitaire.estNul();
    }
}
