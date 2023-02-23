package com.anass.puissance4.app.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grille {

    private List<List<Jeton>> lines = new ArrayList<>(Arrays.asList(initLine(), initLine(), initLine(), initLine(), initLine(), initLine()));

    public boolean isEmpty() {
        return lines.stream().flatMap(List::stream).allMatch(item->item instanceof JetonVide);

    }

    public void addTocken(int nbrColone, Jeton jeton) throws InvalidColonException, ColumnFullException {

       if(nbrColone<1 || nbrColone>7) throw new InvalidColonException();
        List<Jeton> nextLine = this.lines.stream()
                .filter(line -> line.get(nbrColone - 1) instanceof JetonVide).findFirst()
                .orElseThrow(ColumnFullException::new);

        nextLine.set(nbrColone-1, jeton);


    }
    public List<Jeton> getLine(int line){
        return lines.get(line);

    }

    private static ArrayList<Jeton> initLine() {
        return new ArrayList<>(Arrays.asList(new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide()));
    }

    public boolean isFull() {
         return lines.stream().flatMap(List::stream).allMatch(item->item instanceof JetonJoueur);
    }

    public List<Jeton> getColumn(int column) {
        return lines.stream().map(line -> line.get(column-1)).collect(Collectors.toList());
    }
}

