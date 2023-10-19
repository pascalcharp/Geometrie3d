package Point3d;

import geometrie3d.Point3d;
import geometrie3d.Vecteur3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3dTest {

    @Test
    void translation() {
        Vecteur3d v = new Vecteur3d(1, 2, 3) ;
        Point3d p = new Point3d(10, 10, 10) ;
        Point3d resultat = p.translation(v) ;
        assertEquals(11, resultat.getX()) ;
        assertEquals(12, resultat.getY()) ;
        assertEquals(13, resultat.getZ()) ;
    }
}