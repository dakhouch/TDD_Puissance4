package com.anass.puissance4.app.classes.beans.impl;

import com.anass.puissance4.app.classes.beans.IAnalyser;
import com.anass.puissance4.app.classes.beans.IGrille;
import com.anass.puissance4.app.classes.exceptions.GridNullException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class Analyser implements IAnalyser {

    public GameState checkGame(IGrille grille) {
        if(grille == null) throw new GridNullException();
        if(grille.getAllLines().stream().anyMatch(line->
                has4ConnectedTokens(line)
        )){
            return GameState.Winner;
        } else if (grille.getAllColumns().stream().anyMatch(col->
                has4ConnectedTokens(col)
        )) {
            return GameState.Winner;
        } else if (grille.isFull()) {
            return GameState.Draw;
        }

        return GameState.InProgress;
    }

    private boolean has4ConnectedTokens(List<Jeton> line) {
        return line.size()>= 4 && new HashSet<>(line.subList(0, 4)).size() == 1 ||
                line.size()>= 5 && new HashSet<>(line.subList(1, 5)).size() == 1 ||
                line.size()>= 6 && new HashSet<>(line.subList(2, 6)).size() == 1 ||
                line.size()>= 7 && new HashSet<>(line.subList(3, 7)).size() == 1;
    }
}
