package com.anass.puissance4.app.classes.beans;

import com.anass.puissance4.app.classes.beans.impl.Jeton;
import com.anass.puissance4.app.classes.exceptions.ColumnFullException;
import com.anass.puissance4.app.classes.exceptions.InvalidColonException;

public interface IOrdonnanceur {

    IGrille getGrille();

    boolean demarrerPartie();

    Jeton donnerLaMain();

    void play(int column, Jeton jeton) throws InvalidColonException, ColumnFullException;

    boolean isOver();

    void result();

    void affiche();

}
