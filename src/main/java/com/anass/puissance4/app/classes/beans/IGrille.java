package com.anass.puissance4.app.classes.beans;

import com.anass.puissance4.app.classes.beans.impl.Jeton;
import com.anass.puissance4.app.classes.beans.impl.JetonJoueur;
import com.anass.puissance4.app.classes.beans.impl.JetonVide;
import com.anass.puissance4.app.classes.exceptions.ColumnFullException;
import com.anass.puissance4.app.classes.exceptions.InvalidColonException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface IGrille {

    boolean isEmpty();

    boolean isFull();

    void addTocken(int nbrColone, Jeton jeton) throws InvalidColonException, ColumnFullException;

    List<Jeton> getLine(int line);


    List<Jeton> getColumn(int column);

    List<List<Jeton>> getDiagonals();

    List<List<Jeton>> getAllLines();

    List<List<Jeton>> getAllColumns();
}
