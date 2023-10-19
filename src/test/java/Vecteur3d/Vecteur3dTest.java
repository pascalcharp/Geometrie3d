package Vecteur3d;

import geometrie3d.Vecteur3d;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vecteur3dTest {

    Vecteur3d nul = new Vecteur3d(0, 0, 0) ;
    Vecteur3d v100 = new Vecteur3d(1, 0, 0) ;
    Vecteur3d v010 = new Vecteur3d(0, 1, 0) ;
    Vecteur3d v001 = new Vecteur3d(0, 0, 1) ;
    Vecteur3d v345 = new Vecteur3d(3, 4, 5) ;
    Vecteur3d vm345 = new Vecteur3d(-3, -4, -5) ;
    Vecteur3d vm001 = new Vecteur3d(0, 0, -1) ;
    Vecteur3d v6810 = new Vecteur3d(6, 8, 10) ;


    @Test
    void estNul() {
        assertTrue(nul.estNul()) ;
        assertFalse(v100.estNul()) ;
    }

    @Test
    void normeCarree() {
        assertEquals(0, nul.normeCarree()) ;
        assertEquals(1, v100.normeCarree()) ;
        assertEquals(1, v010.normeCarree()) ;
        assertEquals(1, v001.normeCarree()) ;
        assertEquals(50, v345.normeCarree()) ;
    }

    @Test
    void norme() {
        assertEquals(0, nul.norme()) ;
        assertEquals(1, v001.norme()) ;
        assertEquals(1, v010.norme()) ;
        assertEquals(1, v001.norme()) ;
        assertEquals(7.0710678118654755, v345.norme()) ;
    }

    @Test
    void produitScalaire() {
        assertEquals(0, v100.produitScalaire(v010)) ;
        assertEquals(0, v010.produitScalaire(v100)) ;
        assertEquals(1, v100.produitScalaire(v100)) ;
        assertEquals(1, v010.produitScalaire(v010)) ;
        assertEquals(0, nul.produitScalaire(v345)) ;
        assertEquals(0, v345.produitScalaire(nul)) ;
        assertEquals(3, v100.produitScalaire(v345)) ;
        assertEquals(4, v345.produitScalaire(v010)) ;
        assertEquals(5, v345.produitScalaire(v001)) ;
    }

    @Test
    void produitVectoriel() {
        assertTrue(v345.produitVectoriel(v345).estNul()) ;
        assertTrue(nul.produitVectoriel(v345).estNul()) ;
        assertTrue(v345.produitVectoriel(vm345).estNul()) ;

        assertEquals(v001, v100.produitVectoriel(v010)) ;
        assertEquals(vm001, v010.produitVectoriel(v100)) ;

    }

    @Test
    void multiplier() {
        assertEquals(vm001, v001.multiplier(-1)) ;
        assertEquals(vm345, v345.multiplier(-1)) ;
        assertEquals(v6810, v345.multiplier(2)) ;
        assertEquals(v345, v6810.multiplier(0.5)) ;

    }

    @Test
    void normaliser() {
        assertEquals(1, v345.normaliser().normeCarree(), 1e-10) ;
        assertEquals(v345.normaliser(), v6810.normaliser()) ;
        assertEquals(v100.normaliser(), v100) ;
    }

    @Test
    void add() {
        assertEquals(v345, v345.add(nul)) ;
        assertEquals(v345, nul.add(v345)) ;
        assertEquals(v6810, v345.add(v345)) ;
    }

    @Test
    void sub() {
        assertEquals(nul, v345.sub(v345)) ;
        assertEquals(v345, nul.sub(vm345)) ;
    }

    @Test
    void projeterSur() {
        Vecteur3d resultat = new Vecteur3d(3, 0, 0) ;
        assertEquals(resultat, v345.projeterSur(v100)) ;
        Vecteur3d resultat2 = new Vecteur3d(0, 4, 0) ;
        assertEquals(resultat2, v345.projeterSur(v010)) ;
        Vecteur3d resultat3 = new Vecteur3d(0, 0, 5) ;
        assertEquals(resultat3, v345.projeterSur(v001)) ;
        assertEquals(nul, v100.projeterSur(v010)) ;


    }


}