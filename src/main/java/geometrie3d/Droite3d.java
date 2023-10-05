package geometrie3d;

public class Droite3d {
    private Point3d point ;
    private Vecteur3d unitaire ;

    public Droite3d(Point3d pPoint, Vecteur3d pUnitaire) {
        point = pPoint ;
        unitaire = pUnitaire ;

        assert invariant() ;
    }

    private Boolean invariant() {
        return unitaire.normeCarree() == 1 ;
    }
}
