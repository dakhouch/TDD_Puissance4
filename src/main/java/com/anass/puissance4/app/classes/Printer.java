package com.anass.puissance4.app.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Printer {
    public void print(Grille grille){
        if (grille == null) throw  new GridNullException();
        List<List<Jeton>> allLines = grille.getAllLines();
        List<List<Jeton>> reversedGrid = new ArrayList<>(allLines);
        Collections.reverse(reversedGrid);
        reversedGrid.stream().forEach(line ->{
            line.stream().map(Jeton::getContent).forEach(System.out::print);
            System.out.println();
        });
    }
}
