package com.anass.puissance4.app.classes.beans.impl;

import com.anass.puissance4.app.classes.beans.IGrille;
import com.anass.puissance4.app.classes.beans.IPrinter;
import com.anass.puissance4.app.classes.exceptions.GridNullException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Printer implements IPrinter {
    public void print(IGrille grille){
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
