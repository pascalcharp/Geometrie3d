package Plan3dTest;

import geometrie3d.Plan3d;
import geometrie3d.Point3d;
import geometrie3d.Vecteur3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Plan3dTest {
    private final Vecteur3d xChapeau = new Vecteur3d(1, 0, 0) ;
    private final Vecteur3d yChapeau = new Vecteur3d(0, 1, 0) ;
    private final Vecteur3d zChapeau = new Vecteur3d(0, 0, 1) ;

    private final Point3d origine = new Point3d(0, 0, 0) ;
    private final Vecteur3d unitaire45 = new Vecteur3d(1, 1, 0).normaliser() ;

    @Test
    void appartient() {
        Plan3d planXY = new Plan3d(origine, zChapeau) ;
        assertTrue(planXY.contient(origine)) ;
        assertTrue(planXY.contient(new Point3d(1, -1, 0))) ;
        assertTrue(planXY.contient(new Point3d(-1000, 5000, 0))) ;
        assertFalse(planXY.contient(new Point3d(1, 1, -1))) ;

        Plan3d planYZ = new Plan3d(origine, xChapeau) ;
        assertTrue(planYZ.contient(origine)) ;
        assertTrue(planYZ.contient(new Point3d(0, 5, -10000))) ;
    }

    @Test
    void projectionOrthographique() {
        Plan3d planXY = new Plan3d(origine, zChapeau) ;
        Point3d point = new Point3d(3, 4, 10) ;
        Point3d attendu = new Point3d(3, 4, 0) ;
        assertEquals(attendu, planXY.projectionOrthographique(point)) ;

        Plan3d plan45 = new Plan3d(new Point3d(1, 0, 0), unitaire45) ;
        Point3d pointx = new Point3d(1, 0, 0) ;
        Point3d pointy = new Point3d(0, 1, 0) ;
        Point3d attenduOrigine = new Point3d(0.5, 0.5, 0) ;

        assertEquals(pointx, plan45.projectionOrthographique(pointx)) ;
        assertEquals(pointy, plan45.projectionOrthographique(pointy)) ;

        Point3d resultatOrigine = plan45.projectionOrthographique(origine) ;
        assertEquals(attenduOrigine, resultatOrigine) ;

    }
}