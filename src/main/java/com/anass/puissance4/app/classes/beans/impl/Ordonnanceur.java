package com.anass.puissance4.app.classes.beans.impl;

import com.anass.puissance4.app.classes.beans.*;
import com.anass.puissance4.app.classes.exceptions.ColumnFullException;
import com.anass.puissance4.app.classes.exceptions.InvalidColonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ordonnanceur implements IOrdonnanceur {

    @Autowired
    private IGrille grille;
    @Autowired
    private IPrinter printer;
    @Autowired
    private IAnalyser analyser;

    private boolean isOver = false;

    private String nextPlayer = "x";

    public IGrille getGrille() {
        return grille;
    }

    public boolean demarrerPartie() {
        return grille.isEmpty();
    }

    @Override
    public Jeton donnerLaMain() {
        Jeton jeton = new JetonJoueur(nextPlayer);
        nextPlayer = switchPlayer();
        return jeton;
    }

    @Override
    public void play(int column, Jeton jeton) throws InvalidColonException, ColumnFullException {
        grille.addTocken(column, jeton);
        checkGame();
    }

    public boolean isOver() {
        return isOver;
    }

    @Override
    public void result() {
        GameState state = analyser.checkGame(grille);
        if (state.equals(GameState.Winner))
            System.out.println(nextPlayer.equals("x")?"o":"x" +" wins");
    }

    private void checkGame() {
        GameState state = analyser.checkGame(grille);
        if (state.equals(GameState.Winner) || state.equals(GameState.Draw)) isOver = true;
    }


    @Override
    public void affiche() {
        printer.print(grille);
    }


    private String switchPlayer() {
        if (nextPlayer.equals("x")) return "o";
        return "x";
    }


}
