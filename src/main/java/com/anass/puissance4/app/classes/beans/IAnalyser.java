package com.anass.puissance4.app.classes.beans;

import com.anass.puissance4.app.classes.beans.impl.GameState;
import com.anass.puissance4.app.classes.beans.impl.Grille;

public interface IAnalyser {
     GameState checkGame(IGrille grille);
}
